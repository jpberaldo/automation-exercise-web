package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver browser;

    public CartPage (WebDriver browser){
        this.browser = browser;
    }

    public CartPage preencherCampoSubscriptionComEmail(String email) {
        browser.findElement(By.id("susbscribe_email")).sendKeys(email);
        browser.findElement(By.id("subscribe")).click();
        return this;
    }

}
