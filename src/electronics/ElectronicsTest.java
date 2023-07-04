package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseurl = " https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonePageSuccessfully()throws InterruptedException{
        //2.1 Mouse Hover on “Electronics” Tab
        WebElement electronics=driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        //2.2 Mouse Hover on “Cell phones” and click
        WebElement cellPhones=driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhones).click().build().perform();
        Thread.sleep(1000);
        //2.3  Verify the text “Cell phones”
        String expectedText=" Verify the text “Cell phones”";
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Message is not display",expectedText,actualText);
        //2.4 Click on List view Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5  Click on product name “Nokia Lumia 1020” lin
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(1000);
        //2.6Verify the text “Nokia Lumia 1020
        String expectedResult="“Nokia Lumia 1020”";
        String actualResult=getTextFromElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Error message is display",expectedResult,actualResult);
        Thread.sleep(1000);
        //2.7 Verify the price “$349.00”
        String expectedPrice="$349.00";
        String actualPrice=getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Error message is display",expectedResult,actualResult);
        Thread.sleep(1000);
        //Change Quality to 2
        //Click on Add to cart tab
        clickOnElement(By.xpath("//span[contains(text(),'$349.00')]"));
        //2.10  Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedDisplay="The product has been added to your shopping cart";
        String actualDisplay=getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Message is not display",expectedDisplay,actualDisplay);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(1000);
        //2.11Then MouseHover on "Shopping cart" and Click on "GO TO CART"button
        WebElement shoppingCart=driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement cart=driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Actions actions1=new Actions(driver);
        actions.moveToElement(shoppingCart).moveToElement(cart).click().build().perform();
        //2.12 Verify the message shopping cart
        String expectedMessage="Shopping cart";
        String actualMessage=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Error Message is display",expectedMessage,actualMessage);
        //2.13 Verify the  quantity is 2
        String expectedError=" quantity is 2";
        String actualError=getTextFromElement(By.xpath("//input[@id='itemquantity11260']"));
        Assert.assertEquals("Error message is display",expectedError,actualError);
        //2.14 Verify the Total $698.00
        String expectedTotal="$698.00";
        String actualTotal=getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT"button
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17  Verify the Text “Welcome, Please Sign In!"
        String expectDisplay="Welcome, Please Sign In!";
        String actualDis=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Error message is displayed",expectedDisplay,actualDis);
        Thread.sleep(1000);
        //2.18 Click on Register page
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text Register
        String expectedRes="Register";
        String actualRes=getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Error message Display",expectedRes,actualRes);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
