package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login extends BaseTest{

    @Test
    public void login(){
        String email = "bla@bla.com";
        String password = "kazkas";
        String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";

        LoginPage loginPage = new LoginPage(driver);
        CommonPage commonPage = new CommonPage(driver);

        commonPage.clickOnMyAccont();
        commonPage.clickOnLogin();

        List<WebElement> customerBlocks = loginPage.getAllCustomerBlocks();
        for (WebElement block : customerBlocks) {
            System.out.println(block.getText());
            assertTrue(block.isDisplayed());
        }

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(loginPage.getAlert().isDisplayed());

        String alertWarningText = loginPage.getAlert().getText();
        System.out.println(alertWarningText);
        assertEquals(alertWarningText,expectedWarningText,"Warning ne tai ko reikia: \n" + alertWarningText);

    }

}
