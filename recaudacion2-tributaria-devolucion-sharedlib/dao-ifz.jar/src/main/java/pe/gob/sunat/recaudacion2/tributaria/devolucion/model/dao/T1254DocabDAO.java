/***********************************************************************
 * Module:  T1254DocabDAO.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface T1254DocabDAO
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1693;
import java.util.*;

/** @pdOid 518086ce-80d9-4acb-8f49-b9b1f8efb80a */
public interface T1254DocabDAO extends TGenericDAO<Formulario1693> {
   /** Obtiene una lista de  formularios de Modificación de Datos 1693 según ruc, tributo, periodo y estados
    * 
    * @param ruc Número de RUC del contribuyente.
    * @param tributo Código de tributo
    * @param periodo Periodo del tributo
    * @param estados Lista de estados a ser verificada
    * @pdOid 8387b36a-8336-442d-8372-7e8889c6d872 */
   List<Formulario1693> findBy(String ruc, String tributo, String periodo, String[] estados);
   /** Permite la búsqueda de formularios con codigoFormulario según el número de abono, código de formulario asociado y el número de orden asociado que se encuentre pendientes (ind_activo = '1')
    * 
    * @param codigoFormulario 
    * @param numeroAbonoAsociado 
    * @param codigoFormularioAsociado 
    * @param numeroOrdenAsociado 
    * @param estados
    * @pdOid f660b0c6-c9b3-42b5-80d0-b7006c007ea5 */
   List<Formulario1693> findBy(String codigoFormulario, String numeroAbonoAsociado, String codigoFormularioAsociado, String numeroOrdenAsociado, String[] estados);

}