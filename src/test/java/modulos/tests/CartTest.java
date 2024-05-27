package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import paginas.LoginPage;
import service.ServiceTest;

import java.util.List;
import java.util.stream.Collectors;

public class CartTest {

    private WebDriver browser;
    ServiceTest util = new ServiceTest();

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        ServiceTest.configurarNavegador();
        browser = util.abrirNavegador(browser, "https://automationexercise.com/login");

    }

    @Test
    @DisplayName("Test Case 11: Verify Subscription in Cart page")
    public void validarBotaoDeInscricaoPorEmailNaPaginaDoCarrinho() {

        new HomePage(browser)
                .selecionarBotaoCart()
                .preencherCampoSubscriptionComEmail("testes@email.com");

        WebElement campoSubscription = browser.findElement(By.xpath("//h2[text()='Subscription']"));
        String actual = campoSubscription.getText();
        String expected = "SUBSCRIPTION";
        Assertions.assertEquals(expected, actual);

        WebElement mensagemSucesso = browser.findElement(By.id("success-subscribe"));
        actual = mensagemSucesso.getText();
        expected = "You have been successfully subscribed!";
        Assertions.assertEquals(expected, actual);

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
        String actual = prod1.getText();
        String expected = "Blue Top";
        Assertions.assertEquals(expected, actual);

        WebElement prod2 = browser.findElement(By.linkText("Men Tshirt"));
        actual = prod2.getText();
        expected = "Men Tshirt";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Case 13: Verify Product quantity in Cart")
    public void verificarEAlterarQuantidadeDoProdutoNoCarrinho() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto(1)
                //.fecharPropaganda()
                .alterarQuantidadeDoProduto("4")
                .selecionarContinuarParaCarrinho();

        WebElement qtdAtualCarrinho = browser.findElement(By.cssSelector("button[class='disabled']"));
        String actual = qtdAtualCarrinho.getText();
        String expected = "4";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Case 14: Place Order: Register while Checkout")
    public void fazerRegistroDaContaDuranteACompraDoProduto() throws InterruptedException {

        new HomePage(browser)
                .selecionarBotaoProducts()
                .fecharPropaganda()
                .selecionarProduto(1)
                .fecharPropaganda()
                .alterarQuantidadeDoProduto("1")
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
                .botaoConfirmar();

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
                .selecionarProduto(1)
                .fecharPropaganda()
                .alterarQuantidadeDoProduto("1")
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
                .selecionarProduto(1)
                .fecharPropaganda()
                .alterarQuantidadeDoProduto("1")
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
        String actual = produto.getText();
        String expected = "Men Tshirt";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Case 23: Verify address details in checkout page")
    public void verificarEnderecoNaPaginaDeCheckout() throws InterruptedException {

        new LoginPage(browser)
                .preencherCampoNovoNomeParaCadastro("test0")
                .preencherCampoEmailParaCadastro("test0@email.com")
                .clicarNoBotaoCriarNovaConta()
                .escolherTitulo(1)
                .definirSenha("senhanova123")
                .selecionarDiaMesAno(10, 5, 1) //Ano subentende-se que o valor 1
                // seria o ano 2021 e vamos até 1900 ou seja o ultimo valor valido seria 121
                .selecionarCheckboxUm()
                .selecionarCheckboxDois()
                .preencherCampoPrimeiroNome("teste0")
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
                .selecionarProduto(1)
                .alterarQuantidadeDoProduto("1")
                .selecionarContinuarParaCarrinho()
                .selecionarBotaoProcederParaCheckout();

        List<WebElement> nome = browser.findElements(By.cssSelector("li[class='address_firstname address_lastname']"));
        nome.stream().map(WebElement::getText).forEach(System.out::println);
        String actual = nome.stream().map(WebElement::getText).collect(Collectors.joining(" | "));
        String expected = "Mr. teste0 testando | Mr. teste0 testando";
        Assertions.assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Test Case 24: Download Invoice after purchase order")
    public void downloadInvoiceDepoisDeFazerUmaCompra() throws InterruptedException {

        new LoginPage(browser)
                .preencherCampoEmailLogin("teste9@email.com")
                .preencherCampoSenhaLogin("senhanova123")
                .selecionarBotaoLogarNaConta()
                .selecionarBotaoParaPaginaProdutos()
                .fecharPropaganda()
                .selecionarProduto(1)
                .alterarQuantidadeDoProduto("1")
                .selecionarContinuarParaCarrinho()
                .botaoCheckout()
                .selecionarBotaoPlaceOrder()
                .preencherNumeroCartao()
                .preencherNomeCartao()
                .preencherMesCartao()
                .preencherAnoCartao()
                .preencherCVC()
                .botaoConfirmar()
                .fazerDonwloadInvoice();

        WebElement elemento = browser.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        String actual = elemento.getText();
        String expected = "Congratulations! Your order has been confirmed!";
        Assertions.assertEquals(expected, actual);

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois cada teste")
    public void afterEach() {
        //browser.quit();
    }

}
