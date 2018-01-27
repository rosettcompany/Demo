/***********************************************************************
 * Module:  Formulario.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Formulario
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid de218995-e35a-4c51-9765-8ed702ea3d05 */
public class Formulario implements GenericModel {
   /** @pdOid 58e53892-ab0c-434a-834b-9c76391e64d2 */
   private Integer numeroOrden;
   /** @pdOid c44da5ed-fd7b-4ee2-8459-10832c4501f7 */
   private String periodoDocumento;
   /** @pdOid 4bae5e7d-bed2-4922-be76-f0631b578bb6 */
   private String ruc;
   
   /** @pdOid c89761c6-8da0-447c-9f6e-341f71c2d88d */
   public String getRuc() {
      return ruc;
   }
   
   /** @param newRuc
    * @pdOid 4c758d2a-d7d3-47e2-8842-023784ec7103 */
   public void setRuc(String newRuc) {
      ruc = newRuc;
   }

}