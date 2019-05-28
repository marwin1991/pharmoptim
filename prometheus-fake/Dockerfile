FROM docker:18-dind

RUN apk add --update openssh
RUN apk add --update openrc
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config
RUN echo "rc-status && touch /run/openrc/softlevel && /etc/init.d/sshd start" >> /script.sh
RUN chmod +x /script.sh
RUN rc-update add sshd

