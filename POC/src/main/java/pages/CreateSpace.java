package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class CreateSpace extends BasePage{

    public CreateSpace() {
        super(Locator);
    }

    private static final Map<String, By> Locator;
    static {
        Map<String, By> myLocators = new HashMap<String, By>();

        myLocators.put("Plus", By.xpath("//*[@class='cu2-project-list-bar__add-icon icon']"));
        myLocators.put("Space Name", By.xpath("//*[@class='cu-form__input ng-pristine ng-invalid ng-touched']"));
        myLocators.put("Next", By.xpath("//*[@class='cu-btn cu-btn_m cu-create-project-modal__next ng-star-inserted']"));
        myLocators.put("Next template", By.xpath("//*[@class='cu-btn cu-btn_m cu-create-project-modal__statuses-btn ng-star-inserted']"));
        myLocators.put("Review space", By.xpath("//*[@class='cu-btn cu-btn_m cu-create-project-modal__next ng-star-inserted']"));
        myLocators.put("Create space", By.xpath("//*[@class='cu-btn cu-btn_m cu-create-project-modal__next ng-star-inserted']"));

        Locator = myLocators;
    }


}
