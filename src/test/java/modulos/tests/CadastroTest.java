package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

public class CadastroTest {

    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.get("https://automationexercise.com");
        this.browser.manage().window().maximize();
        browser.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        //verificar se o site, é o correto
        String url = browser.getTitle();
        System.out.println(url);
        Assertions.assertEquals("Automation Exercise - Signup / Login", url);

    }

    @Test
    @DisplayName("Test Case 1: Register User")
    public void preencherPrimeiraParteDoCadastroDoUsuario() throws InterruptedException {

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("teste5")
                .preencherCampoEmailParaCadastro("teste5@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("teste5")
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
        this.browser.close();
    }

}
