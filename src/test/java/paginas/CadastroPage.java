package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings({"UnusedReturnValue", "unused", "FieldMayBeFinal"})
public class CadastroPage {

    private WebDriver browser;

    @FindBy(name = "password")
    private WebElement campoSenha;

    @FindBy(id = "newsletter")
    private WebElement primeiroCheckbox;

    @FindBy(name = "optin")
    private WebElement segundoCheckbox;

    @FindBy(id = "first_name")
    private WebElement campoPrimeiroNome;

    @FindBy(id = "last_name")
    private WebElement campoUltimoNome;

    @FindBy(id = "company")
    private WebElement campoEmpresa;

    @FindBy(id = "address1")
    private WebElement campoEndereco;

    @FindBy(name = "country")
    private WebElement campoPais;

    @FindBy(id = "state")
    private WebElement campoEstado;

    @FindBy(id = "city")
    private WebElement campoCidade;

    @FindBy(id = "zipcode")
    private WebElement campoCEP;

    @FindBy(name = "mobile_number")
    private WebElement campoNumeroCelular;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement botaoCriarConta;


    public CadastroPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
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
        campoSenha.sendKeys(senha);
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
        primeiroCheckbox.click();
        return this;
    }

    public CadastroPage selecionarCheckboxDois() {
        segundoCheckbox.click();
        return this;
    }

    public CadastroPage preencherCampoPrimeiroNome(String primeiroNome) {
        campoPrimeiroNome.sendKeys(primeiroNome);
        return this;
    }

    public CadastroPage preencherCampoUltimoNome(String ultimoNome) {
        campoUltimoNome.sendKeys(ultimoNome);
        return this;
    }

    public CadastroPage preencherCampoEmpresa(String empresa) {
        campoEmpresa.sendKeys(empresa);
        return this;
    }

    public CadastroPage preencherCampoEndereco(String endereco) {
        campoEndereco.sendKeys(endereco);
        return this;
    }

    public CadastroPage selecionarPais(String pais) {
        Select selectPais = new Select(campoPais);
        selectPais.selectByValue(pais);
        return this;
    }

    public CadastroPage preencherCampoEstado(String estado) {
        campoEstado.sendKeys(estado);
        return this;
    }

    public CadastroPage preencherCampoCidade(String cidade) {
        campoCidade.sendKeys(cidade);
        return this;
    }

    public CadastroPage preencherCep(String cep) {
        campoCEP.sendKeys(cep);
        return this;
    }

    public CadastroPage preencherCelular(String celular) {
        campoNumeroCelular.sendKeys(celular);
        return this;
    }

    public CadastroPage rolarPaginaParaBaixo() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,500);");

        return this;
    }

    public ContaCriadaPage clicarNoBotaoCriarConta() {
        botaoCriarConta.click();
        return new ContaCriadaPage(browser);
    }

}
