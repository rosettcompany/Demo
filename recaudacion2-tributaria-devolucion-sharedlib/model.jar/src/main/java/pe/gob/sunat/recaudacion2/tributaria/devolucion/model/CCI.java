/***********************************************************************
 * Module:  CCI.java
 * Author:  jmazuelos
 * Purpose: Defines the Class CCI
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid 6841d930-eff1-4b9f-9b57-506e577497c7 */
public class CCI implements GenericModel {
   /** Código de Cuenta Interbancario del cual se ha verificado su titularidad.
    * 
    * @pdOid d70addaa-5269-4e9f-8040-c67985c6cd36 */
   private String codigoCCI;
   /** Tipo de documento del contribuyente titular de la cuenta bancaria con CCI
    * 
    * @pdOid ba162544-7d8e-47be-9d0c-e0118bed79b4 */
   private String tipoDocumentoIdentidad;
   /** Número de documento del contribuyente titular de la cuenta bancaria con CCI
    * 
    * @pdOid ac8cabe6-8c66-4d9b-aedb-4ad1f33c51b7 */
   private String numeroDocumentoIdentidad;
   /** Determina si el CCI verificado se encuentra activo (1) o no (0).
    * 
    * @pdOid d290b308-be23-4fb2-8851-a369e7d8c1f3 */
   private int indicadorActivo;
   public String getCodigoCCI() {
      return codigoCCI;
   }
   public void setCodigoCCI(String codigoCCI) {
      this.codigoCCI = codigoCCI;
   }
   public String getTipoDocumentoIdentidad() {
      return tipoDocumentoIdentidad;
   }
   public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
      this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
   }
   public String getNumeroDocumentoIdentidad() {
      return numeroDocumentoIdentidad;
   }
   public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
      this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
   }
   public int getIndicadorActivo() {
      return indicadorActivo;
   }
   public void setIndicadorActivo(int indicadorActivo) {
      this.indicadorActivo = indicadorActivo;
   }

   
}