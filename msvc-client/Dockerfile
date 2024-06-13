FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-client-1.0.0.jar" "msvc-client.jar"
ENTRYPOINT ["java", "-jar", "msvc-client.jar"]