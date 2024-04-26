package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver browser;

    public PaymentPage(WebDriver browser) {
        this.browser = browser;
    }

    public PaymentPage preencherNomeCartao() {
        browser.findElement(By.cssSelector("input[data-qa='name-on-card']")).sendKeys("TESTESSSSSS");
        return this;
    }

    public PaymentPage preencherNumeroCartao() {
        browser.findElement(By.cssSelector("input[data-qa='card-number']")).sendKeys("1111222233334444");
        return this;
    }

    public PaymentPage preencherCVC() {
        browser.findElement(By.cssSelector("input[data-qa='cvc']")).sendKeys("123");
        return this;
    }

    public PaymentPage preencherMesCartao() {
        browser.findElement(By.cssSelector("input[data-qa='expiry-month']")).sendKeys("01");
        return this;
    }

    public PaymentPage preencherAnoCartao() {
        browser.findElement(By.cssSelector("input[data-qa='expiry-year']")).sendKeys("2030");
        return this;
    }

    public InicialLogonPage botaoConfirmar() {
        browser.findElement(By.id("submit")).click();
        return new InicialLogonPage(browser);
    }
}
