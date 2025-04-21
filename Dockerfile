FROM openjdk:17-jdk-oracle

EXPOSE 8080

WORKDIR /root

COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Descargar las dependencias
RUN ./mvnw dependency:go-offline

# Construir el codigo fuente del contenedor
COPY ./src /root/src

# Construir la aplicacion
RUN ./mvnw clean install -DskipTests

# Levantar la aplicacion cuando el contenedor inicie
ENTRYPOINT ["java","-jar","/root/target/shortening-url-0.0.1-SNAPSHOT.jar"]