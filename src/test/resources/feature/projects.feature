@projects
Feature: Projects Management
        In order to manage project with the application we need to create, delete
        and modify the distinct types of projects in ProjectBubble.com
  Background:
    Given I navigate to login Page
    And I login as "joaquinjqn2@gmail.com" with password "P4ssw0rd"
    @Project
   Scenario Outline: Create a new project with an client associated and the user
              that will have access to work with the project
    Given I want to create a project
          And I have an active Client
    When  I create a new project with "<ProjectName>" and a "<ProjectDescription>"
    Then I should have the project created in the main page
      Examples:
      |ProjectName  |ProjectDescription   |
      |ProjectName1 |ProjectDescription1  |

  Scenario Outline: Delete a project with an client associated and the user
  that will have access to work with the project
    Given I want to create a project
    When  I create a new project with "<ProjectName>" and a "<ProjectDescription>"
    Then I should have the project created in the main page
  Examples:
    |ProjectName  |ProjectDescription   |
    |ProjectName1 |ProjectDescription1  |


