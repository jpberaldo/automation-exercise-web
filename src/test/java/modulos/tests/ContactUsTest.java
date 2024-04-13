package modulos.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.HomePage;

public class ContactUsTest {

    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste da classe.")
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.browser = new ChromeDriver();
        //acessar site abaixo
        this.browser.get("https://automationexercise.com");
        this.browser.manage().window().maximize();

    }

    @Test
    @DisplayName("Test Case 6: Contact Us Form")
    public void preencherFormularioNaPaginaDeContato(){

        String descricao = "Lorem ipsum dolor sit amet. Ut praesentium fuga est dicta commodi ut reprehenderit velit quo error odio ut nobis commodi sed adipisci consectetur cum quia corrupti? Sit voluptatem excepturi ut iusto impedit et mollitia eligendi vel assumenda magnam. Et minus nihil ex veritatis dolores a iure cupiditate id aperiam dicta in minima voluptatem qui natus pariatur rem debitis velit. Id exercitationem nemo a possimus vero sit neque galisum non neque iste a omnis molestias quo unde voluptate.\n" +
                "\n";

        new HomePage(browser)
                .selecionarBotaoContactUs()
                .capturarTituloDoFormulario()
                .preencherCampoNome("Testes")
                .preencherCampoEmail("testes@email.com")
                .preencherCampoAssunto("Testes")
                .preencherCampoDescricao(descricao);
    }

}
