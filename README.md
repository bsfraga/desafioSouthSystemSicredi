# Desafio South System + Sicredi

Framework de testes utilizado na validação do [Desafio QA](https://github.com/rh-southsystem/desafio-qa).

![Imgur](https://imgur.com/uUPimzs)



## Relatório de Testes

Foram executados testes funcionais e automatizados (interface e API) na seguinte história:

### Historia

Com o propósito de Simular um Investimento na Poupança como um Associado, eu gostaria de preencher o formulário de simulação e ver a tabela de resultado com Mês e Valor

### Critérios de Aceitação (Interface)

1. O associado preencher todos os campos corretamente e visualizar o formulário de simulação
2. O associado preencher o valor inferior a “R$ 20.00” e receber a mensagem de orientação “Valor mínimo de R$ 20.00”

### Critérios de Aceitação (API)

1. Acessar o [endpoint](http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador)
2. Validar retorno :
```json
{ "id": 1, "meses": ["112", "124", "136", "148"], "valor": ["2.802", "3.174", "3.564", "3.971"] }
```
### Casos de Teste

* Validar comportamento da aplicação quando associado preenche formulário corretamente
```
O objetivo deste teste é avaliar como a aplicação se comporta de acordo com a entrada de dados do usuário utilizando dados válidos no formulário do Simulador de Investimento Sicredi.
```
![Validar comportamento da aplicação quando associado preenche formulário corretamente](https://i.imgur.com/uZaaO3D.png)

* Validar comportamento da aplicação quando associado preenche valores inválidos nos campos
```
O objetivo deste teste é avaliar como a aplicação se comporta de acordo com a entrada de dados do usuário utilizando dados inválidos no formulário do Simulador de Investimento Sicredi.
```
![Validar comportamento da aplicação quando associado preenche valores inválidos nos campos](https://i.imgur.com/MVCoiy7.png)

* Validar serviço do Simulador de Investimento Sicredi
```
O objetivo deste teste é avaliar como o serviço da aplicação se comporta com uma chamada de requisição do tipo GET e se a requisição está retornando os valores corretamente.
```
![Validar serviço do Simulador de Investimento Sicredi](https://i.imgur.com/uUPimzs.png)

## Framework
Desenvolvido em Java, o framework utiliza junto do jUnit5, Cucumber (BDD), RestAssured (API) e Selenium (Interface Web).

OBS: o framework está atualmente configurado para utilizar paralelismo.

O paralelismo apenas será utilizado efetivamente se os testes forem executados pelo Maven.
```
Exemplo:

mvn clean test
```
## Processo de Testes

Inicialmente, testes funcionais foram executados. Visando melhor entendimento do fluxo de execução dos critérios de aceitação. Em seguida, foi feito o levantamento da necessidade de dados (quais dados seriam utilizados e como) para que fosse possível a criação de casos de teste em formado BDD, tornando assim os estes mais intuitivos para qualquer pessoa que queira entender o fluxo da funcionalidade assim como dos testes em si.

Após a criação dos BDDs foram criados os códigos que executam a automação de fato. Utilizando o padrão de projetos "Page-Objects". 
```
Projeto╗
       ╠...
       ╠features - Casos de Teste
       ╠pageSteps - Hooks das Steps dos Casos de Teste
       ╠pageObjects - Automação
       ╠...
```
