package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Login extends BasePage {

    public Login() {
        super(Locator);
    }

    private static final Map<String, By> Locator;
    static {
        Map<String, By> myLocators = new HashMap<String, By>();
        myLocators.put("UserName", By.id("email"));
        myLocators.put("Password", By.id("passwd"));
        myLocators.put("Sign In", By.id("SubmitLogin"));

        Locator = myLocators;
    }
}
