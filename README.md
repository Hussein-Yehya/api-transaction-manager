# api-transaction-manager
API to manage account transactions

## Stack
The application was developed with Docker + JAVA 1.8 platform + Spring Boot 2.2.6.RELEASE framework.

## Requirements

- Docker
- default port 8080 for the application
- Java JDK > 1.8
- Maven

## Clone Repository
You run the command on the terminal to clone the repository or you can download
*  `https://github.com/Hussein-Yehya/api-transaction-manager.git`

## Maven Build 

*  `mvn clean install`

## Docker 
You can run the project using the docker commands directly
* `docker pull husseinyehya/api-transaction-manager`
* `docker run -d -p 8080:8080 -t husseinyehya/api-transaction-manager:latest`

## Access
Address to check if the application is running
`http://localhost:8080/ping`

# 
Following are operations exposed as REST API:

## Account
* Account create	(`/accounts`) [POST]
* Account find id (`/accounts/{account_id}`) [GET]

## Transaction
* Transaction create (`/transactions`) [POST]

#API Contract Documentation
It is possible to get information about the REST API contract by accessing the following URI: (`https://app.swaggerhub.com/apis-docs/huyehya7/pismo-transaction_manager/0.0.1`)


