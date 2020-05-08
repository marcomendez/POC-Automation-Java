package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriverManager instance = null;
    private WebDriver webDriver;
    public WebDriverWait Wait;

    protected WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
        initialize();
    }

    public static WebDriverManager getInstance() {
        if (instance == null ) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initialize() {
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        Wait = new WebDriverWait(webDriver, 10000, 10000);
    }

    public  WebDriver getWebDriver()
    {
        return  webDriver;
    }
}
