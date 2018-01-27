/***********************************************************************
 * Module:  ContribuyenteService.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface ContribuyenteService
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DatosSecundarios;
import java.util.*;

/** @pdOid 35da13ac-3318-4bb5-b2eb-395da193e372 */
public interface ContribuyenteService {
   /** Determina si el contribuyente es persona natural. Devuelve TRUE en caso de ser persona natural, en caso contrario devuelve FALSE
    * 
    * @param ruc
    * @pdOid 5148b804-8f42-4b8c-b0d5-317293a8d10f */
   boolean isPersonaNatural(String ruc);
   /** Devuelve el tipo de documento registrado en el padrón RUC para el contribuyente con el numero de ruc indicado.
    * 
    * @param ruc Número de RUC del contribuyente
    * @pdOid 4aac3e12-0483-40fb-9ae1-fcbb8865382a */
   String tipoDocumentoRegistradoPadronRuc(String ruc);
   /** Obtiene los datos secundarios del contribuyente según su numeroRUC
    * 
    * @param numeroRUC Número de RUC
    * @pdOid f5705d87-6579-47b3-b632-a9c13f65f470 */
   DatosSecundarios obtenerDatosSecundarios(String numeroRUC);

}