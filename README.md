# Sistema de Agenda Online

Este é um sistema de **Agenda Online** desenvolvido utilizando **Spring Web MVC**, **Thymeleaf** e **MySQL**. O objetivo é permitir que os usuários gerenciem seus contatos de forma segura e eficiente.

## Funcionalidades

### 1. Cadastro de Usuário
- O usuário pode se cadastrar no sistema criando uma conta com um nome de usuário e senha.

### 2. Login de Usuário
- O usuário pode se logar utilizando as credenciais cadastradas.

### 3. Alteração de Perfil
- Após o login, o usuário pode alterar sua senha e as informações de perfil.

### 4. Cadastro de Contatos
- O usuário pode cadastrar novos contatos em sua agenda, sendo que cada contato possui:
  - Nome
  - Endereço
  - E-mail
  - Mais de um telefone

### 5. Visualização de Contatos
- Na tela inicial do usuário, ele pode ver todos os contatos que cadastrou.
- O sistema garante que cada usuário só veja seus próprios contatos.

### 6. Pesquisa de Contatos
- O usuário pode pesquisar seus contatos pelo nome.

## Tecnologias Utilizadas

- **Spring Web MVC**: Framework para construção da aplicação web.
- **Thymeleaf**: Motor de templates utilizado para renderização das páginas HTML.
- **MySQL**: Banco de dados utilizado para armazenamento dos dados, gerenciado através do MySQL Workbench.
