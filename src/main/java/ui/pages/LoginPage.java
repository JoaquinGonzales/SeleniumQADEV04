package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/11/15
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage  extends BasePageObject
{
    @FindBy(id = "email")
    @CacheLookup
    WebElement emailInput;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@id='content']/div/div/div[2]/div")
    WebElement error;
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }
    public LoginPage setEmailInput(String email)
    {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }
    public LoginPage setPasswordInput(String password)
    {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }
    public MainPage clickLoginButton()
    {
        loginBtn.click();
        return new MainPage();
    }
    public LoginPage clickWrongLoginButton()
    {
        loginBtn.click();
        return this;
    }
    public boolean errorMessage()
    {
        return error.isDisplayed();
    }
}
