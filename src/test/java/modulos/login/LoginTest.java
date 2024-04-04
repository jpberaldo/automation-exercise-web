package modulos.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

public class LoginTest {

    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.get("https://automationexercise.com/login");
        this.browser.manage().window().maximize();
        //verificar se o site, é o correto
        String url = browser.getTitle();
        System.out.println(url);
        Assertions.assertEquals("Automation Exercise - Signup / Login", url);

    }

    @Test
    @DisplayName("Preencher campo nome e email para ir a tela de cadastro")
    public void preencherCamposNomeAndEmailDoCadastroEClicarNoBotaoSignup() {

        //verificando se o texto "New User Signup!" esta visivel
        String verificaNome = browser.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        System.out.println(verificaNome);

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("Testes")
                .preencherCampoEmailParaCadastro("testes@email.com")
                .clicarNoBotaoCriarNovaConta();

        //Verificando texto da tela da pagina de cadastro
        String verificaTxtTelaCadastro = browser.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
        Assertions.assertEquals("ENTER ACCOUNT INFORMATION", verificaTxtTelaCadastro);

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois de cada teste que foi executado")
    public void afterEach(){
        this.browser.close();
    }


}
