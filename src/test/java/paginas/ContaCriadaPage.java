package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaCriadaPage {

    private WebDriver browser;

    public ContaCriadaPage(WebDriver browser) {
        this.browser = browser;
    }

    public InicialPage clicarNoBotaoContinuar() {
        browser.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        return new InicialPage(browser);
    }
}
