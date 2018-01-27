/***********************************************************************
 * Module:  JSONResponse.java
 * Author:  jmazuelos
 * Purpose: Defines the Class JSONResponse
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** Clase BEAN usada para las respuestas a través de peticiones POST que devuelven la información en formato JSON.
 * Permite devolver un conjunto de datos, adicionalmente de un estado el cual indica si fue correcta la ejecución.
 * 
 * 
 * @pdOid f7c3d151-84a5-4228-a0ad-7293c1d46134 */
public class JSONResponse {
   /** Indica si la operación se realizó correctamente.
    * Los posibles valores de este estado son los siguientes
    *  - ResponseStatus.Fallo
    *  - ResponseStatus.Correcto
    *  - ResponseStatus.Peligro
    * 
    * 
    * 
    * @pdOid aedf02f1-f4eb-45ec-8030-bffdb3fd921f */
   private int estadoRespuesta;
   /** @pdOid f24917e3-7e3a-4f4f-907e-8992a82cee20
       @pdRoleInfo migr=yes name=Mensaje assc=association1 mult=1..1 */
   private Mensaje mensaje;
   /** Conjunto de datos a devolver en la respuesta JSON.
    * 
    * 
    * @pdOid 501335bf-c567-47cf-95b7-1932d59e60ce */
   private Object datos;
   /** Devuelve la cantidad de datos enviados.
    * 
    * 
    * @pdOid 1e4307b0-f13d-47e7-a16f-560e7007fc1d */
   private int cantidadDatos;
   /** Indica si los datos enviados se enviaron como una lista.
    * 
    * 
    * @pdOid 656c21a6-61db-48ae-a693-0daf8fd43115 */
   private boolean isDatosArray;
   
   /** @param estado Indica el estado del resultado de la ejecución de una operación
    * @param mensaje Mensaje con información sobre el procesamiento realizado.
    * @pdOid 2df2aba8-71d6-4c05-bb4c-bee6b2cfc069 */
   public JSONResponse(int estado, String mensaje) {
      this.estadoRespuesta = estado;
      this.mensaje = new Mensaje(estado, mensaje);
      this.isDatosArray = false;
      this.cantidadDatos = -1;
   }
   
   public JSONResponse(Mensaje mensaje) {
      this.estadoRespuesta = mensaje.getTipo();
      this.mensaje = mensaje;
      this.isDatosArray = false;
      this.cantidadDatos = -1;
   }
   
   /** @param estado Indica el estado del resultado de la ejecución de una operación
    * 0 -> Incorrecto
    * 1 -> Correcto
    * @param mensaje Mensaje con información sobre el procesamiento realizado.
    * @param datos Datos de respuesta e enviar en JSON
    * @pdOid d57ded6d-cab0-4466-bb03-97171c27e844 */
   public JSONResponse(int estado, String mensaje, Object datos) {
      Mensaje msje = new Mensaje(estado,mensaje);
      iniciar(estado, msje, datos);
   }
   
   public JSONResponse(int estado, Mensaje mensaje, Object datos) {
      mensaje.setTipo(estado);
      iniciar(estado, mensaje, datos);
   }
   
   private void iniciar(int estado, Mensaje mensaje, Object datos) {
      this.estadoRespuesta = estado;
      this.mensaje = mensaje;
      this.datos = datos;
      this.isDatosArray = false;
      this.cantidadDatos = -1;
      if(datos == null)
         return;
      if(datos instanceof Object[]){
         isDatosArray = true;
         cantidadDatos = ((Object[])datos).length;
      }
      if(datos instanceof Collection){
         isDatosArray = true;
         cantidadDatos = ((Collection)datos).size();
      }
   }
   
   /** @pdOid eebb8f91-19b6-466d-a12f-e7a078454f0f */
   public int getEstadoRespuesta() {
      return estadoRespuesta;
   }
   
   /** @param newEstadoRespuesta
    * @pdOid 5fa20397-2905-4212-802c-ff03792abc90 */
   public void setEstadoRespuesta(int newEstadoRespuesta) {
      estadoRespuesta = newEstadoRespuesta;
   }
   
   /** @pdOid aca40124-3820-44b3-b578-5ddc5217e532 */
   public Object getDatos() {
      return datos;
   }
   
   /** @param newDatos
    * @pdOid 3deca883-b16c-4e33-ad80-a99a286acee5 */
   public void setDatos(Object newDatos) {
      datos = newDatos;
   }
   
   /** @pdOid b97085dc-d4ce-4b7b-84f1-d32beb796a01 */
   public int getCantidadDatos() {
      return cantidadDatos;
   }
   
   /** @param newCantidadDatos
    * @pdOid 272898b6-3d31-4be4-a07a-b241784bec9a */
   public void setCantidadDatos(int newCantidadDatos) {
      cantidadDatos = newCantidadDatos;
   }
   
   /** @pdOid dfbef7c1-1e4d-4963-ad6d-51a44135871c */
   public boolean getIsDatosArray() {
      return isDatosArray;
   }
   
   /** @param newIsDatosArray
    * @pdOid c97477c1-7ee4-4cf9-8a75-ca9165ce0b5a */
   public void setIsDatosArray(boolean newIsDatosArray) {
      isDatosArray = newIsDatosArray;
   }
   
   /** @pdOid 953cdfbb-6a8f-426d-909d-280ebfbe6483 */
   public Mensaje getMensaje() {
      return mensaje;
   }
   
   /** @param newMensaje
    * @pdOid 6121d52e-7735-48a5-96e8-a83c2cb79356 */
   public void setMensaje(Mensaje newMensaje) {
      mensaje = newMensaje;
   }

}