package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/17/15
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopMenuPage extends BasePageObject{

    @FindBy(xpath = "//div[@id='toolbar']/div/ul/li[6]/a/div/div")
    WebElement logoUser;
    @FindBy(xpath ="//div[@id='toolbar']/div/div[2]/ul/li[5]/a/span[2]")
    WebElement clientsPageButton;
    public TopMenuPage()
    {
        PageFactory.initElements(driver,this);

    }
    public void waitUntilPageObjectIsLoaded()
    {
        wait.until(ExpectedConditions.visibilityOf(logoUser));
    }
    public ClientPage createNewClient()
    {
        clientsPageButton.click();
        return new ClientPage();
    }
}
