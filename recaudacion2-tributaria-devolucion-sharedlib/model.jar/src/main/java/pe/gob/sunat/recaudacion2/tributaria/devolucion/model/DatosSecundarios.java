/***********************************************************************
 * Module:  DatosSecundarios.java
 * Author:  jmazuelos
 * Purpose: Defines the Class DatosSecundarios
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** Datos Secundarios del contribuyente
 * 
 * @pdOid 2ec5c8c3-612c-4166-af7f-1c7acfab1789 */
public class DatosSecundarios extends Contribuyente {
   /** Tipo de documento de identidad registrado por el contribuyente (campo dds_docide)
    * 
    * @pdOid 0510e90a-c157-4c72-bcb7-d14c181b82d5 */
   private String tipoDocumentoIdentidad;
   /** Motivo de baja del contribuyente (campo dds_motbaj)
    * 
    * @pdOid 836919c6-dd6e-499a-bb4e-d8541f60466e */
   private String motivoDeBaja;
   
   /** @pdOid d81f004c-f766-4295-803f-50e6bcb4c48d */
   public String getTipoDocumentoIdentidad() {
      return tipoDocumentoIdentidad;
   }
   
   /** @param newTipoDocumentoIdentidad
    * @pdOid f6686a40-30e9-4c6a-8745-35944f256d51 */
   public void setTipoDocumentoIdentidad(String newTipoDocumentoIdentidad) {
      tipoDocumentoIdentidad = newTipoDocumentoIdentidad;
   }
   
   /** @pdOid 712ee23f-f937-4dfb-8923-bca5bb9674ef */
   public String getMotivoDeBaja() {
      return motivoDeBaja;
   }
   
   /** @param newMotivoDeBaja
    * @pdOid 63a79a52-6e31-46fe-af97-55d5d96eccbb */
   public void setMotivoDeBaja(String newMotivoDeBaja) {
      motivoDeBaja = newMotivoDeBaja;
   }

}