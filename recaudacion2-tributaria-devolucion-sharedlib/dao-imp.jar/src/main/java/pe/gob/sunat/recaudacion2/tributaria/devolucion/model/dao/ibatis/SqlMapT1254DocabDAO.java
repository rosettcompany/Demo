/***********************************************************************
 * Module:  SqlMapT1254DocabDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT1254DocabDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1693;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Vfp;

import java.util.*;

/** @pdOid c35dce26-98a2-4e73-b9e8-be4b546f5c12 */
@Repository
public class SqlMapT1254DocabDAO extends SqlMapModificaDJDAO<Formulario1693> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T1254DocabDAO {
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid 222a3edb-7078-42ef-8012-cbbc632de406 */
   public boolean isValidPK(Formulario1693 model) {
      // TODO: implement
      return false;
   }
   
   /** Obtiene una lista de  formularios de Modificación de Datos 1693 según ruc, tributo, periodo y estados
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param estados Lista de estados a ser verificada
    * @pdOid 5e16d9f9-e83e-46be-8129-943150093446 */
   public List<Formulario1693> findBy(String ruc, String periodo, String tributo, String[] estados) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("numruc", ruc);
      datos.put("perfor", periodo);
      datos.put("codtrib", tributo);
      datos.put("estados", estados);
      List<Formulario1693> query = getSqlMapClientTemplate().queryForList("t1254.buscarPorRucPerTribEst",datos);
      return query;   
   }
   
   /** Permite la búsqueda de formularios con codigoFormulario según el número de abono, código de formulario asociado y el número de orden asociado que se encuentre pendientes (ind_activo = '1')
    * 
    * @param codigoFormulario 
    * @param numeroAbonoAsociado 
    * @param codigoFormularioAsociado 
    * @param numeroOrdenAsociado 
    * @param estados
    * @pdOid d92db78c-09b4-4b00-bf17-950f668ba53d */
   public List<Formulario1693> findBy(String codigoFormulario, String numeroAbonoAsociado, String codigoFormularioAsociado, String numeroOrdenAsociado, String[] estados) {
      HashMap<String, Object> datos = new HashMap<String, Object>();
      datos.put("codigoFormulario", codigoFormulario);
      datos.put("numeroAbonoAsociado", numeroAbonoAsociado);
      datos.put("codigoFormularioAsociado", codigoFormularioAsociado);
      datos.put("numeroOrdenAsociado", numeroOrdenAsociado);
      datos.put("estados", estados);
      List<Formulario1693> query = getSqlMapClientTemplate().queryForList("t1254.findByCodigoForm",datos);
      return query;   
   }

}