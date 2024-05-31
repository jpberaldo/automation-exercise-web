package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InicialLogonPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public InicialLogonPage(WebDriver browser) {
        this.browser = browser;
    }

    public ContaDeletadaPage selecionarBotaoDeletarConta() throws InterruptedException {
        Thread.sleep(3000);
        browser.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        return new ContaDeletadaPage(browser);
    }

    public LoginPage selecionarBotaoParaSairDaContaLogada() {
        browser.findElement(By.linkText("Logout")).click();
        return new LoginPage(browser);
    }

    public CartPage selecionarBotaoParaCarrinho() {
        browser.findElement(By.linkText("Cart")).click();
        return new CartPage(browser);
    }

    public ProductsPage selecionarBotaoParaPaginaProdutos() {
        browser.findElement(By.cssSelector("a[href='/products']")).click();
        return new ProductsPage(browser);
    }

    public InicialLogonPage fazerDonwloadInvoice() {
        browser.findElement(By.linkText("Download Invoice")).click();
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
