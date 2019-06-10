#!/bin/bash 

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








