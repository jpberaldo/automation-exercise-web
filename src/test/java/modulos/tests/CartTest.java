package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import paginas.LoginPage;
import service.ServiceTest;

import java.util.List;

public class CartTest {

    private final String CHROME_EXECUTAVEL = "webdriver.chrome.driver";
    private final String CAMINHO_CHROME_PATH = "C:\\drivers\\chromedriver.exe";
    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        System.setProperty(CHROME_EXECUTAVEL, CAMINHO_CHROME_PATH);
        ServiceTest util = new ServiceTest();

        this.browser = util.abrirNavegador(browser, "https://automationexercise.com/login");

    }

    @Test
    @DisplayName("Test Case 11: Verify Subscription in Cart page")
    public void validarBotaoDeInscricaoPorEmailNaPaginaDoCarrinho() {

        new HomePage(browser)
                .selecionarBotaoCart()
                .preencherCampoSubscriptionComEmail("testes@email.com");

        WebElement sucesso = browser.findElement(By.id("success-subscribe"));
        System.out.println(sucesso.isDisplayed() + " :::: " + sucesso.getText());

        WebElement subscriptionTela = browser.findElement(By.xpath("//h2[text()='Subscription']"));
        System.out.println(subscriptionTela.isDisplayed() + " :::: " + subscriptionTela.getText());

    }

    @Test
    @DisplayName("Test Case 12: Add Products in Cart")
    public void validarAdicaoDeProdutosNoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .adicionarProdutoAoCarrinho(1)
                .selecionarBotaoContinuarParaAdicionarMaisProdutos()
                .adicionarProdutoAoCarrinho(2)
                .selecionarContinuarParaCarrinho();

        WebElement prod1 = browser.findElement(By.linkText("Blue Top"));
        System.out.println(prod1.getText());

        Assertions.assertEquals("Blue Top", prod1.getText());

        WebElement prod2 = browser.findElement(By.linkText("Men Tshirt"));
        System.out.println(prod2.getText());

        Assertions.assertEquals("Men Tshirt", prod2.getText());

        List<WebElement> listaPreco = browser.findElements(By.cssSelector("td[class='cart_price']"));
        System.out.println("Tamanho da lista: " + listaPreco.size());
        System.out.println("\nExibindo precos dos produtos");
        listaPreco.stream().filter(l -> l.isDisplayed()).forEach(System.out::println);

    }

    @Test
    @DisplayName("Test Case 13: Verify Product quantity in Cart")
    public void verificarEAlterarQuantidadeDoProdutoNoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto()
                .fecharPropaganda()
                .alterarQuantidadeDoProduto()
                .selecionarContinuarParaCarrinho();

        WebElement qtdAtualCarrinho = browser.findElement(By.cssSelector("button[class='disabled']"));
        System.out.println(qtdAtualCarrinho.getText());

        Assertions.assertEquals("4", qtdAtualCarrinho.getText());

    }

    @Test
    @DisplayName("Test Case 14: Place Order: Register while Checkout")
    public void fazerRegistroDaContaDuranteACompraDoProduto() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto()
                .fecharPropaganda()
                .alterarQuantidadeDoProduto()
                .selecionarContinuarParaCarrinho()
                .selecionarBotaoProcederParaCheckout()
                .selecionarBotaoRegistroOuLogin()
                .preencherCampoNovoNomeParaCadastro("test6")
                .preencherCampoEmailParaCadastro("testesbr6@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("test5")
                .preencherCampoUltimoNome("testando")
                .preencherCampoEmpresa("Google")
                .preencherCampoEndereco("Times Square")
                .selecionarPais("United States")
                .rolarPaginaParaBaixo()
                .preencherCampoEstado("New York")
                .preencherCampoCidade("New York")
                .preencherCep("10036")
                .preencherCelular("999999999")
                .clicarNoBotaoCriarConta()
                .clicarNoBotaoContinuar()
                .selecionarBotaoParaCarrinho()
                .botaoCheckout()
                .selecionarBotaoPlaceOrder()
                .preencherNomeCartao()
                .preencherNumeroCartao()
                .preencherCVC()
                .preencherMesCartao()
                .preencherAnoCartao()
                .botaoConfirmar()
                .selecionarBotaoDeletarConta()
                .fecharPropaganda()
                .clicarNoBotaoContinuarParaHome();

    }

    @Test
    @DisplayName("Test Case 15: Place Order: Register before Checkout")
    public void realizarCadastroAntesDeAdicionarParaOCarrinho() throws InterruptedException {

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("teste15")
                .preencherCampoEmailParaCadastro("teste15@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("teste15")
                .preencherCampoUltimoNome("testando")
                .preencherCampoEmpresa("Google")
                .preencherCampoEndereco("Times Square")
                .selecionarPais("United States")
                .rolarPaginaParaBaixo()
                .preencherCampoEstado("New York")
                .preencherCampoCidade("New York")
                .preencherCep("10036")
                .preencherCelular("999999999")
                .clicarNoBotaoCriarConta()
                .clicarNoBotaoContinuar()
                .selecionarBotaoParaPaginaProdutos()
                .fecharPropaganda()
                .selecionarProduto()
                .fecharPropaganda()
                .alterarQuantidadeDoProduto()
                .selecionarContinuarParaCarrinho()
                .selecionarBotaoProcederParaCheckoutJaLogadoNaConta()
                .selecionarBotaoPlaceOrder()
                .preencherNomeCartao()
                .preencherNumeroCartao()
                .preencherCVC()
                .preencherMesCartao()
                .preencherAnoCartao()
                .botaoConfirmar()
                .selecionarBotaoDeletarConta()
                .fecharPropaganda();


    }

    @Test
    @DisplayName("Test Case 16: Place Order: Login before Checkout")
    public void logarNaContaAntesDeIrParaCarrinho() throws InterruptedException {

        new LoginPage(browser)
                .preencherCampoEmailLogin("teste9@email.com")
                .preencherCampoSenhaLogin("senhanova123")
                .selecionarBotaoLogarNaConta()
                .selecionarBotaoParaPaginaProdutos()
                .fecharPropaganda()
                .selecionarProduto()
                .fecharPropaganda()
                .alterarQuantidadeDoProduto()
                .selecionarContinuarParaCarrinho()
                .selecionarBotaoProcederParaCheckoutJaLogadoNaConta()
                .selecionarBotaoPlaceOrder()
                .preencherNomeCartao()
                .preencherNumeroCartao()
                .preencherCVC()
                .preencherMesCartao()
                .preencherAnoCartao()
                .botaoConfirmar();
    }

    @Test
    @DisplayName("Test Case 17: Remove Products From Cart")
    public void removerProdutoDoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .adicionarProdutoAoCarrinho(1)
                .selecionarBotaoContinuarParaAdicionarMaisProdutos()
                .adicionarProdutoAoCarrinho(2)
                .selecionarContinuarParaCarrinho()
                .removerProdutoDoCarrinho();

    }

    @Test
    @DisplayName("Test Case 20: Search Products and Verify Cart After Login")
    public void procuraProdutosEVerificaCarrinhoDepoisDeLogar() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .pesquisarPorProduto("top")
                .selecionarVariosProdutos(1)
                .selecionarBotaoContinuarParaAdicionarMaisProdutos()
                .adicionarProdutoAoCarrinho(5)
                .selecionarContinuarParaCarrinho()
                .selecionarBotaoParaPaginaDeSignupOuLogin()
                .preencherCampoEmailLogin("teste9@email.com")
                .preencherCampoSenhaLogin("senhanova123")
                .selecionarBotaoLogarNaConta()
                .selecionarBotaoParaCarrinho();

        WebElement produto1 = browser.findElement(By.cssSelector("a[href='/product_details/1']"));
        Assertions.assertEquals("Blue Top", produto1.getText());

        WebElement produto2 = browser.findElement(By.cssSelector("a[href='/product_details/5']"));
        Assertions.assertEquals("Winter Top", produto2.getText());

    }

    @Test
    @DisplayName("Test Case 22: Add to cart from Recommended items")
    public void adicionarItemDosRecomendadosParaOCarrinho() throws InterruptedException {

        new LoginPage(browser)
                .selecionarBotaoHome()
                .fecharPropaganda()
                .rolarPaginaParaBaixo("7500")
                .selecionarProduto()
                .selecionarContinuarParaCarrinho();

        WebElement produto = browser.findElement(By.cssSelector("a[href='/product_details/2']"));
        Assertions.assertEquals("Men Tshirt", produto.getText());

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois cada teste")
    public void afterEach() {
        //browser.quit();
    }

}
