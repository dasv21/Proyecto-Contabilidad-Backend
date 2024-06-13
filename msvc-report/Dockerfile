FROM eclipse-temurin:21
VOLUME /tmp
COPY "target/msvc-report-1.0.0.jar" "msvc-report.jar"
ENTRYPOINT ["java", "-jar", "msvc-report.jar"]