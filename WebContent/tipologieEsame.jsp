<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tipologie Esame</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="grafica/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<f:view>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class = "container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="main.jsp">ClinicaACME</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="main.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="loginAdmin.jsp">Area Riservata</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div align="center">
			<h2>Tipologie Esame Offerte</h2>
				<h4>Clicca sulla Tipologia per saperne di più</h4>
					<h:form>
						<c:forEach var="tipologiaEsame" items="#{tipologiaEsameController.tipologieEsame}">
 							<div>
 								<h:outputText value="#{tipologiaEsame.nome}"/>
								<h:outputText value="  "/>
								<h:commandButton value="Lista Esami" type="submit" action="#{tipologiaEsameController.tipologiaEsameDettaglio(tipologiaEsame.nome)}">
									<f:param name="action" value="#{tipologiaEsame.nome}"/>
								</h:commandButton>
								<h:outputText value="  "/>
								<h:commandButton value="Dettagli" onclick="alert('#{tipologiaEsame.descrizione}' + ' ' + '- Costo: ' + '#{tipologiaEsame.costo}')">
									<f:param name="action" value="#{tipologiaEsame.nome}"/>
								</h:commandButton>
							</div>
						</c:forEach>
					</h:form>
			</div>
		</f:view>
	</body>
</html>