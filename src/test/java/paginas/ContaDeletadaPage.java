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
        Thread.sleep(4000);
        browser.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        return new HomePage(browser);
    }

    @Override
    public ContaDeletadaPage fecharPropaganda() throws InterruptedException {

        for (int i = 0; i < 6; i++) {

            try {
                String iframeName = "aswift_" + i;
                WebElement iframe = browser.findElement(By.id(iframeName));
//                Wait<WebDriver> wait = new WebDriverWait(browser, Duration.ofSeconds(10));
//                wait.until(b -> iframe.isDisplayed());

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    browser.findElement(By.id("dismiss-button")).click();
                    browser.switchTo().defaultContent();

                } else if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    WebElement iframe2 = browser.findElement(By.id("ad_iframe"));
                    browser.switchTo().frame(iframe2);
                    browser.findElement(By.id("dismiss-button")).click();
                    browser.switchTo().defaultContent();

                }

            } catch (Exception e) {
                System.out.println("Qual foi a excecao: " + e.getMessage());
            }
        }

        return this;
    }
}
