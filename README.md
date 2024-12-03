# Algorithm Directory Server

This directory is meant to be used with Algorithm Directory which can be found in the following. [link](https://github.com/allenjkung/AlgorithmDirectory).

Currently, it is meant to be used locally as the location for where to live and host it is still under research and therefore unknown.

## Installation

Java version of at least version 17 (JDK 17) or later is required. To confirm Java and version run the following command.
```bash
java -version
```

If Java is not installed, go and install [Java](https://www.java.com/en/) or a different JDK of choice.

If Java version is outdated, follow JDK website used for instructions on how to update Java to the latest version.

Maven is required in order to run. To check if Maven is installed, run the following command.
```bash
mvn -v
```

If Maven is not installed, go and install [Maven](https://maven.apache.org/).

Once Java and Maven are installed, run the following command below in the directory location of choice.
```bash
git clone https://github.com/allenjkung/AlgorithmDirectoryServer.git
```

## Running for Development/Building for Production

To run the client, open a shell command prompt, go to the directory and run the command below.
```bash
mvn spring-boot:run
```

The server should now be running http://localhost:8080