package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public LoginPage preencherCampoNovoNomeParaCadastro(String nomeCadastro) {
        this.browser.findElement(By.cssSelector("input[data-qa='signup-name']")).click();
        this.browser.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys(nomeCadastro);
        return this;
    }

    public LoginPage preencherCampoEmailParaCadastro(String emailCadastro) {
        this.browser.findElement(By.cssSelector("input[data-qa='signup-email']")).click();
        this.browser.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(emailCadastro);
        return this;
    }

    public CadastroPage clicarNoBotaoCriarNovaConta() {
        this.browser.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        return new CadastroPage(browser);
    }

}
