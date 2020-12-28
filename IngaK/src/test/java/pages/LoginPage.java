package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver){
        super(driver);
    }

    //-------------------------Locators----------------------
    By customerBlock = By.cssSelector(".well h2");
    By emailInput = By.id("input-email");
    By passwordInput = By.id("input-password");
    By loginButton = By.cssSelector("input[type='submit']");
    By alertField = By.cssSelector(".alert-danger");

    //-------------------------WebElements-------------------

    public List<WebElement> getAllCustomerBlocks() {
        return driver.findElements(customerBlock);
    }

    public WebElement getAlert() {
        return driver.findElement(alertField);
    }

    //-------------------------Methods-----------------------

    public void enterEmail(String email) {
        enterText(emailInput, email);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

}
