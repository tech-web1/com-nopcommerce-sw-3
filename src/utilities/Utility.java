package utilities;

import browsertesting.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     *Click on element method
     */
    public void clickOnElement(By by) {
    driver.findElement(by).click();

}

    /**
     * This
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendKeysToElement(By by, String text)
    {
        driver.findElement(by).sendKeys("text");
    }
    //********************Alert methods************************************//
    //5 Methods (switch to alert)

    //****************select class Method*******************//

    /**
     * This method will select the option by visible text
     */
    public void selectVisibleTextDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectVisibleText(By by,String text){
        WebElement dropDown =driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectValueDropDown(By by,String text){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByValue(text);
    }

    public void indexDropDown(By by,int index){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByIndex(index);
    }

    public void mouseHoverExample(By by,By by1){
        WebElement text1=driver.findElement(by);
        WebElement text2=driver.findElement(by1);
        Actions actions=new Actions(driver);
    }
}
