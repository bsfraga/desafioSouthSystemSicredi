package pageObjects;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import utils.Report;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ServicoSimuladorInvestimentoObjects {

    private Response response;
    private ValidatableResponse json;

    public void enviarRequisicaoSericoSimulador(String url) {
        response = given()
                .contentType(ContentType.JSON)
                .get(url);
        Report.logPass("Requisição enviada para o endpoint \""+url+"\" com sucesso.");
    }

    public void validarStatusCodeRequisicaoSimulador(String statusCode) {
        json = response.then().statusCode(Integer.parseInt(statusCode));
        Report.logPass("Status code da requisição validado com sucesso.");
    }

    public void validarId(String id){
        json.assertThat().body("id", Matchers.is(Integer.parseInt(id)));
        Report.logPass("ID contido no corpo da requisição validado com sucesso.");
    }

    public void validarMeses(String meses){
        ArrayList aux = new ArrayList();
        for (String item : meses.split(",")){
            aux.add(item.trim());
        }
        json.assertThat().body("meses", Matchers.is(aux));
        Report.logPass("Objeto \"meses\" contido no corpo da requisição validado com sucesso.");
    }

    public void validarValor(String valor){
        ArrayList aux = new ArrayList();
        for(String item : valor.split(",")){
            aux.add(item.trim());
        }
        json.assertThat().body("valor", Matchers.is(aux));
        Report.logPass("Objeto \"valor\" contido no corpo da requisição validado com sucesso.");
    }

}
