package modulos.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

import java.time.Duration;

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
}
