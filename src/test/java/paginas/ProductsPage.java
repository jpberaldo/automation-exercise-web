package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ProductsPage(WebDriver browser) {
        this.browser = browser;

    }


    public ProductsDetailsPage selecionarProduto() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,250);");
        browser.findElement(By.cssSelector("a[href='/product_details/1']")).isDisplayed();
        browser.findElement(By.cssSelector("a[href='/product_details/1']")).click();
        return new ProductsDetailsPage(browser);
    }

    public ProductsDetailsPage pesquisarPorProduto(String produto) {
        browser.findElement(By.id("search_product")).sendKeys(produto);
        browser.findElement(By.id("submit_search")).click();
        return new ProductsDetailsPage(browser);
    }

    public ContinuarOuAdicionarProdutosPage adicionarProdutoAoCarrinho(int numeroProduto) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,250);");
        WebElement centralizarMouseNoProdutoSelecionado = browser.findElement(By.cssSelector("a[data-product-id='" + numeroProduto + "']"));
        new Actions(browser)
                .moveToElement(centralizarMouseNoProdutoSelecionado)
                .perform();

        centralizarMouseNoProdutoSelecionado.click();

        return new ContinuarOuAdicionarProdutosPage(browser);
    }


    @Override
    public ProductsPage fecharPropaganda() throws InterruptedException {

        for (int i = 5; i < 6; i++) {

            try {
                String iframeName = "aswift_" + i;
                WebElement iframe = browser.findElement(By.id(iframeName));
//                Wait<WebDriver> wait = new WebDriverWait(browser, Duration.ofSeconds(10));
//                wait.until(b -> iframe.isDisplayed());

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    browser.findElement(By.id("dismiss-button")).click();
                    browser.switchTo().defaultContent();

                } else if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    WebElement iframe2 = browser.findElement(By.id("ad_iframe"));
                    browser.switchTo().frame(iframe2);
                    browser.findElement(By.id("dismiss-button")).click();
                    browser.switchTo().defaultContent();

                }

            } catch (Exception e) {
                System.out.println("Qual foi a excecao: " + e.getMessage());
            }
        }

        return this;
    }
}
