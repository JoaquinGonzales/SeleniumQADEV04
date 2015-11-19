package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DriverManager;
import org.junit.Before;
import org.testng.Assert;
import ui.BasePageObject;
import ui.PageTransporter;
import ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;


public class LoginSteps {

    public LoginPage loginPage;
    public MainPage mainPage;

    @Given("^I navigate to login Page$")
    public void navigateLoginPage() {
         loginPage = PageTransporter.getInstance().navigateToLoginPage();
    }
    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
     public void loginAndPassword(String email, String password)
     {
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
        mainPage = loginPage.clickLoginButton();
     }
   @Then("^I should be login successfully$")
    public void assertLogin()
    {
        boolean userLogo = mainPage.userLogged();
        Assert.assertEquals(userLogo,true,"the user is correctly logged");
    }
    @When("I login as wrong email \"(.*?)\" with password \"(.*?)\"$")
    public void loginAndPasswordWrong(String email,String password)
    {
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
        loginPage = loginPage.clickWrongLoginButton();
    }
    @Then("^I should not be logged in the application$")
    public void assertLoginFailed()
    {
        Assert.assertEquals(loginPage.errorMessage(),true,"the message error is displayed");
    }
}
