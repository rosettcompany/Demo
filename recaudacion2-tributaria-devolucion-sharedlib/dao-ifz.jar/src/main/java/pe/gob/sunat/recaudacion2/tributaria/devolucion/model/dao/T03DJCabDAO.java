/***********************************************************************
 * Module:  T03DJCabDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T03DJCabDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DeclaracionDeterminativa;
import java.util.*;

/** @pdOid 682925f0-8943-450f-b2d9-bf4e5af1d2ac */
public interface T03DJCabDAO extends TGenericDAO<DeclaracionDeterminativa> {
   /** Obtiene la cantidad de formularios presentados según ruc y periodo.
    * 
    * @param ruc 
    * @param periodo 
    * @param formularios
    * @pdOid 3fe4c3fe-e427-423d-aff8-4133584035dd */
   List<DeclaracionDeterminativa> findByRucPerFor(String ruc, String periodo, String[] formularios);

}