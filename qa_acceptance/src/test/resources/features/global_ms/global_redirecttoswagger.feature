Feature: Redirect requests base path / to /docs/swagger

  """
  As a developer,
  I want to ensure that all microservices return a standardized custom alert for non-existent endpoints
  So that specific situations can be identified and handled consistently across services.

  Expected response:
    - status response equals 200
    - content-type equals text/html
  """

  Scenario Outline: Verify redirec base path / to /docs/swagger
    Given `F5#` - the "<service_name>" microservice is running
    When `F5#` - make a GET request to "/"
    Then `F5#` - the response should have an HTTP status 200
    And `F5#` - the content-type equals text/html

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
