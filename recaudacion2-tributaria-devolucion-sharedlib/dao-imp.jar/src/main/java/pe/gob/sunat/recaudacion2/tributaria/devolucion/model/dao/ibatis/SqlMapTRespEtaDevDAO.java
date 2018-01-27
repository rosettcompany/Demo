/***********************************************************************
 * Module:  SqlMapTRespEtaDevDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapTRespEtaDevDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ResponsableEtapa;
import java.util.*;

/** @pdOid a877beba-cd13-424f-ad9c-0d97b555affc */
@Repository
public class SqlMapTRespEtaDevDAO extends SqlMapRfiscaDAO<ResponsableEtapa> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TRespEtaDevDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid 35509965-b63f-46e8-af51-56aa8cf2aacd */
   public boolean isValidPK(ResponsableEtapa model) {
      // TODO: implement
      return false;
   }

}