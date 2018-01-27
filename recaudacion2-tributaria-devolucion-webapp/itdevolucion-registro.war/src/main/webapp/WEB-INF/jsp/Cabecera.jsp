<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center">Registro de Solicitud de Devolución 1649</h1>
          </div>
        </div><c:if test="${(model != null) && (model.solicitudDevolucion != null)}">
        <div class="row">
          <div class="col-md-12">
            <h3 class="text-center">${model.solicitudDevolucion.tipoSolicitud.valueName}</h3>
          </div>
        </div></c:if>
<!--[if lt IE 11]>
    <div class="alert alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span> La versión de INTERNET EXPLORER que está usando no es soportada. Por favor actualice su navegador a la versión 11 o mayor, o use otro navegador como Chrome o Firefox. De lo contrario puede experimentar problemas en el uso de esta aplicación.
    </div>
<![endif]-->
        