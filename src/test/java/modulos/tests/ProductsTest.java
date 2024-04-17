package modulos.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

public class ProductsTest {

    private WebDriver browser;


    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.get("https://automationexercise.com");
        this.browser.manage().window().maximize();

    }

    @Test
    @DisplayName("Test Case 8: Verify All Products and product detail page")
    public void testarPaginaDeProdutoEUmProdutoEspecifico() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .verificaPagina()
                .selecionarProduto()
                .fecharPropaganda();

    }

}
