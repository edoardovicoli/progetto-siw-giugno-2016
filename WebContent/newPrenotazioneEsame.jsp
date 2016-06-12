<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Prenotazione Esame</title>
		
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
						<li><a href="admin.jsp">Menù Area Riservata</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div align="center">
			<h2>Laboratorio Analisi Cliniche - Prenotazione Esame</h2>
			<h4>Inserire dettagli Tipologia Esame</h4>
			<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
		</div>
		<f:view>
			<h:form>
				<div align="center">
					<label for="inputCodice">Codice Cartella: </label>
					<h:inputText styleClass="form-control" value="#{esamePazienteController.codice}" required="true" requiredMessage="Codice Obbligatorio!" id="codice" style="width:250px"/>
					<h:message for="codice"/>
				</div>
				<p></p>
				<div align="center">
					<label for="inputData">Data di Svolgimento:</label>
					<h:inputText styleClass="form-control" value="#{esamePazienteController.dataSvolgimentoCartella}" required="true" requiredMessage="Data obbligatoria!" id="data" style="width:250px">
						<f:convertDateTime pattern="dd-MM-yyyy"/>
					</h:inputText>
					<h:message for="data"/>
				</div>
				<p></p>
				<div align="center">
					Medico: <h:selectOneMenu value="#{esamePazienteController.medico}">
								<f:selectItems value="#{esamePazienteController.mediciSelezionabili}"/>
							</h:selectOneMenu>
				</div>
				<p></p>
				<div align="center">
					Paziente: <h:selectOneMenu value="#{esamePazienteController.paziente}">
								<f:selectItems value="#{esamePazienteController.pazientiSelezionabili}"/>
							  </h:selectOneMenu>
				</div>
				<p></p>
				<div align="center">
					Tipologia Esame: <h:selectOneMenu value="#{esamePazienteController.tipologiaEsame}">
										<f:selectItems value="#{esamePazienteController.tipologieEsameSelezionabili}"/>
									 </h:selectOneMenu>
					<p></p>
					<h:commandButton value="Mostra Esami" action="#{esamePazienteController.mostraEsami}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
				<p></p>
				<div align="center">
					<h:outputText value="#{esamePazienteController.esamiPerTipologia}"/>
					<h:selectManyCheckbox value="#{esamePazienteController.esamiSelezionati}">
						<f:selectItems value="#{esamePazienteController.esamiPerTipologiaStringhe}"/>
					</h:selectManyCheckbox>
				</div>
				<p></p>
				<div align="center">
					<h:commandButton value="Invia" action="#{esamePazienteController.createEsamePaziente}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
			</h:form>
		</f:view>
	</body>
</html>