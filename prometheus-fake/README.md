Docker Container With Singularity and SSH-server
------------------------------------------------

Start container: 
```
./run.sh
``` 

Now you can connect to docker via ssh using \
root@docker_ip:1022 test1234

Connect to docker: 
```
docker exec -it prometheus_fake /bin/sh
```

Publish
```
docker tag prometheus_fake marwin1991/singularity-with-ssh
docker push marwin1991/singularity-with-ssh
```
