package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage{
    public CommonPage (WebDriver driver){
        super(driver);
    }

    //-------------------------Locators----------------------
    By myAccountButton = By.cssSelector(".dropdown");
    By loginButton = By.partialLinkText("Login");
    By allMP3Button = By.partialLinkText("Show All MP3 Players");


    //-------------------------Methods-----------------------
    public void clickOnMyAccont() {
        click(myAccountButton);
    }

    public void clickOnLogin(){
        click(loginButton);
    }

    public void clickShowAllMP3Button(){
        click(allMP3Button);
    }
}
