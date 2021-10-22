
This project contains example to demonstrate fundamentals of spring-security Authentication/Authorization.

1. Default form based authentication 
2. Custom login screen for authentication.

spring profile feature is used to switch authentication mechanism. 'customlogin' profile will enable configuration and beans for
custom login authentication mechanism.If no profile specified default spring provided login flow will be used
for Authentication.

Dependencies:

1. Dependency on mysql database


How to run the application:

1. Make sure to run the mysql docker image.
   docker container run -p 3306:3306 --name mysql-1 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

   docker-compose

2. Run the DDL scripts available in db folder.
3. Create two users for the testing the authentication. 
4. encrypted Passwords can be generated in springboot cli.


Pending:

1. Method level annotation @PreAuthorize and @PostAuthorize examples
2. Dockerizing the complete app.
