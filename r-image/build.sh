#!/bin/bash

docker build -t r_script . 
rm -f r_script.tar
docker save r_script -o r_script.tar