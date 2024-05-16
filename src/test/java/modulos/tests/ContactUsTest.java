package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;
import service.ServiceTest;

public class ContactUsTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com");

    }

    @Test
    @DisplayName("Test Case 6: Contact Us Form")
    public void preencherFormularioNaPaginaDeContato() throws InterruptedException {

        String descricao = "Lorem ipsum dolor sit amet. Ut praesentium fuga est dicta commodi ut reprehenderit velit quo error odio ut nobis commodi sed adipisci consectetur cum quia corrupti? Sit voluptatem excepturi ut iusto impedit et mollitia eligendi vel assumenda magnam. Et minus nihil ex veritatis dolores a iure cupiditate id aperiam dicta in minima voluptatem qui natus pariatur rem debitis velit. Id exercitationem nemo a possimus vero sit neque galisum non neque iste a omnis molestias quo unde voluptate.\n" +
                "\n";

        new HomePage(browser)
                .selecionarBotaoContactUs()
                .capturarTituloDoFormulario()
                .preencherCampoNome("Testes")
                .preencherCampoEmail("testes@email.com")
                .preencherCampoAssunto("Testes")
                .preencherCampoDescricao(descricao)
                .subirArquivo()
                .clicarNoBotaoSubmit()
                .clicarNoBotaoOk();
//                .retornarParaPaginaInicial()
//                .fecharPropaganda();

        String actual = browser.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        String expected = "Success! Your details have been submitted successfully.";
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    @DisplayName("Executa toda vez depois de cada teste.")
    public void afterEach() {
        browser.quit();
    }

}
