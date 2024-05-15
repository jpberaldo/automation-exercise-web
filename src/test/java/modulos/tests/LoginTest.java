package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import paginas.LoginPage;
import service.ServiceTest;

public class LoginTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com");

    }

    @Test
    @DisplayName("Test Case 1: Register User")
    public void preencherCamposNomeAndEmailDoCadastroEClicarNoBotaoSignup() {

        //verificar se esta na pagina correta
        String url = browser.getTitle();
        System.out.println(url);
        String expected = "Automation Exercise";
        Assertions.assertEquals(expected, url);

        new HomePage(browser)
                .selecionarBotaoLoginECadastrar()
                .preencherCampoNovoNomeParaCadastro("Testes12")
                .preencherCampoEmailParaCadastro("testes12@email.com")
                .clicarNoBotaoCriarNovaConta();

        //Verificando texto da tela da pagina de cadastro
        String actual = browser.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
        expected = "ENTER ACCOUNT INFORMATION";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Case 2: Login User with correct email and password")
    public void fazerLoginComDadosValidos() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoLoginECadastrar()
                .preencherCampoEmailLogin("teste9@email.com")
                .preencherCampoSenhaLogin("senhanova123")
                .selecionarBotaoLogarNaConta()
                .selecionarBotaoDeletarConta()
                .fecharPropaganda();
        //.clicarNoBotaoContinuarParaHome();

        if (browser.findElement(By.cssSelector("h2[data-qa='account-deleted']")).isDisplayed()) {
            String expected = "ACCOUNT DELETED!";
            String actual = browser.findElement(By.cssSelector("h2[data-qa='account-deleted']")).getText();
            Assertions.assertEquals(expected, actual);
        }

    }

    @Test
    @DisplayName("Test Case 3: Login User with incorrect email and password")
    public void fazerLoginComDadosInvalidos() {

        browser.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        new LoginPage(browser)
                .preencherCampoEmailLogin("testes@testes")
                .preencherCampoSenhaLogin("111111")
                .selecionarBotaoLogarNaConta();

        String msgErro = browser.findElement(By.cssSelector("p[style='color: red;']")).getText();
        Assertions.assertEquals("Your email or password is incorrect!", msgErro);
        System.out.printf(msgErro);

    }

    @Test
    @DisplayName("Test Case 4: Logout User")
    public void sairDaContaLogada() {

        browser.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        new LoginPage(browser)
                .preencherCampoEmailLogin("teste9@email.com")
                .preencherCampoSenhaLogin("senhanova123")
                .selecionarBotaoLogarNaConta()
                .selecionarBotaoParaSairDaContaLogada();

    }

    @Test
    @DisplayName("Test Case 10: Verify Subscription in home page")
    public void validarBotaoDeInscricaoPorEmail() {

        new HomePage(browser)
                .rolarPaginaParaBaixo("8000")
                .preencherCampoSubscriptionComEmail("email@testes.com");

        WebElement sucesso = browser.findElement(By.id("success-subscribe"));
        System.out.println(sucesso.isDisplayed() + " :::: " + sucesso.getText());

        WebElement subscriptionTela = browser.findElement(By.xpath("//h2[text()='Subscription']"));
        System.out.println(subscriptionTela.isDisplayed() + " :::: " + subscriptionTela.getText());


    }

    @AfterEach
    @DisplayName("Executa toda vez, depois de cada teste que foi executado")
    public void afterEach() {
        browser.quit();
    }

}
