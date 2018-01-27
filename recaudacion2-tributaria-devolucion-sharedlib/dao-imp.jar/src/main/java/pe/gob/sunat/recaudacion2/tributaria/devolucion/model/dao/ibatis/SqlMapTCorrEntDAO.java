/***********************************************************************
 * Module:  SqlMapTCorrEntDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapTCorrEntDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;
import java.util.*;

/** @pdOid 059b523b-ae95-4118-ba14-2a4c8493bdf1 */
@Repository
public class SqlMapTCorrEntDAO extends SqlMapRfiscaDAO<GenericModel> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TCorrEntDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid 31187f91-9e34-4fa4-ba8e-e69cd59a0526 */
   public boolean isValidPK(GenericModel model) {
      // TODO: implement
      return false;
   }
   
   /** Obtiene un número de correlativo según dependencia, y código
    * 
    * @param dependencia Código de dependencia
    * @param codigo Código de correlativo
    * @pdOid 547ac256-2874-43b2-8996-9d7506d2242f */
   public int obtenerCorrelativo(String dependencia, String codigo) {
      HashMap<String, String> has = new HashMap<String, String>();
      has.put("dependencia", dependencia);
      has.put("documento", codigo);
      Integer a = (Integer)getSqlMapClientTemplate().queryForObject(parseMapId("obtenerCorrelativo"),has);
      return a;
   }
   
   /** Actualiza el valorCorrelativo según la dependencia y código
    * 
    * @param dependencia Código de dependencia
    * @param codigo Código de correlativo
    * @param valorCorrelativo Valor a actualizar de correlativo
    * @pdOid e01aff3b-899a-45a1-9e2a-c0737d31ac30 */
   public void actualizarCorrelativo(String dependencia, String codigo, int valorCorrelativo) {
      HashMap<String, Object> has = new HashMap<String, Object>();
      has.put("dependencia", dependencia);
      has.put("documento", codigo);
      has.put("correlativo", valorCorrelativo);
      Integer a = (Integer)getSqlMapClientTemplate().update(parseMapId("update"),has);
   }
   
   /** Obtiene el ente al cual está asociado según tipoSolicitud, fecha y tributo
    * 
    * @param codigoTipoSolicitud Código del tipo de solicitud de devolución
    * @param codigoTributo Código del tributo del cual se solicita devolución
    * @param fecha Fecha desde la cual se desea consultar.
    * @pdOid f3cfefe7-fc44-48fb-b232-4c68132c6198 */
   public java.util.HashMap<String, String> obtenerEnte(String codigoTipoSolicitud, String codigoTributo, Date fecha) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("tipoSolicitud", codigoTipoSolicitud);
      datos.put("fecha", fecha);
      datos.put("tributo", codigoTributo);
      return (HashMap<String, String>)getSqlMapClientTemplate().queryForObject(parseMapId("obtenerEnte"), datos);
   }

}