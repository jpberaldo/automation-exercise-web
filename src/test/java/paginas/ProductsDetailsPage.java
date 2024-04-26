package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsDetailsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ProductsDetailsPage(WebDriver browser) {
        this.browser = browser;
    }

    public ContinuarOuAdicionarProdutosPage alterarQuantidadeDoProduto() {
        //browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.findElement(By.cssSelector("input[type='number']")).clear();
        browser.findElement(By.cssSelector("input[type='number']")).sendKeys("1");
        browser.findElement(By.cssSelector("button[type='button']")).click();
        return new ContinuarOuAdicionarProdutosPage(browser);
    }

    @Override
    public ProductsDetailsPage fecharPropaganda() throws InterruptedException {

        for (int i = 5; i < 6; i++) {

            try {
                String iframeName = "aswift_" + i + "']";
                WebElement iframe = browser.findElement(By.cssSelector("iframe[id='" + iframeName));

//                Wait<WebDriver> wait = new WebDriverWait(browser, Duration.ofSeconds(10));
//                wait.until(b -> iframe.isDisplayed());

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
