package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseurl=" https://demo.nopcommerce.com";

    @Before
    public void setUp(){
        openBrowser(baseurl);
    }
    public void selectMenu(String menu){
        String xpath="//a[text()="+menu+"]";
        //Find element
        By element=By.xpath(xpath);
        //click element
        clickOnElement(element);
    }
    @Test
    public void PageNavigation(){
        selectMenu("Computers");
        //Find expected element
        String actualResult=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String expectedText="Computers";
        Assert.assertEquals("Text matched", expectedText, actualResult);
    }














    @After
    public void tearDown(){
        closeBrowser();
    }
}
