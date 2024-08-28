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

