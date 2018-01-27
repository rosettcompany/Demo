/***********************************************************************
 * Module:  CasillaDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class CasillaDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid 7a4ef094-6597-47a7-9ed7-ae6ba11875e6 */
public class CasillaDevolucion implements GenericModel {
   /** @pdOid f70e4322-da56-4c51-a26c-f81ab0c79b2e */
   private String codigoCasilla;
   /** @pdOid 4595440e-b69d-4a24-befa-f77c6e67132e */
   private String valorCasilla;
   /** @pdRoleInfo migr=no name=Devolucion assc=association4 mult=0..1 side=A */
   public Devolucion devolucion;
   
   public CasillaDevolucion() {
      
   }
   
   public CasillaDevolucion(Devolucion devolucion, String codigoCasilla, String valorCasilla) {
      this.devolucion = devolucion;
      this.codigoCasilla = codigoCasilla;
      this.valorCasilla = valorCasilla;
   }
   
   public String getCodigoCasilla() {
      return codigoCasilla;
   }
   public void setCodigoCasilla(String codigoCasilla) {
      this.codigoCasilla = codigoCasilla;
   }
   public String getValorCasilla() {
      return valorCasilla;
   }
   public void setValorCasilla(String valorCasilla) {
      this.valorCasilla = valorCasilla;
   }
   public Devolucion getDevolucion() {
      return devolucion;
   }
   public void setDevolucion(Devolucion devolucion) {
      this.devolucion = devolucion;
   }
  
}