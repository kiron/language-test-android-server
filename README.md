# language-test-server

## Build 

* In the project's root directory run Maven `mvn package`
* The build will produce a java archive `language-assessment-server-X.Y.Z.jar` in the `target` directory

## Deployment

* Run PostgreSQL database server first (and ensure the schema is set up, see `postgres-schema.sql` for schema creation)
* Fill the database with questions
* Start the server application by running the java archive with `java -jar language-assessment-server-X.Y.Z.jar`
* The server will now listen on port 8080

## Notes

* The implementation of the REST server is based on the [Spring framework](https://spring.io/)'s tutorial for a [REST server](https://spring.io/guides/gs/rest-service/)
* Currently, the database connection is hard-coded and points to a server that is no longer available
