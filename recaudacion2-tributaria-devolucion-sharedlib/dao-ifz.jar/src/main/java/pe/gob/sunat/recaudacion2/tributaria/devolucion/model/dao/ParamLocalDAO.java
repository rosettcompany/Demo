/***********************************************************************
 * Module:  ParamLocalDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface ParamLocalDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

import java.util.*;

/** @pdOid 42fe10fd-c97d-4d79-bcb3-25b4f51de081 */
public interface ParamLocalDAO extends TGenericDAO<GenericModel> {
   /** Obtiene un registro del parámetro según código de parámetro y dependencia.
    * 
    * @param codigo Código del parámetro local
    * @param dependencia Código de dependencia de la param local
    * @pdOid cacd8ee6-4e0c-4c10-a316-590b2f190af0 */
   NameValuePair getNameValuePairByDependencia(String codigo, String dependencia);

}