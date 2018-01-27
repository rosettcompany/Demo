/***********************************************************************
 * Module:  Casilla.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Casilla
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid c7caa853-bc6a-4ee6-9214-2872079a0048 */
public class Casilla implements GenericModel {
   /** @pdOid 2ed7a27a-b6e0-4f94-aa3b-50143e39cec1 */
   private Integer numeroSecuencia;
   
   /** @pdOid 26eaef9c-f863-4f94-9331-cb23d7d17965 */
   public Integer getNumeroSecuencia() {
      return numeroSecuencia;
   }
   
   /** @param newNumeroSecuencia
    * @pdOid 18ae57ac-80e6-41ff-833d-3d04f4642360 */
   public void setNumeroSecuencia(Integer newNumeroSecuencia) {
      numeroSecuencia = newNumeroSecuencia;
   }

}