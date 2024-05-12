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
                .selecionarProduto()
                .fecharPropaganda();

        //Asserts, voltar para melhorar/corrigir depois

//        List<WebElement> nomeProduto = browser.findElements(By.tagName("h2"));
//        String texto = nomeProduto.get(2).getText();
//        String texto2 = nomeProduto.get(2).getAccessibleName();
//        String texto3 = nomeProduto.get(2).toString();
//        System.out.println(texto +"\n" + texto2 + "\n" + texto3);
//        //Assertions.assertTrue(nomeProduto.isDisplayed());
//
//        String categoria = browser.findElement(By.xpath("//p[text()='Category: Women > Tops']")).getText();
//        Assertions.assertEquals("Category: Women > Tops", categoria);
//
//        String preco = browser.findElement(By.xpath("//span[text()='Rs. 500']")).getText();
//        Assertions.assertEquals("Rs. 500", preco);
//
//        String disponibilidade = browser.findElement(By.xpath("//p[text()=' In Stock']")).getText();
//        Assertions.assertEquals(" In Stock", disponibilidade);
    }

    @Test
    @DisplayName("Test Case 9: Search Product")
    public void testPesquisarPorProduto() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .pesquisarPorProduto("men");
//                .fecharPropaganda();

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
