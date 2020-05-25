#language:pt
#encoding:utf-8
@Selenium
Funcionalidade: Validar comportamento da aplicação quando associado preenche valores inválidos nos campos

  Como um usuário associado
  Quero efetuar uma simualção de investimento na poupança Sicredi utilizando valores inferiores aos exigidos
  Para validar o comportamento da aplicação

  Cenário de Fundo:
    Dado que acesso a pagina do Simulador de Investimento Sicredi

  Esquema do Cenário: Deve preencher campos com valores inválidos e validar mensagens de erro
    Quando preencho o campo "Qual o valor que você quer aplicar?" com o "<valorAplicar>" na página do Simulador de Investimento Sicredi
    E preencho o campo "Quando você quer poupar todo mês?" com o "<valorPoupar>" na página do Simulador de Investimento Sicredi
    E preencho o campo "Por quanto tempo você quer poupar?" com o "<tempo>" na página do Simulador de Investimento Sicredi
    E clico no botão "Simular" na página do Simulador de Investimento Sicredi
    Então mensagem "<mensagemValor>" será exibida na página do Simulador de Investimento Sicredi
    E mensagem "<mensagemTempo>" será exibida na página do Simulador de Investimento Sicredi

    Cenários:Valor invalido #1
      | valorAplicar | valorPoupar | tempo | mensagemValor         | mensagemTempo              |
      | 5,00         | 5,00        | 0     | Valor mínimo de 20.00 | Valor esperado não confere |
    Cenários:Valor invalido #2
      | valorAplicar | valorPoupar | tempo | mensagemValor         | mensagemTempo              |
      | 10,00        | 10,00       | 0     | Valor mínimo de 20.00 | Valor esperado não confere |
    Cenários:Valor invalido #3
      | valorAplicar | valorPoupar | tempo | mensagemValor         | mensagemTempo              |
      | 15,00        | 15,00       | 0     | Valor mínimo de 20.00 | Valor esperado não confere |
