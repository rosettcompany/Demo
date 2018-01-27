/***********************************************************************
 * Module:  SqlMapT5386CASSEGUNDADAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT5386CASSEGUNDADAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasSegunda;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import java.util.*;

/** @pdOid e6bdbc66-8622-47a6-9ebc-4e67b36c1401 */
@Repository
public class SqlMapT5386CASSEGUNDADAO extends SqlMapPDTInternetDAO<CasillasSegunda> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5386CasSegundaDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * 
    * @param model
    * @pdOid 983206de-5c3a-4f84-87d6-286d911473cc */
   protected boolean isValidPK(CasillasSegunda model) {
      // TODO: implement
      return false;
   }
   
   /** @param filterBean
    * @pdOid a2c06b46-124d-4492-afc4-16c4afdf023c */
   public List<CasillasSegunda> findByNumeroSecuencia(ControlDeclaracion filterBean) {
      List<CasillasSegunda> casillas = getSqlMapClientTemplate()
      .queryForList(parseMapId("findByControlDeclaracion"),
            filterBean);
      return casillas;
   }

}