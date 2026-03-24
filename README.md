# 📅 Agenda API

API REST para gerenciamento de usuários, incluindo dados como endereço e telefone, com autenticação via JWT.

## 🚀 Sobre o projeto

A **Agenda API** é uma aplicação backend desenvolvida com Spring Boot que permite o cadastro e gerenciamento de usuários, incluindo múltiplas informações relacionadas, como endereço e telefone.

O sistema também conta com **autenticação e segurança utilizando JWT**, garantindo proteção dos endpoints.

## 🛠️ Tecnologias utilizadas

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* Maven
* Banco de dados relacional

## 🔐 Segurança

O projeto implementa autenticação baseada em **JWT**, contendo:

* Filtro de autenticação (`JwtRequestFilter`)
* Geração e validação de token (`JwtUtil`)
* Configuração de segurança (`SecurityConfig`)
* UserDetails customizado

## 📌 Funcionalidades

* ✅ Cadastro de usuários
* ✅ Listagem de usuários
* ✅ Atualização de dados
* ✅ Exclusão de usuários
* ✅ Cadastro de endereço vinculado ao usuário
* ✅ Cadastro de telefone vinculado ao usuário
* ✅ Tratamento de exceções customizadas
* 🔐 Autenticação com JWT

## 🏗️ Estrutura do projeto

```
src/main/java/com/spring/javanauta
│
├── controller        # Endpoints da API
├── business          # Regras de negócio (Service)
├── infrastructure
│   ├── entitys       # Entidades (Usuario, Endereco, Telefone)
│   ├── repository    # Interfaces JPA
│   ├── exceptions    # Tratamento de erros
│
├── security          # Configuração de segurança e JWT
```

## ⚙️ Como executar o projeto

### Pré-requisitos

* Java 17+
* Maven
* Banco de dados configurado

### Passos

```bash
# Clone o repositório
git clone https://github.com/enthonefs/Agenda.git

# Acesse a pasta
cd Agenda

# Execute o projeto
mvn spring-boot:run
```

## 🔧 Configuração

Configure o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agenda
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
```

## 📡 Endpoints principais

### 👤 Usuários

| Método | Endpoint  | Descrição         |
| ------ | --------- | ----------------- |
| POST   | /usuarios | Criar usuário     |
| GET    | /usuarios | Listar usuários   |
| PUT    | /usuarios | Atualizar usuário |
| DELETE | /usuarios | Deletar usuário   |

## ⚠️ Tratamento de erros

O projeto possui exceções customizadas como:

* `ResourceNotFoundException`
* `ConflictException`

## 🧠 Aprendizados

Este projeto demonstra:

* Arquitetura em camadas (Controller, Service, Repository)
* Integração com banco de dados usando JPA
* Implementação de autenticação com JWT
* Boas práticas com Spring Boot
* Tratamento de exceções em APIs REST

## 📌 Melhorias futuras

* 📱 Integração com frontend
* 📊 Dashboard de usuários
* 📅 Agendamento de horários (feature futura)
* 📧 Validação de email
* 🧪 Testes unitários mais completos

## 👨‍💻 Autor

Desenvolvido por **Enthone Ferreira**

* GitHub: https://github.com/enthonefs
* LinkedIn: https://linkedin.com/in/enthone-ferreira
