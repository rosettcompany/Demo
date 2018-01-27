/***********************************************************************
 * Module:  Mensaje.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Mensaje
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** @pdOid 4bb03c80-ea25-4b0c-b86c-5ff378ba5784 */
public class Mensaje {
   /** Indica el nivel de criticidad del mensaje. Los niveles pueden ser los siguientes:
    *  Informativo : Para indicar que una acción ha sido realizada correctamente
    *  Peligro        : Para indicar que una acción ha sido realizada correctamente pero se debe tomar en cuenta información adicional.
    *  Error            : Para indicar que no se ha podido procesar la información y que se deben realizar acciones respectivas
    *  Error de validación : Para indicar que un dato no ha podido ser verificado correctamente.
    * 
    * @pdOid 800f3332-791d-43f8-9aa3-e98d1144b4ba */
   private int tipo;
   /** Cadena de caracteres que se muestra al usuario con ifnormación acerca del mensaje.
    * 
    * @pdOid aef3548e-bd8e-4ba4-a619-5afe03c9a16c */
   private String mensaje;
   
   
   private List<Mensaje> mensajesDetalle;
   /** @param tipo 
    * @param mensaje
    * @pdOid 3f320bff-583f-47f3-824b-a354de896770 */
   public Mensaje(String mensaje) {
      this.tipo = ResponseStatus.Correcto;
      this.mensaje= mensaje;
   }
   public Mensaje(int tipo, String mensaje) {
      this.tipo = tipo;
      this.mensaje= mensaje;
   }
   
   public Mensaje(int tipo, String mensaje, List<Mensaje> mensajesDetalle) {
      this.tipo = tipo;
      this.mensaje= mensaje;
      this.mensajesDetalle = mensajesDetalle;
   }
   
   /** @pdOid 6ce43018-d854-4cc6-ab77-64fb7fce7c84 */
   public int getTipo() {
      return tipo;
   }
   
   /** @param newTipo
    * @pdOid 06664b9b-99b5-490e-a6bf-20a3eac0befc */
   public void setTipo(int newTipo) {
      tipo = newTipo;
   }

   public String getMensaje() {
      return mensaje;
   }

   public void setMensaje(String mensaje) {
      this.mensaje = mensaje;
   }

   public List<Mensaje> getMensajesDetalle() {
      return mensajesDetalle;
   }

   public void setMensajesDetalle(List<Mensaje> mensajesDetalle) {
      this.mensajesDetalle = mensajesDetalle;
   }
   
   
}