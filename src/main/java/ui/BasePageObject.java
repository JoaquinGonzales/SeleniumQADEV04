package ui;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.TopMenuPage;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/11/15
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BasePageObject
{
    public TopMenuPage topMenuPage;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageObject()
    {
        this.driver = DriverManager.getWebDriver().getDriver();
        this.wait = DriverManager.getWebDriver().getWait();
        this.topMenuPage = new TopMenuPage();
        PageFactory.initElements(driver,this);
    }
    public abstract void waitUntilPageObjectIsLoaded();
}
