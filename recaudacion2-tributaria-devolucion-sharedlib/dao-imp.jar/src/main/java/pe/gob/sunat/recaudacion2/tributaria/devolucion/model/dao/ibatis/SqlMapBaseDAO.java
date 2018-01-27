/***********************************************************************
 * Module:  SqlMapPDTInternetDao.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SqlMapPDTInternetDao
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

/** Clase que maneja todos los DAO relacionados a la base de datos pdtinternet.
 * Los nombres de los archivos map de ibatis sólo deben contener el
 * prefijo txxxx.
 * 
 * 
 * 
 * @pdOid de093d2e-8f35-4e31-8866-9474d69f08a7 */
public abstract class SqlMapBaseDAO <T extends GenericModel> extends SqlMapClientDaoSupport implements pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TGenericDAO<T> {
   /** Contiene el prefijo de la tabla (TXXXX).
    * El cual es usado para realizar las llamadas al name space
    * para ibatis.
    * 
    * @pdOid 5433c3fa-ed3b-4e65-a7a6-b967ec4070c8 */
   protected String sqlMapName;
   
   /** Obtiene el nombre de la tabla a partir del nombre de la clase.
    * 
    * @pdOid 24de26ed-e8b6-49fe-a9e3-0f52728db163 */
   protected String obtenerNombreTabla() {
      String nombre = getClass().getName();
      Pattern pattern = Pattern.compile("T[0-9][0-9]+");
      Matcher matcher = pattern.matcher(nombre);
   
      if(matcher.find()){
         nombre = nombre.substring(matcher.start(),matcher.end()).toLowerCase();
      } else {
         pattern = Pattern.compile("Map.+DAO");
         matcher = pattern.matcher(nombre);
         if(matcher.find())
            nombre = nombre.substring(matcher.start() +3 ,matcher.end() -3).toLowerCase();
      }
      return nombre;
   }
   
   /** Función que determina si el objeto model tiene llenados los atributos PK relacionados a la clase.
    * 
    * 
    * @param model
    * @pdOid 8f9cf775-f320-4ab2-b058-2cc893c09f4f */
   protected abstract boolean isValidPK(T model);
   
   /** Obtiene una lista con todos los registros de la tabla relacionada a la claseDao
    * 
    * @pdOid 851bdc8b-9a2e-470e-9287-8ab6af9122b7 */
   public List<T> findAll() {
      List<T> lista =getSqlMapClientTemplate().queryForList(sqlMapName+ ".findAll");
      return lista;
   }
   
   /** Busca un registro específico que coincida con la PK del model enviado como argumento.
    * Devuelve un objeto GenericDAO en caso de encontrar un registro coincidente, en caso contrario devuelve null
    * 
    * @param model
    * @pdOid 43269d9e-64b4-4417-9660-6ea7d1ce8bb8 */
   public T findByPk(T model) {
      if(!isValidPK(model))
         throw new InvalidParameterException("El objeto model recibido no tiene los atributos PK llenados. Revisar si se ha implementado la función isValidPk de la clase "+
      this.getClass().getName());
      T objeto = (T)getSqlMapClientTemplate().queryForObject(sqlMapName+ ".findByPk", model);
      return objeto;
   }
   
   /** Inserta un registro (model). Se asume que se ha creado una
    * sentencia INSERT con el id insert en el archivo de mapeo de ibatis.
    * 
    * @param model Objeto a ser insertado
    * @pdOid da9f3fd7-b86e-4a87-b3c6-29ec4c9e6945 */
   public int insert(T model) {
      getSqlMapClientTemplate().insert(sqlMapName+ ".insert", model);
      return 1;
   }
   
   /** Inicializa el objeto DAO con el sqlMAP relacioando
    * al data source.
    * 
    * @pdOid 6a1844b4-00d6-4158-a114-41b47418636f */
   @Autowired
   public abstract void init();
   /** Inserta un registro (model) haciendo uso del inserID
    * declarado en el archivo map de Ibatis.
    * 
    * 
    * @param model Objeto a ser insertado.
    * @param insertIbatisID Nombre del id de la sentencia INSERT creada en
    * el archivo de mapeo de ibatis.
    * @pdOid b72fe28f-5793-4897-8dc7-54b73615848c */
   public boolean insert(T model, String insertIbatisID) {
      getSqlMapClientTemplate().insert(sqlMapName+ "." + insertIbatisID, model);
      return true;
   }
   
   /** Obtiene el prefijo de la tabla, el cual es usado
    * para realizar las operaciones INSERT.
    * 
    * @pdOid a3a2ec18-65e0-4fd8-b588-1058e8b3338d */
   public String getSqlMapName() {
      return sqlMapName;
   }
   
   
   public String parseMapId(String ibatisID){
      return sqlMapName + "." + ibatisID;
   }

}