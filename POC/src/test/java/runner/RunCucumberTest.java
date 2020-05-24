package runner;

import core.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;




@CucumberOptions(
        features = "@build/cucumber/rerun.txt",
        glue = {"steps"},
        plugin = {"pretty", "json:build/cucumber/retry/cucumber.json", "rerun:build/cucumber/retry/rerun.txt",
        }
)

/*
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = "@smoke",
        plugin = {"pretty", "json:build/cucumber/cucumber.json", "rerun:build/cucumber/rerun.txt",}
)
*/
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void open() {
        // Implement.
        System.setProperty("dataproviderthreadcount", "1");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


    @AfterTest
    public void close() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}