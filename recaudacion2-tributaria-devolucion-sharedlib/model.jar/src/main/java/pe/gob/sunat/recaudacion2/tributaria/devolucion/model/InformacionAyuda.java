/***********************************************************************
 * Module:  InformacionAyuda.java
 * Author:  jmazuelos
 * Purpose: Defines the Class InformacionAyuda
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import java.util.*;

/** @pdOid ccfee466-4ce5-4ab5-9a7f-816039c5f086 */
public class InformacionAyuda implements GenericModel {
   /** Determina el contexto al cual se aplican los textos de ayuda.
    * 
    * @pdOid 599238f4-ec31-4ef3-acf6-d31eadadad63 */
   private String contexto;
   /** Indica el tipo de registro (Cabecera o Detalle)
    * 
    * @pdOid 7ad16a3d-473f-4a82-943e-1d3c50dd896f */
   private String tipo;
   /** Código asignado al texto de ayuda
    * 
    * @pdOid 5ad7f30e-44e5-498e-bcc7-fc07fd0cb6c0 */
   private String codigoAyuda;
   /** Texto de ayuda
    * 
    * @pdOid 183eae16-ad78-4166-a719-bf71d3dd22b8 */
   private String descripcionAyuda;

}