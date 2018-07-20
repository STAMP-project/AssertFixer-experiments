[![Build Status](https://travis-ci.org/Brest-Java-Course-2018/Dmitriy-Shestak.svg?branch=master)](https://travis-ci.org/Brest-Java-Course-2018/Dmitriy-Shestak) 
[![Coverage Status](https://coveralls.io/repos/github/Brest-Java-Course-2018/Dmitriy-Shestak/badge.svg)](https://coveralls.io/github/Brest-Java-Course-2018/Dmitriy-Shestak)

# Beer factory
Sample web application for beer management.
## Prerequisites
* JDK 1.8 and higher
* Spring 4 Framework  
* Maven v3.2.2
* Jetty v.9.4.8  
* H2 database v1.4.196
* Camel 2.21.1

## Getting Started
1. Download source code: `git clone https://github.com/Brest-Java-Course-2018/Dmitriy-Shestak.git`.
2. Install the application: `mvn install`.
3. Prepare reports: `mvn site` then `mvn site:stage`. Available at `<project_name>/target/stage/index.html`
4. Start jetty server for rest service: `mvn -pl rest-app/ jetty:run`.
5. Start jetty server for soap service: `mvn -pl soap-app/ jetty:run`.
6. Start jetty server for web application: `mvn -pl web-app/ jetty:run`.
7. Start camel for rest and soap integration: `mvn -pl camel-integration/ camel:run`.
8. Now, you can see result at `http://localhost:8080/` in browser. For rest service use `http://localhost:8085/`.
9. For changing direction from soap (default) to rest and back use MBean `direction` (availble values: `rest` and `soap`).

### REST API

| URL                                                       | Method | Description                                        |
|-----------------------------------------------------------|--------|----------------------------------------------------|
| "/beerfactory/beers"                                      | GET    | Return list of all beers                           |
| "/beerfactory/beers/{beerId}"                             | GET    | Return beer by ID                                  |
| "/beerfactory/beers"                                      | POST   | Create new beer                                    |
| "/beerfactory/beers/{beerId}"                             | PUT    | Update beer                                        |
| "/beerfactory/beers/{beerId}"                             | DELETE | Remove beer by ID                                  |
| "/beerfactory/beers/review"                               | POST   | Add new beer review                                |
| "/beerfactory/orders"                                     | GET    | Return list of all orders                          |
| "/beerfactory/orders?fromDate={fromDate}&toDate={toDate}" | GET    | Return list of orders filtered by date             |
| "/beerfactory/orders/{orderId}"                           | GET    | Return order by ID                                 |
| "/beerfactory/orders"                                     | POST   | Create new order                                   |
| "/beerfactory/orders/{orderId}"                           | DELETE | Remove order by ID                                 |





