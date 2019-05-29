FROM r-base

RUN R -e "install.packages('distr',dependencies=TRUE, repos='http://cran.rstudio.com/')"
RUN R -e "install.packages('data.table',dependencies=TRUE, repos='http://cran.rstudio.com/')"
RUN R -e "install.packages('dplyr',dependencies=TRUE, repos='http://cran.rstudio.com/')"
RUN R -e "install.packages('deSolve',dependencies=TRUE, repos='http://cran.rstudio.com/')"

COPY ./script.R /script.R

WORKDIR /

CMD ["Rscript", "/script.R"]