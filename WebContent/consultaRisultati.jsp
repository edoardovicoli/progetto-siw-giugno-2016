<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Risultati Esami</title>
		
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
			<div align="center">
			<h2>Elenco Esami per: <h:outputText value="#{consultaRisultatiController.codiceFiscale}"/></h2>
		</div>
			<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
			<h:form>
				<div align="center">
				<h:dataTable value="#{consultaRisultatiController.esamiDelPazienteModel}" var="esamePaziente" styleClass="esamePazienteTable" headerClass="esamePazienteTableHeader" rowClasses="esamePazienteTableOddRow,esamePazienteTableEvenRow" border="1" width="45%">
   					<h:column> 
   						<f:facet name="header"><h:outputText value="Codice"/></f:facet>   					  				
      					<h:outputText value="#{esamePaziente.codice}"/>
   					</h:column>
   					<h:column> 
   						<f:facet name="header"><h:outputText value="Data"/></f:facet>   					  				
      					<h:outputText value="#{esamePaziente.dataSvolgimento}"/>
   					</h:column>
   					<h:column>			
      					<f:facet name="header"><h:outputText value="CF Paziente"/></f:facet>   				
      					<h:outputText value="#{esamePaziente.paziente.cf}"/>
   					</h:column>
   					<h:column> 				
      					<f:facet name="header"><h:outputText value="Paziente"/></f:facet>   				
      					<h:outputText value="#{esamePaziente.paziente.nome} #{esamePaziente.paziente.cognome}"/>
   					</h:column>
   					<h:column> 				
      					<f:facet name="header"><h:outputText value="Tipologia"/></f:facet>    				
      					<h:outputText value="#{esamePaziente.tipologiaEsame.nome}"/>
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value="Medico"/></f:facet> 
      					<h:outputText value="#{esamePaziente.medico.nome} #{esamePaziente.medico.cognome}" />
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value=""/></f:facet>
      					<div align="center">
							<h:commandButton value="Controlla" action="#{consultaRisultatiController.controlloRisultati}" styleClass="btn btn-lg btn-success"/>
						</div>
   					</h:column>
   				</h:dataTable>
			</div>
			</h:form>
		</f:view>
	</body>
</html>