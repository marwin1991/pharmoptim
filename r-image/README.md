Image with R-script for Pharmoptim project
------------------------------------------

Image is using environment variables: 
- ORAL_DOSE (int)
- INF_DOSE (int)
- INF_TIME (int)
- T_END (int)
- SEED (int)

Setting in shell:
```
export ORAL_DOSE=880\
export INF_DOSE=0\
export INF_TIME=2\
export T_END=15\
export SEED=1111
```


Building image: 
```
./build.sh
```

Publishing image in docker registry: 
```
./publish.sh
``` 

It is adjust for marwin1991 account

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

```
docker run -e "ORAL_DOSE=880" -e "INF_DOSE=0" -e "INF_TIME=2" -e "T_END=15" -e "SEED=1111" -v ./result:/result -it marwin1991/pharmoptim /bin/bash
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
