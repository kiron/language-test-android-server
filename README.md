# language-test-server

## Build 

### Maven

* In the project's root directory run `mvn package`
* The build will produce a java archive `gs-rest-service-0.1.0.jar` in the `target` directory

### Gradle

Todo

##Deployment

* Run PostgreSQL database server first (and ensure the schema is set up, see `postgres-schema.sql` for schema creation)
* Fill the database with questions
* Start the server application by running the java archive with `java -jar gs-rest-service-0.1.0.jar`

## Notes

* The implementation of the REST server is based on the [Spring framework](https://spring.io/)'s tutorial for a [REST server](https://spring.io/guides/gs/rest-service/)
* Currently, the database connection is hard-coded and points to a server that is no longer available
