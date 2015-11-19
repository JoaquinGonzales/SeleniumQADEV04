package ui.pages;

import framework.ElementManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/19/15
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateTaskPage extends BasePageObject
{
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveTaskButton;
    @FindBy(id="taskName")
    WebElement taskNameInput;
    @FindBy(id="description")
    WebElement taskDescriptionInput;
    @FindBy(id="projectID")
    WebElement projectAssociatedDropDown;
    @FindBy(id="ongoing")
    WebElement checkBoxOngoing;
    @FindBy(id="startDate")
    WebElement startDateInput;
    @FindBy(id="dueDate")
    WebElement dueDateInput;

    public CreateTaskPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(saveTaskButton));
    }

    public CreateTaskPage setTaskName(String taskName)
    {
        taskNameInput.clear();
        taskNameInput.sendKeys(taskName);
        return this;
    }

    public CreateTaskPage setTaskDescription(String taskDescription)
    {
        taskDescriptionInput.clear();
        taskDescriptionInput.sendKeys(taskDescription);
        return this;
    }

    public CreateTaskPage setProjectAssociation(String projectName)
    {
        projectAssociatedDropDown.click();
        WebElement option = ElementManager.getElementOption(projectName);
        option.click();
        return this;
    }

    public CreateTaskPage setStartDate(String startDate)
    {
        checkBoxOngoing.click();
        wait.until(ExpectedConditions.elementToBeClickable(startDateInput));
        ElementManager.elementHighlight(startDateInput);
        ElementManager.setAttributeDisable(startDateInput);
        startDateInput.sendKeys(startDate);
        return this;
    }
    public CreateTaskPage setDueDate(String dueDate)
    {
        wait.until(ExpectedConditions.elementToBeClickable(dueDateInput));
        ElementManager.elementHighlight(dueDateInput);
        ElementManager.setAttributeDisable(dueDateInput);
        startDateInput.sendKeys(dueDate);
        return this;
    }
    public MainPage clickSaveButton()
    {
        saveTaskButton.click();
        return new MainPage();
    }
}
