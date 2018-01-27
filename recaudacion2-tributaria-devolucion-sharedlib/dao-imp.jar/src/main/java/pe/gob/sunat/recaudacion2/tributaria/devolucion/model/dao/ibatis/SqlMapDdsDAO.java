/***********************************************************************
 * Module:  SqlMapDdsDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapDdsDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DatosSecundarios;
import java.util.*;

/** @pdOid 567070b2-e96d-4428-9efc-163b9245b808 */
//@Repository
public class SqlMapDdsDAO extends SqlMapRecaudaDAO<DatosSecundarios> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.DdsDAO {
   /** Obtiene los datos secundarios del contribuyente con numeroRUC.
    * 
    * @param numeroRUC Número de RUC del contribuyente
    * @pdOid 7af8c42d-c3d9-4fe2-9b56-046d3f517731 */
   public DatosSecundarios findDatosSecundariosByRuc(String numeroRUC) {
      DatosSecundarios dda = (DatosSecundarios)getSqlMapClientTemplate().queryForObject(parseMapId("findByPK"),numeroRUC);
      return dda;
   }
   
   /** Determina si el objeto cumple con tener datos en los atributos que conforman su llave primaria
    * 
    * @param model
    * @pdOid 14bd8ed5-0c94-4a0b-8eff-d182dc18de1d */
   public boolean isValidPK(DatosSecundarios model) {
      // TODO: implement
      return false;
   }

}