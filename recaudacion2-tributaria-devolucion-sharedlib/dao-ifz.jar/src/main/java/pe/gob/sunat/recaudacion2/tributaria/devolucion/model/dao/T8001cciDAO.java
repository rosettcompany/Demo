/***********************************************************************
 * Module:  T8001cciDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T8001cciDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CCI;
import java.util.*;

/** @pdOid 626d44d8-7d61-457e-bc8a-bbbfac99f8b4 */
public interface T8001cciDAO extends TGenericDAO<CCI> {
   /** Obtiene una lista de CCI que han sido registrados por el contribuyente en Solicitudes de Devolución anteriores y que se haya verificado la titularidad de los mismos.
    * 
    * @param ruc
    * @pdOid 3e8e1902-6a5d-46c4-b4ed-97e4e0bdfb26 */
   List<CCI> buscarCciPorRuc(String ruc);

}