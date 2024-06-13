package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ServiceTest {

    private static final String CHROME_EXECUTAVEL = "webdriver.chrome.driver";
    private static final String CAMINHO_CHROME_PATH = "C:\\drivers\\chromedriver.exe";
    private WebDriver browser;

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

    public void selecionarDiaMesAno(WebDriver driver, int dia, int mes, int ano) {

        this.browser = driver;
        WebElement elementDia = this.browser.findElement(By.id("days"));
        Select selectDia = new Select(elementDia);
        if (dia >= 1 && dia <= 31) {
            selectDia.selectByIndex(dia);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um dia entre 1 e 31");
        }

        WebElement elementMes = this.browser.findElement(By.name("months"));
        Select selectMes = new Select(elementMes);
        if (mes >= 1 && mes <= 12) {
            selectMes.selectByIndex(mes);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um mes entre 1 e 12");
        }

        WebElement elementAno = this.browser.findElement(By.id("years"));
        Select selectAno = new Select(elementAno);
        if (ano >= 0 && ano <= 121) {
            selectAno.selectByIndex(ano);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um ano entre 1900 e 2021");
        }
    }

}
