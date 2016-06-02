<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nuovo Paziente</title>
	
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
									<li><a href="tipologieEsame.jsp">Esami offerti</a></li>
									<li><a href="#">Another Action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Nav header</li>
									<li><a href="#">Separated link</a></li>
									<li><a href="#">One More Separated link</a></li>
								</ul>
							</li>
							<li><a href="loginAdmin.jsp">Area Riservata</a></li>
						</ul>
					</div>
				</div>
			</div>
			<f:view>
				<h:form>
				<div align="center">
					<h2>Dati nuovo Paziente</h2>
				</div>
				<div align="center">
					<label for="inputNome">Nome:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.nome}" required="true" requiredMessage="Nome Obbligatorio!" id="nome" style="width:250px"/>
					<h:message for="nome"/>
					<label for="inputCognome">Cognome:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.cognome}" required="true" requiredMessage="Cognome Obbligatorio!" id="cognome" style="width:250px"/>
					<h:message for="cognome"/>
				</div>
				<div align="center">
					<label for="inputData">Data di Nascita:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.dataNascita}" required="true" requiredMessage="Data obbligatorio!" id="data" style="width:250px">
						<f:convertDateTime pattern="dd-MM-yyyy"/>
					</h:inputText>
					<h:message for="data"/>
				</div>
				<div align="center">
					<h:selectOneMenu value="#{pazienteController.sesso}">
						<label for="inputSesso">Sesso:</label>
   						<f:selectItem itemValue="M" itemLabel="M"/>
   						<f:selectItem itemValue="F" itemLabel="F"/>	   							
					</h:selectOneMenu>
				</div>
				<div align="center">
					<label for="inputIndirizzo">Indirizzo:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.indirizzo}" required="true" requiredMessage="Indirizzo obbligatorio!" id="indirizzo" style="width:400px"/>
					<h:message for="indirizzo"/>
				</div>
				<div align="center">
					<label for="inputCF">Codice Fiscale:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.cf}" required="true" requiredMessage="CF obbligatorio!" id="CF" style="width:400px"/>
					<h:message for="CF"/>
				</div>
				<div align="center">
					<label for="inputEmail">E-Mail:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.email}" required="true" requiredMessage="E-Mail obbligatorio!" id="email" style="width:300px"/>
					<h:message for="email"/>
				</div>
				<div align="center">
					<label for="inputTelefono">Recapito Telefonico:</label>
					<h:inputText styleClass="form-control" value="#{pazienteController.telefono}" required="true" requiredMessage="Telefono obbligatorio!" id="telefono" style="width:250px"/>
					<h:message for="email"/>
				</div>
				<p></p>
				<div align="center">
					<h:commandButton value="Invia" action="#{pazienteController.createPaziente}" styleClass="btn btn-lg btn-primary btn-block"/>
				</div>
				<div align="center">
					<h:outputText value="#{pazienteController.messaggioSuccesso}"></h:outputText>
				</div>
				<div align="center">
					<h:outputText value="#{pazienteController.messaggioFallimento}"></h:outputText>
				</div>
				</h:form>
			</f:view>
		</body>
</html>