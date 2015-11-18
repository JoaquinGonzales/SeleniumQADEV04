@projects
Feature: Projects Management
        In order to manage project with the application we need to create, delete
        and modify the distinct types of projects in ProjectBubble.com
  Background:
    Given I navigate to login Page
    And I login as "joaquinjqn2@gmail.com" with password "P4ssw0rd"
    @Project
   Scenario: Create a new project with Project Name and Project Description with a Start Date
             and a Due Date for the project
    Given I want to create a project
    When  I create a new project with "ProjectName" and a "ProjectDescription"
          And with a Start Date "Nov 17 2015" and with a Finish Date "Nov 25 2015"
    Then I should have the project created in the main page

   Scenario: Delete a Project with Project Name and Project Description
   Given


