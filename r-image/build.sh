#!/bin/bash

docker build -t r_script . 
docker save r_script -o r_script.tar