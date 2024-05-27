package paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ContactUsPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    public ContactUsPage(WebDriver browser) {
        this.browser = browser;
    }

    public ContactUsPage capturarTituloDoFormulario() {

        List<WebElement> element = browser.findElements(By.cssSelector("h2[class='title text-center']"));
        WebElement element2 = element.get(1);
        System.out.println("O titulo 'GET IN TOUCH', esta visivel?: " + element2.isDisplayed());
        return this;
    }

    public ContactUsPage preencherCampoNome(String nome) {
        browser.findElement(By.name("name")).sendKeys(nome);
        return this;
    }

    public ContactUsPage preencherCampoEmail(String email) {
        browser.findElement(By.name("email")).sendKeys(email);
        return this;

    }

    public ContactUsPage preencherCampoAssunto(String assuntoContato) {
        browser.findElement(By.name("subject")).sendKeys(assuntoContato);
        return this;

    }

    public ContactUsPage preencherCampoDescricao(String descricao) {
        browser.findElement(By.id("message")).sendKeys(descricao);
        return this;

    }

    public ContactUsPage subirArquivo() {
        File subirArquivo = new File("C:\\Users\\Joao\\Pictures\\teste.png");
        WebElement arquivo = browser.findElement(By.cssSelector("input[type=file]"));
        arquivo.sendKeys(subirArquivo.getAbsolutePath());
        return this;
    }

    public ContactUsPage clicarNoBotaoSubmit() {
        browser.findElement(By.cssSelector("input[data-qa=submit-button]")).click();
        return this;
    }

    public ContactUsPage clicarNoBotaoOk() {
        Alert alert = browser.switchTo().alert();
        alert.accept();
        return this;
    }

    public ContactUsPage retornarParaPaginaInicial() {
        browser.findElement(By.xpath("//span[text()=' Home']")).click();
        return this;
    }

    @Override
    public HomePage fecharPropaganda() throws InterruptedException {

        for (int i = 0; i < 7; i++) {

            try {
                String iframeName = "aswift_" + i + "']";
                WebElement iframe = browser.findElement(By.cssSelector("iframe[id='" + iframeName));

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);

                    try {
                        WebElement botaoFechar = browser.findElement(By.cssSelector("div[id='dismiss-button']"));
                        botaoFechar.click();
                    } catch (Exception e) {

                        try {
                            WebElement iframe2 = browser.findElement(By.cssSelector("iframe[id='ad_iframe']"));
                            browser.switchTo().frame(iframe2);
                            browser.findElement(By.id("dismiss-button")).click();
                        } catch (Exception e2) {
                            System.out.println("Elemento nao encontrado: " + e2.getMessage());
                        }
                    } finally {
                        browser.switchTo().defaultContent();
                    }
                }

            } catch (Exception e3) {
                System.out.println("Excessao encontrada: " + e3.getMessage());
            }
        }
        return new HomePage(browser);
    }
}
