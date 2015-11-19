@Task
  @SmokeTest
  Feature: Task Management
           In order to manage Task to assign, create, delete and modify the task
           for a respective Project
    Background:
      Given I navigate to login Page
      And I login as "<joaquinjqn2@gmail.com>" with password "<P4ssw0rd>"
    @CreateTask
    Scenario: Create a new Task to assign a new project with a user associated
    Given I have Created a Project with "ProjectName","ProjectDescription","20 Nov 2015","25 Nov 2015"
          And I navigate to Tasks Page
      When I create a new task with Task Name "<TaskName>" and with taskDescription "<TaskDescription>"
         And I associate a Project with ProjectName
         And with the task StarDate "<18 Nov 2015>" and DueDate "<18 Nov 2015>"
    Then I should have a Task Created




