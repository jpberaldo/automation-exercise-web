package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicialLogonPage {

    private WebDriver browser;

    public InicialLogonPage(WebDriver browser) {
        this.browser = browser;
    }

    public ContaDeletadaPage selecionarBotaoDeletarConta() throws InterruptedException {
        Thread.sleep(3000);
        browser.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        return new ContaDeletadaPage(browser);
    }

    public LoginPage selecionarBotaoParaSairDaContaLogada() {
        browser.findElement(By.linkText("Logout")).click();
        return new LoginPage(browser);
    }

    public CartPage selecionarBotaoParaCarrinho() {
        browser.findElement(By.linkText("Cart")).click();
        return new CartPage(browser);
    }

}
