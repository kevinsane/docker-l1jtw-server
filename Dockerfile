# L1J-TW Server Dockerfile

FROM java:openjdk-7-jdk
MAINTAINER Tony Pai <tonypai@ifalo.com.tw>

RUN apt-get update
RUN apt-get install -y mysql-client

WORKDIR /data
VOLUME /data

COPY L1J-TW_3.50c /data

EXPOSE 2000

CMD sh /data/ServerStart.sh
