package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

public class TestCaseTest {

    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.get("https://automationexercise.com");
        this.browser.manage().window().maximize();

    }

    @Test
    @DisplayName("Test Case 7: Verify Test Cases Page")
    public void acessarPaginaDeTestCase() {

        new HomePage(browser)
                .selecionarBotaoTestCases();

        String urlAtual = browser.getCurrentUrl();
        Assertions.assertEquals("https://automationexercise.com/test_cases", urlAtual);
    }

    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste.")
    public void afterEach() {
        this.browser.close();
    }
}
