/***********************************************************************
 * Module:  ConfiguracionRegistroSolicitudDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ConfiguracionRegistroSolicitudDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** Obtiene la metadata relacionada al formulario para proceder al registro.
 * 
 * @pdOid 42f8a50a-0d0b-4d0f-9e08-06bc5e176a3d */
public class ConfiguracionRegistroSolicitudDevolucion {
   /** Código del tipo de devolución
    * 
    * @pdOid a03a50b9-8987-4423-beca-69f1c62f919b */
   private String codigoTipoDevolucion;
   /** Determina el modo de llenado establecido para el formulario
    * 
    * @pdOid 5aba0dd8-854c-4f81-a362-38148091c232 */
   private String modoLlenado;
   /** @pdOid 3b088875-71bb-4185-b018-58c8e8d6b83b */
   private boolean indicadorRegistroAreaEvaluacion;
   /** @pdOid 43fdbf3e-a9e1-4e5c-9025-c78cb0fc53e6 */
   private boolean indicadorRegistroFormularioAsociado;
   /** @pdOid eb2b5895-5706-4db3-8047-05eb14b55515 */
   private boolean indicadorRegistroRUC;
   /** @pdOid 93892cfa-ebf0-4d74-94d8-5566e480966d */
   private boolean indicadorRegistroArea;
   /** @pdOid e51939bb-8e29-4723-bc32-fa4e2a497f51 */
   private boolean indicadorRegistroTelefono;
   /** @pdOid 50e250a0-a441-4386-9878-0c48ae182c62 */
   private boolean indicadorRegistroTipoSolicitud;
   /** @pdOid 5fb7ab34-eae1-452a-be49-5d9ea4564a46 */
   private boolean indicadorRegistroImporteSolicitado;
   /** @pdOid 0128cf19-2a91-4310-a560-2636e4ac71ff */
   private boolean indicadorRegistroCodigoTributario;
   /** @pdOid a961c317-8170-4f5e-8b56-00d6dd837bd1 */
   private boolean indicadorRegistroPeriodoTributario;
   /** @pdOid b925a75c-f613-4f3d-8657-e31c983320cf */
   private boolean indicadorRegistroFechaRecepcion;
   /** @pdOid bcc13a47-9b0c-4602-aac5-cc193dc55bdc */
   private boolean indicadorRegistroFormularioSustento;

}