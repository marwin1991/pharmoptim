Pharmoptim - Prometheus
--------------

Directory contains scripts that are used on the Prometheus and useful notes.


####Useful commands on Prometheus
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
