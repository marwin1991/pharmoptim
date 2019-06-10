PharmOptim - Java - Prometheus
-----------------------------------------
This project provides api and its implementation
to manage jobs in AGH Prometheus super computer.


##### You can find here two APIS:

- pharmoptim-api.yaml - contains the API for external services to manage jobs
- pharmoptim-promethus-callback-api.yaml - contains the API for AGH Prometheus to
return results from calculations

##### Project background:
- This project is to start docker image on AGH Prometheus using singularity.
- To provide abstraction we assume that on host is a file that starts container and second
one that is stopping container. If you want learn more about this files go to prometheus or
prometheus_fake directory
- This files take input arguments as follow
- Then job is started
- After job finish container execute curl command to return files to this service
 (f.e. curl -v -H "Content-Type: multipart/form-data" -F "files=@./population.data" -F "files=@newDF.pdf" -X POST http://localhost:8080/callback/jobs/2)
- Frontend can ten get results
- Project uses database to keep: job id - status - results - some not important infos



##### TODO:
- security layer (spring security) with two user one FRONT and second PROMETHEUS
and let this users execute only theirs endpoints
- parameters passed to scripts can be passed as option (f.e. --oral_doce=880) this work
need to be done also at prometheus and prometheus_fake directory
- script to check job status on prometheus using some "pro-jobs" or something else
(check [Promethues site](https://kdm.cyfronet.pl/portal/Prometheus:Podstawy))
- scheduler that will check statues on Prometheus
- maybe script should return data instead of files - this work should be done at
r_script directory.
- move database to mongoDB from h2