/***********************************************************************
 * Module:  T1113BueConDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T1113BueConDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import java.sql.SQLException;
import java.util.*;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

/** @pdOid 91118f16-0f50-4dea-930c-1a84db647915 */
public interface T1113BueConDAO extends TGenericDAO<GenericModel> {
   /** Obtiene la cantidad de registros en la tabla t1113buecon para el ruc especificado como parámetro.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @throws SQLException 
    * @pdOid 6fb84e5c-4914-4994-af6d-5ee45a82f9fc */
   int obtenerCantidadRegistros(String ruc) throws SQLException;

}