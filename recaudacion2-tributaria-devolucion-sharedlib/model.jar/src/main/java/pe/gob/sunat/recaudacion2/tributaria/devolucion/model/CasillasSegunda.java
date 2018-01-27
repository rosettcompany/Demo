/***********************************************************************
 * Module:  CasillasSegunda.java
 * Author:  jmazuelos
 * Purpose: Defines the Class CasillasSegunda
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** Model usado para almacenar las casilas de la tabla
 * T5386CASSEGUNDA
 * 
 * @pdOid d931d57d-efe0-4a40-a60f-af15e7f0732a */
public class CasillasSegunda extends Casilla {
   /** @pdOid e3c6ab56-f882-4cb0-b466-05e01626f47f */
   private String casilla360;
   /** @pdOid 6f8ece0d-f6cb-417a-8896-8dbceafe38b9 */
   private String casilla361;
   
   /** @pdOid 3c491a9d-c2c9-437e-9de3-c8c90d24bfc9 */
   public String getCasilla360() {
      return casilla360;
   }
   
   /** @param newCasilla360
    * @pdOid be6751e3-34a6-4da1-980d-053fa262a031 */
   public void setCasilla360(String newCasilla360) {
      casilla360 = newCasilla360;
   }
   
   /** @pdOid 7936c52a-b84e-4ccf-960b-645a8cadc6a4 */
   public String getCasilla361() {
      return casilla361;
   }
   
   /** @param newCasilla361
    * @pdOid cdc0e7eb-760c-4085-bcef-922f462a1829 */
   public void setCasilla361(String newCasilla361) {
      casilla361 = newCasilla361;
   }

}