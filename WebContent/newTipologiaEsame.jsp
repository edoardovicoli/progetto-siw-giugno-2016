<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nuova Tipologia Esame</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<f:view>
			<h:form>
				<div align="center">
					Nome: <h:inputText value="#{tipologiaEsameController.nome}" required="true"
					requiredMessage="Nome obbligatorio" id="nome"/>
				</div>
				<p> </p>
				<div align="center">
					<h:commandButton value="Submit" action="#{tipologiaEsameController.createTipologiaEsame}" styleClass="btn btn-lg btn-success"/>
				</div>
			</h:form>
		</f:view>
	</body>
</html>