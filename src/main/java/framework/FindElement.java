package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/16/15
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindElement {
    private static FindElement instance;
    WebDriver driver = DriverManager.getWebDriver().getDriver();
    protected FindElement()
    {

    }
    public static FindElement getInstance()
    {
        if(instance == null)
            instance = new FindElement();
        return instance;
    }
    public boolean findElementPresent(By element)
    {
       try
       {
          driver.findElement(element);
          return true;
       }
        catch(NoSuchElementException e)
        {
           return false;
        }
    }
}
