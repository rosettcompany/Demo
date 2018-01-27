/***********************************************************************
 * Module:  ResponsableEtapa.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ResponsableEtapa
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** Registra al responsable del cambio de etapa de la devolución
 * 
 * @pdOid d0698e81-e95e-489c-80fd-7e57239d220f */
public class ResponsableEtapa implements GenericModel {
   /** @pdOid 89253915-56a1-40a9-875a-2a59a7775a7e */
   private int numeroCiclo;
   /** @pdOid 53cd6022-f1da-4b1b-8da1-d1c1dac4e3e4 */
   private String indicadorEtapa;
   /** @pdOid 184ba51c-92fe-4c7a-8def-ecfebff294f4 */
   private String codigoRegistroResponsable;
   /** @pdOid 57a6f8e2-a37f-4897-9ee0-e062d86469d2 */
   private Date fechaEtapa;
   
   /** @pdRoleInfo migr=no name=Devolucion assc=association5 mult=1..1 type=Composition */
   private Devolucion devolucion;

   public int getNumeroCiclo() {
      return numeroCiclo;
   }

   public void setNumeroCiclo(int numeroCiclo) {
      this.numeroCiclo = numeroCiclo;
   }

   public String getIndicadorEtapa() {
      return indicadorEtapa;
   }

   public void setIndicadorEtapa(String indicadorEtapa) {
      this.indicadorEtapa = indicadorEtapa;
   }

   public String getCodigoRegistroResponsable() {
      return codigoRegistroResponsable;
   }

   public void setCodigoRegistroResponsable(String codigoRegistroResponsable) {
      this.codigoRegistroResponsable = codigoRegistroResponsable;
   }

   public Date getFechaEtapa() {
      return fechaEtapa;
   }

   public void setFechaEtapa(Date fechaEtapa) {
      this.fechaEtapa = fechaEtapa;
   }

   public Devolucion getDevolucion() {
      return devolucion;
   }

   public void setDevolucion(Devolucion devolucion) {
      this.devolucion = devolucion;
   }
   
   
}