package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CartPage
{
    WebDriver driver;
    WebDriverWait wait;

    By cartIcon = By.cssSelector("a[href*='viewcart']");
    By removeBtn = By.xpath("//div[contains(text(),'Remove')]");

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void openCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void removeProduct()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
        } catch (Exception ignored) {}
    }
}
