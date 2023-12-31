package browsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest { public static WebDriver driver;

    public void openBrowser(String baseurl){
        // Launch the Chrome Browser
        driver = new ChromeDriver();
        //Open the URL into Browser
        driver.get(baseurl);
        //Maximise Browser
        driver.manage().window().maximize();
        //we give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
