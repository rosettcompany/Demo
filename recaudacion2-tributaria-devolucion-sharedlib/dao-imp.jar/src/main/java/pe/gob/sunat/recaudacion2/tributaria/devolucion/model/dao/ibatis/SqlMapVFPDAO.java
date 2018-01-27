/***********************************************************************
 * Module:  SqlMapVFPDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapVFPDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Vfp;
import java.util.*;

/** @pdOid 54e4d183-48e4-43c7-b78e-208f21298fc5 */
@Repository
public class SqlMapVFPDAO extends SqlMapRecaudaDAO<Vfp> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.VfpDAO {
   /** Obtiene todos los registros VFP según ruc y lista de Tributos
    * 
    * @param ruc Número de ruc del contribuyente
    * @param tributos Lista de tributos a verificar
    * @pdOid e72bfcc2-a3aa-4018-aabd-915601144c93 */
   public List<Vfp> findByRucTributos(String ruc, String[] tributos) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      datos.put("codtri", tributos);
      List<Vfp> query = getSqlMapClientTemplate().queryForList("vfp.findByRucTributos",datos);
      return query;

   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 20e5094a-bdf1-47ac-a1aa-32d576b58a21 */
   public boolean isValidPK(Vfp model) {
      // TODO: implement
      return false;
   }
   
}