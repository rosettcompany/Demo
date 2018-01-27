/***********************************************************************
 * Module:  SqlMapPDTInternetDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapPDTInternetDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid a61e29a6-0449-4629-8233-c3194ee31137 */
public abstract class SqlMapPDTInternetDAO <T extends GenericModel> extends SqlMapBaseDAO<T> {
   /** @pdOid c039492a-6f5d-42aa-bfd5-ffc41bd42091 */
   @Autowired
   private SqlMapClient sqlMapPDTInternetDAO;
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid bbadf272-e0e5-493b-b15c-9828b3e12124 */
   @Autowired
   public void init() {
      setSqlMapClient(sqlMapPDTInternetDAO);
      sqlMapName = obtenerNombreTabla();
   }

}