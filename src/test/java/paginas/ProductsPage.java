package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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
        return new ProductsDetailsPage(browser);
    }

    @Override
    public ProductsPage fecharPropaganda() throws InterruptedException {

        for (int i = 0; i < 6; i++) {

            try {
                String iframeName = "aswift_" + i + "']";
                WebElement iframe = browser.findElement(By.cssSelector("iframe[id='" + iframeName));
                Wait<WebDriver> wait = new WebDriverWait(browser, Duration.ofSeconds(10));
                wait.until(b -> iframe.isDisplayed());

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                    browser.switchTo().defaultContent();
                    break;

                } else if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    WebElement iframe2 = browser.findElement(By.cssSelector("iframe[id='ad_iframe']"));
                    browser.switchTo().frame(iframe2);
                    browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                    browser.switchTo().defaultContent();
                    break;
                }

            } catch (Exception e) {
                System.out.println("Qual foi a excecao: " + e.getMessage());
            }
        }

        return this;
    }
}
