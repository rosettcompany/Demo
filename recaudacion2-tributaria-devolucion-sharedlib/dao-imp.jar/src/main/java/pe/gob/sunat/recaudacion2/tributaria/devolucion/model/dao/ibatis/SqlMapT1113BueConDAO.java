/***********************************************************************
 * Module:  SqlMapT1113BueConDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT1113BueConDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.sql.SQLException;
import java.util.*;
import java.math.BigDecimal;

/** @pdOid 639debb5-4dca-462b-b245-0f7c979ab31d */
@Repository
public class SqlMapT1113BueConDAO extends SqlMapRecaudaDAO<GenericModel> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T1113BueConDAO {
   /** Obtiene la cantidad de registros en la tabla t1113buecon para el ruc especificado como parámetro.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @throws SQLException 
    * @pdOid 41c71d5d-a484-4ab4-9cda-29ed9d4aabc7 */
   public int obtenerCantidadRegistros(String ruc) throws SQLException {
      BigDecimal bg1 = new BigDecimal(0);

      HashMap<String, Object> query =  (HashMap<String, Object>)getSqlMapClient().queryForObject("t1113.obtenerCantidadRegistros",ruc);
      bg1 = (BigDecimal)query.get("cant1113") ;
      //Integer cantidad = (Integer)query.get("cant1113") ;
      Integer cantidad = bg1.intValue();
      return cantidad;
   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 58fa7e0b-3390-4f22-b325-5a22a79bc2ad */
   public boolean isValidPK(GenericModel model) {
      // TODO: implement
      return false;
   }

}