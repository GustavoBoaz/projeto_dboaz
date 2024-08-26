Feature: Verify /doc/apis.html endpoint in all microservices

  As a developer
  I want to ensure that all microservices have a /doc/apis.html endpoint
  So that I can retrieve essential API resources

  Scenario Outline: Validate response from /doc/apis.html endpoint of <service_name> microservice
    Given `F2#` - the "<service_name>" microservice is running
    When `F2#` - make a GET request to "<path>"
    Then `F2#` - the response should have an HTTP status 200

    Examples:
      | service_name      | path                             |
      | ms_auction        | /ms_auction/doc/apis.html        |
      | ms_auth           | /ms_auth/doc/apis.html           |
      | ms_bid            | /ms_bid/doc/apis.html            |
      | ms_comment_rating | /ms_comment_rating/doc/apis.html |
      | ms_logistic       | /ms_logistic/doc/apis.html       |
      | ms_messaging      | /ms_messaging/doc/apis.html      |
      | ms_notification   | /ms_notification/doc/apis.html   |
      | ms_payment        | /ms_payment/doc/apis.html        |
      | ms_product        | /ms_product/doc/apis.html        |
      | ms_profile        | /ms_profile/doc/apis.html        |
