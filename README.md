# 1 - Decskill Technical Test

This repository contains code for solving the technical test for Decskill Technical Test.

# 2 - Run instructions

## 2.1 With Docker
For running this application we can use Docker Compose:

   ```
   docker compose up
   ```

## 2.1 Manually
> For running this application we use Gradle in version `8.5` and its wrapper (Java 21 is needed).

1. We can easily run the application on port `8080` (if needed to change the port it can be
   done [here](src/main/resources/application.yml)) with the following command:
    ```
    ./gradlew clean bootRun
    ```

2. To stop the application you can use this command (or simply close the cmd):
    ```
    ./gradlew -stop
    ```

# 3 - Test execution

The tests can be executed using the following command:

   ```
   ./gradlew clean test
   ```

The tests are executed in the GitHub pipelines as well:

[GitHub Actions](https://github.com/barjola/decskill-test/actions)

# 4 - OpenApi Specification

The API for this application is defined using the OpenAPI specification. 

The [openapi.yaml](specification/openapi.yml) file contains the complete API definition.

# 5 - Endpoints

On the top of the application I put [Springdoc Open API UI](https://github.com/springdoc/springdoc-openapi) to provide
a user-friendly UI for testing our endpoints.

Once the application is up and running, we can access the Open API
UI [here](http://localhost:8080/swagger-ui/index.html)
and test our endpoints in a super easy way

# 5 - Contact

- [Email - Daniel Barjola](mailto:danibarjola@gmail.com)
- [LinkedIn](https://www.linkedin.com/in/daniel-barjola/)
