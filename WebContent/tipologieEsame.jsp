<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tipologie Esame</title>
	</head>
	<body>
		<f:view>
			<c:forEach var="order" items="#{tipologiaEsameController.tipologieEsame}">
				<h:form>
	 				<h:commandLink action="#{tipologiaEsame.findTipologiaEsame}" value="#{tipologiaEsame.nome}">
						<f:param name="id" value="#{tipologiaEsame.id}" />
					</h:commandLink>
				</h:form>
			</c:forEach>
		</f:view>
	</body>
</html>