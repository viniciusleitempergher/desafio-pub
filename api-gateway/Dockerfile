FROM maven

WORKDIR /api-gateway

COPY . .

CMD ["mvn", "spring-boot:build-image", "-DskipTests", "package"]