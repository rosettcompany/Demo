/***********************************************************************
 * Module:  SqlMapParamLocalDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapParamLocalDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import java.util.*;

/** @pdOid 20f506db-945c-4ca0-8d28-8859a20c734b */
@Repository
public class SqlMapParamLocalDAO extends SqlMapRfiscaDAO<GenericModel> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ParamLocalDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid 12a096c1-252d-488c-87eb-624be83ecca5 */
   public boolean isValidPK(GenericModel model) {
      // TODO: implement
      return false;
   }
   
   /** Obtiene un registro del parámetro según código de parámetro y dependencia.
    * 
    * @param codigo Código del parámetro local
    * @param dependencia Código de dependencia de la param local
    * @pdOid 1d7db011-84a5-42a9-a35c-f4a1a5f85df0 */
   public NameValuePair getNameValuePairByDependencia(String codigo, String dependencia) {
      HashMap<String, String> datos = new HashMap<String, String>();
      datos.put("codigo", codigo);
      datos.put("dependencia", dependencia);
      return (NameValuePair)getSqlMapClientTemplate().queryForObject("paramlocal.getNameValuePair",datos);
   }

}