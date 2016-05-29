<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<f:view>
			<h:form>
			<div align="center">
				<h1>Login Area Riservata</h1>
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