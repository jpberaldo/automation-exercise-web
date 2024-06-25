package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
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
                .preencherCampoNovoNomeParaCadastro("teste31")
                .preencherCampoEmailParaCadastro("teste31@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDataNascimento(10, 5, 1)
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("teste31")
                .preencherCampoUltimoNome("testando")
                .preencherCampoEmpresa("Google")
                .preencherCampoEndereco("Times Square")
                .selecionarPais("United States")
                .rolarPaginaParaBaixo(500)
                .preencherCampoEstado("New York")
                .preencherCampoCidade("New York")
                .preencherCep("10036")
                .preencherCelular("999999999")
                .clicarNoBotaoCriarConta()
                .clicarNoBotaoContinuar()
                .fecharPropaganda()
                .selecionarBotaoDeletarConta();

        WebElement contaDeletadaMsg = browser.findElement(By.xpath("//b[text()='Account Deleted!']"));
        String actual = contaDeletadaMsg.getText();
        String expected = "Account Deleted!";
        Assertions.assertEquals(expected.toUpperCase(), actual);

    }

    @Test
    @DisplayName("Test Case 5: Register User with existing email")
    public void tentarRegistarComEmailJaUtilizado() {

        new HomePage(browser)
                .selecionarBotaoLoginECadastrar()
                .preencherCampoNovoNomeParaCadastro("teste20")
                .preencherCampoEmailParaCadastro("teste20@email.com")
                .clicarNoBotaoCriarNovaConta();

        String actual = browser.findElement(By.cssSelector("p[style='color: red;']")).getText();
        String expected = "Email Address already exist!";
        Assertions.assertEquals(expected, actual);

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois de cada teste que foi executado")
    public void afterEach() {
        browser.quit();
    }

}
