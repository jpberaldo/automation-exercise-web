package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;
import service.ServiceTest;

public class TestCaseTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com");

    }

    @Test
    @DisplayName("Test Case 7: Verify Test Cases Page")
    public void acessarPaginaDeTestCase() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoTestCases()
                .fecharPropaganda();

        String actual = browser.getCurrentUrl();
        String expected = "https://automationexercise.com/test_cases";
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste.")
    public void afterEach() {
        browser.quit();
    }
}
