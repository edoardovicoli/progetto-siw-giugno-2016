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
			<div align="center">
				<h1>Laboratorio Analisi Cliniche</h1>
			</div>
			<h:form>
				<div align="center">
					Nome Tipologia Esame: <h:inputText value="#{tipologiaEsameController.nome}" required="true"
					requiredMessage="Nome Tipologia Esame obbligatorio!" id="nomeTipologia"/>
				</div>
				<div align="center">
					Codice Tipologia: <h:inputText value="#{tipologiaEsameController.codice}" required="true"
					requiredMessage="Codice Tipologia Esame obbligatorio!" id="codiceTipologia"/>
				</div>
				<div align="center">
					Costo Tipologia: <h:inputText value="#{tipologiaEsameController.costo}" required="true"
					requiredMessage="Costo Tipologia Esame obbligatorio!" id="costoTipologia"/>
				</div>
				<div align="center">
					Descrizione Tipologia: <h:inputText value="#{tipologiaEsameController.descrizione}" required="true"
					requiredMessage="Descrizione Tipologia Esame obbligatoria!" id="descrizioneTipologia"/>
				</div>
				
				<div align="center">
					Nome Esame: <h:inputText value="#{tipologiaEsameController.nomeEsame}" required="true"
					requiredMessage="Nome Esame obbligatorio" id="nomeEsame"/>
				</div>
				
				<div align="center">
					Nome Prerequisito: <h:inputText value="#{tipologiaEsameController.nomePrerequisito}" required="true"
					requiredMessage="Nome Prerequisito obbligatorio" id="nomePrerequisitoEsame"/>
				</div>
				
				<div align="center">
					Valore Prerequisito: <h:inputText value="#{tipologiaEsameController.valorePrerequisito}" required="true"
					requiredMessage="Valore Prerequisito obbligatorio" id="valorePrerequisitoEsame"/>
				</div>
				
				<div align="center">
					<h:commandButton value="Submit" action="#{tipologiaEsameController.createTipologiaEsame}" styleClass="btn btn-lg btn-success"/>
				</div>
			</h:form>
			<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
			<div align="center">
				<h:dataTable value="#{tipologiaEsameController.prerequisitiEsame}" var="prerequisitoEsame" styleClass="prerequisitoTable" headerClass="prerequisitoTableHeader" rowClasses="prerequisitoTableOddRow,prerequisitoTableEvenRow" border="1">
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="CodTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.codice}"/>
   					</h:column>
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="NomeTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.nome}"/>
   					</h:column>
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="CostoTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.costo}"/>
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value="Prerequisito"/></f:facet>
      					<h:outputText value="#{prerequisitoEsame.nome}"/>
   					</h:column>
   				</h:dataTable>
			</div>
			<p></p>
			<div align="center">
				<h:dataTable value="#{tipologiaEsameController.esami}" var="esame" styleClass="esameTable" headerClass="esameTableHeader" rowClasses="esameTableOddRow,esameTableEvenRow" border="1">
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="CodTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.codice}"/>
   					</h:column>
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="NomeTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.nome}"/>
   					</h:column>
   					<h:column>    				
      					<f:facet name="header"><h:outputText value="CostoTipologia"/></f:facet>    				
      					<h:outputText value="#{tipologiaEsameController.costo}"/>
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