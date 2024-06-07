package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class ContaCriadaPage {

    private WebDriver browser;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement botaoContinuar;

    public ContaCriadaPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public InicialLogonPage clicarNoBotaoContinuar() {
        botaoContinuar.click();
        return new InicialLogonPage(browser);
    }

}
