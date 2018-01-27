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
</head>
<body>
<div class="section">
    <div class="container">
        <jsp:include page="Cabecera.jsp" />
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Seleccione Datos Básicos de la Solicitud</h3>
                    </div>
                    <div class="panel-body">
                        <form:form id="formulario" class="form-horizontal form-group-xs" action="RegistrarDevolucion.htm" role="form" method="POST" commandName="model" acceptCharset="UTF-8">
                            <form:hidden path="opcion" />
                          <div class="form-group">
                            <div class="col-sm-4"> <label for="tipoDevolucion" class="control-label">Tipo de Solicitud de Devolución
                                  <br>
                                </label> </div>
                            <div class="col-sm-8">
                                <form:select path="solicitudDevolucion.tipoSolicitud" class="form-control" >
                                    <form:option disabled="disabled" value="">--SELECCIONE--</form:option>
                                    <form:options items="${tiposSolicitud}" itemValue="serializedValue" itemLabel="valueName" />
                                </form:select>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-4"> <label for="tributo" class="control-label">Tributo &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                  <br>
                                </label>
                             </div>
                            <div class="col-sm-8">
                                <form:select path="solicitudDevolucion.tributo" class="form-control" />
                            </div>
                            </div>
                          <button class="btn btn-primary pull-right" id="btnContinuar" disabled="disabled">Continuar</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<sunat:resources tipo="js" />
<script>
$(document).ready(function() {
    $("#formulario").validate({
        rules:{
            'solicitudDevolucion.tipoSolicitud': {required: true,},
            'solicitudDevolucion.tributo': {required: true,},
        },
        messages: {
            'solicitudDevolucion.tipoSolicitud': {
                required : "Debe seleccionar un Tipo de Solicitud de devolución.",
            },
            'solicitudDevolucion.tributo': {
                required : "Debe seleccionar un Tributo.",
            },
        }
    });
    
    $( "#solicitudDevolucion\\.tipoSolicitud" ).change(function() {
        var tipSolicitud = $(this).val();
        $("#solicitudDevolucion\\.tributo").fillWithJSON({
            message : "Obteniendo tributos asociados",
            url : 'ObtenerTributos?tipoDevolucion='+tipSolicitud,
            labelProperty : "name",
        });
    });
    
    $("#btnContinuar").click(function(){
        var form = $("#formulario");
        form.validate();
        if(!form.valid())
            return;
        $.blockUI({message : "Por favor espere.....", fadeIn: 0, baseZ: 2000});
        form.submit();
    });
    $(window).load(function(){
        $("#btnContinuar").prop( "disabled", false );
    });
});
</script>
</body>
</html>