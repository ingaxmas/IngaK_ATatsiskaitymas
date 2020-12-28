package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage (WebDriver driver){
        super(driver);
    }

    //-------------------------Locators----------------------
    By productTitle = By.cssSelector("#content h2");
    By listViewButton = By.id("list-view");
    By productInList = By.cssSelector(".product-thumb");
    By cartButton = By.cssSelector(".button-group button");
    By productName = By.tagName("h4");
    By alert = By.cssSelector(".alert-success");
    By cart = By.id("cart");
    By productInCart = By.xpath("//table[@class='table table-striped']//tr[1]//td[2]");
    //-------------------------WebElements-------------------

    public WebElement getProductTitle(){
        return  driver.findElement(productTitle);
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(productInList);
    }

    public WebElement getAlert(){
        return driver.findElement(alert);
    }

    public WebElement getproductInCart(){
        return driver.findElement(productInCart);
    }
    //-------------------------Methods-----------------------

    public String getProductTitleText(){
        return getProductTitle().getText();
    }

    public void clickListViewButton(){
        click(listViewButton);
    }

    public By getCartButton(){
        return cartButton;
    }

    public By getProductName(){
        return productName;
    }

    public String getAlertText() {
        return getAlert().getText();
    }

    public void clickOnCart(){
        click(cart);
    }

    public String productInCart(){
        return getproductInCart().getText();
    }
}
