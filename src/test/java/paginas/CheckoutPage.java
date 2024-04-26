package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver browser;

    public CheckoutPage(WebDriver browser) {
        this.browser = browser;
    }

    public CheckoutPage preencherComentario(String msg) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,750);");
        browser.findElement(By.cssSelector("textarea[name='message']")).sendKeys();
        return this;
    }

    public PaymentPage selecionarBotaoPlaceOrder() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,750);");
        browser.findElement(By.linkText("Place Order")).click();
        return new PaymentPage(browser);
    }

}
