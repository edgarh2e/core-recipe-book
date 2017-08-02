Core Recipe Book
===============================

# core-recipe-book

*Microservice* project with *Spring boot* & *Gradle* that contains all the modules and functionalities 
to communicate and persist information (Resquests/Responses) beetwen View through RESTful Services (JSON) and Data Base.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Hardware (Minimum):

* Laptop or PC.
* 8GB RAM
* Intel® Core™ i5
* 2.80GHz 

Software:

* IntellijIDE or other IDE.
* SDKMAN [`http://sdkman.io/install.html`](http://sdkman.io/install.html)*
* Gradle [`https://gradle.org/install/`](https://gradle.org/install/)*
* java 8.
* Docker (Optional)
* MariaDB (Optional Docker image) [`https://hub.docker.com/r/edgarh2e/mariadb/`](https://hub.docker.com/r/edgarh2e/mariadb/)*

### Installing

Clone the project in your local machine:

```
clone https://github.com/edgarh2e/core-recipe-book.git
```

## Deployment

1. Create the file **application.properties** in your local machine with the route **${HOME}/../../application.properties** with the next elements:

```
server.port=8081
```

2. Running the tests:

```gradle test```

3. Build project:

```gradle clean build```

3. Deploy local:


```gradle bootRun```
