package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import service.ServiceTest;

public class CategoryProductsTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com/");

    }


    @Test
    @DisplayName("Test Case 18: View Category Products")
    public void visualizarProdutosNoMenuDeCategoria() throws InterruptedException {

        new HomePage(browser)
                .rolarPaginaParaBaixo("400")
                .selecionarCategoriaWomen()
                .selecionarOpcaoDress()
                .fecharPropaganda();

        WebElement titulo = browser.findElement(By.cssSelector("h2[class='title text-center']"));
        Assertions.assertEquals("women - dress products", titulo.getText().toLowerCase());

    }

    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste")
    public void afterEach() {
        browser.quit();
    }
}
