package steps;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.pages.*;

import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/19/15
 * Time: 9:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaskSteps
{
    public MainPage main;
    public TaskPage taskPage;
    public CreateTaskPage createTaskPage;
    public ProjectPage projectPage;
    public CreateProjectPage createProjectPage;
    public String newProjectName,newTaskName;

    @Given("^I have Created a Project with \"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"")
    public void createNewProject(String projectName, String projectDescription, String startDate, String dueDate)
    {
        newProjectName = projectName;
        projectPage = main.goToProjectPage();
        createProjectPage = projectPage.createNewProject();
        main = createProjectPage.createProject(projectName,projectDescription,startDate,dueDate);
    }
    @And("^I navigate to Tasks Page$")
    public void navigateToTaskPage()
    {
        taskPage = main.gotoTaskPage();
        createTaskPage = taskPage.createNewTask();
    }
    @When("^I create a new task with Task Name \"(.*?)\" and with taskDescription \"(.*?)\"$")
    public void createNewTask(String taskName, String taskDescription)
    {
        newTaskName = taskName;
        createTaskPage = createTaskPage.setTaskName(taskName);
        createTaskPage = createTaskPage.setTaskDescription(taskDescription);
    }
    @And("^I associate a Project with ProjectName$")
    public void associateProject()
    {
        createTaskPage = createTaskPage.setProjectAssociation(newProjectName);
    }
    @And("^with the task StarDate \"(.*?)\" and DueDate \"(.*?)\"$")
    public void setTaskDate(String startDate, String dueDate)
    {
        createTaskPage = createTaskPage.setStartDate(startDate);
        createTaskPage = createTaskPage.setDueDate(dueDate);
        main = createTaskPage.clickSaveButton();
    }
    @Then("^I should have a Task Created$")
    public void taskCreated()
    {
        boolean actualResult = main.isElementCreated(newTaskName);
        Assert.assertEquals(actualResult,true,"task Created");
    }

    @After(value = "@CreateTask",order = 999)
    public void logout()
    {
       main.logOut();
    }
}
