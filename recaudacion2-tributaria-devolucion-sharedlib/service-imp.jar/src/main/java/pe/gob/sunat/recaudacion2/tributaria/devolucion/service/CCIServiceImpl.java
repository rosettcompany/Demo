/***********************************************************************
 * Module:  CCIServiceImpl.java
 * Author:  jmazuelos
 * Purpose: Defines the Class CCIServiceImpl
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T8001cciDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.framework.spring.util.jdbc.datasource.lookup.DataSourceContextHolder;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CCI;
import java.util.*;

/** @pdOid 478be092-8207-407a-ab09-d4c02dbe0ed2 */
@Service
public class CCIServiceImpl implements CCIService {
   /** @pdRoleInfo migr=no name=T8001cciDAO assc=association16 mult=1..1 */
   @Autowired
   private T8001cciDAO t8001cciDAO;
   
   /** Obtiene una lista con los CCI que han sido validados y se ha verificado la titularidad según el ruc.
    * 
    * @param ruc Número de RUC del contribuyente del cual se va a traer los CCI que tiene registrado y se ha verificado su titularidad.
    * @pdOid 5b912719-0783-4b22-8a68-c05a15187db2 */
   public List<CCI> obtenerCciValidadosPorRuc(String ruc) {
      DataSourceContextHolder.setKeyDataSource(Constantes.DATASOURCE_READ_KEY);
      return t8001cciDAO.buscarCciPorRuc(ruc);
   }

}