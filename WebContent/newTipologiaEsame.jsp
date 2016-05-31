<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nuova Tipologia Esame</title>
		
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
			<div align="center">
				<h1>Laboratorio Analisi Cliniche</h1>
			</div>
			<h:form>
				<div align="center">
					Nome Tipologia Esame: <h:inputText value="#{tipologiaEsameController.nome}" required="true"
					requiredMessage="Nome Tipologia Esame obbligatorio" id="nomeTipologia"/>
				</div>
				
				<div align="center">
					Nome Esame: <h:inputText value="#{tipologiaEsameController.nomeEsame}" required="true"
					requiredMessage="Nome Esame obbligatorio" id="nomeEsame"/>
				</div>
				
				<div align="center">
					<h:commandButton value="Submit" action="#{tipologiaEsameController.createTipologiaEsame}" styleClass="btn btn-lg btn-success"/>
				</div>
			</h:form>
			<hr>
			<div align="center">
				<h:dataTable value="#{tipologiaEsameController.esami}" var="esame" styleClass="esameTable" headerClass="esameTableHeader" rowClasses="esameTableOddRow,esameTableEvenRow" border="1">
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="Tipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.nome}"/>
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value="Esame"/></f:facet>
      					<h:outputText value="#{esame.nome}"/>
   					</h:column>
   				</h:dataTable>
			</div>
		</f:view>
	</body>
</html>