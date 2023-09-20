<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="com.agenda.models.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("contacts");
	// list.forEach(x -> out.println(x));
	
%>
	
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>

<link rel="icon" href="imagens/chamada-telefonica.png" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="container">
		<h1>Lista de Contatos</h1>
		<a href="novo-contato.html" class="botao" >Adicionar</a>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
			<% for(int i = 0; i < list.size(); i++) { %>
				<tr>
					<td><%= list.get(i).getId() %></td>
					<td><%= list.get(i).getNome() %></td>
					<td><%= list.get(i).getTelefone() %></td>
					<td><%= list.get(i).getEmail()%></td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>