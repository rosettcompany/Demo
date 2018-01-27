/***********************************************************************
 * Module:  HvpDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface HvpDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Hvp;
import java.util.*;

/** @pdOid 34161fa4-9c20-4307-94d4-d994951c1607 */
public interface HvpDAO extends TGenericDAO<Hvp> {
   /** Obtiene todos los registros HVP según ruc y lista de Tributos
    * 
    * @param ruc Número de ruc del contribuyente
    * @param tributos Lista de tributos a verificar
    * @pdOid 6289581b-aca3-4828-ae2d-58a83b49cbb6 */
   List<Hvp> findByRucTributos(String ruc, String[] tributos);

}