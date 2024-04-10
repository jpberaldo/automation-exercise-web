package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaDeletadaPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ContaDeletadaPage(WebDriver browser) {
        this.browser = browser;
    }

    public InicialPage clicarNoBotaoContinuarParaHome() throws InterruptedException {
        Thread.sleep(3000);
        browser.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        return new InicialPage(browser);
    }

    @Override
    public InicialPage fecharPropaganda() throws InterruptedException {
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
        return new InicialPage(browser);
    }
}
