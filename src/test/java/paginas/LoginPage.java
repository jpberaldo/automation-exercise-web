package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class LoginPage {

    private WebDriver browser;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement campoNomeCadastro;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement campoEmailCadastro;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement botaoCriarNovaConta;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement campoSenhaLogin;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement campoEmailLogin;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement botaoLogarNaConta;

    @FindBy(css = "a[href='/']")
    private WebElement botaoPaginaInicial; //voltar para home

    public LoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public LoginPage preencherCampoNovoNomeParaCadastro(String nomeCadastro) {
        campoNomeCadastro.click();
        campoNomeCadastro.sendKeys(nomeCadastro);
        return this;
    }

    public LoginPage preencherCampoEmailParaCadastro(String emailCadastro) {
        campoEmailCadastro.click();
        campoEmailCadastro.sendKeys(emailCadastro);
        return this;
    }

    public CadastroPage clicarNoBotaoCriarNovaConta() {
        botaoCriarNovaConta.click();
        return new CadastroPage(browser);
    }

    public LoginPage preencherCampoSenhaLogin(String senhaLogin) {
        campoSenhaLogin.click();
        campoSenhaLogin.sendKeys(senhaLogin);
        return this;
    }

    public LoginPage preencherCampoEmailLogin(String emailLogin) {
        campoEmailLogin.click();
        campoEmailLogin.sendKeys(emailLogin);
        return this;
    }

    public InicialLogonPage selecionarBotaoLogarNaConta() {
        botaoLogarNaConta.click();
        return new InicialLogonPage(browser);
    }

    public HomePage selecionarBotaoHome() {
        botaoPaginaInicial.click();
        return new HomePage(browser);
    }

}
