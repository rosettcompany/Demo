<jsp:useBean id="beanErr" scope="request" class="pe.gob.sunat.framework.core.bean.MensajeBean" />
<% 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
if(request.getHeader("X-Requested-With")==null) { %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="SUNATTags" prefix="sunat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<sunat:resources tipo="css" />
</head>
<body>
<div class="section">
    <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center">Registro de Solicitud de Devolución 1649</h1>
          </div>
        </div>
        <div class="row">
           <div class="col-md-12">
            <div class="alert alert-danger" role="alert">
   <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
   <span class="sr-only">Error:</span><%=beanErr.getMensajeerror()%>
   </div>
   <div class="alert alert-info" role="alert">
   <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
      <% if(beanErr.getMensajesol()!= null && !beanErr.getMensajesol().isEmpty()) {%>
   <span class="sr-only">Tip:</span><%=beanErr.getMensajesol()%>
   <%} else { %>
   <span class="sr-only">Tip:</span>Intente de nuevo más tarde.
   <% } %>
   </div>
           </div>
        </div>
     </div>
</div>
</body>
</html>
<%} else {   response.setContentType("application/json");%>
{"estadoRespuesta":0,
   "mensaje":{
      "tipo":0,
      "mensaje":"<%=beanErr.getMensajeerror().replace("&oacute;", "ó") %>",
      "mensajesDetalle":[{
         "tipo":0,
         "mensaje":"<%=beanErr.getMensajesol()!= null && !beanErr.getMensajesol().isEmpty() ? beanErr.getMensajesol() : "Su sesión ha caducado, ingrese nuevamente." %>"
      }]
   }
} <%} %>