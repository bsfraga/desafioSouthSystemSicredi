#language: pt
#encoding: utf-8
@Selenium
Funcionalidade: Validar comportamento da aplicação quando associado preenche formulário corretamente

  Como um usuário associado
  Quero efetuar uma simulação de investimento na poupança Sicredi
  Para validar a tabela de resultado mês e valor

  Cenário de Fundo:
    Dado que acesso a pagina do Simulador de Investimento Sicredi

  Esquema do Cenário: Deve simular investimento com dados válidos e validar resultado de simulação
    Quando preencho o campo "Qual o valor que você quer aplicar?" com o "<valorAplicar>" na página do Simulador de Investimento Sicredi
    E preencho o campo "Quando você quer poupar todo mês?" com o "<valorInvestir>" na página do Simulador de Investimento Sicredi
    E preencho o campo "Por quanto tempo você quer poupar?" com o "<tempo>" na página do Simulador de Investimento Sicredi
    E clico no botão "Simular" na página do Simulador de Investimento Sicredi
    Então a pagina com o resultado do Simulador de Investimento Sicredi será exibida
    E verifico o valor de "<tempo1>" e "<valorTempo1>" na linha "1"
    E verifico o valor de "<tempo2>" e "<valorTempo2>" na linha "2"
    E verifico o valor de "<tempo3>" e "<valorTempo3>" na linha "3"
    E verifico o valor de "<tempo4>" e "<valorTempo4>" na linha "4"

    Cenarios:Simulação Investimento #1
      | valorAplicar | valorInvestir | tempo | tempo1 | tempo2 | tempo3 | tempo4 | valorTempo1 | valorTempo2 | valorTempo3 | valorTempo4 |
      | 20.00        | 20.00         | 100   | 112    | 124    | 136    | 148    | R$ 2.494    | R$ 2.789    | R$ 3.090    | R$ 3.397    |
    Cenarios:Simulação Investimento #2
      | valorAplicar | valorInvestir | tempo | tempo1 | tempo2 | tempo3 | tempo4 | valorTempo1 | valorTempo2 | valorTempo3 | valorTempo4 |
      | 35.76        | 23.40         | 30    | 42     | 54     | 66     | 78     | R$ 1.057    | R$ 1.363    | R$ 1.675    | R$ 1.993    |
    Cenarios:Simulação Investimento #3
      | valorAplicar | valorInvestir | tempo | tempo1 | tempo2 | tempo3 | tempo4 | valorTempo1 | valorTempo2 | valorTempo3 | valorTempo4 |
      | 150.44       | 75.90         | 44    | 56     | 68     | 80     | 92     | R$ 4.625    | R$ 5.642    | R$ 6.680    | R$ 7.740    |
    Cenarios:Simulação Investimento #4
      | valorAplicar | valorInvestir | tempo | tempo1 | tempo2 | tempo3 | tempo4 | valorTempo1 | valorTempo2 | valorTempo3 | valorTempo4 |
      | 500.10       | 250.00        | 97    | 109    | 121    | 133    | 145    | R$ 30.570   | R$ 34.241   | R$ 37.988   | R$ 41.815   |

