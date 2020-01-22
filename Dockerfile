FROM openjdk:8
VOLUME /tmp
ADD ./target/ClientesMS-0.0.1-SNAPSHOT.jar micro-clientes.jar
ENTRYPOINT ["java","-jar","/micro-clientes.jar"]