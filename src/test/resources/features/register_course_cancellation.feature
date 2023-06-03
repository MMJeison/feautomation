Feature: Register a course cancellation on the university platform
  As student
  I want to make a request to cancel a course on the platform
  So my request can be evaluated


Scenario: Cancel a course fulfilling all the requirements of the student regulation
  Given I am in the course cancellation section with my platform user
  When I fill all the required fields to make a cancellation request
  Then I can see that my request was successfully registered

Scenario: Cancel a course and remain with less than 8 credits enrolled
  Given I am in the course cancellation section with my platform user 2
  When I fill all the required fields to make a cancellation request 2
  Then I can see an error message for the amount of credits enrolled