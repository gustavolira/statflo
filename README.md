### statflo code challenge
technologies: Spring boot, Spring data (with HSQLDB embedded), Spring test, Swagger, mongodb, maven

### How to run?
docker-compose up

### Documentation
http://localhost:8182/swagger-ui.html

### Services 
To query a specific user
```GET http://localhost:8182/users/?role=foo ```

Save user
```POST http://localhost:8182/users/```
