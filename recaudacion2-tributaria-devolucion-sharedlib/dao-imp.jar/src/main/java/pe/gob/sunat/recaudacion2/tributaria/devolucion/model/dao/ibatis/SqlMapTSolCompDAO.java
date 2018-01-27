/***********************************************************************
 * Module:  SqlMapTSolCompDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapTSolCompDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1648;

import java.util.*;

/** @pdOid 7490aa4e-1290-485f-bfa3-59f7dc6db87f */
@Repository
public class SqlMapTSolCompDAO extends SqlMapRSiratDAO<Formulario1648> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TSolCompDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid 196f0f73-ff5d-4c8e-893c-8fecfd3600d4 */
   public boolean isValidPK(Formulario1648 model) {
      // TODO: implement
      return false;
   }
   
   /** Obtiene formulariod de Compensación 1648 registrados según ruc, tributo y periodo.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param codigoFormOrigen 
    * @param numeroDocOrigen 
    * @param etapas Lista de estados a ser verificada
    * @pdOid fc7e8666-f030-4d45-8e33-effb764a9e90 */
   public List<Formulario1648> findBy(String ruc, String tributo, String periodo, String codigoFormOrigen, String numeroDocOrigen, String[] etapas) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      datos.put("codtri", tributo);
      datos.put("perdoc", periodo);
      datos.put("codforori", codigoFormOrigen);
      datos.put("numdocori", numeroDocOrigen);
      datos.put("codetasol", etapas);
      List<Formulario1648> query = getSqlMapClientTemplate().queryForList("solcomp.buscarPorRucTribPerFormDocEta",datos);
      return query;
   }
   
   
   /** Obtiene formulariod de Compensación 1648 registrados según ruc, tributo y periodo.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param etapas Lista de estados a ser verificada
    * @pdOid 2c4407a2-4b68-4ead-923d-c4665e7da32a */
   public List<Formulario1648> findBy(String ruc, String tributo, String periodo, String[] etapas) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      datos.put("codtri", tributo);
      datos.put("perdoc", periodo);
      datos.put("codetasol", etapas);
      List<Formulario1648> query = getSqlMapClientTemplate().queryForList("solcomp.buscarPorRucTribPerFormDocEta",datos);
      return query;
   }

}