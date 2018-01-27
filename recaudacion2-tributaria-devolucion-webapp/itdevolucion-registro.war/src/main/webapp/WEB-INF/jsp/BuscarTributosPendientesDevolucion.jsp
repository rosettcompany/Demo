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
        <jsp:include page="Cabecera.jsp" />
        <div class="row">
          <div class="col-md-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Búsqueda de formularios</h3>
              </div>
              <div class="panel-body">
                <form:form id="formBusqueda" class="form-horizontal" role="form" method="POST" commandName="model">
                  <form:hidden path="solicitudDevolucion.tipoSolicitud" />
                  <div class="form-group">
                    <div class="col-sm-2">
                      <form:label path="solicitudDevolucion.periodo" class="col-sm-3 control-label" title="">
                                        Periodo:
                      </form:label>
                    </div>
                    <div class="col-sm-10">
                      <form:input path="solicitudDevolucion.periodo" class="form-control" placeholder="YYYYMM" />
                    </div>
                  </div>
                  <a class="btn btn-primary pull-right" id="btnLimpiar" href="#" style="margin-left: 10px !important;">Limpiar</a>
                  <a class="btn btn-primary pull-right" id="btnBuscar" href="#">Buscar</a>
                </form:form>
              </div>
            </div>
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Tributos pendientes de devolución</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
                  <table id="dataTable" class="table table-striped table-bordered" cellspacing="0"
                  width="98%">
                    <thead>
                      <tr>
                        <th class="text-center" valign="middle">Periodo</th>
                        <th class="text-center" valign="middle">Formulario</th>
                        <th class="text-center" valign="middle">Nro Orden</th>
                        <th class="text-center" valign="middle">Tributo</th>
                        <th class="text-center" valign="middle">Monto <br /> S/</th>
                        <th class="text-center" valign="middle">Presentar</th>
                      </tr>
                    </thead>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
<sunat:resources tipo="js" />
<script>
function callFV1649(hash){
    var url = "/ol-ti-itsoldev/devInterS03Alias?appext=" + hash;
    window.open(url,'FV1649','location=no,menubar=no,resizable=1');
}

$(document).ready(function() {
    $('#solicitudDevolucion\\.periodo').inputmask({ mask: "999913", placeholder : "YYYYMM",greedy: false });
    $("#formBusqueda").validate({
        rules:{
            'solicitudDevolucion.periodo': {
                required: true,
                periodoMajorTo : [">=", "2016"]
            }
        },
        messages: {
            'solicitudDevolucion.periodo': {
                required : "Debe registrar un periodo válido. Ejem. 201613",
                periodoMajorTo : "La búsqueda solo se puede realizar a partir del periodo 2016."
            } 
        },
        submitHandler: function(form) {
           var form = $("#formBusqueda");
           form.validate();
           if(!form.valid())
               return;
           $.blockUI({message: 'Procesando... espere por favor' });
           $.ajax({
              dataType: "json",
              url: "ListarTributosPendientesDevolucion",
              data: form.serialize()
           }).done(function( respuesta ) {
               if(respuesta.estadoRespuesta == 1){
                   dataTable.page( 'first' ).draw( 'page' );
                   dataTable.clear().draw( false );
                   if(respuesta.isDatosArray && respuesta.cantidadDatos > 0){
                       dataTable.rows.add(respuesta.datos).draw( false );
                   } else {
                       AlertDialog.showInfo('No se encontraron resultados.');
                   }
               }
               else{
                   AlertDialog.showMessageJSON(respuesta);
               }
           }).error(function(xhr, status, text){ 
             AlertDialog.showAJAXError(xhr, status, text);
           }).complete(function(jqXHR, textStatus){
             $.unblockUI(); // Fin de bloqueo
           });
            return false;
        }
    });
    var dataTable = $('#dataTable').DataTable({
        bFilter: false,
        bLengthChange: false,
        info: false,
        searching: false,
        pagingType: "numbers",
        pageLength: 30,
        language: {
            emptyTable: "No hay resultados que mostrar"     
        },
        columns: [
            { data: "periodo" },
            { data: "formulario", render : "valueName" },
            { data: "numeroOrdenFormulario" },
            { data: "tributo", render : "valueName" },
            { data: "monto" },
            { data: "hash" }
        ],
        columnDefs: [
        {
            targets: [0,1,2,3,5],
            className: 'text-center'
        },
        {
            targets: 4,
            className: 'text-right'
        },
        {
            targets: 5,
            render: function (data, type, full, meta){
                return '<a class="btn btn-primary" href="#" onclick="callFV1649(' + "'" + data +"'" +')">FV1649</a>';
            }
        }]
    });
    $( "#btnLimpiar" ).click(function() {
         $('#solicitudDevolucion\\.periodo').val("");
         dataTable.clear().draw( false );
         $('#solicitudDevolucion\\.periodo').focus();
    });
    $( "#btnBuscar" ).click(function() {
        $("#formBusqueda").submit();
    });
});
</script>
</body>
</html>