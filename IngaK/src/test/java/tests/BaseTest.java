package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ComponentUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            ComponentUtils.printTimeOfFailure();
            ComponentUtils.makeScreenshot(result.getName(), driver);
        }
        driver.quit();
    }
}
