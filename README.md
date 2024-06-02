# dboaz-project

The "dboaz-project" is a comprehensive online auction system designed to facilitate the buying and selling of a variety of products in a secure and efficient virtual environment. Below is a detailed description of the main components of the project:

## Description packages

### lib_common/
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
      |   |           ├── app/
      |   |           ├── properties/
      |   |           ├── server/
      |   |           └── utils/
      |   └── resources/
      └── test/
          ├── java/
          |   └── com/
          |       └── dboaz/
          |           ├── integration/
          |           └── unit/
          └── resources/
  ```

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### bff_gateway/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_auction/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_auth/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_bid/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_comment_rating/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_logistic/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_messaging/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_notification/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_payment/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_product/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### ms_profile/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

### qa_acceptance/
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

<h3>Version</h3>

| Number  | Descrição                                   |
| :------ | :------------------------------------------ |
| `00.01` | **Description**: initial version            |

</details>

## Test ALL modules local

In current folder run build mvn command `mvn clean test`, ex:

```bash
mvn clean test
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

## Run docker-compose local

This project includes the following scripts that can be used to simplify common tasks:

- `./dev_start.sh`: Creates the application's target and runs the mss in Docker (docker-compose up).
- `./dev_stop.sh`: Clears the application's target and removes the Docker mss (docker-compose down).

Before running the scripts, make sure to grant execution permissions on your machine using the command `chmod +x nome_do_script.sh`.