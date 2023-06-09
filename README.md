# Spring-Sales-and-Order
### Introduction
A Simple API documentation on Sales and Inventory and Order Reports endpoints

### Project Support Features
* User can place orders
* User can request for order reports
* User can create product
* User can retrieve all available products

### Installation Guide
* Clone this repository [here](https://github.com/LuthyX/Spring-Sales-and-Order).
* The develop branch is the most stable branch at any given time, ensure you're working from it.
* Run maven to reload and install the dependencies
* Configure Your Postgres Credentials in the application.properties files on each sub module;
* Make you sure you have Apache Kafka installed on your computer to run it locally;
### Usage
* Navigate to your Kafka Directory and run "$bin/zookeeper-server-start.sh config/zookeeper.properties."to start Zookeeper service
* Then "$bin/zookeeper-server-start.sh config/zookeeper.properties" to start your broker service which runs on port 9082
* Run The Reports Application which runs on port 8081
* Run the Sales and Inventory Application which runs on port 8080 

### API Endpoints
| HTTP Verbs | Endpoints            | Action                                  |
|------------|----------------------|-----------------------------------------|
| POST       | /api/v1/product      | To create a Product                     |
| POST       | /api/v1/order        | To create an Order                      |
| POST       | /api/v1/report       | To generate Order Reports               |
| GET        | /api/v1/product      | To retrieve all available products      |
| PUT        | /api/v1/product/:id  | To edit the details of a single product |           |
### Technologies Used
* [Spring](https://spring.io/) This is a Java Backend Framework that allows us to create Restful applications.
* [Springboot](https://spring.io/) This is a Java Backend Framework that allows us to create Restful applications.
* [Postgres](https://www.postgresql.org/) This is a SQL database with scalability and structure. Data are stored in tables
* [Kafka](https://kafka.apache.org.com/) This is an open source distributed event streaming platform.