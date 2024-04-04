package modulos.cadastro;

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
    @DisplayName("Preencher primeira parte do cadastro 'Enter account information'")
    public void preencherPrimeiraParteDoCadastroDoUsuario() {

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("testes")
                .preencherCampoEmailParaCadastro("testes@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois();

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois de cada teste que foi executado")
    public void afterEach() {
        this.browser.close();
    }

}
