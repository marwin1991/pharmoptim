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