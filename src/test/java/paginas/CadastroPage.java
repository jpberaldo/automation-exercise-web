package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage {

    private WebDriver browser;

    public CadastroPage(WebDriver browser) {
        this.browser = browser;
    }

    public CadastroPage escolherTitulo(int titulo) {
        if (titulo == 1) {
            browser.findElement(By.id("id_gender1")).click();
        } else if (titulo == 2) {
            browser.findElement(By.id("id_gender2")).click();
        } else {
            throw new IllegalArgumentException("Você precisa selecionar 1 para Mr ou 2 para Mrs");
        }
        return this;
    }

    public CadastroPage definirSenha(String senha) {
        browser.findElement(By.name("password")).sendKeys(senha);
        return this;
    }

    public CadastroPage selecionarDiaMesAno(int dia, int mes, int ano) {

        WebElement elementDia = browser.findElement(By.id("days"));
        Select selectDia = new Select(elementDia);
        if (dia >= 1 && dia <= 31) {
            selectDia.selectByIndex(dia);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um dia entre 1 e 31");
        }

        WebElement elementMes = browser.findElement(By.name("months"));
        Select selectMes = new Select(elementMes);
        if (mes >= 1 && mes <= 12) {
            selectMes.selectByIndex(5);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um mes entre 1 e 12");
        }

        WebElement elementAno = browser.findElement(By.id("years"));
        Select selectAno = new Select(elementAno);
        if (ano >= 0 && ano <= 121) {
            selectAno.selectByIndex(ano);
        } else {
            throw new IllegalArgumentException("Você deve selecionar um ano entre 1900 e 2021");
        }

        return this;
    }

    public CadastroPage selecionarCheckboxUm() {
        browser.findElement(By.id("newsletter")).click();
        return this;
    }

    public CadastroPage selecionarCheckboxDois() {
        browser.findElement(By.name("optin")).click();
        return this;
    }

    public CadastroPage preencherCampoPrimeiroNome(String primeiroNome) {
        browser.findElement(By.id("first_name")).sendKeys(primeiroNome);
        return this;
    }

    public CadastroPage preencherCampoUltimoNome(String ultimoNome) {
        browser.findElement(By.id("last_name")).sendKeys(ultimoNome);
        return this;
    }

    public CadastroPage preencherCampoEmpresa(String empresa) {
        browser.findElement(By.id("company")).sendKeys(empresa);
        return this;
    }

    public CadastroPage preencherCampoEndereco(String endereco) {
        browser.findElement(By.id("address1")).sendKeys(endereco);
        return this;
    }

    public CadastroPage selecionarPais(String pais) {
        WebElement elementPais = browser.findElement(By.name("country"));
        Select selectPais = new Select(elementPais);
        selectPais.selectByValue(pais);
        return this;
    }

    public CadastroPage preencherCampoEstado(String estado) {
        browser.findElement(By.id("state")).sendKeys(estado);
        return this;
    }

    public CadastroPage preencherCampoCidade(String cidade) {
        browser.findElement(By.id("city")).sendKeys(cidade);
        return this;
    }

    public CadastroPage preencherCep(String cep) {
        browser.findElement(By.id("zipcode")).sendKeys(cep);
        return this;
    }

    public CadastroPage preencherCelular(String celular) {
        browser.findElement(By.name("mobile_number")).sendKeys(celular);
        return this;
    }

    public CadastroPage rolarPaginaParaBaixo() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,500);");

        return this;
    }

    public ContaCriadaPage clicarNoBotaoCriarConta() {
        browser.findElement(By.cssSelector("button[data-qa='create-account']")).click();
        return new ContaCriadaPage(browser);
    }

}
