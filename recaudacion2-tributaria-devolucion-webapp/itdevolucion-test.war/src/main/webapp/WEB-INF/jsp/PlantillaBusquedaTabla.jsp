<%@ page import="org.apache.velocity.runtime.directive.Include" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="SUNATTags" prefix="sunat" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TITULO FORMULARIO</title>
<sunat:resources tipo="css" />

</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center text-primary">
				TITULO FORMULARIO
			</h3>

			<%@include file="MostrarMensaje.jsp"%>
			<form:form id="formBusqueda" class="form-horizontal" role="form" method="POST" commandName="model">
				<input type="hidden" id="opcion" name="opcion" value="buscarCarga" />

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							Búsqueda de Cargas
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<div class='col-sm-6'>
								<form:label path="numeroCarga" class="col-sm-3 control-label" title="">
                                        Número de carga:
								</form:label>
								<div>
								<form:input path="numeroCarga" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class='col-sm-6'>
								<form:label path="numeroMetodo" class="col-sm-3 control-label" title="">
                                        Número de método:
								</form:label>
								<div>
								<form:input path="numeroMetodo" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class='col-sm-6'>
								<form:label path="fechaInicioTransferencia" class="col-sm-3 control-label" title="">
									Fecha de Transferencia Inicio:
								</form:label>
								<div class="input-group input-append date" id="fechaInicioTransferencia">
									<form:input path="fechaInicioTransferencia" class="form-control" />
									<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
							<div class='col-sm-6'>
								<form:label path="fechaFinTransferencia" class="col-sm-2 control-label" title="">
									Fin:
								</form:label>
								<div class="input-group input-append date" id="fechaFinTransferencia">
									<form:input path="fechaFinTransferencia" class="form-control" />
									<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</div>
						<button id="btnBuscar" name="btnBuscar" type="button" class="btn btn-primary pull-right" value="Buscar">
							Buscar
						</button>
					</div>
				</div>
			</form:form>
			<form id="formSolicitarGeneracion" class="form-horizontal" role="form" method="POST" >
				<input type="hidden" id="opcion" name="opcion" value="generarRegistro" />

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							Cargas Encontradas
						</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
						<table id="dataTable" class="table table-striped table-bordered" cellspacing="0" width="98%">
							<thead>
								<tr>
									<th></th>
									<th>Número de Carga</th>
									<th>Fecha de Transferencia</th>
									<th>Método</th>
									<th>Cantidad Fiscalizables</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th></th>
									<th>Número de Carga</th>
									<th>Fecha de Transferencia</th>
									<th>Método</th>
									<th>Cantidad Fiscalizables</th>
								</tr>
							</tfoot>
						</table>
						</div>
						<button id="btnSolicitarGeneracion" name="btnSolicitarGeneracion" type="button" class="btn  btn-primary pull-right" value="Solicitar Generación">
							Solicitar generación de Acciones de Fiscalización
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<sunat:resources tipo="js" />

<script>
$(document).ready(function() {
	var dataTable = $('#dataTable').DataTable({
		bFilter: false,
		bInfo: false,
		columns: [
			{ data: "numeroCarga" },
			{ data: "numeroCarga" },
			{ data: "fechaTransferencia" },
			{ data: "metodo" },
			{ data: "cantidadFiscalizables" }
		],
		columnDefs: [{
			targets: 0,
			searchable:false,
			orderable:false,
			className: 'dt-body-center',
			render: function (data, type, full, meta){
				return '<input type="checkbox" name="cargasSeleccionadas" value="'
					+ $('<div/>').text(data).html() + '" />';
			}
		}],
	});
	
	$('#fechaFinTransferencia').datetimepicker({
		locale: 'es',
		format: 'DD/MM/YYYY',
	});

	$('#fechaInicioTransferencia').datetimepicker({
		locale: 'es',
		format: 'DD/MM/YYYY',
	});

	$('#numeroCarga').inputmask({ mask: "9[99999999]", greedy: false });
	
	
	//Validación del formulario
	$("#formBusqueda").validate({
		rules: {
			numeroCarga: "required",
		},
		messages: {
			numeroCarga: "Debe registrar un número de carga :).",
		}
	});
	
	$( "#btnBuscar" ).click(function() {
		var form = $("#formBusqueda");
		form.validate();
		if(form.valid()){
			$.ajax({
				type: "POST",
				dataType: "json",
				url: "ListarCarga",
				data: form.serialize()
			}).done(function( respuesta ) {
				if(respuesta.estado == 1){
					alert ("Mensaje recibido al cargar: " + respuesta.mensaje);
					dataTable.clear().draw( false );
					dataTable.rows.add(respuesta.datos).draw( false );
				}
				else{
					alert (respuesta.mensaje);
				}
				
			}).error(function(xhr, status, text){
				alert("Hubo un error al procesar la solicitud. Por favor intente nuevamente.");
			});
		}
	});
});
</script>
</body>
</html>