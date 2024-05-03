package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ServiceTest {

    public WebDriver abrirNavegador(WebDriver browser, String url) {
        browser = new ChromeDriver();
        //acessar site abaixo
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        browser.manage().window().maximize();
        browser.get(url);
        return browser;
    }
}
