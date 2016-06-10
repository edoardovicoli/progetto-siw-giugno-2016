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
					<a class="navbar-brand" href="#">ClinicaACME</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="main.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Servizi<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="tipologieEsame.jsp">Tipologie Esame offerti</a></li>
								<li><a href="#">Another Action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One More Separated link</a></li>
							</ul>
						</li>
						<li><a href="loginAdmin.jsp">Area Riservata</a></li>
						<li><a href="admin.jsp">Torna indietro</a></li>
					</ul>
				</div>
			</div>
		</div>
		<f:view>
			<h:form>
				<div align="center">
					<h1>Laboratorio Analisi Cliniche - Prenotazione Esame</h1>
				</div>
				<div align="center">
					Medico: <h:selectOneMenu value="#{esamePazienteController.medico}">
								<f:selectItems value="#{esamePazienteController.mediciSelezionabili}"/>
							</h:selectOneMenu>
				</div>
				<div align="center">
					Paziente: <h:selectOneMenu value="#{esamePazienteController.paziente}">
								<f:selectItems value="#{esamePazienteController.pazientiSelezionabili}"/>
							</h:selectOneMenu>
				</div>
				<div align="center">
					Tipologia Esame: <h:selectOneMenu value="#{esamePazienteController.tipologiaEsame}">
										<f:selectItems value="#{esamePazienteController.tipologieEsameSelezionabili}"/>
									 </h:selectOneMenu>
					<h:commandButton value="Mostra Esami" action="#{esamePazienteController.mostraEsami}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
				<div align="center">
					<h:outputText value="#{esamePazienteController.esamiPerTipologia}"/><h:selectManyCheckbox value="#{esamePazienteController.esamiSelezionati}">
											<f:selectItems value="#{esamePazienteController.esamiPerTipologiaStringhe}"/>
										 </h:selectManyCheckbox>
				</div>
				<div align="center">
					<label for="inputData">Data di Svolgimento:</label>
					<h:inputText styleClass="form-control" value="#{esamePazienteController.dataSvolgimentoCartella}" required="true" requiredMessage="Data obbligatoria!" id="data" style="width:250px">
						<f:convertDateTime pattern="dd-MM-yyyy"/>
					</h:inputText>
					<h:message for="data"/>
				</div>
				<p></p>
				<div align="center">
					<h:commandButton value="Invia" action="#{esamePazienteController.createEsamePaziente}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
			</h:form>
		</f:view>
	</body>
</html>