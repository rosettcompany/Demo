/***********************************************************************
 * Module:  T5847CtlDeclDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T5847CtlDeclDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import java.util.*;

/** @pdOid 6758d8ef-7ae4-4fb6-9d07-ee725ad5306b */
public interface T5847CtlDeclDAO extends TGenericDAO<ControlDeclaracion> {
   /** Permite buscar una declración en función de los atributos enviados 
    * en el parámetro 
    * 
    * @param filterBean Objeto de declracion usado como filtro
    * para la consulta de declaraciones.
    * @pdOid 2d34fe79-6386-4db8-94fa-bf4f3de78937 */
   List<ControlDeclaracion> findByControlDeclaracion(ControlDeclaracion filterBean);

}