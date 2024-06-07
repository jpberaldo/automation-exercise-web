package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "unchecked"})
public class ProductsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    @FindBy(id = "search_product")
    private WebElement campoPesquisarProduto;

    @FindBy(id = "submit_search")
    private WebElement botaoPesquisarProduto;

    @FindBy(id = "name")
    private WebElement campoNomeNoFormularioDeRevisao;

    @FindBy(id = "email")
    private WebElement campoEmailNoFormularioDeRevisao;

    @FindBy(xpath = "//textarea[@placeholder='Add Review Here!']")
    private WebElement campoRevisao;

    @FindBy(id = "button-review")
    private WebElement botaoEnviarRevisao;


    public ProductsPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public ProductsDetailsPage selecionarProduto(int numeroProduto) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,250);");
        WebElement produto = browser.findElement(By.cssSelector("a[href='/product_details/" + numeroProduto + "']"));
        produto.click();
        return new ProductsDetailsPage(browser);
    }


    public ProductsDetailsPage pesquisarPorProduto(String produto) {
        campoPesquisarProduto.sendKeys(produto);
        botaoPesquisarProduto.click();
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

    public BrandPage selecionarBrand(int opcao) {

        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,500);");

        if (opcao == 1) {
            browser.findElement(By.cssSelector("a[href='/brand_products/Polo']")).click();

        } else if (opcao == 2) {
            browser.findElement(By.cssSelector("a[href='/brand_products/H&M']")).click();

        }
        return new BrandPage(browser);
    }

    public ProductsPage visualizarUmProduto() {

        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,500);");
        browser.findElement(By.cssSelector("a[href='/product_details/1']")).click();

        return this;
    }

    public ProductsPage preencherCampoNomeRevisao(String nome) {
        campoNomeNoFormularioDeRevisao.sendKeys(nome);
        return this;
    }

    public ProductsPage preencherCampoEmailRevisao(String email) {
        campoEmailNoFormularioDeRevisao.sendKeys(email);
        return this;
    }

    public ProductsPage preencherRevisaoDoProduto(String descricao) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,500);");
        campoRevisao.sendKeys(descricao);
        return this;
    }

    public ProductsPage selecionarBotaoEnviarRevisao() {
        botaoEnviarRevisao.click();
        return this;
    }

    @Override
    public ProductsPage fecharPropaganda() throws InterruptedException {

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
