# dboaz-project

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

![UML](https://img.shields.io/badge/UML--white?style=for-the-badge)
![Markdown](https://img.shields.io/badge/Markdown--black?style=for-the-badge)


<br>

# Description packages

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

### Version

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details><br>

<br>

# Tecnical details

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

<br>

# Builds and Tests
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
