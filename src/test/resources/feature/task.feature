@Task
  @SmokeTest
  Feature: Task Management
           In order to manage Task to assign, create, delete and modify the task
           for a respective Project
  Scenario: Create a new Task to assign a new project with a user associated
    Given I navigate to Tasks Page
    When I create a new task with Task Name "TaskName" and with taskDescription "TaskDescription"
         And a Project with ProjectName "projectName" associated
         And with StarDate "18 Nov 2015" and DueDate "18 Nov 2015"
    Then I should have a Task Created

    @SmokeTest
    Scenario: assign a new Task to assign a new project with a user associated
      Given I have been logged in ProjectBubble.com
      And I have a project created
          And a User created to associate it to the new task
      When I assign a new Task with an user
      Then The task should be assigned to a project
           And the task associated to an User


