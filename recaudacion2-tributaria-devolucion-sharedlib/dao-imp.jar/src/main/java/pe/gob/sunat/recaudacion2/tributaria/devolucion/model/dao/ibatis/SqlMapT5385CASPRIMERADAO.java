/***********************************************************************
 * Module:  SqlMapT5385CASPRIMERADAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT5385CASPRIMERADAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasPrimera;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;

import java.util.*;

/** @pdOid 548b60a8-623f-4f1b-8d57-47a9f6f003bb */
@Repository
public class SqlMapT5385CASPRIMERADAO extends SqlMapPDTInternetDAO<CasillasPrimera> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5385CasPrimeraDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * 
    * @param model
    * @pdOid 9622bb5a-dd34-4838-8d2d-3b27afc7abbc */
   protected boolean isValidPK(CasillasPrimera model) {
      // TODO: implement
      return false;
   }
   
   /** @param filterBean
    * @pdOid f4fab363-69eb-4c37-8836-e54ee8ae67ba */
   public List<CasillasPrimera> findByNumeroSecuencia(ControlDeclaracion filterBean) {
      List<CasillasPrimera> casillas = getSqlMapClientTemplate()
      .queryForList(parseMapId("findByControlDeclaracion"),
            filterBean);
      return casillas;
   }

}