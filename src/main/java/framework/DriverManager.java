package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by JoaquinGonzales on 11/10/2015.
 */
public class DriverManager {

    public static DriverManager instance = null;
    public WebDriver driver;
    public WebDriverWait wait;
    protected DriverManager()
    {
        init();
    }
    public static DriverManager getWebDriver()
    {
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
    private void init()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }
    public WebDriver getDriver()
    {
        return driver;
    }
    public WebDriverWait getWait()
    {
        return wait;
    }
}