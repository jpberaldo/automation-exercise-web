package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsDetailsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ProductsDetailsPage(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    public ProductsDetailsPage fecharPropaganda() throws InterruptedException {
        try {
            WebElement iframe1 = browser.findElement(By.cssSelector("iframe[id='aswift_6']"));

            if (iframe1.isDisplayed()) {
                Thread.sleep(1000);
                browser.switchTo().frame(iframe1);
                browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                browser.switchTo().defaultContent();

            } else if (iframe1.isDisplayed()) {
                Thread.sleep(1000);
                browser.switchTo().frame(iframe1);
                WebElement iframe2 = browser.findElement(By.cssSelector("iframe[id='ad_iframe']"));
                browser.switchTo().frame(iframe2);
                Thread.sleep(1000);
                browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                browser.switchTo().defaultContent();
            }

        } catch (Exception e) {
            System.out.println("Qual foi a excecao: " + e.getMessage());
        }

        return this;
    }
}
