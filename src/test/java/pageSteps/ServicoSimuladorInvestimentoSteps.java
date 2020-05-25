package pageSteps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import pageObjects.ServicoSimuladorInvestimentoObjects;

public class ServicoSimuladorInvestimentoSteps extends ServicoSimuladorInvestimentoObjects {

    @Dado("que envio uma requisição do tipo GET para o serviço {string}")
    public void queEnvioUmaRequisicaoDoTipoGetParaOServico(String url) {
        enviarRequisicaoSericoSimulador(url);
    }

    @Então("o código da requisição deverá ser {string}")
    public void oCodigoDaRequisicaoDeveraSer(String statusCode) {
        validarStatusCodeRequisicaoSimulador(statusCode);
    }

    @Então("o corpo da requisição deve conter id {string}")
    public void oCorpoDaRequisicaoDeveConterId(String id) {
        validarId(id);
    }

    @Então("o corpo da requisição deve conter meses {string}")
    public void oCorpoDaRequisicaoDeveConterMeses(String meses) {
        validarMeses(meses);
    }

    @Então("o corpo da requisição deve conter valor {string}")
    public void oCorpoDaRequisicaoDeveConterValor(String valor) {
        validarValor(valor);
    }

}
