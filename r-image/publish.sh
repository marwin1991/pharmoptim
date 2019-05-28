#!/bin/bash
# in future change marwin1991 to organisation

docker login
docker tag r_script marwin1991/pharmoptim
docker push marwin1991/pharmoptim