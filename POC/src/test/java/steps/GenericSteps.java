package steps;

import core.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static org.testng.Assert.assertTrue;

public class GenericSteps extends  BaseStep{

    @Given("^I navigate to ClickUp$")
    public void NavigateToPage()  {
        WebDriverManager.getInstance().getWebDriver().get("https://app.clickup.com/login");
    }

    @And("^I set '([^']+?)' in ([^']+?)(?: on ([^']+?)|)$")
    public void SetText(final String text, final String elementName, final String pageName) {
        GetElement(elementName, pageName).sendKeys(text);
    }

    @And("^I click ([^']+?)(?: on ([^']+?)|)$")
    public void Click(final String elementName, final String pageName) {
        GetElement(elementName, pageName).click();
    }

    @And("^I should see '([^']+?)' displayed(?: on ([^']+?)|)$")
    public void VerifyFieldOnPage(final String elementName, final String pageName) {
        boolean isDisplayed =  GetElement(elementName, pageName).isDisplayed();
        assertTrue(isDisplayed);
    }
}
