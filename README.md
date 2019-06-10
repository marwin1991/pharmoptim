Pharmoptim
--------------
This project is used to provide API to create and run docker images
on AGH super computer Prometheus.

#### How it works? ####
- Job is one docker container lifecycle.
- Docker container lifecycle is start R-base image, start R script,
return results to server via callback API.
- Job is started/checked/deleted via API by external server.

#### Project Structure ####
- **java** - directory with Java/Spring boot based microservice to base and callback API
- **test-requests** - directory with postman collection to test API and some other test request
- **prometheus** - directory contains scripts that are used on the Prometheus and useful notes.
- **prometheus_fake** - directory contains files to create and develop docker image simulating AGH Prometheus.
- **r-image** - directory contains files to create and develop docker image on witch calculations are made.
