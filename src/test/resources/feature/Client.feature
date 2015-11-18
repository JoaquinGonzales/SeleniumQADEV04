@Client
Feature: Clients Management
         In order to manage clients with the application we need to create, delete
         and modify clients that will be the owners of our projects
  Background:
    Given I navigate to login Page
    And I login as "joaquinjqn2@gmail.com" with password "P4ssw0rd"
    @Client
    Scenario:Create a new Client to be a product owner of the project
     Given I navigate to Client Page
     When I create a new Client