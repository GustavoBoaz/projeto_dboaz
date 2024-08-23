Feature: Global microservices

    Scenario: All microservices return version resource
        Given that the customer wants to know the version of the resource
        When the client makes call to GET /version
        Then the client receives status code of 200
        And the client receives server version 1.0
