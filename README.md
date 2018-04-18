### statflo code challenge
technologies: Spring boot, Spring data (with HSQLDB embedded), Spring test, Swagger, mongodb, maven

### How to run?

Install [Docker](https://www.docker.com/)

Install [Docker Compose](https://docs.docker.com/compose/)

Run the following command:

if linux/mac
```./mvnw clean package -DskipTests```

if windows
```mvnw.cmd clean package -DskipTests```

Tests will be executed inside docker container

```docker-compose up```

### Documentation
http://localhost:8182/swagger-ui.html

### Services 
To query a specific user
```GET http://localhost:8182/users/?role=foo ```

Save user
```POST http://localhost:8182/users/```
