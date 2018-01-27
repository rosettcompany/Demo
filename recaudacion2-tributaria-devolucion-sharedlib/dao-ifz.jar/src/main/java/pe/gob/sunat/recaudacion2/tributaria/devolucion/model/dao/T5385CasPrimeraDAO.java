/***********************************************************************
 * Module:  T5385CasPrimeraDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T5385CasPrimeraDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasPrimera;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import java.util.*;

/** @pdOid 3c2e0b80-77b2-47d2-a211-f6b41fbdaa3f */
public interface T5385CasPrimeraDAO extends TGenericDAO<CasillasPrimera> {
   /** @param filterBean
    * @pdOid aac5f058-dc81-46ea-86ca-fa999d2ae807 */
   List<CasillasPrimera> findByNumeroSecuencia(ControlDeclaracion filterBean);

}