# dboaz-project

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/GustavoBoaz/projeto_dboaz/main_spring-pipeline.yml)

The "dboaz-project" is a comprehensive online auction system designed to facilitate the buying and selling of a variety of products in a secure and efficient virtual environment. Below is a detailed description of the main components of the project:

### Author
- [@gustavoboaz](https://github.com/GustavoBoaz)

### Project skills
![Linux](https://img.shields.io/badge/Linux--orange?style=for-the-badge)
![Windows](https://img.shields.io/badge/Windows--brown?style=for-the-badge)

![Java](https://img.shields.io/badge/Java--red?style=for-the-badge)
![Git](https://img.shields.io/badge/Git--purple?style=for-the-badge)
![Shell](https://img.shields.io/badge/Shell--magenta?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven--green?style=for-the-badge)
![Docker](https://img.shields.io/badge/Docker--blue?style=for-the-badge)

![CleanArquitecture](https://img.shields.io/badge/Clean_Architecture--pink?style=for-the-badge)
![DesingPatters](https://img.shields.io/badge/Design_Patters--violet?style=for-the-badge)
![CleanCode](https://img.shields.io/badge/Clean_Code--yellow?style=for-the-badge)
![TDD](https://img.shields.io/badge/TDD--red?style=for-the-badge)
![BDD](https://img.shields.io/badge/BDD--brown?style=for-the-badge)

![UML](https://img.shields.io/badge/UML--white?style=for-the-badge)
![Markdown](https://img.shields.io/badge/Markdown--black?style=for-the-badge)
![Gherkin](https://img.shields.io/badge/Gherkin--gree?style=for-the-badge)


<br>

# Development process
<details>
  <summary>🛠 View</summary>

### <span style="color:green">New features</span> - *(when the solution does not exist)*
1. **QA (Junior)** - Add a feature section in this README within the `qa_acceptance` module.
2. **QA - OWNER (Mid level - Senior)** - Add the feature Gherkin in this README within the `qa_acceptance` module.
3. **QA (Junior - Mid level - Senior)** - Develop test automation in the `qa_acceptance` module.
4. **DEV (Junior)** - Add a feature section in this README within the module corresponding to the feature.
5. **DEV (Mid level - Senior)** - Create UML diagrams that represent this feature.
6. **DEV (Junior - Mid level - Senior)** - Develop the feature.

#### Pattern for new Branches (home branch):
- if new feature: Feature/[Title-Feature]/[initial-date-aaaaMMdd]/[Owner.Name]
- if new bug: Bug/[Title-Bug]/[initial-date-aaaaMMdd]/[Owner.Name]
- if new spike: Spike/[Title-Spike]/[initial-date-aaaaMMdd]/[Owner.Name]
#### Pattern worker in Branches (development branch):
- if feature: [aaaaMMdd]/[Developer.Name]/Feature/[Title-Feature]/[Description-feature]
- if bug: [aaaaMMdd]/[Developer.Name]/Bug/[Title-Bug]/[Description-bug]
- if spike: [aaaaMMdd]/[Developer.Name]/Spike/[Title-Spike]/[Description-spike]
#### Pattern Commit:
- if feature: [Developer.Name]/Feature/[Title-Feature]-[Description commit]
- if bug: [Developer.Name]/Bug/[Title-Bug]-[Description commit]
- if spike: [Developer.Name]/Spike/[Title-Spike]-[Description commit]

#### other Patters:
- if update in project: [aaaaMMdd]/[Owner.Name]/UPDATE-[Description-update]
- if create in project: [aaaaMMdd]/[Owner.Name]/CREATE-[Description-create]
- if delete in project: [aaaaMMdd]/[Owner.Name]/DELETE-[Description-create]

<span style="color:orange">**NOTE**</span>
- All development must be done based on the home branch.
- To develop bas create a development branch based on the home branch corresponding to Feature, Bug or Spike.
- Pull requests should be made to the home branch. When development is complete, the home branch should open a pull request to the main branch of the project.
- In case of refactoring during the project, update the Gherkin documentation and UML diagrams first.
- For common entities and those with a significant business impact, the Senior QA can create them in the `base_core` module.
- For solid definitions, the Mid-Level or Senior QA can include UML diagrams in the feature section within this README in the qa_acceptance module.

<br>

### <span style="color:yellow">Old Features</span> - *(when the solution exists but needs repairs and adjustments)*
1. **QA (Mid-Level - Senior)** - Adjust the feature section in this README within the `qa_acceptance` module.
2. **QA (Junior - Mid-Level - Senior)** - Adjust the test automation in the `qa_acceptance` module.
3. **DEV (Mid-Level - Senior)** - Adjust the UML diagrams that represent this feature.
4. **DEV (Junior - Mid-Level - Senior)** - Develop or adjust the feature.

</details><br><br>

# Description packages
<details>
  <summary>🛠 View</summary>

## qa_acceptance/
👨‍💻Responseible for project of test acceptance
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      └── test/
          ├── java/
          |   └── com/
          |        └── dboaz/
          |            └── steps
          └── resources/
              └── features
  ```
### Features
#### Feature F1# `Global info`:
:white_circle: developing
:white_circle: stopped
:radio_button: done
<details>
  <summary>🛠 View</summary>

- This feature is request for new resource in all microservise.
- Owner QA Test - Create feature gherkin in `resources/features/global_info.feature`.
- Owner QA Automation - Create model GlobalInfo in `base_core` module in folder `dboaz/utils/modules`.
- Owner QA Automation - Create steps in `steps/GlobalInfoStep.java`
- Owner DEV Back end - Implements feature in all microservices.
##### Gherkin
```gherkin
Feature: Verify /info endpoint in all microservices

  As a developer
  I want to ensure that all microservices have a /info endpoint
  So that I can retrieve essential API information like version, name, and description

  Scenario Outline: Validate response from /info endpoint of <service_name> microservice
    Given `F1#` - the "<service_name>" microservice is running
    When `F1#` - make a GET request to "<path>"
    Then `F1#` - the response should have an HTTP status 200
    And `F1#` - the response body should contain the following fields with expected values:
      | field       | expected_value |
      | name        | <service_name> |
      | version     | <version>      |
      | description | <description>  |

    Examples:
      | service_name      | path                    | version | description                                                                                                 |
      | ms_auction        | /ms_auction/info        | v1      | Responsible for managing auctions, including creation, closing and listing                                  |
      | ms_auth           | /ms_auth/info           | v1      | Responsible for user management, authentication and authorization                                           |
      | ms_bid            | /ms_bid/info            | v1      | Manages bidding logic during auctions, including tracking user bids                                         |
      | ms_comment_rating | /ms_comment_rating/info | v1      | Handles comments and ratings functionality for buyers and sellers                                           |
      | ms_logistic       | /ms_logistic/info       | v1      | Manages delivery and logistics information for auctioned products                                           |
      | ms_messaging      | /ms_messaging/info      | v1      | Provides messaging functionality for communication between users during auctions                            |
      | ms_notification   | /ms_notification/info   | v1      | Responsible for sending notifications, such as reminders of upcoming auctions, unread chat messages         |
      | ms_payment        | /ms_payment/info        | v1      | Handles transactions payments upon successful completion of an auction                                      |
      | ms_product        | /ms_product/info        | v1      | Stores information about the products being auctioned, including descriptions, images, and specific details |
      | ms_profile        | /ms_profile/info        | v1      | Stores and manages user-specific information such as contact details and preferences                        |
```
</details><br>

#### Feature F2# `Global SpringDoc`:
:white_circle: developing
:white_circle: stopped
:radio_button: done
<details>
  <summary>🛠 View</summary>

**This feature provide documentation OpenApi in all microservise.**
- Owner QA Mid level or Senior - Create feature in readme `qa_acceptance`.
- Owner QA Junior or Mid level - Create feature gherkin in `resources/features/global_springdoc.feature`.
- Owner QA Mid level or Senior - Create steps in `steps/GlobalSpringDocStep.java`
- Owner DEV Mid level or Senior - Implements feature in all microservices.
- Owner QA Senior - Validate manual tests.

**Util:**
- [OpenApi - Springdoc](https://springdoc.org/)
- [Bealdung](https://www.baeldung.com/spring-rest-openapi-documentation)

##### Gherkin
```gherkin
Feature: Verify /docs/openapi and /docs/swagger endpoint in all microservices

  As a developer
  I want to ensure that all microservices have a /docs/openapi and /docs/swagger endpoint
  So that I can retrieve essential API resources

  Scenario Outline: Validate response from /docs/openapi/ endpoint of <service_name> microservice
    Given `F2#` - the "<service_name>" microservice is running
    When `F2#` - make a GET request to "/docs/openapi"
    Then `F2#` - the response should have an HTTP status 200
    And `F2#` - the content-type equals application/json

    Examples:
      | service_name      |
      | ms_auction        |
      | ms_auth           |
      | ms_bid            |
      | ms_comment_rating |
      | ms_logistic       |
      | ms_messaging      |
      | ms_notification   |
      | ms_payment        |
      | ms_product        |
      | ms_profile        |

  Scenario Outline: Validate response from /docs/swagger/ endpoint of <service_name> microservice
    Given `F2#` - the "<service_name>" microservice is running
    When `F2#` - make a GET request to "/docs/swagger"
    Then `F2#` - the response should have an HTTP status 200
    And `F2#` - the content-type equals text/html

    Examples:
      | service_name      |
      | ms_auction        |
      | ms_auth           |
      | ms_bid            |
      | ms_comment_rating |
      | ms_logistic       |
      | ms_messaging      |
      | ms_notification   |
      | ms_payment        |
      | ms_product        |
      | ms_profile        |
```
</details><br>

#### Feature F3# `Global Custom Alert`:
:radio_button: developing
:white_circle: stopped
:white_circle: done
<details>
  <summary>🛠 View</summary>

**This feature is about implementing custom alerts for all microservices.**
- Owner QA Mid level or Senior - Create feature in readme `qa_acceptance`.
- Owner QA Junior or Mid level - Create feature gherkin in `resources/features/global_customalert.feature`.
- Owner QA Mid level or Senior - Create steps in `steps/GlobalCustomAlertStep.java`.
- Owner DEV Junior Mid level or Senior - Implements feature in all microservices.
- Owner QA Senior - Validate manual tests.

**Util:**
- [Controller Advice](https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-advice.html)
- [Custom Exceptions in spring](https://medium.com/@themoinmalik/custom-exceptional-handling-using-controlleradvice-8fc66eb49d03)
- [Custom Exceptions in java](https://medium.com/@salvipriya97/custom-exceptions-in-java-301ef3b568a3)

**Diagrams:**

*Information flow:*

![](/asset_diagrams/f3/d_information_flow.png)

##### Gherkin
```gherkin
Feature: Custom alert in microservices

  """
    As a developer
    I want to ensure that all microservices return a custom alert
    So that specific situations can be identified.
    
    Suggestive models:
    - GlobalException
      fiels:
        - String message 
        - Integer status
        - CustomAlert alert
    - CustomAlert
      fields:
        - SystemCodeEnum code
        - String action
    
    Examples:
      {
        "message": "Internal server error",
        "status": 500,
        "alert": {
          "code": "C001DB",
          "action": "We are taking care of the problem, please try again later"
        }
      }
      ....
      {
        "message": "Not found",
        "status": 404,
        "alert": {
          "code": "C002DB",
          "action": "The resource is not available"
        }
      }
  """

  Scenario Outline: Verify custom alert in microservices
    Given `F3#` - the "<service_name>" microservice is running
    When `F3#` - a request is made to the any endpoint that provides an alert
    Then `F3#` - the microservice should return a custom alert
      | GlobalException | CustomAlert |
      | message         | code        |
      | status          | action      |
      | alert           |             |

    Examples:
      | service_name      |
      | ms_auction        |
      | ms_auth           |
      | ms_bid            |
      | ms_comment_rating |
      | ms_logistic       |
      | ms_messaging      |
      | ms_notification   |
      | ms_payment        |
      | ms_product        |
      | ms_profile        |
```
</details><br>

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |
| `00.02` | **New Feature**: Global info                |
| `00.03` | **New Feature**: Global SpringDoc           |

</details><br>

## lib_common/

👨‍💻The lib features common.

<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   └── resources/
      |── test/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── integration/
      |   |           └── unit/
      |   └── resources/
      └── pom.xml
  ```

### Version
| Number  | Descrição                                                                         |
| :------ | :-------------------------------------------------------------------------------- |
| `00.01` | **Description**: include global libs - spring boot starter web, test and cucumber |

</details><br>

## base_core/

👨‍💻The base code core system.

<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── ms_auction/
      |   |           ├── ms_auth/
      |   |           ├── ms_bid/
      |   |           ├── ms_comment_rating/
      |   |           ├── ms_logistic/
      |   |           ├── ms_messaging/
      |   |           ├── ms_notification/
      |   |           ├── ms_payment/
      |   |           ├── ms_product/
      |   |           ├── ms_profile/
      |   |           └── utils/
      |   └── resources/
      |── test/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── integration/
      |   |           └── unit/
      |   └── resources/
      └── pom.xml
  ```

### Version
| Number  | Descrição                        |
| :------ | :--------------------------------|
| `00.01` | **Description**: initial version |

</details><br>

## bff_gateway/
👨‍💻It facilitates communication between different applications through application programming interfaces (APIs).
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_auction/
👨‍💻Responsible for managing auctions, including creation, closing and listing. It may involve timer logic to control the duration of auctions.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_auth/
👨‍💻Responsible for user management, authentication and authorization.
 Handling access tokens to ensure security.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_bid/
👨‍💻Manages bidding logic during auctions, including tracking user bids.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_comment_rating/
👨‍💻Handles comments and ratings functionality for buyers and sellers.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_logistic/
👨‍💻Manages delivery and logistics information for auctioned products.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_messaging/
👨‍💻Provides messaging functionality for communication between users during auctions.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_notification/
👨‍💻Responsible for sending notifications, such as reminders of upcoming auctions, unread chat messages, etc.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_payment/
👨‍💻Handles financial transactions, including deposits, fees, and releasing payments upon successful completion of an auction.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_product/
👨‍💻Stores information about the products being auctioned, including descriptions, images, and specific details.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

## ms_profile/
👨‍💻Stores and manages user-specific information such as contact details and preferences.
<details>
    <summary>🛠 Details</summary>
    <h3>Tree</h3>

  ```tree
  .
  ├── src/
      ├── main/
      |   ├── java/
      |   |   └── com/
      |   |       └── dboaz/
      |   |           ├── core/
      |   |           ├── infreastructure/
      |   |           └── resources//
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

</details><br><br>

# Tecnical details
<details>
  <summary>🛠 View</summary>

## Linux

```bash
java --version
openjdk 21.0.3 2024-04-16 LTS
OpenJDK Runtime Environment Temurin-21.0.3+9 (build 21.0.3+9-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.3+9 (build 21.0.3+9-LTS, mixed mode, sharing)
```
```bash
mvn --version
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 21.0.3, vendor: Eclipse Adoptium, runtime: /home/gustavo/.sdkman/candidates/java/21.0.3-tem
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.5.0-15-generic", arch: "amd64", family: "unix"
```
```bash
docker --version
Docker version 25.0.1
```
```bash
docker-compose --version
docker-compose version 1.29.2
```
## Windows

```bash
java --version
java 21.0.1 2023-10-17 LTS
Java(TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29, mixed mode, sharing)
```
```bash
mvn --version
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\Program Files\Maven\apache-maven-3.9.6
Java version: 21.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-21
Default locale: pt_BR, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```
```bash
docker --version
Docker version 26.1.1, build 4cf5afa
```
```bash
docker-compose --version
Docker Compose version v2.27.0-desktop.2
```
</details><br><br>

# Builds and Tests
<details>
  <summary>🛠 View</summary>

## Test ALL modules local

In current folder run build mvn command `mvn clean verify`, ex:

```bash
mvn clean verify
```

## Build ALL modules local

In current folder run build mvn command `mvn clean package`, ex:

```bash
mvn clean package
```

## Run ONE module local

In current folder run sh command `./dev_run.sh <name_module>`, this command build all modules and run expecific module. ex:
- Execute `chmod +x dev_run.sh` case if not permition.

```bash
./dev_run.sh ms_auction
```

## Run docker-compose local: ONLY Linux

This project includes the following scripts that can be used to simplify common tasks:

- `./dev_start_linux.sh`: Creates the application's target and runs the mss in Docker (docker-compose up).
- `./dev_stop_linux.sh`: Clears the application's target and removes the Docker mss (docker-compose down).

Before running the scripts, make sure to grant execution permissions on your machine using the command `chmod +x nome_do_script.sh`.

## Run docker-compose local: ONLY Windows

This project includes the following scripts that can be used to simplify common tasks:

- `./dev_start_windows.sh`: Creates the application's target and runs the mss in Docker (docker-compose up).
- `./dev_stop_windows.sh`: Clears the application's target and removes the Docker mss (docker-compose down).

Before running the scripts, make sure to grant execution permissions on your machine using the command `chmod +x nome_do_script.sh`.
</details><br><br>
