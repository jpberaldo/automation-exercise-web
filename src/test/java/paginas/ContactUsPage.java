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

        WebElement iframe1 = browser.findElement(By.cssSelector("iframe[id='aswift_1']"));

        if (iframe1.isDisplayed()) {
            Thread.sleep(1000);
            browser.switchTo().frame("aswift_1");
            Thread.sleep(1000);
            browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
            browser.switchTo().defaultContent();

        } else if (iframe1.isDisplayed()) {
            Thread.sleep(1000);
            browser.switchTo().frame("aswift_1");
            Thread.sleep(1000);
            browser.switchTo().frame("ad_iframe");
            Thread.sleep(1000);
            browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
            browser.switchTo().defaultContent();
        }

        return new HomePage(browser);
    }
}
