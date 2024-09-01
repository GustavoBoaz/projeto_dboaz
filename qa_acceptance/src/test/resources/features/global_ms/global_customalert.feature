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

    Example:
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
