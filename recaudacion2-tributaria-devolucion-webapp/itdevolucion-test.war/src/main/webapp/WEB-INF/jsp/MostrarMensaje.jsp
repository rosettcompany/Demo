<c:if test="${(mensajesInformativos != null) || (mensajeInformativo != null)}">
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span>
		<c:forEach items="${mensajesInformativos}" var="mensaje" varStatus="myItemStat">
			${mensaje} <br />
		</c:forEach>
		${mensajeInformativo}
	</div>
</c:if>