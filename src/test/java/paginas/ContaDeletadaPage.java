package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal", "unchecked"})
public class ContaDeletadaPage implements fecharBotaoDePropaganda {

    private WebDriver browser;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement botaoContinuarParaPaginaInicial;

    public ContaDeletadaPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }

    public HomePage clicarNoBotaoContinuarParaHome() {
        botaoContinuarParaPaginaInicial.click();
        return new HomePage(browser);
    }

    @Override
    public ContaDeletadaPage fecharPropaganda() throws InterruptedException {

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
        return this;
    }
}
