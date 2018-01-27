/***********************************************************************
 * Module:  ControlDeclaracion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ControlDeclaracion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid 53c7fd14-ed89-4fc6-859e-5bdf689554d8 */
public class ControlDeclaracion implements GenericModel {
   /** Número que identifica de manera única la declaración
    * 
    * @pdOid 275e4bcc-0532-406b-a084-5ad531735f1b */
   private Integer numeroSecuencia;
   /** Indica el ejercicio relacionado a la declración registrada.
    * Ejemplo:
    * 2016
    * 2015
    * 
    * @pdOid c9057bdb-f68d-41da-a4e6-b9b5d07775ae */
   private String numeroEjercicio;
   /** Indica el número de formulario llenado en la declaración.
    * Ejemplo:
    * 1649 - Formulario Virtual de Deovlución
    * 4949 - Formulario de Devolución
    * 0703 - Declaración de Renta de Persona Natural.
    * 
    * @pdOid 38a13c13-ff7b-486b-a48e-ebd5206cfe11 */
   private String numeroFormulario;
   /** @pdOid 020788dd-c2ea-4d59-9db4-f4a759b77246 */
   private Integer numeroOrden;
   /** Indica el número de RUC del contribuyente que presentó la declaración.
    * 
    * @pdOid 31c19482-cd53-4cb2-b843-8f720f0d257c */
   private String ruc;
   /** Especifica el estado de la declración.
    * Estados
    *  1 -> Preliminar
    *  2 -> Enviado
    * 
    * @pdOid 0ea91be2-5bdf-47c8-a3fa-b04f41c4309c */
   private Integer indicadorEstado;
   /** @pdOid 144d5f9c-073e-4927-8bc4-a43c13b588c4 */
   private Integer numeroRevision;
   /** @pdOid 05275cd5-5edd-425c-a1d8-4b2b9188651f */
   private Integer indicadorActual;
   /** @pdOid b591140c-d2ca-4031-8aef-181483fe653c */
   private Integer indicadorProceso;
   /** Inda la fecha en la cual se realizó la revisión de la declración
    * 
    * @pdOid 8a23be1f-d68a-4d77-ad52-1c64ac56c473 */
   private java.util.Date fechaRevision;
   /** @pdOid 298c962c-6e14-470c-b0ed-36c4fe9cb3a8 */
   private Date fechaCreacion;
   
   /** @pdRoleInfo migr=no name=CasillasCuarta assc=association1 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   public java.util.List<CasillasCuarta> casillasCuarta;
   /** @pdRoleInfo migr=no name=CasillasSegunda assc=association2 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   public java.util.List<CasillasSegunda> casillasSegunda;
   /** @pdRoleInfo migr=no name=CasillasPrimera assc=association3 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   public java.util.List<CasillasPrimera> casillasPrimera;
   
   /** @pdOid a85508fc-3545-42a0-b2fb-c4d085679a6e */
   public Integer getNumeroSecuencia() {
      return numeroSecuencia;
   }
   
   /** @param newNumeroSecuencia
    * @pdOid 69b1ff03-17a1-4084-bc5a-73dde72f459f */
   public void setNumeroSecuencia(Integer newNumeroSecuencia) {
      numeroSecuencia = newNumeroSecuencia;
   }
   
   /** @pdOid 3d180ada-5140-47c0-a5f6-00a0c22f3259 */
   public String getNumeroFormulario() {
      return numeroFormulario;
   }
   
   /** @param newNumeroFormulario
    * @pdOid 95af0395-7de4-4f88-9154-45cb7f8c6bd9 */
   public void setNumeroFormulario(String newNumeroFormulario) {
      numeroFormulario = newNumeroFormulario;
   }
   
   /** @pdOid 80b50f62-f100-488d-85cf-4027a673212d */
   public String getNumeroEjercicio() {
      return numeroEjercicio;
   }
   
   /** @param newNumeroEjercicio
    * @pdOid 02a80b72-99e2-43b2-a4b0-0b68a81d5ec5 */
   public void setNumeroEjercicio(String newNumeroEjercicio) {
      numeroEjercicio = newNumeroEjercicio;
   }
   
   /** @pdOid 55703145-f434-4d82-8bcb-d39167f0c56b */
   public String getRuc() {
      return ruc;
   }
   
   /** @param newRuc
    * @pdOid 7f1e01ff-9322-48d8-aa0e-fb6b9bffa980 */
   public void setRuc(String newRuc) {
      ruc = newRuc;
   }
   
   /** @pdOid 12e862b0-3f91-48a2-b68d-cea4537ee8d4 */
   public Integer getIndicadorEstado() {
      return indicadorEstado;
   }
   
   /** @param newIndicadorEstado
    * @pdOid 00eed13e-fe58-4c6d-99f9-6b1678e889bf */
   public void setIndicadorEstado(Integer newIndicadorEstado) {
      indicadorEstado = newIndicadorEstado;
   }
   
   /** @pdOid 639ab18b-d059-420a-b50a-2da7338b40d5 */
   public java.util.Date getFechaRevision() {
      return fechaRevision;
   }
   
   /** @param newFechaRevision
    * @pdOid 6d708d58-5d17-4980-9861-d6c7db7c9315 */
   public void setFechaRevision(java.util.Date newFechaRevision) {
      fechaRevision = newFechaRevision;
   }
   
   /** @pdOid 28d13f9a-9502-4e2f-9928-b87cfd6745e2 */
   public Integer getNumeroOrden() {
      return numeroOrden;
   }
   
   /** @param newNumeroOrden
    * @pdOid c0084c89-1f0b-43b9-b1e1-63981dd33afd */
   public void setNumeroOrden(Integer newNumeroOrden) {
      numeroOrden = newNumeroOrden;
   }
   
   /** @pdOid 726c8872-dfe6-44bb-8f9c-bb8ee2c46a7f */
   public Integer getNumeroRevision() {
      return numeroRevision;
   }
   
   /** @param newNumeroRevision
    * @pdOid 313e8a42-c4de-4ea6-92fa-18dd52dce85e */
   public void setNumeroRevision(Integer newNumeroRevision) {
      numeroRevision = newNumeroRevision;
   }
   
   /** @pdOid 620742fc-ba8a-4286-98ff-036d01689e2e */
   public Integer getIndicadorActual() {
      return indicadorActual;
   }
   
   /** @param newIndicadorActual
    * @pdOid ef74a6fc-84ad-4303-a4b5-392c2be4d2b7 */
   public void setIndicadorActual(Integer newIndicadorActual) {
      indicadorActual = newIndicadorActual;
   }
   
   /** @pdOid f3adf38d-032f-48ed-835b-2798491369f2 */
   public Integer getIndicadorProceso() {
      return indicadorProceso;
   }
   
   /** @param newIndicadorProceso
    * @pdOid f4322250-10c8-4ca5-bf28-0027ab95a37a */
   public void setIndicadorProceso(Integer newIndicadorProceso) {
      indicadorProceso = newIndicadorProceso;
   }
   
   /** @pdOid ad43da46-8d7b-4dfb-9264-8d77acd21cd2 */
   public Date getFechaCreacion() {
      return fechaCreacion;
   }
   
   /** @param newFechaCreacion
    * @pdOid d5eb6d82-3ba6-4a51-9846-a43ff0d767f0 */
   public void setFechaCreacion(Date newFechaCreacion) {
      fechaCreacion = newFechaCreacion;
   }

}