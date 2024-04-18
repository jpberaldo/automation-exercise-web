package modulos.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

import java.time.Duration;
import java.util.List;

public class ProductsTest {

    private final String CHROME_EXECUTAVEL = "webdriver.chrome.driver";
    private final String CAMINHO_CHROME_PATH = "C:\\drivers\\chromedriver.exe";
    private WebDriver browser;


    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        System.setProperty(CHROME_EXECUTAVEL, CAMINHO_CHROME_PATH);
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.manage().window().maximize();
        this.browser.get("https://automationexercise.com");


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

}
