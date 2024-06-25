package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class PaymentPage {

    private WebDriver browser;

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement campoNomeCartao;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement campoNumeroDoCartao;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement campoCvcCartao;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement campoMesValidadeDoCartao;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement campoAnoDeValidadeCartao;

    @FindBy(id = "submit")
    private WebElement botaoConfirmar;

    public PaymentPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public PaymentPage preencherNomeCartao() {
        campoNomeCartao.sendKeys("TESTESSSSSS");
        return this;
    }

    public PaymentPage preencherNumeroCartao() {
        campoNumeroDoCartao.sendKeys("1111222233334444");
        return this;
    }

    public PaymentPage preencherCVC() {
        campoCvcCartao.sendKeys("123");
        return this;
    }

    public PaymentPage preencherMesCartao() {
        campoMesValidadeDoCartao.sendKeys("01");
        return this;
    }

    public PaymentPage preencherAnoCartao() {
        campoAnoDeValidadeCartao.sendKeys("2030");
        return this;
    }

    public InicialLogonPage selecionarBotaoConfirmar() {
        botaoConfirmar.click();
        return new InicialLogonPage(browser);
    }

    public PaymentPage preencherCamposDaPaginaDoCartao() {
        preencherNomeCartao();
        preencherNumeroCartao();
        preencherCVC();
        preencherMesCartao();
        preencherAnoCartao();
        return this;
    }
}
