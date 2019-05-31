Pharmoptim
--------------
This project is used to provide API to create and run docker images
on AGH super computer Prometheus.

#####How it works?
- Job is one docker container lifecycle.
- Docker container lifecycle is start R-base image, start R script,
return results to server via callback API.
- Job is started/checked/deleted via API by external server.

####Project Structure
- java - directory with Java/Spring boot based microservice to base and callback API
- prometheus - directory contains scripts that are used on the Prometheus and useful notes.
- prometheus_fake - directory contains files to create and develop docker image simulating AGH Prometheus.
- r-image - directory contains files to create and develop docker image on witch calculations are made.

Useful commands (Development)
---------------------------
Download R-script image: 
```
docker pull marwin1991/pharmoptim
```
Start container and enter it: 
```
docker run -e "ORAL_DOSE=880" \
-e "INF_DOSE=0" \
-e "INF_TIME=2" \
-e "T_END=15" \
-e "SEED=1111" \
-v ./result:/result \
-it marwin1991/pharmoptim /bin/bash
```
Run container in background: 
```
docker run -e "ORAL_DOSE=880" \
-e "INF_DOSE=0" \
-e "INF_TIME=2" \
-e "T_END=15" \
-e "SEED=1111" \
-v ./result:/result \
-d marwin1991/pharmoptim
```
TODO: Image is really primitive due to no appropriate R-script
that should be provided. 

Useful commands on Prometheus
-----------------------------
Start node in test partition:
```
srun -p plgrid-testing -N 1 --ntasks-per-node=1 -n 1 -A pharmoptim01 --pty /bin/bash
```
Loading Singularity module: 
```
module add plgrid/tools/singularity/stable
```
Pull image:
```
singularity pull docker://marwin1991/pharmoptim
```
Adding environment variables:\
https://groups.google.com/a/lbl.gov/forum/#!topic/singularity/jfD57abWHoo
```
export SINGULARITYENV_ORAL_DOSE=880 \
export SINGULARITYENV_INF_TIME=2 \
export SINGULARITYENV_T_END=15 \
export SINGULARITYENV_SEED=1111
```
Start singularity container with shell:
```
singularity shell pharmoptim.simg
```
Binding directories(create result directory first):
```
singularity shell -B results:/results pharmoptim.simg
```
Removing Singularity module: 
```
module rm plgrid/tools/singularity/stable
```
