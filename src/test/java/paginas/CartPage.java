package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver browser;

    public CartPage(WebDriver browser) {
        this.browser = browser;
    }

    public CartPage preencherCampoSubscriptionComEmail(String email) {
        browser.findElement(By.id("susbscribe_email")).sendKeys(email);
        browser.findElement(By.id("subscribe")).click();
        return this;
    }

    public CartPage selecionarBotaoProcederParaCheckout() {
        browser.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        return this;
    }

    public CheckoutPage selecionarBotaoProcederParaCheckoutJaLogadoNaConta() {
        browser.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        return new CheckoutPage(browser);
    }

    public CheckoutPage botaoCheckout() {
        browser.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        return new CheckoutPage(browser);
    }

    public LoginPage selecionarBotaoRegistroOuLogin() {
        browser.findElement(By.linkText("Register / Login")).click();
        return new LoginPage(browser);
    }

    public CartPage removerProdutoDoCarrinho() {
        browser.findElement(By.cssSelector("a[data-product-id='1']")).click();
        return this;
    }

    public LoginPage selecionarBotaoParaPaginaDeSignupOuLogin() {
        browser.findElement(By.linkText("Signup / Login")).click();
        return new LoginPage(browser);
    }

}
