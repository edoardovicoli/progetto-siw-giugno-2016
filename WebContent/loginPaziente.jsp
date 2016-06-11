<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Paziente</title>
		
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
					</ul>
				</div>
			</div>
		</div>
		<f:view>
			<h:form>
			<div align="center">
				<h2>Login Paziente</h2>
				<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
				<h4>Inserire il proprio Codice Fiscale</h4>
			</div>
			<div align="center">
				<label for="inputCF">Codice Fiscale:</label>
				<h:inputText styleClass="form-control" value="#{loginPazienteController.codiceFiscale}" required="true" requiredMessage="CF obbligatorio!" id="cf"/>
				<h:message for="cf"/>
			</div>
			<p></p>
			<div align="center">
				<h:commandButton value="Invia" action="#{loginPazienteController.validate}" styleClass="btn btn-lg btn-primary btn-block"/>
			</div>
			<div align="center">
				<h:outputText value="#{loginPazienteController.messaggioErrore}"></h:outputText>
			</div>
			</h:form>
		</f:view>
	</body>
</html>