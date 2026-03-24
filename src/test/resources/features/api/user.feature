@api
Feature: User Management API
  As a developer, I want to manage user data through the DummyAPI.

  Scenario: Get User by ID successfully
    Given I have a valid app-id "63a804408eb0cb069b57e43a"
    When I send a GET request to user with ID "60d0fe4f5311236168a109ca"
    Then the response status code should be 200
    And the response should contain the user's firstName and lastName