package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class ContinuarOuAdicionarProdutosPage {

    private WebDriver browser;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement botaoContinuarParaAdicionarMaisProdutos;

    @FindBy(linkText = "View Cart")
    private WebElement botaoContinuarParaCarrinho;

    public ContinuarOuAdicionarProdutosPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public ProductsPage selecionarBotaoContinuarParaAdicionarMaisProdutos() {
        botaoContinuarParaAdicionarMaisProdutos.click();
        return new ProductsPage(browser);
    }

    public CartPage selecionarContinuarParaCarrinho() {
        botaoContinuarParaCarrinho.click();
        return new CartPage(browser);
    }

}
