<%@page import="br.com.dambroski.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Usuario Logado : ${usuarioLogado.login}
	
	<br>
	<br>
	<br>
	<c:if test = "${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso
	</c:if>
	
	<c:if test = "${empty empresa}">
		Nenhuma empresa cadastrada
	</c:if>
		
	
	
    Lista de empresas: <br />
    
    <ul>
    	<c:forEach items="${empresas}" var="empresa">
    	
    		<li>
    		${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
    		<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
    		<a href="/gerenciador/entrada?acao=RemovaEmpresa&id=${empresa.id}">remove</a>
    		</li>
    	 </c:forEach>
    </ul>

</body>
</html>