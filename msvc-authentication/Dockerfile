FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-authentication-1.0.0.jar" "msvc-authentication.jar"
ENTRYPOINT ["java", "-jar", "msvc-authentication.jar"]