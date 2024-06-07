package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "unchecked"})
public class ProductsDetailsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    @FindBy(css = "input[type='number']")
    private WebElement campoQuantidadeDoProduto;

    @FindBy(css = "button[type='button']")
    private WebElement botaoAdicionarProduto;

    public ProductsDetailsPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public ContinuarOuAdicionarProdutosPage alterarQuantidadeDoProduto(String qtdProduto) {
        campoQuantidadeDoProduto.clear();
        campoQuantidadeDoProduto.sendKeys(qtdProduto);
        botaoAdicionarProduto.click();
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
