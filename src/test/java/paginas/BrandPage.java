package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "FieldCanBeLocal"})
public class BrandPage {

    private WebDriver browser;

    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement produtoPolo;

    @FindBy(css = "a[href='/brand_products/H&M']")
    private WebElement produtoHM;

    public BrandPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public BrandPage selecionarNovaBrand(int opcao) {

        if (opcao == 1) {
            produtoPolo.click();

        } else if (opcao == 2) {
            produtoHM.click();

        }
        return this;
    }
}
