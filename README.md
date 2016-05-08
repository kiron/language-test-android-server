# language-test-server

## Build 

* In the project's root directory run Maven `mvn package` (or run Maven via your IDE) 
* The build will produce a java archive `language-assessment-server-X.Y.Z.jar` in the `target` directory

## Deployment

* Run PostgreSQL database server first (and ensure the schema is set up, see `postgres-schema.sql` for schema creation)
* Fill the database with questions
* Start the server application by running the java archive with `java -jar language-assessment-server-X.Y.Z.jar`
* The server will now listen on port 8080

## REST Queries

### Retrieving Questions

All questions for a language assessment test can be retrieved with a single request:

`/questions`

The answer will provide a JSON structure with the questions (ids, question text, question image url, and answers).

### Submitting Answers

The following request allows for the submission of the answers of the language assessment test:

`/submit/{answers}?username={username}`

The server will answer with a JSON structure giving back a status (boolean) and a message that may contain information in case something went wrong.

where

* `{answers}` has the structure `{questionId:(A|B|C|D),}+{questionId:(A|B|C|D)}`
  * `questionId` is the question's unqiue id
  * `(A|B|C|D)` are the four options to answer the question
* `{username}` is the user's name as entered in the beginning of the test in the mobile application 
  
#### Example

`/submit/12:A,13:B:16:D?username=John`

## Notes

* The implementation of the REST server is based on the [Spring framework](https://spring.io/)'s tutorial for a [REST server](https://spring.io/guides/gs/rest-service/)
* Currently, the database connection is hard-coded and points to a server that is no longer available
