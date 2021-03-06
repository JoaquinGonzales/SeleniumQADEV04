package ui.pages;

import framework.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/12/15
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainPage extends BasePageObject
{
    public TopMenuPage topMenuPage;
    @FindBy(xpath = "//div[@id='toolbar']/div/ul/li[6]/a/div/div")
    WebElement logoUser;
    @FindBy(xpath = "//div[@id='toolbar']/div/ul/li[6]/ul/li[6]/a")
    WebElement logOut;
    @FindBy(id = "addproject")
    WebElement addProjectButton;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;

    public MainPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
        this.topMenuPage = new TopMenuPage();
    }
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(logoUser));
    }
    public Boolean userLogged()
    {
        return logoUser.isDisplayed();
    }

    public LoginPage logOut()
    {
        logoUser.click();
        wait.until(ExpectedConditions.visibilityOf(logOut));
        logOut.click();
        return new LoginPage();
    }
    public CreateProjectPage createProject()
    {
       addProjectButton.click();
       wait.until(ExpectedConditions.visibilityOf(saveButton));
       return new CreateProjectPage();
    }
    public ProjectPage goToProjectPage()
    {
        return topMenuPage.goToProjectPage();
    }
    public TaskPage gotoTaskPage()
    {
        return topMenuPage.goToTaskPage();
    }
    public boolean isElementCreated(String projectName)
    {
        By selector = By.xpath("//a[contains(text()," + projectName + ")]");
        WebElement element = driver.findElement(By.xpath("//a[contains(text()," + projectName + ")]"));
        ElementManager.elementHighlight(element);
        return ElementManager.getInstance().findElementPresent(selector);
    }

}
