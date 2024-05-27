package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.debugger.Debugger;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsDetailsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ProductsDetailsPage(WebDriver browser) {
        this.browser = browser;
    }

    public ContinuarOuAdicionarProdutosPage alterarQuantidadeDoProduto(String qtdProduto) {
        browser.findElement(By.cssSelector("input[type='number']")).clear();
        browser.findElement(By.cssSelector("input[type='number']")).sendKeys(qtdProduto);
        browser.findElement(By.cssSelector("button[type='button']")).click();
        return new ContinuarOuAdicionarProdutosPage(browser);
    }

    public ContinuarOuAdicionarProdutosPage selecionarVariosProdutos(int produtoNum) {

        WebElement produtoSelecionado = browser.findElement(By.cssSelector("a[data-product-id='" + produtoNum + "']"));

        try {
            if (produtoSelecionado.isDisplayed()) {
                produtoSelecionado.click();

            } else if (!produtoSelecionado.isDisplayed()) {
                JavascriptExecutor jse = (JavascriptExecutor) browser;
                jse.executeScript("window.scrollBy(0,750);");
                produtoSelecionado.click();

            }
        } catch (Exception e) {
            System.out.println("Qual foi a excecao: " + e.getMessage());
        }
        return new ContinuarOuAdicionarProdutosPage(browser);
    }

    @Override
    public ProductsDetailsPage fecharPropaganda() throws InterruptedException {

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
