package ui;

import framework.DriverManager;
import ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/12/15
 * Time: 8:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageTransporter {
    public WebDriver driver = DriverManager.getWebDriver().getDriver();
    private String loginUrl= "https://secure.projectbubble.com/login";
    private static PageTransporter instance;
    public PageTransporter()
    {
        init();
    }
    private  void init()
    {

    }
    public static PageTransporter getInstance()
    {
        if(instance==null)
        {
            instance = new PageTransporter();
        }
        return instance;
    }
    public void goToUrl(String url)
    {
        driver.navigate().to(url);
    }
    public String getCurrentUrl()
    {
        return  driver.getCurrentUrl();
    }
    public LoginPage navigateToLoginPage()
    {
       goToUrl(loginUrl);
        return new LoginPage();
    }
}
