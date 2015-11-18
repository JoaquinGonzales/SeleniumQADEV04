package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.testng.Assert;
import ui.pages.CreateProjectPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/13/15
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Project {
    public MainPage main;
    public LoginPage loginPage;
    public CreateProjectPage projectPage;
    public String newProjectName;
    public String newProjectDesctiption;

    @Given("^I want to create a project$")
    public void createProject()
    {
        main = new MainPage();
        projectPage = main.createProject();
    }

    @When("^I create a new project with \"(.*?)\" and a \"(.*?)\"$")
    public void createNewProject(String projectName, String projectDescription)
    {
        newProjectName = projectName;
        newProjectDesctiption = projectDescription;
        projectPage = projectPage.setProjectName(projectName);
        projectPage = projectPage.setProjectDescription(projectDescription);

    }
    @And("^with a Start Date \"(.*?)\" and with a Finish Date \"(.*?)\"$")
    public void setStartAndFinishDate(String startDate, String finishDate)
    {
        projectPage = projectPage.setStartDate(startDate);
        projectPage = projectPage.setDueDate(finishDate);
        main = projectPage.clickSaveButton();
    }
    @Then("^I should have the project created in the main page$")
    public void projectCreated()
    {
        boolean projectCreated = main.projectCreated(newProjectName);
        Assert.assertEquals(projectCreated, true, "the project was created correctly");
    }

    @After(value = "@Project",order=999)
    public void logOut()
    {
        loginPage = main.logOut();
    }

}
