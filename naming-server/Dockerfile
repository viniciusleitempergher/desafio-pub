FROM maven

WORKDIR /naming-server

COPY . .

CMD ["mvn", "spring-boot:build-image", "-DskipTests", "package"]