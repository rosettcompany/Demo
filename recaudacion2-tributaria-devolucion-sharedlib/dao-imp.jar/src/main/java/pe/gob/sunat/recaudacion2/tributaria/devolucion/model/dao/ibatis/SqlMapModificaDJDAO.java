/***********************************************************************
 * Module:  SqlMapModificaDJDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapModificaDJDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid dd6473ee-6820-446a-aee6-d6a972b5c4b4 */
public abstract class SqlMapModificaDJDAO <T extends GenericModel> extends SqlMapBaseDAO<T> {
   /** @pdOid 66ac592b-8902-4e31-b19c-dd618c2fd865 */
   @Autowired
   private SqlMapClient sqlMapModificaDJDAO;
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid f94f37ec-0be7-4917-a33b-fa5a6c90da67 */
   @Autowired
   public void init() {
      setSqlMapClient(sqlMapModificaDJDAO);
      sqlMapName = obtenerNombreTabla();
   }

}