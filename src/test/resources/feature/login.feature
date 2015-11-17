@login
Feature: Login for ProjectBubble.com
  Test successfully and unsuccessfully  login and logout
  @SmokeTest
  Scenario: Login to the ProjectBubble.com with valid credentials
    Given  I navigate to login Page
    When  I login as "joaquinjqn2@gmail.com" with password "P4ssw0rd"
    Then   I should be login successfully

  @SmokeTest
   Scenario: Login to the ProductBubble.com with invalid credentials
      Given I navigate to login Page
      When  I login as wrong email "joaquin.gonzales@gmail.com" with password "P4ssw0rd!@#$1"
      Then I should not be logged in the application



