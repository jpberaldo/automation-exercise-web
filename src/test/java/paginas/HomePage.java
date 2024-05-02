package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage implements fecharBotaoDePropaganda {

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

    public ProductsPage selecionarBotaoProducts() {
        browser.findElement(By.cssSelector("a[href='/products']")).click();
        return new ProductsPage(browser);
    }

    public HomePage rolarPaginaParaBaixo(String valor) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0," + valor + ");");
        return this;
    }

    public HomePage preencherCampoSubscriptionComEmail(String email) {
        browser.findElement(By.id("susbscribe_email")).sendKeys(email);
        browser.findElement(By.id("subscribe")).click();
        return this;
    }

    public CartPage selecionarBotaoCart() {
        browser.findElement(By.cssSelector("a[href='/view_cart']")).click();
        return new CartPage(browser);
    }

    public HomePage selecionarCategoriaWomen() {
        browser.findElement(By.cssSelector("a[href='#Women']")).click();
        return this;
    }

    public HomePage selecionarOpcaoDress() {
        browser.findElement(By.cssSelector("a[href='/category_products/1']")).click();
        return this;
    }

    @Override
    public HomePage fecharPropaganda() throws InterruptedException {

        for (int i = 0; i < 6; i++) {

            try {
                String iframeName = "aswift_" + i + "']";
                WebElement iframe = browser.findElement(By.cssSelector("iframe[id='" + iframeName));

                if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                    browser.switchTo().defaultContent();


                } else if (iframe.isDisplayed()) {
                    browser.switchTo().frame(iframe);
                    WebElement iframe2 = browser.findElement(By.cssSelector("iframe[id='ad_iframe']"));
                    browser.switchTo().frame(iframe2);
                    browser.findElement(By.cssSelector("div[id='dismiss-button']")).click();
                    browser.switchTo().defaultContent();

                }

            } catch (Exception e) {
                System.out.println("Qual foi a excecao: " + e.getMessage());
            }
        }

        return this;
    }
}
