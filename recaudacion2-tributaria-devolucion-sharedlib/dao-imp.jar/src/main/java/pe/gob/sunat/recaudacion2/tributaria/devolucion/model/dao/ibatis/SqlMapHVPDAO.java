/***********************************************************************
 * Module:  SqlMapHVPDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapHVPDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Hvp;
import java.util.*;

/** @pdOid 339959b1-a66c-4753-9f42-3605976ac4cd */
@Repository
public class SqlMapHVPDAO extends SqlMapRecaudaDAO<Hvp> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.HvpDAO {
   /** Obtiene todos los registros HVP según ruc y lista de Tributos
    * 
    * @param ruc Número de ruc del contribuyente
    * @param tributos Lista de tributos a verificar
    * @pdOid 37147fdc-3fcd-4671-83e9-4469301958ae */
   public List<Hvp> findByRucTributos(String ruc, String[] tributos) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      datos.put("codtri", tributos);
      List<Hvp> query = getSqlMapClientTemplate().queryForList("hvp.findByRucTributos",datos);
      return query;
   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid fe1155f7-cedf-45c4-b093-a8aba021524c */
   public boolean isValidPK(Hvp model) {
      // TODO: implement
      return false;
   }

}