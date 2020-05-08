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
        myLocators.put("View", By.xpath("//*[@class='cu-data-view-list__add-text']"));
        myLocators.put("Plus", By.xpath("//*[@class='cu2-project-list-bar__add-icon icon']"));

        Locator = myLocators;
    }
}
