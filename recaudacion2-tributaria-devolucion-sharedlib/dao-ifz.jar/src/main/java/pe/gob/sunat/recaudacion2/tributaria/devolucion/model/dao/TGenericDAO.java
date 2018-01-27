/***********************************************************************
 * Module:  TGenericDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface TGenericDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.GenericModel;

/** Interfaz genérica para la elaboración de DAO
 * Esta interfaz es implementada por SqlMapFPEDAO
 * 
 * @pdOid 4651ef01-b45d-4d30-aa68-992deedace8a */
public interface TGenericDAO <T extends GenericModel> {
   /** Inserta un registro (model). Se asume que se ha creado una
    * sentencia INSERT con el id insert en el archivo de mapeo de ibatis.
    * 
    * @param model Objeto a ser insertado
    * @pdOid ad658774-51a8-4c26-8383-d3797856a11a */
   int insert(T model);

}