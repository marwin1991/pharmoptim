#!/bin/bash -l
## Nazwa zlecenia
#SBATCH -J Test pharmoptim
## Liczba alokowanych węzłów
#SBATCH -N 1
## Liczba zadań per węzeł (domyślnie jest to liczba alokowanych rdzeni na węźle)
#SBATCH --ntasks-per-node=245
## Ilość pamięci przypadającej na jeden rdzeń obliczeniowy (domyślnie 5GB na rdzeń)
#SBATCH --mem-per-cpu=5GB
## Maksymalny czas trwania zlecenia (format HH:MM:SS)
#SBATCH --time=01:00:00 
## Nazwa grantu do rozliczenia zużycia zasobów
#SBATCH -A pharmoptim01
## Specyfikacja partycji
#SBATCH -p plgrid-testing
## Plik ze standardowym wyjściem
#SBATCH --output="output.out"
## Plik ze standardowym wyjściem błędów
#SBATCH --error="error.err"
 
## Zaladowanie modulu Singularity
module add plgrid/tools/singularity/stable
 
## przejscie do katalogu z ktorego wywolany zostal sbatch
cd $SLURM_SUBMIT_DIR

JOB_ID=$1
ORAL_DOSE=$2
INF_DOSE=$3
INF_TIME=$4
INDIVIDUAL_COUNT=$5
FEMALE_COUNT=$6
MIN_AGE=$7
MAX_AGE=$8
T_END=$9
SEED=${10}
CALLBACK_ADDRESS=${11}

echo "TEST1"
FILE=pharmoptim.simg
if [ -f "$FILE" ]; then
    echo "$FILE exist, you can delete it to download newer version of image"
else 
    singularity pull docker://marwin1991/pharmoptim
fi

echo "TEST2"

export SINGULARITYENV_JOB_ID=${JOB_ID}
export SINGULARITYENV_ORAL_DOSE=${ORAL_DOSE}
export SINGULARITYENV_INF_DOSE=${INF_DOSE}
export SINGULARITYENV_INF_TIME=${INF_TIME}
export SINGULARITYENV_INDIVIDUAL_COUNT=${INDIVIDUAL_COUNT}
export SINGULARITYENV_FEMALE_COUNT=${FEMALE_COUNT}
export SINGULARITYENV_MIN_AGE=${MIN_AGE}
export SINGULARITYENV_MAX_AGE=${MAX_AGE}
export SINGULARITYENV_T_END=${T_END}
export SINGULARITYENV_SEED=${SEED}
export SINGULARITYENV_CALLBACK_ADDRESS=${CALLBACK_ADDRESS}

mkdir pharmoptim_${JOB_ID}

singularity instance.start pharmoptim.simg pharmoptim_${JOB_ID}

#singularity exec instance://pharmoptim_${JOB_ID} /bin/bash -c "Rscript /script.R"

cd pharmoptim_${JOB_ID}

singularity run instance://pharmoptim_${JOB_ID}
singularity instance.stop pharmoptim.simg pharmoptim_${JOB_ID}
ls -al

cd ..

./send.sh ${JOB_ID} ${CALLBACK_ADDRESS}

rm -r -f pharmoptim_${JOB_ID}








