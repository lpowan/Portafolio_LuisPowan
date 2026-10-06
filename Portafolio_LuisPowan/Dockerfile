FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# La clave de Firebase no va en el repositorio: en Render se toma del Secret File "firebase-key.json"
# y se copia con el nombre que indica firebase.json.file en application.properties
RUN --mount=type=secret,id=firebase-key_json,dst=/etc/secrets/firebase-key.json,required=true \
    mkdir -p src/main/resources/firebase && \
    cp /etc/secrets/firebase-key.json "src/main/resources/firebase/$(grep '^firebase.json.file=' src/main/resources/application.properties | cut -d= -f2 | tr -d '\r')"
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]