/***********************************************************************
 * Module:  ModelFormBase.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ModelFormBase
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** Clase genérica usada para encapsular la información que va a viajar entre formularios.
 * 
 * @pdOid 8e3d54c0-8b5b-4290-9468-d01ea3be5d8a */
public class ModelFormBase {
   /** Indica la opción que ha sido invocada al momento de enviar la información por POST o GET
    * 
    * @pdOid 6a53940f-56be-4761-873f-480099fee7db */
   private String opcion;
   
   /** @pdRoleInfo migr=no name=Mensaje assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0.* */
   private java.util.List<Mensaje> mensajes;
   
   
   /** @pdGenerated default getter */
   public java.util.List<Mensaje> getMensajes() {
      if (mensajes == null)
         mensajes = new java.util.ArrayList<Mensaje>();
      return mensajes;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Mensaje> getIteratorMensajes() {
      if (mensajes == null)
         mensajes = new java.util.ArrayList<Mensaje>();
      return mensajes.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMensajes */
   public void setMensajes(java.util.List<Mensaje> newMensajes) {
      removeAllMensajes();
      for (Iterator<Mensaje> iter = newMensajes.iterator(); iter.hasNext();)
         addMensajes((Mensaje)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMensaje */
   public void addMensajes(Mensaje newMensaje) {
      if (newMensaje == null)
         return;
      if (this.mensajes == null)
         this.mensajes = new java.util.ArrayList<Mensaje>();
      if (!this.mensajes.contains(newMensaje))
         this.mensajes.add(newMensaje);
   }
   
   /** @pdGenerated default remove
     * @param oldMensaje */
   public void removeMensajes(Mensaje oldMensaje) {
      if (oldMensaje == null)
         return;
      if (this.mensajes != null)
         if (this.mensajes.contains(oldMensaje))
            this.mensajes.remove(oldMensaje);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMensajes() {
      if (mensajes != null)
         mensajes.clear();
   }
   
   /** @pdOid 0c2c1f3b-2310-4e44-9a9c-a2e0b649eb02 */
   public String getOpcion() {
      return opcion;
   }
   
   /** @param newOpcion
    * @pdOid d9bc14aa-65c3-42ba-9035-624e823f4a1c */
   public void setOpcion(String newOpcion) {
      opcion = newOpcion;
   }

}