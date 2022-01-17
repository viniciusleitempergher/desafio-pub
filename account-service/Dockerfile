FROM maven

WORKDIR /account-service

COPY . .

CMD ["mvn", "spring-boot:build-image", "-DskipTests", "package"]