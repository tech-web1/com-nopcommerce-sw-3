package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseurl = " https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Click on Computer menu
        WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(computer).moveToElement(desktops).click().build().perform();
        //Select sort By position "Name:Z toA"
        selectVisibleText(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //Verify the product will arrange in descending order
        String expectedTest = "Name: Z to A";
        String actualTest = getTextFromElement(By.xpath("//select[@id='products-orderby']"));
        Assert.assertEquals("Message is not display", expectedTest, actualTest);
        Thread.sleep(1000);
    }

    @Test
    public void verifytheProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer menu
        WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(computer).moveToElement(desktops).click().build().perform();
        Thread.sleep(1000);
        //Select sort By position "Name:AtoZ"
        selectValueDropDown(By.xpath("//select[@id='products-orderby']"),"");
        //Click on Add to cart
        WebElement cart = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the text Build your own Computer
        String expectedTest = "Build your own compute";
        String actualTest = getTextFromElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectValueDropDown(By.xpath("//select[@id='product_attribute_1']"), "");
        //2.7 Select "8GB [+$60.00]" using Select class.
        selectVisibleText(By.xpath("//select[@id='product_attribute_2']"),"");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        selectVisibleText(By.xpath("//select[@id='product_attribute_2']"),"");
        //2.9 Select OS radio "Vista Premium [+$60.00
        selectVisibleText(By.xpath("//label[contains(text(),'Vista Premium [+$60.00]"),"");
        //2.10 check Two check boxes Microsoftoffice and total commander
        WebElement microwSoftOffice = driver.findElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]"));
        WebElement totalCommander = driver.findElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]"));
        Actions actions1 = new Actions(driver);
        actions.moveToElement(microwSoftOffice).moveToElement(totalCommander).click().build().perform();
        //Verify the price
        String expectedPrice = "$1,475.00";
        String actualPrice = "$1,315.00";
        Assert.assertEquals("price is not matched", expectedPrice, actualPrice);
        //2.12 click on add to cart button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 verify the message the product has been added to your shopping cart on top green bar
        String expectedMessage = "Verify the Message The product has been added to your shopping cart\" on Top\n" +
                "green Bar";
        String actualMessage = getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Assert.assertEquals("Error message is displayed", expectedMessage, actualMessage);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Actions actions2 = new Actions(driver);
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        //2.15 verify the message shopping cart
        String expectedText = "Shopping cart";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message is not display", expectedMessage, actualMessage);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement quality = driver.findElement(By.xpath("//input[@id='itemquantity11255']"));
        WebElement update = driver.findElement(By.xpath("//button[@id='updatecart']"));
        Actions actions3 = new Actions(driver);
        actions.moveToElement(quality).moveToElement(update).click().build().perform();
        //2.17 Verify the total
        String expectedTotal = "$2,960.00";
        String actualTotal = getTextFromElement(By.linkText("$2,960.00"));
        Assert.assertEquals("Total is not matched", expectedTotal, actualTotal);
        Thread.sleep(1000);
        //2.18click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //2.19Click on Checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedError="Verify the Text “Welcome, Please Sign In!";
        String actualError=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Message is not matched",expectedError,actualError);
        Thread.sleep(1000);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//strong[contains(text(),'Checkout as a guest or register')]"));
        //Click on Continue
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //Select Radio Button “Credit Card”




    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
