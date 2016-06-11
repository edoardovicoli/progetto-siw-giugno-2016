<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ClinicaACME - Centro Analisi</title>

<!-- Link al file .css -->
<link rel="stylesheet" href="grafica/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<f:view>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
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
		</nav>
		<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<div class="container">
				<h1>ClinicaACME</h1>
				<p>	La ClinicaACME è da sempre la migliore clinica al mondo
					per effettuare analisi di qualunque tipo. E' sicuramente
					la più all'avanguardia in quanto il suo sito permette
					la gestione remota dei dati di ogni singolo paziente.
				</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Leggi di più »</a>
				</p>
			</div>
		</div>
		<div class="container">
			<!-- Example row of columns -->
			<div class="row">
				<div class="col-md-4">
					<h2>Offerta della ClinicaACME</h2>
					<p>	Clicca su "Maggiori dettagli" per accedere alla pagina di consultazione
						degli Esami offerti da ClinicaACME. La sezione offre un elenco di tutti
						gli Esami assieme ad una piccola descrizione ed il prezzo
					</p>
					<p>
						<a class="btn btn-default" href="tipologieEsame.jsp" role="button">Maggiori dettagli »</a>
					</p>
				</div>
				<div class="col-md-4">
					<h2>Referto Elettronico</h2>
					<p> ClinicaACME offre il servizio "Referto Elettronico" per i pazienti che
						hanno effettuato un esame. Cliccando su "Maggiori dettagli" è possibile
						accedere alla pagina di Login per i pazienti.
					</p>
					<p>
						<a class="btn btn-default" href="loginPaziente.jsp" role="button">Maggiori dettagli »</a>
					</p>
				</div>
				<div class="col-md-4">
					<h2>Contatti</h2>
					<p>	E' possibile contattare ClinicaACME direttamente da casa mandando una
						mail. Dunque, è possibile chiedere chiarimenti riguardo problematiche
						con la visualizzazione degli esami, richiesta preventivi o altro.
					</p>
					<p>
						<a class="btn btn-default" href="contact.jsp" role="button">Maggiori dettagli »</a>
					</p>
				</div>
			</div>
			<hr>
			<footer>
			<p>© 2016 ClinicaACME, Inc.</p>
			</footer>
		</div>
		</div>
	</body>
</f:view>
</html>