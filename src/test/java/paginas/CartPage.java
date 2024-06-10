package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class CartPage {

    private WebDriver browser;

    @FindBy(id = "susbscribe_email")
    private WebElement campoEmailDeSubscribe;

    @FindBy(id = "subscribe")
    private WebElement botaoSubscribe;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement botaoProcederParaCheckout;

    @FindBy(linkText = "Register / Login")
    private WebElement botaoRegistroOuLogin;

    @FindBy(linkText = "Signup / Login")
    private WebElement botaoSignupOuLogin;

    public CartPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public CartPage preencherCampoSubscriptionComEmail(String email) {
        campoEmailDeSubscribe.sendKeys(email);
        botaoSubscribe.click();
        return this;
    }

    public CartPage selecionarBotaoProcederParaCheckout() {
        botaoProcederParaCheckout.click();
        return this;
    }

    public CheckoutPage selecionarBotaoProcederParaCheckoutJaLogadoNaConta() {
        botaoProcederParaCheckout.click();
        return new CheckoutPage(browser);
    }

    public CheckoutPage botaoCheckout() {
        botaoProcederParaCheckout.click();
        return new CheckoutPage(browser);
    }

    public LoginPage selecionarBotaoRegistroOuLogin() {
        botaoRegistroOuLogin.click();
        return new LoginPage(browser);
    }

    public CartPage removerProdutoDoCarrinho(int numProduto) {
        browser.findElement(By.cssSelector("a[data-product-id='" + numProduto + "']")).click();
        return this;
    }

    public LoginPage selecionarBotaoParaPaginaDeSignupOuLogin() {
        botaoSignupOuLogin.click();
        return new LoginPage(browser);
    }

}
