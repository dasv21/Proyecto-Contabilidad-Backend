FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-accountant-1.0.0.jar" "msvc-accountant.jar"
ENTRYPOINT ["java", "-jar", "msvc-accountant.jar"]