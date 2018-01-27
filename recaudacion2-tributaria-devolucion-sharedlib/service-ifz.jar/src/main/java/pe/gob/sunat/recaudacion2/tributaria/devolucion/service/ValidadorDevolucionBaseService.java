/***********************************************************************
 * Module:  ValidadorDevolucionBaseService.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface ValidadorDevolucionBaseService
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.TributoPendienteDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;
import java.util.*;

/** @pdOid 9615bd1e-5429-424d-968b-361620bc4f8b */
public interface ValidadorDevolucionBaseService {
   /** Devuelve el código de tipo de devolución de la cual se está implementando su respectiva validación
    * 
    * @pdOid 9ce4a0c0-3701-4102-a96a-c8938dc37143 */
   String getTipoDevolucion();
   /** Obtiene los tributos pendientes de devolucion segun periodos según el tipo de Key
    * 
    * @param model Objeto que contiene los datos necesarios para realizar la búsqueda de tributos pendientes de devolución
    * @pdOid 80b87cb2-0ce0-45c0-99c3-22f585db23b7 */
   List<TributoPendienteDevolucion> obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model);
   /** Realiza las validaciones correspondientes según el tipo de solicitud registrada
    * 
    * @param solicitudDevolucion Solicitud de devolución a validar
    * @throws Exception 
    * @pdOid 38948409-a125-4700-b489-ec5d7f93eaa2 */
   List<Mensaje> validarRegistroDeSolicitud(SolicitudDevolucion solicitudDevolucion) throws Exception;
   /** Realiza acciones de post el registro de la solicitud de devolución
    * 
    * @param solicitudDevolucion
    * @pdOid d56d765a-ad7b-45a3-9be1-bad7af3c5809 */
   List<Mensaje> realizarAccionesPostRegistro(SolicitudDevolucion solicitudDevolucion);

}