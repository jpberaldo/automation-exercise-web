package paginas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class CheckoutPage {

    private WebDriver browser;

    @FindBy(css = "textarea[name='message']")
    private WebElement campoComentario;

    @FindBy(linkText = "Place Order")
    private WebElement botaoPlaceOrder;

    public CheckoutPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public CheckoutPage preencherComentario(String msg) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,750);");
        campoComentario.sendKeys();
        return this;
    }

    public PaymentPage selecionarBotaoPlaceOrder() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,750);");
        botaoPlaceOrder.click();
        return new PaymentPage(browser);
    }

}
