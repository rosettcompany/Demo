/***********************************************************************
 * Module:  SqlMapT8232InfoAyudaDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT8232InfoAyudaDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.InformacionAyuda;
import java.util.*;

/** @pdOid d6cd2024-7610-4dc1-9baf-620728a174bc */
@Repository
public class SqlMapT8232InfoAyudaDAO extends SqlMapRfiscaDAO<InformacionAyuda> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T8232InfoAyudaDAO {
   /** Obtiene una lista de parámetros relacionados según el contexto de la aplicación.
    * 
    * @param contexto Código del contexto del cual se van a traer los parámetros.
    * @pdOid 691334af-707a-4b39-b122-2c3f100e196b */
   public List<NameValuePair> findBy(String contexto) {
      // TODO: implement
      return null;
   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid ae1ece8c-ac1d-45c0-85fd-3f8ce00dbcb7 */
   public boolean isValidPK(InformacionAyuda model) {
      // TODO: implement
      return false;
   }

}