/***********************************************************************
 * Module:  T3779FormularioDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T3779FormularioDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario;
import java.util.*;

/** @pdOid d164bb07-928f-4dbf-8c04-499bde20ef9e */
public interface T3779FormularioDAO extends TGenericDAO<Formulario> {
   /** Obtiene una de formularios T3779Formulario según los valores
    * de los atributos de formulario
    * 
    * @param filterBean Objeto Formulario usado en la búsqueda
    * @pdOid c77f87ca-8859-47de-b85f-9d8b7e65009d */
   List<Formulario> findByFormuario(Formulario filterBean);

}