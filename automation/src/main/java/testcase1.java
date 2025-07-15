import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testcase1
{

    // Test case id : FLP_TC_001
    // Ensure homepage loads without errors
    public static void main (String[] arg) throws InterruptedException
    {
        //ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();

        //starter time
        long StartTime = System.currentTimeMillis();
        System.out.println(StartTime);

        driver.get("https://www.flipkart.com/");

        // Create wait object

        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofMillis(10));
        driver.findElement(By.xpath("/html/body/div[4]/div/span")).click();

        // check the essential elements are true

        boolean allElementpresent = true;

        try
        {
            // 1.logo
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='Flipkart']")));

            //search bar
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

            // login  ( Top nav )
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[2]/div/div/div/div/a")));

            //cart
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[3]/div")));

            //banner image

            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-2 > div > div > div > a > div > picture > img")));


        } catch (Exception e) {
            System.out.println("some element fail to load"+ e.getMessage());
            allElementpresent = false;
            throw new RuntimeException(e);
        }


        driver.quit();
}  }
