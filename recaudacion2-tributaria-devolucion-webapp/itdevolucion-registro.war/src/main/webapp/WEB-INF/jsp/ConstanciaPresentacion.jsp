<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="SUNATTags" prefix="sunat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<sunat:resources tipo="css" />
<style type="text/css">
@page {
  min-width: 768px;
}
@media print {
  html {
    font-size: 9px;
    margin: 0;
    padding 0 !important;
  }
  body {
    font-size: 9px;
    margin: 0;
    padding 0 !important;
  }
  div{
    font-size: 9px;
  }
  h3, .panel-title, h1, .h1 {
   font-size: 10px;
   padding: 0px;
  }
  ..panel-heading{
    font-size: 9px;
    padding: 6px;
  }
  .form-control, label{
    font-size: 9px;
    height: 20px;
    margin: 0px;
    padding: 0px;
    border: none;
  }
  .container {
    width: auto;
    display: inline;
  }
}
</style>
</head>
<body>
<div class="section">
    <div class="container">
        <div class="row">
          <div class="col-xs-12">
            <h1 class="text-center">Constancia de Presentación Solicitud de Devolución 1649</h1>
          </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <form:form id="formConstancia" class="form-horizontal" role="form" commandName="model.solicitudDevolucion" >
                <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h3 class="panel-title">Datos Generales de la Solicitud de Devolución</h3>
                    </div>
                    <div class="panel-body">
                      
                        <div class="form-group">
                          <div class="col-xs-3">
                            <label class="control-label" for="tipoSolicitud.name">TIPO DE SOLICITUD</label>
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="tipoSolicitud.valueName"/>
                            <form:hidden class="form-control" readonly="true" path="tipoSolicitud.value"/>
                            <form:hidden class="form-control" readonly="true" path="tipoSolicitud.name"/>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> <label class="control-label" for="numeroDocumento">NUMERO ORDEN SOLICITUD</label> </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="numeroDocumento"/>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> 
                            <label class="control-label" for="ruc">RUC</label> 
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="ruc"/>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> <label class="control-label" for="apellidosNombres">APELLIDOS Y NOMBRES</label> </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="apellidosNombres" /> </div>
                          </div>
                        <div class="form-group">
                          <div class="col-xs-3"> 
                            <label class="control-label" for="telefono">TELEFONO</label> 
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="telefono" /> 
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3">
                            <label class="control-label" for="periodoDocumento">PERIODO TRIBUTARIO</label>
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="periodoDocumento" />
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3">
                            <label class="control-label" for="indicadorFormaDevolucion.value">FORMA DEVOLUCION</label>
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="indicadorFormaDevolucion.name" />
                            <form:hidden class="form-control" readonly="true" path="indicadorFormaDevolucion.value" />
                          </div>
                        </div>
                        <c:if test="${model.solicitudDevolucion.indicadorFormaDevolucion.value == '4'}">
                        <div class="form-group">
                          <div class="col-xs-3">
                            <label class="control-label" for="cci">CCI</label> 
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="cci" />
                          </div>
                        </div>
                        </c:if>
                        <div class="form-group">
                          <div class="col-xs-3">
                            <label class="control-label" for="montoSolicitado">IMPORTE SOLICITADO</label>
                          </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="montoSolicitado" />
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> <label class="control-label" for="tributo.name">TRIBUTO</label> </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="tributo.name" />
                            <form:hidden class="form-control" readonly="true" path="tributo.value" />
                           </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> <label class="control-label" for="fechaDocumento">FECHA PRESENTACION</label> </div>
                          <div class="col-xs-9">
                            <form:input  class="form-control" readonly="true" path="fechaDocumento" /> </div>
                        </div>
                        <div class="form-group">
                          <div class="col-xs-3"> <label class="control-label" for="codigoArchivoSustento">ARCHIVO SUSTENTO</label> </div>
                          <div class="col-xs-9">
                            <form:input class="form-control" readonly="true" path="presentoArchivoSustento" />
                            <form:hidden path="codigoArchivoSustento" />
                          </div>
                        </div>
                      
                    </div>
                  </div>
                  <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h3 class="panel-title">Escrito Fundamentado</h3>
                    </div>
                    <div class="panel-body">
                        <form:hidden path="escritoFundamentado" />
                        <p class="form-control" style="height:auto" ><c:out value="${model.solicitudDevolucion.escritoFundamentado}"></c:out> </p>
                    </div>
                  </div>
                  </form:form>
                  <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h3 class="panel-title">Información Importante</h3>
                    </div>
                    <div class="panel-body">
                      Sr. Contribuyente, durante la atención de su solicitud de devolución, le sugerimos tener en cuenta lo siguiente:
                      <ul>
                        <li>Revisar periódicamente el Buzón Electrónico de su clave SOL, pues podría enviársele información respecto al estado de su solicitud.</li>
                        <li>No dar baja definitiva a su RUC en tanto su solicitud se encuentre pendiente de atención.</li>
                        <li>Mantener la condición de su domicilio fiscal como "HABIDO".</li>
                        <li>No presentar una solicitud de compensación por un pago indebido o en exceso que ha sido solicitado en devolución.</li>
                        <c:if test="${model.solicitudDevolucion.indicadorFormaDevolucion.value == '4'}">
                        <li>El MONTO SOLICITADO será depositado a la cuenta especificada en su Código de Cuenta Interbancario – CCI.</li>
                        <li>En caso de haber problemas en el depósito o no ser válido el CCI, se modificará automáticamente la forma de devolución a OPF.</li>
                        </c:if>
                        <c:if test="${model.solicitudDevolucion.indicadorFormaDevolucion.value == '3'}">
                        <li>La forma de devolución mediante OPF no permite que un tercero con poder cobre el dinero en el Banco.</li>
                        </c:if>
                      </ul>Finalmente, le recordamos que el trámite de devolución es gratuito.
                    </div>
                  </div>
                  <div class="section hidden-print">
                    <div class="container">
                      <div class="row">
                        <div class="col-xs-3">
                          <button id="btnImprimir" type="submit" class="btn btn-primary">Imprimir constancia</button>
                        </div>
                        <div class="col-xs-9">
                          <form id="formEnviarCorreo" class="form-horizontal" role="form">
                            <div class="form-group">
                              <div class="col-xs-3">
                                <label class="control-label" for="correo">Enviar correo</label> </div>
                              <div class="col-xs-6">
                                <input type="text" class="form-control" id="correo" name="correo" placeholder="Correo Electrónico"> </div>
                              <div class="col-xs-2">
                                <button id="btnImprimir" type="submit" class="btn btn-primary">Enviar</button>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
            </div>
        </div>
    </div>
</div>
<sunat:resources tipo="js" />
<script>
$(document).ready(function() {
    $("#formEnviarCorreo").validate({
        rules:{
            'correo': {
                required: true,
                email : true,
            },
        },
        messages: {
            'correo': {
                required : "Ingrese un correo electrónico.",
                email : "El correo electrónico ingresado no es válido.",
            },
        },
        submitHandler: function(form) {
           $.blockUI({message : "Enviando correo electrónico. Por favor espere.....", fadeIn: 0, baseZ: 2000});
           var data =$("#formConstancia").serialize();
           var correo=$("#correo").val();
           $.ajax({
               url: 'EnviarConstanciaCorreo?correoElectronico=' + correo,
               dataType:'JSON',
               type: 'POST',
               data: data,
               cache: false,
           }).done(function( respuesta ) {
               AlertDialog.showMessageJSON(respuesta);
           }).error(function(xhr, status, text){ 
              AlertDialog.showAJAXError(xhr, status, text);
           }).complete(function(jqXHR, textStatus){
                $.unblockUI(); // Fin de bloqueo
           });
            return false;
        }
    });
    $( "#btnImprimir" ).click(function() {
      window.print();
    });
});
</script>
</body>
</html>