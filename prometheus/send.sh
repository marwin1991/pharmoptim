#!/bin/bash
echo "$2/callback/jobs/$1"
curl -v -H "Content-Type: multipart/form-data" -F "files=@./pharmoptim_$1/newDF.RData" -F "files=@./pharmoptim_$1/population.RData" -X POST "$2/callback/jobs/$1"