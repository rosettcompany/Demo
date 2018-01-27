/***********************************************************************
 * Module:  OperacionesJSONController.java
 * Author:  jmazuelos
 * Purpose: Defines the Class OperacionesJSONController
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.web.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.service.SolicitudDevolucionService;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;
import pe.gob.sunat.tecnologia.menu.bean.UsuarioBean;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.service.CCIService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.JSONResponse;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

/** Controlador web que permite realizar operaciones a través de peticiones
 * POST. El resultado es devuendo en una cadena JSON.
 * 
 * @pdOid 547763bb-33db-4aae-a225-4a155633ff12 */
@Controller
public class OperacionesJSONController  extends ControllerBase {
   private Log loger = LogFactory.getLog(getClass());
   /** @pdRoleInfo migr=no name=CCIService assc=association2 mult=1..1 */
   @Autowired
   private CCIService cCIService;
   
   /** @pdRoleInfo migr=no name=SolicitudDevolucionService assc=association1 mult=1..1 */
   @Autowired
   public SolicitudDevolucionService devolucionBaseService;
   
   /** @param model 
    * @param request
    * @pdOid 00787b43-ac00-4ca5-a95d-1e0059976759 */
   @ResponseBody 
   @RequestMapping(value="/ListarTributosPendientesDevolucion", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model, HttpServletRequest request) {
      UsuarioBean us = getUsuarioBean(request);
      model.getSolicitudDevolucion().setRuc(us.getNumRUC());
      model.getSolicitudDevolucion().setLogin(us.getLogin());
      model.getSolicitudDevolucion().setApellidosNombres(us.getNombreCompleto());
      
      Object a = devolucionBaseService.obtenerTributosPendientesDevolucion( model);
      return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
   }
   
   /** Devuelve una lista con los CCI registrados previamente por el contribuyente y que SUNAT ha verificado su titularidad.
    * 
    * @param ruc Número del RUC del contribuyente
    * @param request
    * @pdOid ec3f8dc9-7c72-419a-8100-a5e9dc5698c6 */
   @ResponseBody 
   @RequestMapping(value="/ObtenerCCI", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerCciValidadosPorRuc(@RequestParam("ruc") String ruc, HttpServletRequest request) {
      UsuarioBean bean = getUsuarioBean(request);
      Object a = cCIService.obtenerCciValidadosPorRuc(bean.getNumRUC());
      return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
   }
   
   /** Obtiene el texto de Información Importante relacionado a la forma de devolución
    * 
    * @param formaDevolucion Código de forma de devolución de la cual se va ha obtener su texto de Información Importante relacionado.
    * @param request
    * @pdOid 888cd17d-55f3-46f9-991b-d99e9d997183 */
   @ResponseBody 
   @RequestMapping(value="/ObtenerInformacionImportante", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerInformacionImportantePorFormaDevolucion(@RequestParam("formaDevolucion")String formaDevolucion, HttpServletRequest request) {
      UsuarioBean usuario = getUsuarioBean(request);
      String informacion = devolucionBaseService.obtenerInformacionImportantePorFormaDevolucion(usuario.getNumRUC(), formaDevolucion);
      return new JSONResponse(ResponseStatus.Correcto, "Correcto", informacion);
   }
   
   /** Devuelve una lista de los Tributos asociados a un tipoDeclaracion
    * 
    * @param tipoDevolucion 
    * @param request
    * @pdOid 2a9637fe-6b57-4eee-ac3a-2a3b2a164301 */
   @ResponseBody 
   @RequestMapping(value="/ObtenerTributos", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerTributosAsociadosTipoDevolucion(@RequestParam("tipoDevolucion") NameValuePair tipoDevolucion, HttpServletRequest request) {
      Object a = devolucionBaseService.obtenerTributosPorTipoSolicitud(tipoDevolucion.getValue());
      return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      
   }
   
   /** Registra la solicitud de devolución especificada.
    * 
    * @param modelo Bean que contiene la solicitud a registrar
    * @param request
    * @pdOid 47821b6d-56c8-45d2-aa13-81c39c2a629f */
   @ResponseBody 
   @RequestMapping(value="/RegistrarSolicitudDevolucion", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse registrarSolicitudDeDevolucion(@ModelAttribute("model") ModelFormRegistroDevolucion modelo, HttpServletRequest request) throws Exception {
      UsuarioBean usuario = getUsuarioBean(request);
      modelo.getSolicitudDevolucion().setRuc(usuario.getNumRUC());
      modelo.getSolicitudDevolucion().setApellidosNombres(usuario.getNombreCompleto());
      modelo.getSolicitudDevolucion().setCodigoFormulario(ConstantesDevolucion.CODIGO_FORMULARIO_INTERNET);
      modelo.getSolicitudDevolucion().setLogin(usuario.getLogin());
      List<Mensaje> mensajes = devolucionBaseService.registrarSolicitudDevolucion(modelo.getSolicitudDevolucion());
      if(GenericFunctions.isListEmptyOrNull(mensajes)){
         //No se encontraron mensajes, el registro es satisfactorio.
         request.getSession().setAttribute("solicitudDevolucion", modelo.getSolicitudDevolucion());
         return new JSONResponse(ResponseStatus.Correcto, "Correcto");
      }
      return new JSONResponse(new Mensaje(ResponseStatus.Fallo, "No se pudo completar el registro", mensajes));
   }
   
   /** @param model 
    * @param correoElectronico 
    * @param request
    * @pdOid 98938ec0-f78f-4d2f-9e95-582fc8b6bd73 */
   @ResponseBody 
   @RequestMapping(value="/EnviarConstanciaCorreo", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse enviarConstanciaCorreo(@ModelAttribute("model") ModelFormRegistroDevolucion model, @RequestParam("correoElectronico") String correoElectronico, HttpServletRequest request) throws Exception {
      if(GenericFunctions.isBlankOrNull(correoElectronico))
         throw new BusinessException("No se ha recibido el correo electrónico al cual se va a enviar la constancia.",
               "Por favor, especifique un correo electrónico.");
      devolucionBaseService.enviarConstanciaCorreoElectronico(model.getSolicitudDevolucion(), correoElectronico);
      return new JSONResponse(ResponseStatus.Correcto, String.format("Se ha enviado la constancia de devolución al correo %s.", correoElectronico));
   }

   @ExceptionHandler(BusinessException.class)
   @ResponseBody
   public JSONResponse capturarJSONBusinessException(BusinessException ex){
      loger.info(GenericFunctions.formatException("Error de negocio:", ex));
      return new JSONResponse(ResponseStatus.Fallo, ex.getMensajeNegocio());
   }
   
   @ExceptionHandler(Exception.class)
   @ResponseBody 
   public JSONResponse capturarJSONException(Exception ex, HttpServletRequest request){
      loger.info(GenericFunctions.formatException("Error al intentar realizar la acción:", ex));
      return new JSONResponse(ResponseStatus.Fallo, Constantes.MSG_ERROR_GRAL_NEGOCIO);
   }
}