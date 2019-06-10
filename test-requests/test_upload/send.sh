#!/bin/bash
curl -v -H "Content-Type: multipart/form-data" -F "files=@./population.data" -F "files=@newDF.png" -X POST http://localhost:8080/callback/jobs/1