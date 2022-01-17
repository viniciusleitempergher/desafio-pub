FROM maven

WORKDIR /incoming-balance-service

COPY . .

CMD ["mvn", "spring-boot:build-image", "-DskipTests", "package"]