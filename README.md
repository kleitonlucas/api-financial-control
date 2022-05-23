# api-financial-control

Projeto de uma API para um sistema de controle financeiro pessoal.
Desenvolvido para fins de estudo e prática de Spring Boot.

## Tecnologias usadas

* Java
* Spring Boot
* MySQL

## Requisições

<table>
  <tr>
    <td>/financial-control/user</td><td>POST</td><td>Cadastra um novo usuário.</td>
  </tr>
  <tr>
    <td>/financial-control/user/{id}</td><td>GET</td><td>Busca um usuário pelo id.</td>
  </tr>
  <tr>
    <td>/financial-control/user/{id}</td><td>DELETE</td><td>Deleta um usuário pelo id.</td>
  </tr>
  <tr>
    <td>//financial-control/user/{id}</td><td>PUT</td><td>Edita os dados de um usuário.</td>
  </tr>
  <tr>
    <td>/financial-control/operations</td><td>POST</td><td>Cadastra uma operação financeira de um usuário.</td>
  </tr>
  <tr>
    <td>/financial-control/operations/{userId}</td><td>GET</td><td>Busca todas as operações de um usuário.</td>
  </tr>
  <tr>
    <td>/financial-control/operations/{userId}/{month}</td><td>GET</td><td>Busca todas as operações de um usuário de acordo com o mês.</td>
  </tr>
</table>
