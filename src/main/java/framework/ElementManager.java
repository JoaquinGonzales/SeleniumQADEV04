package framework;


import org.openqa.selenium.*;

/**
 * Created with IntelliJ IDEA.
 * User: JoaquinGonzales
 * Date: 11/16/15
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElementManager {
    private static ElementManager instance;
    public WebDriver driver = DriverManager.getWebDriver().getDriver();
    protected ElementManager()
    {

    }
    public static ElementManager getInstance()
    {
        if(instance == null)
            instance = new ElementManager();
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
    public static void elementHighlight(WebElement element) {

       WebDriver driver = DriverManager.getWebDriver().getDriver();
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: red; border: 3px solid red;");
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
        }
    }
    public static void setAttributeValue(WebElement elem,String atribute, String value){
        WebDriver driver = DriverManager.getWebDriver().getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
        js.executeScript(scriptSetAttrValue, elem, atribute, value);

    }
}
