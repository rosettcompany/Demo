/***********************************************************************
 * Module:  FormularioBase.java
 * Author:  jmazuelos
 * Purpose: Defines the Class FormularioBase
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid cee9fb8c-4c58-4dc8-80bc-aa99d3bc7731 */
public class FormularioBase implements GenericModel {
   /** @pdOid 4096a537-8dee-4e1b-b828-57ae5de635bf */
   private int numeroOrden;
   /** @pdOid ccab71cb-2fbf-467d-bfa0-4468b3ee3f61 */
   private String codigoFormulario;
   
   public int getNumeroOrden() {
      return numeroOrden;
   }
   public void setNumeroOrden(int numeroOrden) {
      this.numeroOrden = numeroOrden;
   }
   public String getCodigoFormulario() {
      return codigoFormulario;
   }
   public void setCodigoFormulario(String codigoFormulario) {
      this.codigoFormulario = codigoFormulario;
   }

   
   
}