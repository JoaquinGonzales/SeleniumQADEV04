package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/14/15
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateProjectPage extends BasePageObject
{
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;
    @FindBy(id = "projectName")
    WebElement projectNameInput;
    @FindBy(id = "description")
    WebElement projectDescriptionInput;

    public CreateProjectPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
    }
    public CreateProjectPage setProjectName(String projectName)
    {
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
        return this;
    }
    public CreateProjectPage setProjectDescription(String projectDescription)
    {
        projectDescriptionInput.clear();
        projectDescriptionInput.sendKeys(projectDescription);
        return this;
    }
    public MainPage clickSaveButton()
    {
        saveButton.click();
        return new MainPage();
    }
   // public MainPage createProject(String )
}
