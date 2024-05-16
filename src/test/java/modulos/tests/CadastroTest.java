package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;
import paginas.LoginPage;
import service.ServiceTest;

public class CadastroTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com/");

    }

    @Test
    @DisplayName("Test Case 1: Register User")
    public void preencherPrimeiraParteDoCadastroDoUsuario() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoLoginECadastrar()
                .preencherCampoNovoNomeParaCadastro("teste20")
                .preencherCampoEmailParaCadastro("teste20@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("teste20")
                .preencherCampoUltimoNome("testando")
                .preencherCampoEmpresa("Google")
                .preencherCampoEndereco("Times Square")
                .selecionarPais("United States")
                .rolarPaginaParaBaixo()
                .preencherCampoEstado("New York")
                .preencherCampoCidade("New York")
                .preencherCep("10036")
                .preencherCelular("999999999")
                .clicarNoBotaoCriarConta()
                .clicarNoBotaoContinuar();
        //.selecionarBotaoDeletarConta()
        //.clicarNoBotaoContinuarParaHome();

    }

    @Test
    @DisplayName("Test Case 5: Register User with existing email")
    public void tentarRegistarComEmailJaUtilizado() {

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("teste9")
                .preencherCampoEmailParaCadastro("teste9@email.com")
                .clicarNoBotaoCriarNovaConta();

        String msgTela = browser.findElement(By.cssSelector("p[style='color: red;']")).getText();
        Assertions.assertEquals("Email Address already exist!", msgTela);
        System.out.printf(msgTela);

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois de cada teste que foi executado")
    public void afterEach() {
        browser.quit();
    }

}
