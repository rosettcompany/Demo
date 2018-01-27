/***********************************************************************
 * Module:  T8232InfoAyudaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T8232InfoAyudaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.InformacionAyuda;

import java.util.*;

/** @pdOid 91aa3cb1-8609-4ebb-a47b-9062cf3bdae7 */
public interface T8232InfoAyudaDAO extends TGenericDAO<InformacionAyuda> {
   /** Obtiene una lista de parámetros relacionados según el contexto de la aplicación.
    * 
    * @param contexto Código del contexto del cual se van a traer los parámetros.
    * @pdOid e60a534a-1512-4d4e-871a-46ae00330efd */
   List<NameValuePair> findBy(String contexto);

}