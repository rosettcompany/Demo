<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="SUNATTags" prefix="sunat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
                <h3 class="panel-title">Datos de Solicitud de Devolución</h3>
              </div>
              <div class="panel-body">
                <form:form id="formulario" class="form-horizontal form-group-xs" action="RegistrarSolicitudDevolucion" role="form" method="POST" commandName="model">
                  <form:hidden path="opcion" />
                  <form:hidden path="solicitudDevolucion.tipoSolicitud" />
                  <div class="form-group">
                    <div class="col-md-6"> <label class="control-label" for="tributo.value">Tributo</label>
                      <form:input path="solicitudDevolucion.tributo.Name" class="form-control" readonly="true"/>
                      <form:hidden path="solicitudDevolucion.tributo.value" />
                   </div>
                    <div class="col-md-6"> 
                      <label class="control-label" for="telefono">Teléfono</label>
                      <form:input path="solicitudDevolucion.telefono" class="form-control" placeholder="Teléfono" maxlength="10" />
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-md-5"> 
                      <label class="control-label" for="indicadorFormaDevolucion.value">Forma de Devolución</label> 
                      <form:select path="solicitudDevolucion.indicadorFormaDevolucion" class="form-control" >
                        <form:option value="" label="--SELECCIONE--"/>
                        <form:options items="${formasDevolucion}" itemValue="serializedValue" itemLabel="name"/>
                      </form:select> 
                    </div>
                    <div class="col-md-1">
                      <p>&nbsp;&nbsp;</p>
                      <a href="#" id="btnAyuda">¿Qué es esto?</a>
                    </div>
                    <div class="col-md-6"> 
                      <label class="control-label" for="cci">CCI</label>
                      <sunat:EditableDropDown cssClass="form-control" readonly="true" placeHolder="Número CCI" path="solicitudDevolucion.cci"/>

                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-md-6"> <label class="control-label" for="periodoDocumento">Periodo Tributario</label>
                      <form:input path="solicitudDevolucion.periodoDocumento" class="form-control" placeholder="AAAAMM" /> 
                    </div>
                    <div class="col-md-6">
                      <label class="control-label" for="montoSolicitado">Importe Solicitado</label>
                      <form:input path="solicitudDevolucion.montoSolicitado" class="form-control" placeholder="0000000000" />
                    </div>  
                  </div>
                  <div class="form-group">
                  <div class="col-md-12"> <label class="control-label" for="archivoSustento">Archivo Sustento</label>
                     <form:input path="solicitudDevolucion.archivoSustento" type="file" class="filestyle" data-buttonText="Examinar" />
                     <span class="help-block">El archivo de sustento debe contener: <c:out value="${textoAyudaArchivo}"/></span>
                  </div> 
                  </div>
                  <div class="form-group">
                    <div class="col-md-12"> 
                    <label class="control-label" for="escritoFundamentado">Escrito Fundamentado</label>
                    <form:textarea path="solicitudDevolucion.escritoFundamentado" rows="4" readonly="true" class="form-control" /> 
                    </div>
                  </div>
                  <div id="informacionImportante">
                  </div>
                  <div class="text-right">
                    <button class="btn btn-primary pull-right" id="btnRegistrar" disabled="disabled">Registrar</button>
                  </div>
                </form:form>
              </div>
            </div>
          </div>
        </div>
    </div>
</div>

<sunat:resources tipo="js" />

<div id="ayudaDevoluciones" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center">SOLICITUD DE DEVOLUCIÓN<br />FORMAS DE DEVOLUCIÓN DE LA SOLICITUD</h4>
            </div>
            <div class="modal-body">
                <p class="text-justify">Usted debe seleccionar la forma en que desea se le efectúe la devolución 
<br /><br />La Orden de Pago del Sistema Financiero le permitirá al beneficiario, de manera personal, hacer efectiva la devolución en cualquier oficina del Banco de la Nación a nivel nacional. Para ello deberá presentar su D.N.I. y el talón de cobro de la OPF para el pago de su devolución. No es necesario recoger ningún documento de las oficinas de SUNAT.
<br /><br />El Abono en Cuenta permitirá que la SUNAT deposite, el importe a ser devuelto, en una cuenta corriente o de ahorros en soles del contribuyente. En tal sentido el contribuyente debe haber informado a la SUNAT su Código de Cuenta Interbancario que identifica una cuenta corriente o de ahorros de una entidad bancaria del sistema financiero nacional la misma que debe estar registrada a nombre del beneficiario sujeto a la devolución.
<br /><br />El Cheque No Negociable deberá ser recogido de las oficinas de SUNAT, para luego hacerlo efectivo en el Banco de la Nación. Se devolverá con Cheque No Negociable: sólo si el monto supera las 10 UIT vigente.
<br /><br />La Nota de Crédito Negociable es un documento valorado que sólo podrá ser utilizado para pagar impuestos ante la SUNAT. Deberá ser recogido de las oficinas de SUNAT, previa presentación de la resolución de intendencia u oficina zonal notificada por SUNAT aprobando la devolución.
                </p>
            </div>
        </div>
    </div>
</div>
<script>
$(document).ready(function() {
    $('#solicitudDevolucion\\.periodoDocumento').inputmask({ mask: "999999", greedy: false });
    $('#solicitudDevolucion\\.cci').inputmask({ mask: "99999999999999999999",greedy: false });
    $('#solicitudDevolucion\\.telefono').inputmask({ mask: "9{6,14}",greedy: false });
    $('#solicitudDevolucion\\.montoSolicitado').inputmask({ 'mask':"9{1,12}.{0,1}9{0,2}", greedy: false});
    var validator = $("#formulario").validate({
        rules:{
            'solicitudDevolucion.periodoDocumento': {
                required: true,
                maxlength: 6,
                minlength: 6,
                number   : true,
                periodoMensual : true,
                periodoMinorTo : ["<=", moment().getPeriodoMensual() ],
            },
            'solicitudDevolucion.cci':{
                required: true,
                cci : true,
            },
            'solicitudDevolucion.archivoSustento' :{
                required: true,
                maxMBSize : 2,
                regexp : ".(pdf)|(PDF)$",
            },
            'solicitudDevolucion.telefono': {
                required: true,
                number : true,
                maxlength : 10,
            },
            'solicitudDevolucion.montoSolicitado': {
                required : true,
                number : true,
            },
            'solicitudDevolucion.indicadorFormaDevolucion': "required",
        },
        messages: {
            'solicitudDevolucion.periodoDocumento': {
                required : "Ingrese el periodo tributario.",
                periodoMinorTo : "El periodo tributario no puede ser mayor al periodo de la fecha de registro de la solicitud.",
                maxlength : "Ingrese un periodo válido.",
                minlength : "Ingrese un periodo válido.",
                number   : "Ingrese un periodo válido.",
                periodoMensual : "Sr. Contribuyente, el Periodo Tributario es Incorrecto debe estar entre 01 y 12.",
            },
            'solicitudDevolucion.cci':{
                required: "Ingrese número de CCI.",
                cci : "Sr. Contribuyente, el número CCI registrado no es válido, intente nuevamente, si el error persiste consulte con su banco el número correcto. El número de CCI debe ser de 20 dígitos (sin guiones, espacios u otro carácter).",
            },
            'solicitudDevolucion.archivoSustento' :{
                required: "Seleccione un archivo de sustento.",
                maxMBSize : "El archivo de sustento excede la capacidad de 2 MB.",
                regexp : "La extensión del archivo de sustento debe ser pdf.",
            },
            'solicitudDevolucion.telefono': {
                required  : "Ingrese el número de teléfono.",
                number    : "Ingrese un  Número de Teléfono válido.",
                maxlength : "Ingrese un  Número de Teléfono válido.",
            },
            'solicitudDevolucion.montoSolicitado':{
               required   : "Ingrese el Importe solicitado.",
               number     : "El monto no es válido.",
            } ,
            'solicitudDevolucion.indicadorFormaDevolucion': "Seleccione la Forma de Devolución.",
        },
        errorPlacement: function(error, element) {
         if(element.hasClass("dropdown-toggle")){
            error.insertAfter(element.parent());
         } else {
            error.insertAfter(element);
         }
       }
    });
    $( "#solicitudDevolucion\\.indicadorFormaDevolucion" ).change(function() {
        var indicador  = $(this).val().split("|")[0];
        if(indicador=="")
            indicador="-1";
        var $inputCCi = $("#solicitudDevolucion\\.cci");
        
        //Obtener el texto de información importante:
        $("#informacionImportante").hide();
        $.getJSON( 'ObtenerInformacionImportante?formaDevolucion='+indicador, function(respuesta) {
            if(respuesta.estadoRespuesta == <%=ResponseStatus.Correcto%>){
                var informacion = $.trim(respuesta.datos);
                if(informacion){
                    $("#informacionImportante").html('<label class="control-label">Información Importante</label>' + informacion);
                    $("#informacionImportante").show();
                }
            } else {
                AlertDialog.showMessageJSON(respuesta);
            }
        });
        
        if( indicador == 4){
            $inputCCi.prop("readonly", false);
            $inputCCi.fillWithJSON({
                message : "Obteniendo CCI validos.",
                url : 'ObtenerCCI?ruc=',
                valueProperty : 'codigoCCI',
                labelProperty : 'codigoCCI',
            });
        } else {
            $inputCCi.prop("readonly", true);
            $inputCCi.clearItems();
        }
        validator.resetForm();
    });
    
    $("#btnRegistrar").click(function(e){
        e.preventDefault();
        var form = $("#formulario");
        if(!form.valid())
            return;
        AlertDialog.showConfirm("¿Sr. Contribuyente ¿está seguro de grabar la información?", function () {
           $.blockUI({message : "Registrando solicitud de devolución. Por favor espere.....", fadeIn: 0, baseZ: 2000});
           var dataFrm = new FormData(form[0]);
           $.ajax({
               url: 'RegistrarSolicitudDevolucion',
               dataType:'JSON',
               type: 'POST',
               data: dataFrm,
               processData: false,
               contentType: false,
               cache: false,
           }).done(function( respuesta ) {
               if(respuesta.estadoRespuesta == <%=ResponseStatus.Correcto%>){
                   $(location).attr('href', 'MostrarConstancia.htm');
               } else {
                   AlertDialog.showMessageJSON(respuesta);
                   $.unblockUI();
               }
           }).error(function(xhr, status, text){ 
             AlertDialog.showAJAXError(xhr, status, text);
             $.unblockUI(); // Fin de bloqueo
           });
        });
    });
    
    $("#btnAyuda").click(function(){
        $('#ayudaDevoluciones').modal('show');
    });
    $( "#solicitudDevolucion\\.periodoDocumento, #solicitudDevolucion\\.montoSolicitado" ).change(function() {
        var escritoBase = '<c:out value="${model.solicitudDevolucion.escritoFundamentado}"/>';
        var periodo = $("#solicitudDevolucion\\.periodoDocumento").val();
        var importe = $("#solicitudDevolucion\\.montoSolicitado").val();
        if(periodo.length > 0)
            escritoBase = escritoBase.replace("%PERIODO%",periodo);
        if(importe.length > 0)
            escritoBase = escritoBase.replace("%IMPORTE%",importe);
        $('#solicitudDevolucion\\.escritoFundamentado').val(escritoBase);
    });
    $(window).load(function(){
        $("#btnRegistrar").prop( "disabled", false );
    });
    
    $("#solicitudDevolucion\\.indicadorFormaDevolucion").trigger("change");
});
</script>
</body>
</html>