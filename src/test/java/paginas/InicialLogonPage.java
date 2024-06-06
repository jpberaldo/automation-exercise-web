package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "unchecked"})
public class InicialLogonPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    private WebElement botaoDeletarConta;

    @FindBy(linkText = "Logout")
    private WebElement botaoDeslogarDaConta;

    @FindBy(linkText = "Cart")
    private WebElement botaoCarrinho;

    @FindBy(css = "a[href='/products']")
    private WebElement botaoProdutos;

    @FindBy(linkText = "Download Invoice")
    private WebElement botaoDownloadInvoice;


    public InicialLogonPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public ContaDeletadaPage selecionarBotaoDeletarConta() {
        botaoDeletarConta.click();
        return new ContaDeletadaPage(browser);
    }

    public LoginPage selecionarBotaoParaSairDaContaLogada() {
        botaoDeslogarDaConta.click();
        return new LoginPage(browser);
    }

    public CartPage selecionarBotaoParaCarrinho() {
        botaoCarrinho.click();
        return new CartPage(browser);
    }

    public ProductsPage selecionarBotaoParaPaginaProdutos() {
        botaoProdutos.click();
        return new ProductsPage(browser);
    }

    public InicialLogonPage fazerDonwloadInvoice() {
        botaoDownloadInvoice.click();
        return this;
    }


    @Override
    public InicialLogonPage fecharPropaganda() throws InterruptedException {

        for (int i = 0; i < 7; i++) {

            try {
                String iframeName = "aswift_" + i + "']";
                WebElement iframe = browser.findElement(By.cssSelector("iframe[id='" + iframeName));

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);

                    try {
                        WebElement botaoFechar = browser.findElement(By.cssSelector("div[id='dismiss-button']"));
                        botaoFechar.click();
                    } catch (Exception e) {

                        try {
                            WebElement iframe2 = browser.findElement(By.cssSelector("iframe[id='ad_iframe']"));
                            browser.switchTo().frame(iframe2);
                            browser.findElement(By.id("dismiss-button")).click();
                        } catch (Exception e2) {
                            System.out.println("Elemento nao encontrado: " + e2.getMessage());
                        }
                    } finally {
                        browser.switchTo().defaultContent();
                    }
                }

            } catch (Exception e3) {
                System.out.println("Excessao encontrada: " + e3.getMessage());
            }
        }
        return this;

    }
}
