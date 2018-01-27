/***********************************************************************
 * Module:  SqlMapT8001CCIDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT8001CCIDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CCI;
import java.util.*;

/** @pdOid 00eae256-54b5-416d-9796-ef798067016a */
@Repository
public class SqlMapT8001CCIDAO extends SqlMapRfiscaDAO<CCI> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T8001cciDAO {
   /** Obtiene una lista de CCI que han sido registrados por el contribuyente en Solicitudes de Devolución anteriores y que se haya verificado la titularidad de los mismos.
    * 
    * @param ruc
    * @pdOid 3004d728-1108-446c-841c-ac2f5674c01b */
   public List<CCI> buscarCciPorRuc(String ruc) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      List<CCI> query = getSqlMapClientTemplate().queryForList("t8001.buscarCciPorRuc",datos);
      return query;   
   }
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 55dd1ec7-2ac7-44de-a964-cbc954e46fa4 */
   public boolean isValidPK(CCI model) {
      // TODO: implement
      return false;
   }

}