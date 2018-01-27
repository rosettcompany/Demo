/***********************************************************************
 * Module:  SqlMapDevolucionesDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapDevolucionesDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion;
import java.util.*;

/** @pdOid 978a24bb-126e-4f9c-b009-d1e4203f5e32 */
@Repository
public class SqlMapDevolucionesDAO extends SqlMapRfiscaDAO<Devolucion> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.DevolucionesDAO {
   /** Busca las devoluciones coincidentes
    * 
    * @param filterBean Bean usado para el filtro de devoluciones
    * @pdOid cfa01a95-1651-4b6e-9f9e-584a78017293 */
   public List<Devolucion> findByDevolucion(Devolucion filterBean) {
       List<Devolucion> devoluciones = getSqlMapClientTemplate()
               .queryForList("devoluciones.findByDevolucion", filterBean);
      return devoluciones;
   }
   
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid c3560224-feec-4585-91aa-da724c50efb0 */
   public boolean isValidPK(Devolucion model) {
      // TODO: implement
      return false;
   }

}