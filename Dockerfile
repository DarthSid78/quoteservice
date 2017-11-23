FROM iron/java:1.8

COPY config.yml /data/quoteservice/config.yml
COPY quotes.csv /data/quoteservice/quotes.csv
COPY /target/quoteservice-1.0-SNAPSHOT.jar /data/quoteservice/quoteservice-1.0-SNAPSHOT.jar

WORKDIR /data/quoteservice

CMD ["java","-jar","quoteservice-1.0-SNAPSHOT.jar","server","config.yml"]

EXPOSE 8080
