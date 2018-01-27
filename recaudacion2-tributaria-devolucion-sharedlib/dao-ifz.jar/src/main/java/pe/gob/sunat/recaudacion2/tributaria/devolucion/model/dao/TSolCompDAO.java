/***********************************************************************
 * Module:  TSolCompDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface TSolCompDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1648;
import java.util.*;

/** @pdOid 8d3d57b7-7ee2-4bac-8962-a69b0fe4e9ce */
public interface TSolCompDAO extends TGenericDAO<Formulario1648> {
   
   /** Obtiene formulariod de Compensación 1648 registrados según ruc, tributo y periodo.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param codigoFormularioAsociado 
    * @param numeroOrdenFormularioAsociado 
    * @param etapas Lista de estados a ser verificada
    * @pdOid c7866fe8-48dc-45fd-ba9e-c8f0d59890af */
   List<Formulario1648> findBy(String ruc, String tributo, String periodo, String codigoFormOrigen, String numeroDocOrigen, String[] etapas);
   
   /** Obtiene formulariod de Compensación 1648 registrados según ruc, tributo y periodo.
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param etapas Lista de estados a ser verificada
    * @pdOid eff082ca-4d0c-4821-ad6b-81d549de3801 */
   List<Formulario1648> findBy(String ruc, String tributo, String periodo, String[] etapas);

   
}