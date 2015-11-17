@Task
  @SmokeTest
  Feature: Task Management
           In order to manage Task to assign, create, delete and modify the task
           for a respective Project
  Scenario: Create a new Task to assign a new project with a user associated
    Given I have been logged in ProjectBubble.com
          And I have a project created
    When I create a new Task
         And I associate the task with the project
    Then The task should be created assigned to a project

    @SmokeTest
    Scenario: assign a new Task to assign a new project with a user associated
      Given I have been logged in ProjectBubble.com
      And I have a project created
          And a User created to associate it to the new task
      When I assign a new Task with an user
      Then The task should be assigned to a project
           And the task associated to an User


