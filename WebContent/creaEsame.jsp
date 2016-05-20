<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Crea nuovo esame</title>
	</head>
	<body>
		<form action="controller" method="post">
			<p>${nomeEsameError}</p>
			nomeEsame: <input type="text" name="nomeEsame" value='${param["nomeEsame"]}'>
			<p>${tipologiaEsameError}</p>
			tipologiaEsame: <input type="text" name="tipologiaEsame" value='${param["tipologiaEsame"]}'>
			<p>${dataSvolgimentoEsameError}</p>
			dataSvolgimentoEsame: <input type="text" name="dataSvolgimentoEsame" value='${param["dataSvolgimentoEsame"]}'>
			<button type="submit" class="btn btn-default">Crea</button>
		</form>
	</body>
</html>