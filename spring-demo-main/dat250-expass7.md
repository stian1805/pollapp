 Report

 The docker run command needs to expose port 5432 and set the enviroment variable POSTGRES_PASSWORD. Used a SQL client to manually apply the tables to the database to pass the
 Unit tests using the PostgresSQL database. 

 Followed the lecture example to create a dockerfile. Created a new user and directory to avoid running the application as root. Used multi staged build to reduce vulnerabilities and size of the final image.
Dockerfile: https://github.com/stian1805/pollapp/blob/main/spring-demo-main/Dockerfile
