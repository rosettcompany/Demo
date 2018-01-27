/***********************************************************************
 * Module:  SqlMapT3617DctosAsocDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT3617DctosAsocDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DocumentoAsociado;
import java.util.*;

/** @pdOid 7529959e-20bc-45db-b306-98bdbe882702 */
@Repository
public class SqlMapT3617DctosAsocDAO extends SqlMapRfiscaDAO<DocumentoAsociado> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T3617DctosAsocDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid b979e888-cde6-4511-9fb1-53fec06f67f8 */
   public boolean isValidPK(DocumentoAsociado model) {
      // TODO: implement
      return false;
   }

}