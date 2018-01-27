/***********************************************************************
 * Module:  SqlMapT3779FormularioDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapT3779FormularioDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario;
import java.util.*;

/** @pdOid 37a511ce-c4dc-48f7-b96c-96bc4d70cd3a */
@Repository
public class SqlMapT3779FormularioDAO extends SqlMapPDTInternetDAO<Formulario> implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T3779FormularioDAO {
   /** Obtiene una de formularios T3779Formulario según los valores
    * de los atributos de formulario
    * 
    * @param filterBean Objeto Formulario usado en la búsqueda
    * @pdOid e15cafce-d239-416a-a754-3c3445546dd6 */
   public List<Formulario> findByFormuario(Formulario filterBean) {
      // TODO: implement
      return null;
   }
   
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * @param model
    * @pdOid d29572a8-81c6-43b9-aef6-04c8cf824e07 */
   public boolean isValidPK(Formulario model) {
      // TODO: implement
      return false;
   }

}