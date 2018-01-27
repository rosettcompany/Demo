/***********************************************************************
 * Module:  SqlMapCasdevDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapCasdevDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillaDevolucion;
import java.util.*;

/** @pdOid 86ef38ed-cc6e-45aa-a6d8-9d0a803b5b21 */
@Repository
public class SqlMapCasdevDAO extends SqlMapRfiscaDAO<CasillaDevolucion> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.CasDevDAO {
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 21265395-969d-46e4-b146-26f44bc7fc08 */
   public boolean isValidPK(CasillaDevolucion model) {
      // TODO: implement
      return false;
   }

}