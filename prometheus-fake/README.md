Start container: 
```
./run.sh
``` 

TODO: install singularity or find docker with singularity

Connect to docker: 
```
docker exec -it prometheus_fake /bin/sh
```
Start sshd inside container: 
```
./script.sh
```

Now you can connect to docker via ssh using \
root@docker_ip:1022 test1234

Pulling image: 
```
docker pull marwin1991/pharmoptim
```