/***********************************************************************
 * Module:  DocumentoAsociado.java
 * Author:  jmazuelos
 * Purpose: Defines the Class DocumentoAsociado
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid e36cf955-27f2-445a-9ba3-ebdf4f8d0eef */
public class DocumentoAsociado implements GenericModel {
   /** Número de documento generado al momento de registrar el dato binario en archbin
    * 
    * @pdOid 27bd5004-b2e7-4519-a683-5cfc51e00ded */
   private int numeroId;
   /** Descripción del documento asociado
    * 
    * @pdOid d84b9c23-b210-4a30-a583-e15811ef9fc5 */
   private String descripcion;
   /** Determina el tipo de dcoumento asociado.
    * 
    * @pdOid d6b7b602-40b3-4980-b79a-c963817ffe54 */
   private String tipoDocumento;
   /** Fecha de asociación de documento
    * 
    * @pdOid 251d62f9-2d4e-40e0-9575-8c3eb2dee8c1 */
   private Date fechaAsociacion;
   /** Usuario que realiza el registro del documento
    * 
    * @pdOid b4d0a9e5-e743-4ff2-bb2e-32ee922f5cac */
   private String usuarioAsociado;
   /** Indica el estado actual del documento asociado
    * 
    * @pdOid 9a45eef7-ba24-4e72-85de-331988192d76 */
   private String indicadorEstado;
   /** Fecha de actualización de documento.
    * 
    * @pdOid 293472a7-a822-4e2c-9247-82035e7517cc */
   private Date fechaActualizacion;
   /** Usuario que actualiza el estado del documento
    * 
    * @pdOid fda82d52-be15-40d6-97e7-a5bdeb936698 */
   private String usuarioActualiza;
   
   /** @pdRoleInfo migr=no name=Devolucion assc=association6 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   private Devolucion devolucion;
   
   /** @pdOid df4c9a98-2cfe-4a07-921e-25cdc7e800d0 */
   public int getNumeroId() {
      return numeroId;
   }
   
   /** @param newNumeroId
    * @pdOid 3544fa8b-4a4c-41c6-b76b-5ecddf85524f */
   public void setNumeroId(int newNumeroId) {
      numeroId = newNumeroId;
   }
   
   /** @pdOid 1a6bfc66-ad7b-4f17-9093-0d2527edb6d2 */
   public String getDescripcion() {
      return descripcion;
   }
   
   /** @param newDescripcion
    * @pdOid 9fc5ac57-60bb-4014-9cfd-fd94c11df28b */
   public void setDescripcion(String newDescripcion) {
      descripcion = newDescripcion;
   }
   
   /** @pdOid 5f179d0d-33ce-454c-b5e9-2a06f7e7c70a */
   public String getTipoDocumento() {
      return tipoDocumento;
   }
   
   /** @param newTipoDocumento
    * @pdOid 458e0949-7bbc-46fa-b11a-035784e78e25 */
   public void setTipoDocumento(String newTipoDocumento) {
      tipoDocumento = newTipoDocumento;
   }
   
   /** @pdOid 07e122c8-883f-4f4f-b23a-409752fa7cd1 */
   public Date getFechaAsociacion() {
      return fechaAsociacion;
   }
   
   /** @param newFechaAsociacion
    * @pdOid 22509189-ed1e-4c84-8bde-9ea9b9d013bd */
   public void setFechaAsociacion(Date newFechaAsociacion) {
      fechaAsociacion = newFechaAsociacion;
   }
   
   /** @pdOid 321cda16-300f-483d-9f3c-f7d6bb18c7ce */
   public String getUsuarioAsociado() {
      return usuarioAsociado;
   }
   
   /** @param newUsuarioAsociado
    * @pdOid 4324b0ac-ea3d-4286-a977-5e062c60c900 */
   public void setUsuarioAsociado(String newUsuarioAsociado) {
      usuarioAsociado = newUsuarioAsociado;
   }
   
   /** @pdOid c15dc732-a5c1-4bfb-b25d-898a340d08dc */
   public String getIndicadorEstado() {
      return indicadorEstado;
   }
   
   /** @param newIndicadorEstado
    * @pdOid 5ad5e12c-9851-4abb-bc7a-a933f6b272a5 */
   public void setIndicadorEstado(String newIndicadorEstado) {
      indicadorEstado = newIndicadorEstado;
   }
   
   /** @pdOid b0d0ed5c-709b-420a-9150-cc481ed553fa */
   public Date getFechaActualizacion() {
      return fechaActualizacion;
   }
   
   /** @param newFechaActualizacion
    * @pdOid 9896559c-4b0b-4481-aa88-e2b50a582a36 */
   public void setFechaActualizacion(Date newFechaActualizacion) {
      fechaActualizacion = newFechaActualizacion;
   }
   
   /** @pdOid fd732ed1-49ce-44df-a431-ba1e79da265c */
   public String getUsuarioActualiza() {
      return usuarioActualiza;
   }
   
   /** @param newUsuarioActualiza
    * @pdOid 9522e20c-fe9a-4297-bfb9-06efad1ebbd6 */
   public void setUsuarioActualiza(String newUsuarioActualiza) {
      usuarioActualiza = newUsuarioActualiza;
   }

   public Devolucion getDevolucion() {
      return devolucion;
   }

   public void setDevolucion(Devolucion devolucion) {
      this.devolucion = devolucion;
   }

   
}