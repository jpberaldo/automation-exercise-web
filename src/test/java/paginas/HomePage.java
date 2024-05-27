package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage implements fecharBotaoDePropaganda {

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

    public HomePage rolarPaginaParaBaixo(String valor) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0," + valor + ");");
        return this;
    }

    public HomePage preencherCampoSubscriptionComEmail(String email) {
        browser.findElement(By.id("susbscribe_email")).sendKeys(email);
        return this;
    }

    public HomePage selecionarBotaoSubscription() {
        browser.findElement(By.id("subscribe")).click();
        return this;
    }

    public CartPage selecionarBotaoCart() {
        browser.findElement(By.cssSelector("a[href='/view_cart']")).click();
        return new CartPage(browser);
    }

    public HomePage selecionarCategoriaWomen() {
        browser.findElement(By.cssSelector("a[href='#Women']")).click();
        return this;
    }

    public HomePage selecionarOpcaoDress() {
        browser.findElement(By.cssSelector("a[href='/category_products/1']")).click();
        return this;
    }

    public ContinuarOuAdicionarProdutosPage selecionarProduto() {

        WebElement elemento = browser.findElements(By.cssSelector("a[data-product-id='2']")).get(2);
        elemento.click();
        return new ContinuarOuAdicionarProdutosPage(browser);
    }

    public HomePage selecionarBotaoScrollUp() {
        browser.findElement(By.id("scrollUp")).click();
        return this;
    }

    public LoginPage selecionarBotaoLoginECadastrar() {
        browser.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
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
