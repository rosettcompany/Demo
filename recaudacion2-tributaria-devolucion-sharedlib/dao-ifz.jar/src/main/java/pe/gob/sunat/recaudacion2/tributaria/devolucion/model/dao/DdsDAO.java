/***********************************************************************
 * Module:  DdsDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface DdsDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DatosSecundarios;
import java.util.*;

/** @pdOid 3519b1cc-75ee-4300-bdbf-551e448dfb0b */
public interface DdsDAO extends TGenericDAO<DatosSecundarios> {
   /** Obtiene los datos secundarios del contribuyente con numeroRUC.
    * 
    * @param numeroRUC Número de RUC del contribuyente
    * @pdOid b69a6cd0-d152-407d-a9f9-20bd29eb19b5 */
   DatosSecundarios findDatosSecundariosByRuc(String numeroRUC);

}