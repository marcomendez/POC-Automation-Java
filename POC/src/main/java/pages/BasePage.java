package pages;

import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class BasePage implements IPage {

    public BasePage(Map<String, By> Locator)
    {
        this.Locators = Locator;
    }

    private Map<String, By> Locators = null;

    public WebElement GetLocator(String locatorName) {
        By locator =  Locators.get(locatorName);
        WebDriverManager.getInstance().Wait.until(ExpectedConditions.elementToBeClickable(locator));
        return  WebDriverManager.getInstance().getWebDriver().findElement(locator);
    }
}
