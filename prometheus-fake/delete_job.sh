#!/bin/bash

JOB_ID=$1

singularity instance.stop pharmoptim.simg pharmoptim_${JOB_ID}
rm -r -f pharmoptim_${JOB_ID}