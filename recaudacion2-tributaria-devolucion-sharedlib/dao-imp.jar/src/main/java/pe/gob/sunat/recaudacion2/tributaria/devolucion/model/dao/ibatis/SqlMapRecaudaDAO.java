/***********************************************************************
 * Module:  SqlMapRecaudaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapRecaudaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid 1498e1cd-46f0-4270-8afc-0ebc26ccad0d */
public abstract class SqlMapRecaudaDAO <T extends GenericModel> extends SqlMapBaseDAO<T> {
   /** @pdOid 4217c928-f81e-4d00-bd47-4152b6f12a42 */
   @Autowired
   private SqlMapClient sqlMapRecaudaDAO;
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid e6785d81-bb4b-4445-bb49-7cc16d8907bf */
   @Autowired
   public void init() {
      setSqlMapClient(sqlMapRecaudaDAO);
      sqlMapName = obtenerNombreTabla();
   }

}