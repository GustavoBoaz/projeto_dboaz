# dboaz-project

The "dboaz-project" is a comprehensive online auction system designed to facilitate the buying and selling of a variety of products in a secure and efficient virtual environment. Below is a detailed description of the main components of the project:

## Description packages

### common/
- The project common.

### gateway/
- It facilitates communication between different applications through application programming interfaces (APIs).

### ms_auction/
- Responsible for managing auctions, including creation, closing and listing.
- It may involve timer logic to control the duration of auctions.

### ms_auth/
- Responsible for user management, authentication and authorization.
- Handling access tokens to ensure security.

### ms_bid/
- Manages bidding logic during auctions, including tracking user bids.

### ms_comment_rating/
- Handles comments and ratings functionality for buyers and sellers.

### ms_logistic/
- Manages delivery and logistics information for auctioned products.

### ms_messaging/
- Provides messaging functionality for communication between users during auctions.

### ms_notification/
- Responsible for sending notifications, such as reminders of upcoming auctions, unread chat messages, etc.

### ms_payment/
- Handles financial transactions, including deposits, fees, and releasing payments upon successful completion of an auction.

### ms_product/
- Stores information about the products being auctioned, including descriptions, images, and specific details.

### ms_profile/
- Stores and manages user-specific information such as contact details and preferences.

### test_acceptance/
- Responseible for project of test acceptance

### test_load/
- Responseible for project of test load


## Run local: Linux

This project includes the following scripts that can be used to simplify common tasks:

- `./dev_start.sh`: Creates the application's target and runs the mss in Docker (docker-compose up).
- `./dev_stop.sh`: Clears the application's target and removes the Docker mss (docker-compose down).

Before running the scripts, make sure to grant execution permissions on your machine using the command `chmod +x nome_do_script.sh`.


## Versions - Releases

`core/` :
- **00.01** initial version

`gateway/` :
- **00.01** initial version

`ms_auction/` :
- **00.01** initial version

`ms_auth/` :
- **00.01** initial version

`ms_bid/` :
- **00.01** initial version

`ms_comment_rating/` :
- **00.01** initial version

`ms_logistic/` :
- **00.01** initial version

`ms_messaging/` :
- **00.01** initial version

`ms_notification/` :
- **00.01** initial version

`ms_payment/` :
- **00.01** initial version

`ms_product/` :
- **00.01** initial version

`ms_profile/` :
- **00.01** initial version

`test_acceptance/` :
- **00.01** initial version

`test_load/` :
- **00.01** initial version
