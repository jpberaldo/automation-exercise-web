package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;
import service.ServiceTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com");

    }

    @Test
    @DisplayName("Test Case 8: Verify All Products and product detail page")
    public void testarPaginaDeProdutoEUmProdutoEspecifico() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto(1);

        WebElement elementoNomeProduto = browser.findElement(By.xpath("//h2[text()='Blue Top']"));
        String expected = "Blue Top";
        Assertions.assertEquals(expected, elementoNomeProduto.getText());

        WebElement elementoCategoria = browser.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        expected = "Category: Women > Tops";
        Assertions.assertEquals(expected, elementoCategoria.getText());

        WebElement elementoSpan = browser.findElement(By.xpath("//span[text()='Rs. 500']"));
        expected = "Rs. 500";
        Assertions.assertEquals(expected, elementoSpan.getText());

        WebElement elementoEstoque = browser.findElement(By.xpath("//p[text()=' In Stock']"));
        expected = "Availability: In Stock";
        Assertions.assertEquals(expected, elementoEstoque.getText());

        WebElement elementoCondicaoProduto = browser.findElement(By.xpath("//p[text()=' New']"));
        expected = "Condition: New";
        Assertions.assertEquals(expected, elementoCondicaoProduto.getText());

        WebElement elementoMarca = browser.findElement(By.xpath("//p[text()=' Polo']"));
        expected = "Brand: Polo";
        Assertions.assertEquals(expected, elementoMarca.getText());

    }

    @Test
    @DisplayName("Test Case 9: Search Product")
    public void testPesquisarPorProduto() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .pesquisarPorProduto("men");

        WebElement lista = browser.findElement(By.cssSelector("div[class='col-sm-4']"));
        if (lista.isDisplayed()) {
            List<WebElement> listaElement = browser.findElements(By.cssSelector("div[class='col-sm-4']"));
            listaElement.forEach(System.out::println);
            System.out.println(listaElement.size());
        }
    }

    @Test
    @DisplayName("Test Case 21: Add review on product")
    public void adicionarUmaRevisaoSobreUmProduto() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .visualizarUmProduto()
                .preencherCampoNomeRevisao("Testes")
                .preencherCampoEmailRevisao("testes@gmail.com")
                .preencherRevisaoDoProduto("Testessssss")
                .selecionarBotaoEnviarRevisao();

    }

    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste")
    public void afterEach() {
        browser.quit();
    }

}
