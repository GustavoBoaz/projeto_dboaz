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
