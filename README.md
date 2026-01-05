# API - Controle de Balança

![STATUS](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=ORANGE&style=for-the-badge)
![JAVA](http://img.shields.io/static/v1?label=TECH&message=JAVA%20SPRING&color=BLUE&style=for-the-badge)

## 📋 Sobre o projeto

Esta API RESTful foi desenvolvida para gerenciar e processar dados provenientes de uma balança de precisão (foco em aplicação neonatal/incubadora). O sistema é responsável por receber os sinais de peso, realizar a persistência dos dados e fornecer endpoints para consulta de histórico e monitoramento em tempo real.

O projeto atua como o Back-end que integra o hardware (sensores de carga) com a interface do usuário ou sistemas de monitoramento hospitalar.

## 🛠 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot** (Framework principal)
* **Spring Data JPA** (Persistência de dados)
* **Maven** (Gerenciamento de dependências)
* **H2 Database / MySQL** (Banco de dados)

## ⚙️ Funcionalidades Principais

- [x] **Leitura de Peso:** Recebimento de dados brutos da balança.
- [x] **Histórico:** Armazenamento de logs de peso com timestamp.
- [x] **Tara:** Funcionalidade lógica para zerar a balança via software.
- [x] **Calibração:** Endpoints para ajuste de parâmetros de conversão.
- [x] **API REST:** Disponibilização dos dados em formato JSON.

## 🔌 Endpoints (Exemplos)

A API disponibiliza as seguintes rotas principais:

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/api/weight/current` | Retorna o peso atual em tempo real. |
| `GET` | `/api/weight/history` | Retorna o histórico de medições. |
| `POST` | `/api/scale/tare` | Executa a função de tara (zerar). |
| `POST` | `/api/scale/calibrate` | Envia parâmetros de calibração. |

## 🚀 Como executar o projeto

### Pré-requisitos
Certifique-se de ter o **Java JDK** e o **Maven** instalados em sua máquina.

### Passo a passo

```bash
# 1. Clone o repositório
git clone [https://github.com/CaioHenryxz/API-Java-Balanca.git](https://github.com/CaioHenryxz/API-Java-Balanca.git)

# 2. Acesse o diretório do projeto
cd API-Java-Balanca

# 3. Compile o projeto e baixe as dependências
./mvnw clean install

# 4. Execute a aplicação
./mvnw spring-boot:run
