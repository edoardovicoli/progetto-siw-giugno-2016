<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>

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
					<a class="navbar-brand" href="#">ClinicaACME</a>
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
			<h:form>
			<div align="center">
				<h2>Login Area Riservata</h2>
			</div>
			<div align="center">
				<label for="inputUsername">Username:</label>
				<h:inputText styleClass="form-control" value="#{loginController.username}" required="true" requiredMessage="Username obbligatorio!" id="id"/>
				<h:message for="id"/>
			</div>
			<div align="center">
				<label for="inputPassword">Password:</label>
				<h:inputSecret styleClass="form-control" value="#{loginController.password}" required="true" requiredMessage="Password obbligatorio!" id="password"/>
				<h:message for="password"/>
			</div>
			<div></div>
			<hr>
			<div></div>
			<div align="center">
				<h:commandButton value="Invia" action="#{loginController.validate}" styleClass="btn btn-lg btn-primary btn-block"/>
			</div>
			<div align="center">
				<h:outputText value="#{loginController.messaggioErrore}"></h:outputText>
			</div>
			</h:form>
		</f:view>
	</body>
</html>