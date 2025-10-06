package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomePage
{
    WebDriver driver;
    WebDriverWait wait;

    By loginPopupClose = By.cssSelector("button._2KpZ6l._2doB4z");
    By logo = By.cssSelector("img[title='Flipkart']");
    By searchBox = By.name("q");
    By searchResultContainer = By.cssSelector("div._1YokD2._3Mn1Gg");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void closeLoginPopup()
    {
        try
        {
            driver.findElement(loginPopupClose).click();
        } catch (Exception ignored) {}
    }

    public boolean isLogoVisible()
    {
        return driver.findElement(logo).isDisplayed();
    }

    public void searchProduct(String keyword)
    {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        box.sendKeys(keyword);
        box.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultVisible()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultContainer)).isDisplayed();
    }
}
