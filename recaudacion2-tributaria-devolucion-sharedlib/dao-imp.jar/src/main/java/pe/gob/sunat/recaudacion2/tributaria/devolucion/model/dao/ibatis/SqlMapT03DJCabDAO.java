/***********************************************************************
 * Module:  SqlMapT03DJCabDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT03DJCabDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DeclaracionDeterminativa;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Vfp;

import java.util.*;

/** @pdOid f6c07a41-02dc-49fe-88d5-cfc053f86084 */
@Repository
public class SqlMapT03DJCabDAO extends SqlMapRecaudaDAO<DeclaracionDeterminativa> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T03DJCabDAO {
   /** Obtiene la cantidad de formularios presentados según ruc y periodo.
    * 
    * @param ruc 
    * @param periodo 
    * @param formularios
    * @pdOid 07b2ce83-c5fb-4e30-b1c0-914a0eb45046 */
   public List<DeclaracionDeterminativa> findByRucPerFor(String ruc, String periodo, String[] formularios) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("ruc", ruc);
      datos.put("periodo", periodo);
      datos.put("codfor", formularios);
      List<DeclaracionDeterminativa> query = getSqlMapClientTemplate().queryForList("t03.findByRucPerFor",datos);
      return query;
   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 076417d6-1970-452c-89ee-3924ad0782be */
   public boolean isValidPK(DeclaracionDeterminativa model) {
      // TODO: implement
      return false;
   }

}