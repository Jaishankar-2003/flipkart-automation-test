package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class productpage
{
    WebDriver driver;
    WebDriverWait wait;

    By firstProduct = By.cssSelector("div._1AtVbE");
    By addToCartBtn = By.xpath("//button[contains(.,'Add to cart')]");
    By placeOrder = By.xpath("//span[contains(.,'Place Order')]");

    public productpage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void openFirstProduct()
    {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        product.click();

        for (String handle : driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
    }

    public void addToCart()
    {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        btn.click();
    }

    public boolean isAddedToCart()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder)).isDisplayed();
    }
}
