package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ComponentUtils {

    /**
     * Prints the time when TestCase failed
     */
    public static void printTimeOfFailure() {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'Europe / Berlin'");
        time.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        long failTime = System.currentTimeMillis();
        System.out.println(time.format(failTime));
    }

    /**
     * @param tcName String
     * @param driver WebDriver
     * @throws IOException exception
     */
    public static void makeScreenshot(String tcName, WebDriver driver) throws IOException {
        SimpleDateFormat time = new SimpleDateFormat("MM_dd_HH_mm_ss");
        time.setTimeZone(TimeZone.getTimeZone("Europe/Vilnius"));
        long failTime = System.currentTimeMillis();
        String failedAt = time.format(failTime);

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\W10\\Documents\\screenshots\\failedTC_ " + tcName + failedAt + ".png"));
    }

    /**
     * Scrolls to top or bottom of the page
     *
     * @param driver   WebDriver
     * @param position top/bottom
     */
    public static void scrollToPagePlace(WebDriver driver, String position) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String positionToScroll = position.toLowerCase();
        if ("top".equals(positionToScroll)) {
            js.executeScript("window.scrollTo(0,0)");
        } else if ("bottom".equals(positionToScroll)) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

    /**
     * Scrolls to the needed WebElement
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    /**
     * Hovers over the elements
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /**
     * Returns page title
     *
     * @param driver WebDriver
     * @return String
     */
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getElementValue(WebDriver driver, By locator) {
        return driver.findElement(locator).getAttribute("value");
    }
}
