/***********************************************************************
 * Module:  SqlMapT5847CTLDECLDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT5847CTLDECLDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import java.util.*;

/** @pdOid f8e8b795-6bf8-4d73-b865-91712e41197b */
@Repository
public class SqlMapT5847CTLDECLDAO extends SqlMapPDTInternetDAO<ControlDeclaracion> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5847CtlDeclDAO {
   /** Permite buscar una declración en función de los atributos enviados 
    * en el parámetro 
    * 
    * @param filterBean Objeto de declracion usado como filtro
    * para la consulta de declaraciones.
    * @pdOid 2e4a0528-b363-47cc-b5f3-1d0b8706ea7e */
   public List<ControlDeclaracion> findByControlDeclaracion(ControlDeclaracion filterBean) {
      List<ControlDeclaracion> query = getSqlMapClientTemplate().queryForList(parseMapId("findByControlDeclaracion"),filterBean);
      return query;
   }
   
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid e34c58ae-b124-4bc1-9eed-88054ca95bf7 */
   public boolean isValidPK(ControlDeclaracion model) {
      // TODO: implement
      return false;
   }

}