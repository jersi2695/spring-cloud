FROM openjdk:8
VOLUME /tmp
ADD ./target/servicio-usuarios-0.0.1-SNAPSHOT.jar servicio-usuarios.jar
ENTRYPOINT ["java","-jar","/servicio-usuarios.jar"]