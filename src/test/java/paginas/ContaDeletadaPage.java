package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContaDeletadaPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ContaDeletadaPage(WebDriver browser) {
        this.browser = browser;
    }

    public HomePage clicarNoBotaoContinuarParaHome() throws InterruptedException {
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        return new HomePage(browser);
    }

    @Override
    public ContaDeletadaPage fecharPropaganda() throws InterruptedException {

        WebElement iframe1 = browser.findElement(By.cssSelector("iframe[id='aswift_1']"));

        if (iframe1.isDisplayed()) {
            Thread.sleep(1000);
            browser.switchTo().frame("aswift_1");
            Thread.sleep(1000);
            browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
            browser.switchTo().defaultContent();

        } else if (iframe1.isDisplayed()) {
            Thread.sleep(1000);
            browser.switchTo().frame("aswift_1");
            Thread.sleep(1000);
            browser.switchTo().frame("ad_iframe");
            Thread.sleep(1000);
            browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
            browser.switchTo().defaultContent();
        }
        return this;
    }
}
