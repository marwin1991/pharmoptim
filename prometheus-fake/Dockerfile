FROM gcc:9

RUN  apt-get update \
  && apt-get install -y wget \
  && apt-get install -y libarchive-dev \
  && apt-get install -y openssh-server \
  && apt-get install -y openrc \
  && rm -rf /var/lib/apt/lists/*

RUN VERSION=2.5.2 \
    && wget https://github.com/singularityware/singularity/releases/download/$VERSION/singularity-$VERSION.tar.gz\
    && tar xvf singularity-$VERSION.tar.gz \
    && cd singularity-$VERSION \
    && ./configure --prefix=/usr/local \
    && make \
    && make install \
    && rm -f singularity-$VERSION.tar.gz

RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config 

RUN echo "root:test1234" | chpasswd

COPY ./start_job.sh /root/start_job.sh
COPY ./delete_job.sh /root/delete_job.sh

WORKDIR /

ENTRYPOINT [ "/bin/bash","-c","service ssh start && tail -f /dev/null" ]