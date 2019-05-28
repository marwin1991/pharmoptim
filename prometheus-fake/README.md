Start container:

./run.sh

Connect to docker:

docker exec -it prometheus_fake /bin/sh

Start sshd inside container
./script.sh

Now you can conect to docker via ssh using root@docker_ip:1022 test1234

Pulling image:
docker pull marwin1991/pharmoptim