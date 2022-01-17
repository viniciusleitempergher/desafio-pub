FROM maven

WORKDIR /expending-balance-service

COPY . .

CMD ["mvn", "spring-boot:build-image", "-DskipTests", "package"]