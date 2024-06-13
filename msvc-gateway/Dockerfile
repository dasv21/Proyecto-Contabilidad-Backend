FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-gateway-1.0.0.jar" "msvc-gateway.jar"
ENTRYPOINT ["java", "-jar", "msvc-gateway.jar"]