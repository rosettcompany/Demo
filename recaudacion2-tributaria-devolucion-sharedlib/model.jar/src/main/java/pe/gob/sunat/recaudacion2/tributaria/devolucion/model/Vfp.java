/***********************************************************************
 * Module:  Vfp.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Vfp
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid da80d1b7-3fba-4172-9192-6ab3df40ecf9 */
public class Vfp implements GenericModel {
   /** @pdOid 5d5235a1-17a3-4991-a3e0-6a25952499e3 */
   private String numeroRuc;
   /** @pdOid 5149cfa8-5c72-4d22-8b0c-594d40c28ee5 */
   private String codigoTributario;
   /** @pdOid 9632bca5-fa09-447a-a3a7-0d90788700aa */
   private Date fechaVigencia;
   
   public String getNumeroRuc() {
      return numeroRuc;
   }
   public void setNumeroRuc(String numeroRuc) {
      this.numeroRuc = numeroRuc;
   }
   public String getCodigoTributario() {
      return codigoTributario;
   }
   public void setCodigoTributario(String codigoTributario) {
      this.codigoTributario = codigoTributario;
   }
   public Date getFechaVigencia() {
      return fechaVigencia;
   }
   public void setFechaVigencia(Date fechaVigencia) {
      this.fechaVigencia = fechaVigencia;
   }

   
   
}