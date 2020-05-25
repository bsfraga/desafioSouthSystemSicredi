package pageObjects;

import core.BasePage;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Report.*;


public class SimuladorInvestimentosObjects extends BasePage {

    private By locatorAplicaError = By.id("valorAplicar-error");
    private By locatorInvestirError = By.id("valorInvestir-error");
    private By locatorTempoError = By.id("tempo-error");
    private By locatorInputAplicar = By.id("valorAplicar");
    private By locatorInputInvestir = By.id("valorInvestir");
    private By locatorInputTempo = By.id("tempo");
    private By locatorBtnSimular = By.xpath("//button[@class='btn btnAmarelo btnSimular']");
    private By locatorBtnLimparFormulario = By.xpath("//a[@class='btn btnLimpar']");
    private By locatorDivResultado = By.xpath("//div[@class='maisOpcoes']");
    private By locatorTempo1 = By.xpath("//tr[1]//td[1]");
    private By locatorTempo2 = By.xpath("//tr[2]//td[1]");
    private By locatorTempo3 = By.xpath("//tr[3]//td[1]");
    private By locatorTempo4 = By.xpath("//tr[4]//td[1]");
    private By locatorValor1 = By.xpath("//tr[1]//td[2]");
    private By locatorValor2 = By.xpath("//tr[2]//td[2]");
    private By locatorValor3 = By.xpath("//tr[3]//td[2]");
    private By locatorValor4 = By.xpath("//tr[4]//td[2]");
    private By locatorTextoAdicional = By.xpath("//div[@class='adicional']/p");

    public void acessarPaginaSimuladorInvestimentoSicredi() {
        try {
            utils.goToUrl("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        } catch (Exception e) {
            logFail("Falha ao acessar página do Simulador de Investimento Sicredi");
            e.printStackTrace();
        }
    }

    public void preencherCampoSimuladorInvestimentoSicrediComValor(String labelInput, String valor) {
        try {
            switch (labelInput) {
                case "Qual o valor que você quer aplicar?":
                    utils.waitElementIsVisible(locatorInputAplicar, 10);
                    utils.sendKeys(locatorInputAplicar, valor);
                    break;
                case "Quando você quer poupar todo mês?":
                    utils.waitElementIsVisible(locatorInputInvestir, 10);
                    utils.sendKeys(locatorInputInvestir, valor);
                    break;
                case "Por quanto tempo você quer poupar?":
                    utils.waitElementIsVisible(locatorInputTempo, 10);
                    utils.sendKeys(locatorInputTempo, valor);
                    break;
            }
        } catch (Exception e) {
            logFail("Falha ao preencher campo \"" + labelInput + "\" na página do Simulador de Investimento Sicredi.");
            e.printStackTrace();
        }
    }

    public void validarMensagemErroValorInvalido(String mensagem) {
        try {
            if (mensagem.contains("20.00")) {
                utils.waitElementIsVisible(locatorAplicaError, 10);
                assertEquals(mensagem, utils.getText(locatorAplicaError));
                logPass("Mensagem de erro no campo \"valorAplicar\" validada com sucesso.");
                utils.waitElementIsVisible(locatorInvestirError, 10);
                assertEquals(mensagem, utils.getText(locatorInvestirError));
                logPass("Mensagem de erro no campo \"valorInvestir\" validada com sucesso.");
            } else if (mensagem.contains("não confere")) {
                utils.waitElementIsVisible(locatorTempoError, 10);
                assertEquals(mensagem, utils.getText(locatorTempoError));
                logPass("Mensagem de erro \"Valor esperado não confere\" validada com sucesso.");
            }
        } catch (Exception e) {
            logFail("Não foi possivel validar a mensagem \"" + mensagem + "\" na página do Simulador de Investimento Sicredi.");
            e.printStackTrace();
        }
    }

    public void clicarBotao(String btnName) {
        try {
            switch (btnName) {
                case "Simular":
                    utils.waitElementIsVisible(locatorBtnSimular, 10);
                    utils.clickButton(locatorBtnSimular);
                    break;
                case "Limpar Formulário":
                    utils.waitElementIsVisible(locatorBtnLimparFormulario, 10);
                    utils.clickButton(locatorBtnLimparFormulario);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logFail("Não foi possível clicar no botão \"" + btnName + "\" na página do Simulador de Investimento Sicredi.");
        }
    }

    public void validarPaginaResultadoSimulador() {
        try {
            assertTrue(utils.waitElementIsVisible(locatorTextoAdicional, 10));
            assertEquals("*** A rentabilidade projetada considera apenas a remuneração adicional da Poupança (0,5% am). Procure o seu gerente na sua cooperativa e veja mais informações e opções de investimento:", utils.getText(locatorTextoAdicional));
            assertTrue(utils.waitElementIsVisible(locatorDivResultado, 10));
            logPass("Página com resultado de Simulador de Investimento Sicredi validada com sucesso.");
        } catch (Exception e) {
            logFail("Não foi possível validar a página de resultado do Simulador de Investimento Sicredi.");
            e.printStackTrace();
        }
    }

    public void validarCamposResultadoSimulador(String linha, String tempo, String valor){
        try {
            switch (linha){
                case "1":
                    assertEquals(tempo, utils.getText(locatorTempo1));
                    assertEquals(valor, utils.getText(locatorValor1));
                    logPass("Tempo 1 e Valor 1 validado com sucesso.");
                    break;
                case "2":
                    assertEquals(tempo, utils.getText(locatorTempo2));
                    assertEquals(valor, utils.getText(locatorValor2));
                    logPass("Tempo 2 e Valor 2 validado com sucesso.");
                    break;
                case "3":
                    assertEquals(tempo, utils.getText(locatorTempo3));
                    assertEquals(valor, utils.getText(locatorValor3));
                    logPass("Tempo 3 e Valor 3 validado com sucesso.");
                    break;
                case "4":
                    assertEquals(tempo, utils.getText(locatorTempo4));
                    assertEquals(valor, utils.getText(locatorValor4));
                    logPass("Tempo 4 e Valor 4 validado com sucesso.");
                    break;
                default: logFail("Verifique o parâmetro de \"linha\" no arquivo feature. ");
            }
        }catch (Exception e){
            e.printStackTrace();
            logFail("Não foi possivel validar o valor do campo Tempo \""+tempo+"\" e do Valor: \""+valor+"\" na página de resultado do Simulador de Investimento Sicredi.");
        }
    }
}
