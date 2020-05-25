package pageSteps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pageObjects.SimuladorInvestimentosObjects;

public class SimuladorInvestimentoSteps extends SimuladorInvestimentosObjects {

    @Dado("que acesso a pagina do Simulador de Investimento Sicredi")
    public void queAcessoAPaginaDoSimuladorDeInvestimentoSicredi() {
        acessarPaginaSimuladorInvestimentoSicredi();
    }

    @E("clico no botão {string} na página do Simulador de Investimento Sicredi")
    public void clicoNoBotaoNaPaginaDoSimuladorDeInvestimentoSicredi(String btnName) {
        clicarBotao(btnName);
    }

    @Quando("preencho o campo {string} com o {string} na página do Simulador de Investimento Sicredi")
    public void preenchoOCampoComONaPaginaDoSimuladorDeInvestimentoSicredi(String labelInput, String valor) {
        preencherCampoSimuladorInvestimentoSicrediComValor(labelInput, valor);
    }

    @Então("mensagem {string} será exibida na página do Simulador de Investimento Sicredi")
    public void mensagemSeraExibidaNaPaginaDoSimuladorDeInvestimento(String mensagem) {
        validarMensagemErroValorInvalido(mensagem);
    }

    @Então("a pagina com o resultado do Simulador de Investimento Sicredi será exibida")
    public void aPaginaComOResultadoDoSimuladorDeInvestimentoSicrediSeraExibida() {
        validarPaginaResultadoSimulador();
    }

    @Então("verifico o valor de {string} e {string} na linha {string}")
    public void verificoOValorDeENaLinha(String tempo, String valor, String linha) {
        validarCamposResultadoSimulador(linha, tempo, valor);
    }

}
