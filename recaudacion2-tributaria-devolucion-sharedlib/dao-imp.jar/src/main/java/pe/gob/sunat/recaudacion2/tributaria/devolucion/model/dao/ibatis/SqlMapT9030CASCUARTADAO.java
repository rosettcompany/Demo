/***********************************************************************
 * Module:  SqlMapT9030CASCUARTADAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT9030CASCUARTADAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasCuarta;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;

import java.util.*;

/** @pdOid 7cc7d54a-f76a-4e84-bf59-baeada7cf246 */
@Repository
public class SqlMapT9030CASCUARTADAO extends SqlMapPDTInternetDAO<CasillasCuarta> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T9030CasCuartaDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * 
    * @param model
    * @pdOid 94cb2c7e-4924-4d84-8b0e-ed81e66ab492 */
   protected boolean isValidPK(CasillasCuarta model) {
      // TODO: implement
      return false;
   }
   
   /** @param filterBean
    * @pdOid 3e6805d4-ef75-42e5-9456-db55da01fe0c */
   public List<CasillasCuarta> findByNumeroSecuencia(ControlDeclaracion filterBean) {
      List<CasillasCuarta> casillas = getSqlMapClientTemplate()
      .queryForList(parseMapId("findByControlDeclaracion"),
            filterBean);
      return casillas;
   }

}