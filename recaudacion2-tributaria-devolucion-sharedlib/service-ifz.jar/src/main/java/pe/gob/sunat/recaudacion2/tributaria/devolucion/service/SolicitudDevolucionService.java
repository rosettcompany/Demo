/***********************************************************************
 * Module:  SolicitudDevolucionService.java
 * Author:  jmazuelos
 * Purpose: Defines the Interface SolicitudDevolucionService
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.TributoPendienteDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import java.util.*;

import javax.mail.MessagingException;

/** Servicio que contiene las operaciones relacionadas a Devoluciones
 * 
 * @pdOid a5ddff72-d78a-4065-99bd-26c551a80d45 */
public interface SolicitudDevolucionService {
   /** Obtiene los tributos pendientes de devolucion segun periodos según el tipo de Key
    * 
    * @param model
    * @pdOid 53103499-adbc-4b5f-be3c-a8c50d484f07 */
   List<TributoPendienteDevolucion> obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model);
   /** Registra la devolucion en la base de datos
    * 
    * @param devolucion
    * @throws Exception 
    * @pdOid 8802e5b2-e17d-4d28-a338-2f53ac78a1ae */
   List<Mensaje> registrarSolicitudDevolucion(SolicitudDevolucion devolucion) throws Exception;
   /** Obtiene un objeto Solicitud de Devolucion con atributos necesarios para la generación de una constancia de presentación
    * 
    * @param numeroDevolucion Número de devolucion
    * @pdOid f2cd7cd2-e544-4b69-96f7-a23a9b1d7c35 */
   SolicitudDevolucion obtenerConstanciaPresentacion(String numeroDevolucion);
   /** Obtiene el escrito fundamentado según Tipo de Devolución y Tributo
    * 
    * @param ruc RUC del contribuyente
    * @param tipoDevolucion Tipo de devolución
    * @param tributo Tributo
    * @pdOid 7d3e3f50-835e-4447-aa82-11081c99364e */
   String obtenerEscritoFundamentado(String ruc, String tipoDevolucion, String tributo);
   /** Obtiene la forma de devolción por defecto según tipo de solicitud y tributo.
    * 
    * @param ruc Número de RUC del contribuyente
    * @param tipoDevolucion Código tipo de devolución.
    * @param tributo Código de tributo
    * @pdOid 433126b4-be49-4e39-98a0-eb41b2da0575 */
   NameValuePair obtenerFormaDevolucionDefecto(String ruc, String tipoDevolucion, String tributo);
   /** Obtiene una lista de formas de devolución habilitadas según Tipo Devolucion, Tributo y RUC.
    * 
    * @param tipoDevolucion Código del tipo de devolución
    * @param tributo Código del Tributo
    * @param ruc RUC del contribuyente
    * @pdOid 1e29f68e-7283-41ae-9b3a-f22cf999fd29 */
   List<NameValuePair> obtenerFormasDevolucion(String tipoDevolucion, String tributo, String ruc);
   /** Obtiene la lista de Tipos de Solicitud de Devoluciones habilitadas
    * 
    * @pdOid bf784bdc-e1c5-444b-b1e2-8f854343d0c6 */
   List<NameValuePair> obtenerTiposSolicitud();
   /** Obtiene una lista de los Tributos Asociados al Tipo de devolución
    * 
    * @param tipoDevolucion Tipo de Devolución
    * @pdOid 50bb64f9-f10f-441b-ac48-91a9067e6d95 */
   List<NameValuePair> obtenerTributosPorTipoSolicitud(String tipoDevolucion);
   /** Obtiene el modo de llenado asociado al Tipo de Devolución y el Tributo Seleccionado
    * 
    * @param tipoDeDevolucion Tipo de Devolución por el cual se va a solicitar la devolución
    * @param tributo Tributo por el cual se va a solicitar la devolución.
    * @pdOid 91956472-d076-46de-9a8d-e1424aa38b75 */
   String obtenerModoLlenado(String tipoDeDevolucion, String tributo);
   /** Obtiene el texto de ayuda relacionado al archivo de sustento a ser adjunato. El texto se obtiene en función 
    * 
    * @param tipoDevolucion Tipo de Devolución
    * @param tributo Tributo
    * @pdOid 854f0c1c-7336-414b-91b4-5667bfd2679f */
   String obtenerTextoAyudaArchivoSustento(String tipoDevolucion, String tributo);
   /** Realiza las validaciones relacionadas antes del llenado de datos de la solicitud de devolución. Las validaciones realizadas son las siguientes:
    *  - Valida si el RUC se encuentra con Baja Definitiva: 
    *     - Por fallecimiento.
    *     - Baja definitiva cuyo motivo de baja no es fallecimiento.
    * - Valida si el RUC tiene estado distinto a ACTIVO.
    * - Valida si su condición domiciliaria es diferente a la de HABIDO.
    * 
    * 
    * @param ruc
    * @pdOid 439179c4-48d3-4cf1-a300-ab15eb7b2b8d */
   List<Mensaje> verificarCondicionHabilitado(String ruc);
   /** Obtiene el texto en formato HTML relacionado a la información importante a tomar en cuenta según forma de devolución.
    * 
    * @param ruc Número de RUC del contribuyente
    * @param formaDevolucion
    * @pdOid 76756583-b41b-498a-9204-6d7ea71c15e3 */
   String obtenerInformacionImportantePorFormaDevolucion(String ruc, String formaDevolucion);
   /** Envia un correo electrónico al contribuyente con la información de su constancia de presentación.
    * 
    * @param solicitudDevolucion 
    * @param correoElectronico
    * @throws MessagingException 
    * @pdOid 7a42240f-8344-414d-ac75-cb62b420edf1 */
   void enviarConstanciaCorreoElectronico(SolicitudDevolucion solicitudDevolucion, String correoElectronico) throws MessagingException;

}