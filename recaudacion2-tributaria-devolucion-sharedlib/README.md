# Solicitudes de Devolución 1649
Este módulo permite el registro de solicitudes de devolución (Formulario Virtual 1649). Los tipos de solicitudes que se pueden registrar son las siguientes
 - Tipo 02 - Pago Indevido o en Exceso
 
El llenado del formulario se puede realizar mediante 2 formas: manual y guiado. En la forma de llenado manual, el usuario debe registrar todos los campos de su solicitud. En el caso del llenado guiado, el contribuyente puede seleccionar de una lista de devoluciones pendientes, en la cual el formulario aparecerá prellenado.

# Documentación
La documentación relacionada al módulo se puede encontrar en las siguientes URL:

| Documento | Descripción | URL |
| ------ | ------ | ------ |
| Documento único F2 | Documento de definición que describe la implementación del registro de declaraciones informativas | http://150.50.50.197/repositorios/documentacion/Modulos/070201/1_informe_definicion/F2_070201_ana_dis.docx |
| Modelos de Arquitectura de Aplicación | Modelos de las aplicaciones/módulos creados. |  http://150.50.50.197/repositorios/documentacion/Modulos/070201/3_diagramas |
| Modelos de Arquitectura de Datos | Modelos de datos (Conceptual/Lógico/Físico) relacionados. | http://150.50.50.197/repositorios/documentacion/Modulos/070201/4_modelos/ |

# Artefactos que componen el sistema

| Artefacto | Descripción |
| ------ | ------ |
| recaudacion2-tributaria-devolucion-sharedlib |  EAR que implementa las API de uso común para las aplicaciones WEBAPP y BATCH|
| recaudacion2-tributaria-devolucion-webapp |  EAR que implementa las funcionalidades del módulo 070201 - Registro de solicitudes de devolución 1649.|
