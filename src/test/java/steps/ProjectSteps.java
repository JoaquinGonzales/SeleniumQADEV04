package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import framework.ElementManager;
import org.testng.Assert;
import ui.pages.CreateProjectPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.ProjectPage;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/13/15
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectSteps {
    public MainPage main;
    public LoginPage loginPage;
    public CreateProjectPage createprojectPage;
    public ProjectPage projectPage;
    public String newProjectName, newProjectDescription;


    @Given("^I want to create a project$")
    public void createProject()
    {
        main = new MainPage();
        createprojectPage = main.createProject();
    }
    @Given("^I go to Projects page$")
    public void navigateToProjectPage(String projectName)
    {
        projectPage = main.goToProjectPage();

    }

    @When("^I create a new project with \"(.*?)\" and a \"(.*?)\"$")
    public void createNewProject(String projectName, String projectDescription)
    {
        newProjectName = projectName;
        newProjectDescription = projectDescription;
        createprojectPage = createprojectPage.setProjectName(projectName);
        createprojectPage = createprojectPage.setProjectDescription(projectDescription);

    }
    @And("^with a Start Date \"(.*?)\" and with a Finish Date \"(.*?)\"$")
    public void setStartAndFinishDate(String startDate, String finishDate)
    {
        createprojectPage = createprojectPage.setStartDate(startDate);
        createprojectPage = createprojectPage.setDueDate(finishDate);
        main = createprojectPage.clickSaveButton();
    }
    @Then("^I should have the project created in the main page$")
    public void projectCreated()
    {
        boolean projectCreated = main.isElementCreated(newProjectName);
        Assert.assertEquals(projectCreated, true, "the project was created correctly");
    }

    @After(value = "@logout",order=998)
    public void logOut()
    {
        loginPage = main.logOut();
    }
    @After(value = "@CreateProject",order = 999 )
    public void deleteProject()
    {

    }

}
