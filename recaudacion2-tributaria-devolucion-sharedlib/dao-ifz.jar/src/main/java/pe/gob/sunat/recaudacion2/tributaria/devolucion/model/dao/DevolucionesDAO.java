/***********************************************************************
 * Module:  DevolucionesDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface DevolucionesDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion;
import java.util.*;

/** @pdOid ea058eb2-5886-4c28-94a6-1c7b398db485 */
public interface DevolucionesDAO extends TGenericDAO<Devolucion> {
   /** Busca las devoluciones coincidentes
    * 
    * @param filterBean Bean usado para el filtro de devoluciones
    * @pdOid 7dbd6504-2484-4664-b438-59aba6c84a65 */
   List<Devolucion> findByDevolucion(Devolucion filterBean);

}