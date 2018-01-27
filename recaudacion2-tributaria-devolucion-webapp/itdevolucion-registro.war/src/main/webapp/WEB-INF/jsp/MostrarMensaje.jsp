<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:if test="${(model!=null) && (model.mensajes != null)}">
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span>
		<c:forEach items="${model.mensajes}" var="mensaje" varStatus="myItemStat">
			${mensaje.mensaje} <br />
		</c:forEach>
	</div>
</c:if>
<c:if test="${(beanM != null)}">
	<div class="alert alert-danger" role="alert">
	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	<span class="sr-only">Error:</span>${beanM.mensajeerror}
	</div>
	<div class="alert alert-info" role="alert">
	<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
	<span class="sr-only">Tip:</span>	${beanM.mensajesol}
	</div>
</c:if>