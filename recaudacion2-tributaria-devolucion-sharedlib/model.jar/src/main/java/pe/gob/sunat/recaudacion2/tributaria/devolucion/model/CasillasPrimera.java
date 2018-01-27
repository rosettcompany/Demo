/***********************************************************************
 * Module:  CasillasPrimera.java
 * Author:  jmazuelos
 * Purpose: Defines the Class CasillasPrimera
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** Model usado para almacenar las casilas de la tabla
 * T5385CASPRIMERA
 * 
 * @pdOid def74bac-cf78-4214-8381-97fa30b1ba99 */
public class CasillasPrimera extends Casilla {
   /** @pdOid a33b1b88-02c5-4ba1-b067-f0693d3d9671 */
   private String casilla159;
   /** @pdOid 141bcffa-3008-4425-b451-c94b39be07fe */
   private String casilla160;
   
   /** @pdOid 1222b866-b062-4c7b-befc-74a5c57557ab */
   public String getCasilla159() {
      return casilla159;
   }
   
   /** @param newCasilla159
    * @pdOid 81aa5532-6944-41db-a450-e73cee8c87d4 */
   public void setCasilla159(String newCasilla159) {
      casilla159 = newCasilla159;
   }
   
   /** @pdOid 998abf64-17f1-4c4b-b77d-aeb0222f1f8f */
   public String getCasilla160() {
      return casilla160;
   }
   
   /** @param newCasilla160
    * @pdOid 49712a68-4ae2-49ba-b210-74e98d73d5e9 */
   public void setCasilla160(String newCasilla160) {
      casilla160 = newCasilla160;
   }

}