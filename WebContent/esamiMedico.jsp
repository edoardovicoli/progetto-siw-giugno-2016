<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Esami effettuati dal Medico</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="grafica/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
		<body>
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
							<li><a href="admin.jsp">Torna indietro</a></li>
						</ul>
					</div>
				</div>
			</div>
		<f:view>
			<h:form>
				<div align="center">
					<h2>Selezionare o inserire il nome e il cognome del Medico</h2>
				</div>
				<p></p>
					<div align="center">
					Medico: <h:selectOneMenu value="#{medicoController.medicoSelezionato}">
								<f:selectItems value="#{medicoController.mediciSelezionabili}"/>
							</h:selectOneMenu>
				</div>
				<p></p>
				<div align="center">
					<label for="inputNome">Nome:</label>
					<h:inputText styleClass="form-control" value="#{medicoController.nomeMedicoPerEsami}" required="false" requiredMessage="Nome Obbligatorio!" id="nome" style="width:250px"/>
					<h:message for="nome"/>
				</div>
				<div align="center">
					<label for="inputCognome">Cognome:</label>
					<h:inputText styleClass="form-control" value="#{medicoController.cognomeMedicoPerEsami}" required="false" requiredMessage="Cognome Obbligatorio!" id="cognome" style="width:250px"/>
					<h:message for="cognome"/>
				</div>
				<p></p>
				<div align="center">
					<h:commandButton value="Invia" action="#{medicoController.esamiMedico}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
				<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
				<div align="center">
					<h3><h:outputText value="#{medicoController.listaEsamiSeguitiDalDr}"/></h3>
				</div>
				<c:forEach var="esamePaziente" items="#{medicoController.listaEsamiPazientePerEsami}">
					<div align="center">
						<h:outputText value="#{esamePaziente.codice}"/>
		     			<h:outputText value=" "/>
		     			<h:outputText value="#{esamePaziente.paziente.nome}"/>
		     			<h:outputText value=" "/>
		     			<h:outputText value="#{esamePaziente.paziente.cognome}"/>
		     			<h:outputText value=" "/>
		     			<h:outputText value="#{esamePaziente.dataSvolgimento}"/>
		     			<h:outputText value=" "/>
		     			<h:outputText value="#{esamePaziente.tipologiaEsame.nome}"/>
		     			<h:outputText value=" "/>
					</div>
				</c:forEach>
			</h:form>
		</f:view>
	</body>
</html>