/***********************************************************************
 * Module:  Contribuyente.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Contribuyente
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid abfba8d0-859f-44dd-bf5d-35a4e3b2d857 */
public class Contribuyente implements GenericModel {
   /** @pdOid 6445b262-f5fc-468f-80a8-c15a95ebbdda */
   private String numeroRuc;
   
   /** @pdOid f0f67408-0d23-452e-b670-2757f8b27969 */
   public String getNumeroRuc() {
      return numeroRuc;
   }
   
   /** @param newNumeroRuc
    * @pdOid 9c5f4032-feef-45e8-b9ed-c3f0afc6c553 */
   public void setNumeroRuc(String newNumeroRuc) {
      numeroRuc = newNumeroRuc;
   }

}