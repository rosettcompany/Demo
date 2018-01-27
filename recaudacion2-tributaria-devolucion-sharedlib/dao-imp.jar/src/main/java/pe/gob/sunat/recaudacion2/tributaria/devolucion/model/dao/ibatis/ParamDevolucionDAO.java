/***********************************************************************
 * Module:  ParamDevolucionDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ParamDevolucionDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis;

import pe.gob.sunat.framework.spring.util.cache2.bean.ParamBean;
import pe.gob.sunat.framework.spring.util.cache2.dao.ParamDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;

import java.util.*;

/** @pdOid 85ac8979-bf9b-4bc8-b509-c551c09843ff */
public class ParamDevolucionDAO extends ParamDAO{
   /** Establece el atributo Name del objeto nameValuePair según el valor de t01funcion (desde substrStart hasta substrStop) según el codigoParametro y su tipo.
    * 
    * 
    * @param nameValuePair NameValuePair al cual se le va a establecer el atributo Name según el valor de  t01funcion  del parámetro. Este objeto debe tener establecido el atributo Value según la descripción a obtener.
    * @param codigoParametro Código del parámetro almacenado en caché.
    * @param tipoParametro Tipo de Parámetro
    * TIPO1 = 1;
    * TIPO2 = 2;
    * TIPO3 = 3;
    * TIPO4 = 4;
    * TIPO5 = 5;
    * TIPO6 = 6;
    * SQLSTC = 0;
    * @param substrStart Inicio de la cadena de t01funcion
    * @param substrStop Fin de la cadena t01funcion
    * @pdOid 8d933f88-d94b-4f3f-95e0-3092449f1f2b */
   public void setNameToNameValuePair(NameValuePair nameValuePair, String codigoParametro, int tipoParametro, int substrStart, int substrStop) {
      ParamBean pbean = buscar(codigoParametro,nameValuePair.getValue(),  tipoParametro);
      if(pbean!=null)
         nameValuePair.setName(pbean.getDescripcion().substring(substrStart, substrStop));
   }
   
   /** Devuelve un objeto NameValuePair según el codigoParametro, codigo, tipoParametro. El valor del atributo Name es una cadena entre substrStart y substrStop del parámetro.
    * 
    * 
    * @param codigoParametro Código del parámetro almacenado en caché.
    * @param tipoParametro TIPO1 = 1;
    * TIPO2 = 2;
    * TIPO3 = 3;
    * TIPO4 = 4;
    * TIPO5 = 5;
    * TIPO6 = 6;
    * SQLSTC = 0;
    * @param codigo Código del objeto paramétrico (t01_argumento)
    * @param substrStart Inicio de la cadena de t01funcion
    * @param substrStop Fin de la cadena t01funcion
    * @pdOid 7684b64f-b16d-4048-821b-db588ebf5390 */
   public NameValuePair getNameValuePair(String codigoParametro, int tipoParametro, String codigo, int substrStart, int substrStop) {
      ParamBean pbean = buscar(codigoParametro,codigo,  tipoParametro);
      NameValuePair nv = new NameValuePair(codigo);
      if(pbean!=null)
         nv.setName(pbean.getDescripcion().substring(substrStart, substrStop).trim());
      return nv;
   }
   
   /** Devuelve una lista de NameValuePair con los códigos/descripción del codigoParametro especificado.
    * El atributo Name contendrá una cadena de texto desde substrStart hasta substrStop de la descripción
    * 
    * @param codigoParametro Código del parámetro almacenado en caché.
    * @param tipoParametro TIPO1 = 1;
    * TIPO2 = 2;
    * TIPO3 = 3;
    * TIPO4 = 4;
    * TIPO5 = 5;
    * TIPO6 = 6;
    * SQLSTC = 0;
    * @param substrStart Inicio de la cadena de t01funcion
    * @param substrStop Fin de la cadena t01funcion
    * @pdOid 8c9da0e3-9e81-4857-9591-dc7696c63ed5 */
   public List<NameValuePair> obtenerParametros(String codigoParametro, int tipoParametro, int substrStart, int substrStop) {
      // TODO: implement
      return null;
   }
   
   public String obtenerDescripcion(String codigoParametro, int tipoParametro, String codigo) {
      List<ParamBean> listBancos = (List<ParamBean>) this.buscar(codigoParametro,  tipoParametro);
      for (ParamBean paramBean : listBancos) {
         if(paramBean.getCodigo().equals(codigo))
            return paramBean.getDescripcion();
      }
      return null;
   }

   public List<ParamBean> buscarTipo1(String codigoParametro){
      return (List<ParamBean>) this.buscar(codigoParametro,  ParamDAO.TIPO1);
   }
   
   public String obtenerDescripcionTipo1(String codigoParametro, String codigo) {
      return obtenerDescripcion(codigoParametro,   ParamDAO.TIPO1, codigo);
   }
}