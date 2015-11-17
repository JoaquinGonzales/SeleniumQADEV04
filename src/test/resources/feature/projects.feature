@projects
Feature: Projects Management
        In order to manage project with the application we need to create, delete
        and modify the distinct types of projects in ProjectBubble.com
  Background:
    Given I navigate to login Page
    And I login as "joaquinjqn2@gmail.com" with password "P4ssw0rd"
    @Project
   Scenario Outline: Create a new project with Project Name and Project Description
    Given I want to create a project
    When  I create a new project with "<ProjectName>" and a "<ProjectDescription>"
          And with a Start Date "11/17/2015" and with a Finish Date "11/25/2015"
    Then I should have the project created in the main page
      Examples:
      |ProjectName  |ProjectDescription   |
      |ProjectName1 |ProjectDescription1  |
      |ProjectName2 |ProjectDescription2  |

  Scenario Outline: Delete a project with Project Name and Project Description
    Given I go to projects page
          And I have a Project Created with "<ProjectName>" and "<ProjectDescription>"
    When  I Delete a Project with "<ProjectName>" and "<ProjectDescription>"
    Then I should have the project created in the main page
  Examples:
    |ProjectName  |ProjectDescription   |
    |ProjectName1 |ProjectDescription1  |


