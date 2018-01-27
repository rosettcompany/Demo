/***********************************************************************
 * Module:  SqlMapRfiscaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapRfiscaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid cd7e033b-c1d5-4c88-ae7c-2e42a3785142 */
public abstract class SqlMapRfiscaDAO <T extends GenericModel> extends SqlMapBaseDAO<T> {
   /** @pdOid c531da15-4c78-4eb3-85ea-a48a5755c7f3 */
   @Autowired
   private SqlMapClient sqlMapRfiscaDAO;
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid 6b0054d4-ba18-486d-8591-305d3b2637bc */
   @Autowired
   public void init() {
      setSqlMapClient(sqlMapRfiscaDAO);
      sqlMapName = obtenerNombreTabla();
   }

}