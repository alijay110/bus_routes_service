# Bus Route Challenge

### Introduction

This is my solution to Bus Route Challenge.
For more information about Bus Route Challenge please refer to CHALLENGE.md file.

### Approach

I decided to use Java 8 and Spring Boot (https://projects.spring.io/spring-boot/) for running Tomcat embedded server application
to serve the REST Api.

### Dependencies 
The application packaging uses Maven.
Additional dependencies included into the project are:

- Spring Boot Web Starter
- Spring Boot AOP Starter
- Lombok project (https://projectlombok.org/)
- JAMM Java Agent (https://github.com/jbellis/jamm) (licence: Apache Licence 2.0)

### Design considerations
To accomplish the challenge requirements:

*Your task is to implement a micro service which is able to answer whether there is a bus route providing a direct connection between two given stations.*

I decided that there is no restriction in station position along a route.
For example when we have routeId:1 and its stationIds:[1,2,3,4] it means that 
when requesting dep_sid=1 and arr_sid=4 returns true it would return true for dep_sid=4 and arr_sid=1 also.

*The bus route data file will be a local file and your service will get the path to file as the first command line argument. Your service will get restarted if the file or its location changes.*

I decided to pass the bus route data file as java argument to the program.
When there is no argument passed - the application uses default data/example file.

To pass custom file to the application please use --file.path=example/path as the argument to 
the application i.e:

**./service.sh dev_run --file.path=data/example**

When you run **./service.sh dev_run** without any file path, default file is being used.

WARNING: The docker command has not been tested ant it might not work.

### Requirements

To run service.sh please make sure you have Maven and Java installed locally.

### Error Codes
There are defined a few error codes in case of runtime exceptions:

    INVALID_REQUEST_PARAMS - 1000
    FILE_READING_ERROR - 1001
    NO_DATA_LOADED_ON_THE_SERVER - 1002
    FILE_HAS_NOT_ENOUGH_DATA - 1003
    FILE_CONTAINS_INVALID_CHARACTERS - 1004
    DEP_AND_ARR_IDS_ARE_THE_SAME - 1005

### How to start

You need to build the application firstly, then you can run it.

**To build**
Invoke **./service.sh dev_build** in microservice directory.

**To run**
Invoke
**./service.sh dev_run --file.path=my/data/example/file**

Where --file.path is an optional argument. When not set, the default example bus data provider is used from data/example subdirectory.

Default server port is 8088.
You can override server port settings by adding command line argument **--server.port** i.e: 

**./service.sh dev_run --server.port=8082**

### Tests

There is coverage of unit tests for both services and rest controllers.

I included additional performance tests regarding log execution time of methods (Using Spring AOP) and memory consumption by objects (using JAMM open source library). 




