@web
Feature: User Authentication on SauceDemo
  As a user, I want to login to the SauceDemo website so that I can access the product list.

  Scenario Outline: User logins with various credentials
    Given user opens the login page
    When user enters username "<username>" and password "<password>"
    And user clicks the login button
    Then user should see the "<result>"

    Examples:
      | username      | password     | result                |
      | standard_user | secret_sauce | products page         |
      | locked_out_user| secret_sauce | an error message      |