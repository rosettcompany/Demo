/***********************************************************************
 * Module:  Hvp.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Hvp
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid c765e5d1-10ad-4fef-b64e-1ecdc3d82027 */
public class Hvp implements GenericModel {
   /** @pdOid 374ec4dc-a58b-4f54-9ffb-9532f06a9f2f */
   private String numeroRuc;
   /** @pdOid f3964fa9-3981-41b2-a505-99013bdd45e3 */
   private String codigoTributario;
   /** @pdOid a578d20a-cf0e-4c7c-a83d-ebe33458113a */
   private Date fechaVigencia;
   private Date fechaBaja;
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
   public Date getFechaBaja() {
      return fechaBaja;
   }
   public void setFechaBaja(Date fechaBaja) {
      this.fechaBaja = fechaBaja;
   }

   
   
}