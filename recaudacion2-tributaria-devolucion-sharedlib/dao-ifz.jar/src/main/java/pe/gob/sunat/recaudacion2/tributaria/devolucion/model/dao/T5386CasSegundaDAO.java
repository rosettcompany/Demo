/***********************************************************************
 * Module:  T5386CasSegundaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T5386CasSegundaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasSegunda;
import java.util.*;

/** @pdOid a18fb15a-0375-4019-8f52-e734abd168f7 */
public interface T5386CasSegundaDAO extends TGenericDAO<CasillasSegunda> {
   /** @param filterBean
    * @pdOid 186ecfdf-0d2e-4946-8aae-4e120710feb2 */
   List<CasillasSegunda> findByNumeroSecuencia(ControlDeclaracion filterBean);

}