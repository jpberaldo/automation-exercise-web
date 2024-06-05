package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "unchecked"})
public class HomePage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    @FindBy(linkText = "Contact us")
    private WebElement botaoContactUs;

    @FindBy(linkText = "Test Cases")
    private WebElement botaoTestCases;

    @FindBy(css = "a[href='/products']")
    private WebElement botaoProducts;

    @FindBy(id = "susbscribe_email")
    private WebElement campoEmailSubscription;

    @FindBy(id = "subscribe")
    private WebElement clicarBotaoSubscription;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement selecionarBotaoCarrinho;

    @FindBy(css = "a[href='#Women']")
    private WebElement selecionarCategoriaWomen;

    @FindBy(css = "a[href='/category_products/1']")
    private WebElement selecionarVestido;

    @FindBy(id = "scrollUp")
    private WebElement selecionarBotaoFlechaParaCima;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement selecionarBotaoLoginECadastrar;

    public HomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public ContactUsPage selecionarBotaoContactUs() {
        botaoContactUs.click();
        return new ContactUsPage(browser);
    }

    public TestCasePage selecionarBotaoTestCases() {
        botaoTestCases.click();
        return new TestCasePage(browser);
    }

    public ProductsPage selecionarBotaoProducts() {
        botaoProducts.click();
        return new ProductsPage(browser);
    }

    public HomePage rolarPaginaParaBaixo(String valor) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0," + valor + ");");
        return this;
    }

    public HomePage preencherCampoSubscriptionComEmail(String email) {
        campoEmailSubscription.sendKeys(email);
        return this;
    }

    public HomePage selecionarBotaoSubscription() {
        clicarBotaoSubscription.click();
        return this;
    }

    public CartPage selecionarBotaoCart() {
        selecionarBotaoCarrinho.click();
        return new CartPage(browser);
    }

    public HomePage selecionarCategoriaWomen() {
        selecionarCategoriaWomen.click();
        return this;
    }

    public HomePage selecionarOpcaoDress() {
        selecionarVestido.click();
        return this;
    }

    public ContinuarOuAdicionarProdutosPage selecionarProduto() {
        WebElement elemento = browser.findElements(By.cssSelector("a[data-product-id='2']")).get(2);
        elemento.click();
        return new ContinuarOuAdicionarProdutosPage(browser);
    }

    public HomePage selecionarBotaoScrollUp() {
        selecionarBotaoFlechaParaCima.click();
        return this;
    }

    public LoginPage selecionarBotaoLoginECadastrar() {
        selecionarBotaoLoginECadastrar.click();
        return new LoginPage(browser);
    }


    @Override
    public HomePage fecharPropaganda() throws InterruptedException {

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
