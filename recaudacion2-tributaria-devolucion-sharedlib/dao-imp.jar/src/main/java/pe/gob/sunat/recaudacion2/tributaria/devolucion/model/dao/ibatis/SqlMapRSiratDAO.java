/***********************************************************************
 * Module:  SqlMapRSiratDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapRSiratDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid 6ce597dd-5ea4-4062-8875-849acf880b08 */
public abstract class SqlMapRSiratDAO <T extends GenericModel> extends SqlMapBaseDAO<T> {
   /** @pdOid 7fe3b788-9433-485d-b40e-64aeea98f3ac */
   @Autowired
   private SqlMapClient sqlMapRSiratDAO;
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid d1cd4bc7-2452-4f35-b64a-09ab661c58cb */
   @Autowired
   public void init() {
      setSqlMapClient(sqlMapRSiratDAO);
      sqlMapName = obtenerNombreTabla();
   }

}