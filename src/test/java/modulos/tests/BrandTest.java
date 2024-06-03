package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import service.ServiceTest;

public class BrandTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com/");

    }

    @Test
    @DisplayName("Test Case 19: View & Cart Brand Products")
    public void visualizarBrandsNaPaginaDeProdutos() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarBrand(1)
                .selecionarNovaBrand(2);

        WebElement produto = browser.findElement(By.cssSelector("h2[class='title text-center']"));
        String actual = produto.getText();
        String expected = "Brand - H&M Products";
        Assertions.assertEquals(expected.toUpperCase(), actual);

    }


    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste")
    public void afterEach() {
        browser.quit();
    }
}
