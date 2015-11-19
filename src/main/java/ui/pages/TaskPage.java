package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/19/15
 * Time: 9:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaskPage extends BasePageObject
{
    public TopMenuPage topMenuPage;
    @FindBy(id="totop")
    WebElement topButton;
    @FindBy(id="addtask")
    WebElement addTaskButton;


    public TaskPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
        this.topMenuPage = new TopMenuPage();
    }
    @Override
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(topButton));
    }
    public CreateTaskPage createNewTask()
    {
        return new CreateTaskPage();
    }
}
