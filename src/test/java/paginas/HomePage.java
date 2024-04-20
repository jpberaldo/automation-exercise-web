package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver browser;

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public ContactUsPage selecionarBotaoContactUs() {
        browser.findElement(By.linkText("Contact us")).isDisplayed();
        browser.findElement(By.linkText("Contact us")).click();

        return new ContactUsPage(browser);
    }

    public TestCasePage selecionarBotaoTestCases() {
        browser.findElement(By.linkText("Test Cases")).click();
        return new TestCasePage(browser);
    }

    public ProductsPage selecionarBotaoProducts() {
        browser.findElement(By.cssSelector("a[href='/products']")).click();
        return new ProductsPage(browser);
    }

    public HomePage rolarPaginaParaBaixo() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,8000);");
        return this;
    }

    public HomePage preencherCampoSubscriptionComEmail(String email) {
        browser.findElement(By.id("susbscribe_email")).sendKeys(email);
        browser.findElement(By.id("subscribe")).click();
        return this;
    }

    public CartPage selecionarBotaoCart() {
        browser.findElement(By.cssSelector("a[href='/view_cart']")).click();
        return new CartPage(browser);
    }
}
