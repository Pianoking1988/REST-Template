# REST Webservice Template

## Description

Template for any REST based webservice, including:
* REST versionizing via /v1/..., /v2/...
* documentation of the interfaces via Swagger
* instant running via in-memory database which can by replaced with a local database individually by each user

## How to ...

### ... connect my own database instead of the in-memory database?

1. Make sure that your database driver exists within _pom.xml_, otherwise add it
2. Add the database connection properties and the flyway location paths to the VM arguments of your run configuration, for example:
* -DJDBC_DATABASE_DRIVER=com.mysql.jdbc.Driver
* -DJDBC_DATABASE_URL=jdbc:mysql://localhost:3306/rest?user=rest&password=rest
* -DJDBC_DATABASE_USERNAME=rest
* -DJDBC_DATABASE_PASSWORD=rest
* -Dflyway.locations=db/migration/mysql,db/migration/example
3. Adjust the flyway locations path to your needs. For eample remove _db/migration/example_ if you don't want the database to be filled with example data.

## Technologies

* _Spring-Boot_ / _Spring_
* _Swagger_ for documentation of the rest service
* _Flyway_ for automatic updates of database structures via scripts

## Problems / Issues

## Still missing / In the future

* Logback
* JGiven
* Lombok for automatic generation of getters, setters and boilerplate class methods