Feature: Login to the university platform
    As a user (student or teacher) of the university
    I want to log in to the university platform
    So that I can to access the functionalities of the page

Scenario: Login successfully
    Given I am on the login page
    When I enter my username and password
    Then I should be able to access the platform

Scenario: Login with wrong user or incorrect password
    Given I am on the login page 2
    When I enter a wrong username and a password
    Then I should see an error message showing that the input fields are wrong

Scenario: Empty fields
    Given I am on the login page of the platform
    When I click on the login button
    Then I should see an warning message
