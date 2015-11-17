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
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClientPage extends BasePageObject{
    @FindBy(xpath = "//div[@id='content']/div/div/a")
    WebElement createClientButton;
    public ClientPage()
    {
        PageFactory.initElements(driver,this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createClientButton));
    }
    public CreateClientPage createClient()
    {
        createClientButton.click();
        return new CreateClientPage();
    }
}
