/***********************************************************************
 * Module:  TCorrEntDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface TCorrEntDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import java.util.*;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

/** @pdOid 74da04a8-9b19-4118-8bdf-6752e235d2dd */
public interface TCorrEntDAO extends TGenericDAO<GenericModel> {
   /** Obtiene un número de correlativo según dependencia, y código
    * 
    * @param dependencia Código de dependencia
    * @param codigo Código de correlativo
    * @pdOid fce9d5ad-68c0-4f15-b687-9c9fc95de920 */
   int obtenerCorrelativo(String dependencia, String codigo);
   /** Actualiza el valorCorrelativo según la dependencia y código
    * 
    * @param dependencia Código de dependencia
    * @param codigo Código de correlativo
    * @param valorCorrelativo Valor a actualizar de correlativo
    * @pdOid 9d596c64-c742-43d2-af14-2062d4847b27 */
   void actualizarCorrelativo(String dependencia, String codigo, int valorCorrelativo);
   /** Obtiene el ente al cual está asociado según tipoSolicitud, fecha y tributo
    * 
    * @param codigoTipoSolicitud Código del tipo de solicitud de devolución
    * @param codigoTributo Código del tributo del cual se solicita devolución
    * @param fecha Fecha desde la cual se desea consultar.
    * @pdOid f4920e3a-50a3-4b76-9102-afc213603391 */
   java.util.HashMap<String, String> obtenerEnte(String codigoTipoSolicitud, String codigoTributo, Date fecha);

}