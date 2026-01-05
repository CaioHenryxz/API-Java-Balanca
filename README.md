# Sistema de Monitoramento de Peso - Incubadora Neonatal (API)

![STATUS](http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge)
![VERSION](http://img.shields.io/static/v1?label=RELEASE&message=V1.0.0&color=BLUE&style=for-the-badge)

## 🏥 Sobre o Projeto

Este projeto consiste na implementação completa de uma API RESTful para o controle e monitoramento de peso em incubadoras neonatais. Desenvolvido no âmbito de uma **Iniciação Científica**, o sistema foi finalizado e validado para atuar como middleware entre o hardware de precisão (células de carga) e interfaces de monitoramento hospitalar.

O software soluciona o problema da pesagem não invasiva, aplicando algoritmos de tratamento de sinais para garantir a precisão dos dados mesmo com a movimentação do recém-nascido.

## 🏛 Arquitetura Implementada

O projeto foi construído seguindo rigorosamente a arquitetura em camadas (Layered Architecture) para garantir escalabilidade e manutenção:

* **Controller Layer:** Gerencia as requisições HTTP e validação de entrada.
* **Service Layer:** Contém a lógica "core" de negócio, incluindo algoritmos de tara e conversão de sinais.
* **Integration Layer:** Módulo responsável pela comunicação serial (RS-232/USB) com o microcontrolador da balança.
* **Persistence Layer:** Gerencia o armazenamento histórico de medições.

## 🛠 Tecnologias e Ferramentas

* **Linguagem:** Java 17 (LTS)
* **Framework:** Spring Boot 3.0
* **Banco de Dados:** MySQL (Produção) / H2 (Memória)
* **Comunicação Serial:** jSerialComm / RXTX
* **Documentação:** Swagger / OpenAPI
* **Testes:** JUnit 5 e Mockito

## ⚙️ Funcionalidades Entregues

### 1. Processamento Digital de Sinais
- [x] Implementação de filtros de média móvel para estabilização de leitura.
- [x] Algoritmo de rejeição de picos (movimentação brusca).
- [x] Conversão AD (Analógico-Digital) tratada via software.

### 2. Controle da Balança
- [x] **Tara Remota:** Endpoint para zerar a balança via API.
- [x] **Calibração:** Interface para ajuste de fator de calibração sem necessidade de recompilar o código.

### 3. Gestão de Dados
- [x] Histórico completo de variações de peso por sessão.
- [x] Logs de auditoria e erros de comunicação com hardware.

## 🔌 Documentação da API

A API está totalmente documentada seguindo a especificação OpenAPI.
Com a aplicação rodando, a documentação interativa pode ser acessada em:
`/swagger-ui.html`

## 🚀 Como executar (Build Final)

```bash
# 1. Clone o repositório
git clone [https://github.com/CaioHenryxz/API-Java-Balanca.git](https://github.com/CaioHenryxz/API-Java-Balanca.git)

# 2. Acesse a pasta
cd API-Java-Balanca

# 3. Gere o executável (JAR)
./mvnw clean package

# 4. Execute o artefato final
java -jar target/balanca-api-1.0.0.jar
