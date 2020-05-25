#language: pt
#encoding: utf-8
@RestAssured
Funcionalidade: Validar serviço do Simulador de Investimento Sicredi

  Como um usuário
  Quero efetuar uma requisição para o serviço do Simulador de Investimento
  Para obter dados de investimentos

  Esquema do Cenário: Validar serviço do Simulador de Investimento Sicredi
    Dado que envio uma requisição do tipo GET para o serviço "<url>"
    Então o código da requisição deverá ser "<statuscode>"
    E o corpo da requisição deve conter id "<id>"
    E o corpo da requisição deve conter meses "<meses>"
    E o corpo da requisição deve conter valor "<valor>"

    Cenarios: Requisição GET
      | id | meses              | valor                      | statuscode | url                                                         |
      | 1  | 112, 124, 136, 148 | 2.802, 3.174, 3.564, 3.971 | 200        | http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador |