/***********************************************************************
 * Module:  VfpDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface VfpDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Vfp;
import java.util.*;

/** @pdOid 9439769f-4914-4d8b-b612-da0de87af9e9 */
public interface VfpDAO extends TGenericDAO<Vfp> {
   /** Obtiene todos los registros VFP según ruc y lista de Tributos
    * 
    * @param ruc Número de ruc del contribuyente
    * @param tributos Lista de tributos a verificar
    * @pdOid 289393c1-23f6-4034-a5ed-8903779367fd */
   List<Vfp> findByRucTributos(String ruc, String[] tributos);

}