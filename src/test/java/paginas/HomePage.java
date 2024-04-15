package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver browser;

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public ContactUsPage selecionarBotaoContactUs() {
        browser.findElement(By.linkText("Contact us")).isDisplayed();
        browser.findElement(By.linkText("Contact us")).click();

        return new ContactUsPage(browser);
    }

    public TestCasePage selecionarBotaoTestCases() {
        browser.findElement(By.linkText("Test Cases")).click();
        return new TestCasePage(browser);
    }
}
