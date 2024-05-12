package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ServiceTest {

    private static final String CHROME_EXECUTAVEL = "webdriver.chrome.driver";
    private static final String CAMINHO_CHROME_PATH = "C:\\drivers\\chromedriver.exe";

    public WebDriver abrirNavegador(WebDriver browser, String url) {
        //instancia do chrome, mas poderia ser o firefox ou edge
        browser = new ChromeDriver();
        //acessar site abaixo
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        browser.manage().window().maximize();
        browser.get(url);
        return browser;
    }

    public static void configurarNavegador() {
        System.setProperty(CHROME_EXECUTAVEL, CAMINHO_CHROME_PATH);
    }
}
