package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactUsPage {

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

    public ContactUsPage preencherCampoEmail(String email){
        browser.findElement(By.name("email")).sendKeys(email);
        return this;

    }

    public ContactUsPage preencherCampoAssunto(String assuntoContato){
        browser.findElement(By.name("subject")).sendKeys(assuntoContato);
        return this;

    }

    public ContactUsPage preencherCampoDescricao(String descricao){
        browser.findElement(By.id("message")).sendKeys(descricao);
        return this;

    }

}
