package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ProductsPage(WebDriver browser) {
        this.browser = browser;

    }

    public ProductsPage verificaPagina() {
        String titulo = browser.getTitle();
        Assertions.assertEquals("Automation Exercise - All Products", titulo);
        return this;
    }

    public ProductsPage selecionarProduto(int numero) {
        List<WebElement> lista = browser.findElements(By.cssSelector("div[class='col-sm-4']")).stream().collect(Collectors.toList());
        lista.get(2).click();
        return this;
    }

    @Override
    public ProductsPage fecharPropaganda() throws InterruptedException {

        try {
            WebElement iframe1 = browser.findElement(By.id("aswift_5"));
            Thread.sleep(1000);

            if (iframe1.isDisplayed()) {
                browser.switchTo().frame("aswift_5");
                browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                browser.switchTo().defaultContent();
            } else {
                browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
            }
        } catch (Exception e) {
            System.out.println("Qual foi a excecao: " + e.getMessage());
        }

        return this;
    }
}
