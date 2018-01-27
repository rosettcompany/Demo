/***********************************************************************
 * Module:  CCIService.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface CCIService
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CCI;
import java.util.*;

/** Service que contiene las operaciones relacioandas a CCI
 * 
 * @pdOid 52bfbdc3-6908-4d9d-8fd5-7029e1336b7f */
public interface CCIService {
   /** Obtiene una lista con los CCI que han sido validados y se ha verificado la titularidad según el ruc.
    * 
    * @param ruc Número de RUC del contribuyente del cual se va a traer los CCI que tiene registrado y se ha verificado su titularidad.
    * @pdOid fe65f48a-782a-4feb-8d0a-298a661d3b71 */
   List<CCI> obtenerCciValidadosPorRuc(String ruc);

}