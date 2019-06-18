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

singularity instance.stop pharmoptim.simg pharmoptim_${JOB_ID}
rm -r -f pharmoptim_${JOB_ID}