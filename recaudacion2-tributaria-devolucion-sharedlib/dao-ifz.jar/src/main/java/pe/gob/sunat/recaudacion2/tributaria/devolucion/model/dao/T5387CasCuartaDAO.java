/***********************************************************************
 * Module:  T5387CasCuartaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T5387CasCuartaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasCuarta;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import java.util.*;

/** @pdOid b14a619f-a574-49c4-baf0-63286f4c123e */
public interface T5387CasCuartaDAO extends TGenericDAO<CasillasCuarta> {
   /** @param filterBean
    * @pdOid 7c9ef6a6-308c-46de-a729-609921a36e6b */
   List<CasillasCuarta> findByNumeroSecuencia(ControlDeclaracion filterBean);

}