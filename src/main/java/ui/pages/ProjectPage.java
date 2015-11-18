package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/18/15
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectPage extends BasePageObject {

    public TopMenuPage topMenuPage;
    @FindBy(id="topop")
    WebElement topButton;
    @FindBy(id = "addproject")
    WebElement addProjectButton;

    public ProjectPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
        this.topMenuPage = new TopMenuPage();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(topButton));
    }
    public CreateProjectPage createNewProject()
    {
        addProjectButton.click();
        return new CreateProjectPage();
    }
}
