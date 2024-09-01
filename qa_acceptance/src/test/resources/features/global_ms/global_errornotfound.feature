Feature: Redirect requests to /notfound

  """
  As a developer,
  I want to ensure that all microservices return a standardized custom alert for non-existent endpoints
  So that specific situations can be identified and handled consistently across services.

  Expected response format:
    {
      "message": "Not found",
      "status": 404,
      "alert": {
        "code": "C002DB",
        "action": "The resource is not available"
      }
    }
  """

  Scenario Outline: Verify custom alert response for non-existent endpoints
    Given `F4#` - the "<service_name>" microservice is running
    When `F4#` - a request is made to an invalid or non-existent endpoint
    Then `F4#` - the microservice should return a custom alert response
      | Field           | Expected Value                |
      | message         | Not found                     |
      | status          | 404                           |
      | alert.code      | C002DB                        |
      | alert.action    | The resource is not available |

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
