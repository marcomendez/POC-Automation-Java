package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Home extends  BasePage {

    public Home() {
        super(Locator);
    }

    private static final Map<String, By> Locator;
    static {
        Map<String, By> myLocators = new HashMap<String, By>();
        myLocators.put("My Personal Information", By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a"));

        Locator = myLocators;
    }
}
