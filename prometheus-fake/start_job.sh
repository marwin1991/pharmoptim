#!/bin/bash

JOB_ID = $1
ORAL_DOSE = $2
INF_DOSE = $3
INF_TIME = $4
INF_TIME = $5
INDIVIDUAL_COUNT = $6
FEMALE_COUNT = $7
MIN_AGE = $8
MAX_AGE = $9
T_END = ${10}
SEED = ${11}
CALLBACK_ADDRESS = ${12}

singularity pull docker://marwin1991/pharmoptim

FILE=pharmoptim.simg
if [ -f "$FILE" ]; then
    echo "$FILE exist, you can delete it to download newer version of image"
else 
    singularity pull docker://marwin1991/pharmoptim
fi

export SINGULARITYENV_JOB_ID = $1
export SINGULARITYENV_ORAL_DOSE = $2
export SINGULARITYENV_INF_DOSE = $3
export SINGULARITYENV_INF_TIME = $4
export SINGULARITYENV_INF_TIME = $5
export SINGULARITYENV_INDIVIDUAL_COUNT = $6
export SINGULARITYENV_FEMALE_COUNT = $7
export SINGULARITYENV_MIN_AGE = $8
export SINGULARITYENV_MAX_AGE = $9
export SINGULARITYENV_T_END = ${10}
export SINGULARITYENV_SEED = ${11}
export SINGULARITYENV_CALLBACK_ADDRESS = ${12}

singularity instance.start pharmoptim.simg pharmoptim_+$JOB_ID