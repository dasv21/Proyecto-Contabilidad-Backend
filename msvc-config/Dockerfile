FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-config-1.0.0.jar" "msvc-config.jar"
ENTRYPOINT ["java", "-jar", "msvc-config.jar"]