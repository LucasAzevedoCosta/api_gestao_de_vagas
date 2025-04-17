# 💼 API - Gestão de Vagas

Este projeto consiste em uma API desenvolvida com **Spring Boot** para gerenciamento de informações relacionadas a vagas de emprego.  
Ela permite o cadastro, autenticação e gestão de candidatos e empresas, além da aplicação a vagas, sendo ideal para sistemas de recrutamento e seleção.

---

## 🛠 Tecnologias Utilizadas

- ⚙️ Java 17  
- 🚀 Spring Boot  
- 🗃 Spring Data JPA  
- 🐬 MySQL  
- 🐳 Docker & Docker Compose  
- 🔐 JWT (para autenticação)  
- 📦 Maven  
- 📈 Prometheus (monitoramento)  
- ✅ GitHub Actions (CI/CD)  

---

## ⚙️ Configuração do Ambiente

### ✅ Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas na sua máquina:

- Git  
- Docker e Docker Compose  

---

## 📥 Instalação

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/api_gestao_de_vagas.git
cd api_gestao_de_vagas
```

2. Execute os containers com Docker Compose:

```bash
docker-compose up --build
```

3. Acesse a aplicação:

A API estará disponível em:  
📍 `http://localhost:8080`

---

## ▶️ Como Executar (alternativa sem Docker)

1. Configure o banco de dados MySQL localmente.

2. Atualize as configurações em `application.properties`.

3. Compile e execute o projeto com Maven:

```bash
./mvnw spring-boot:run
```

---

## 📁 Estrutura do Projeto

| Pasta/Arquivo | Descrição |
|---------------|-----------|
| `src/main/java/.../Controllers/` | Contém os controladores REST (endpoints). |
| `dto/` | Objetos de transferência de dados. |
| `entity/` | Entidades do banco de dados. |
| `repository/` | Interfaces de repositórios (JPA). |
| `services/` | Lógica de negócios. |
| `config/` | Arquivos de configuração (ex: Prometheus). |
| `docker-compose.yml` | Orquestração dos containers da aplicação. |
| `pom.xml` | Gerenciador de dependências Maven. |
| `.github/workflows/` | Pipeline de CI/CD com GitHub Actions. |

---

## 🔐 Autenticação

A autenticação é feita via **JWT**.  
Após realizar o login, inclua o token no header das requisições:

```
Authorization: Bearer <seu_token>
```

---

## 📦 CI/CD

A aplicação possui integração contínua via GitHub Actions.  
Sempre que houver um push na branch `main`, o pipeline `prod.yml` será executado.

---
