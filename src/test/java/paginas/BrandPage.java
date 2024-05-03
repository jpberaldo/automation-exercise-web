package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandPage {

    private WebDriver browser;

    public BrandPage(WebDriver browser) {
        this.browser = browser;
    }

    public BrandPage selecionarNovaBrand(int opcao) {

        if (opcao == 1) {
            browser.findElement(By.cssSelector("a[href='/brand_products/Polo']")).click();

        } else if (opcao == 2) {
            browser.findElement(By.cssSelector("a[href='/brand_products/H&M']")).click();

        }
        return this;
    }
}
