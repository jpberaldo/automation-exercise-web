package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContinuarOuAdicionarProdutosPage {

    private WebDriver browser;

    public ContinuarOuAdicionarProdutosPage(WebDriver browser) {
        this.browser = browser;
    }

    public ProductsPage selecionarBotaoContinuarParaAdicionarMaisProdutos() {
        browser.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        return new ProductsPage(browser);
    }

    public CartPage selecionarContinuarParaCarrinho() {
        browser.findElement(By.linkText("View Cart")).click();
        return new CartPage(browser);
    }

}
