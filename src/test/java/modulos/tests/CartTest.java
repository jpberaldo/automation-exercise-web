package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

import java.time.Duration;
import java.util.List;

public class CartTest {

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
    @DisplayName("Test Case 11: Verify Subscription in Cart page")
    public void validarBotaoDeInscricaoPorEmailNaPaginaDoCarrinho() {

        new HomePage(browser)
                .selecionarBotaoCart()
                .preencherCampoSubscriptionComEmail("testes@email.com");

        WebElement sucesso = browser.findElement(By.id("success-subscribe"));
        System.out.println(sucesso.isDisplayed() + " :::: " + sucesso.getText());

        WebElement subscriptionTela = browser.findElement(By.xpath("//h2[text()='Subscription']"));
        System.out.println(subscriptionTela.isDisplayed() + " :::: " + subscriptionTela.getText());

    }

    @Test
    @DisplayName("Test Case 12: Add Products in Cart")
    public void validarAdicaoDeProdutosNoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .adicionarProdutoAoCarrinho(1)
                .selecionarBotaoContinuarParaAdicionarMaisProdutos()
                .adicionarProdutoAoCarrinho(2)
                .selecionarContinuarParaCarrinho();

        WebElement prod1 = browser.findElement(By.linkText("Blue Top"));
        System.out.println(prod1.getText());

        Assertions.assertEquals("Blue Top", prod1.getText());

        WebElement prod2 = browser.findElement(By.linkText("Men Tshirt"));
        System.out.println(prod2.getText());

        Assertions.assertEquals("Men Tshirt", prod2.getText());

        List<WebElement> listaPreco = browser.findElements(By.cssSelector("td[class='cart_price']"));
        System.out.println("Tamanho da lista: " + listaPreco.size());
        System.out.println("\nExibindo precos dos produtos");
        listaPreco.stream().filter(l -> l.isDisplayed()).forEach(System.out::println);

    }

    @Test
    @DisplayName("Test Case 13: Verify Product quantity in Cart")
    public void verificarEAlterarQuantidadeDoProdutoNoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto()
                .fecharPropaganda()
                .alterarQuantidadeDoProduto();

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois cada teste")
    public void afterEach() {
        browser.quit();
    }

}
