/***********************************************************************
 * Module:  OperacionesIUController.java
 * Author:  jmazuelos
 * Purpose: Defines the Class OperacionesIUController
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.web.controller;

import pe.gob.sunat.tecnologia.menu.bean.UsuarioBean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.service.SolicitudDevolucionService;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.JSONResponse;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormBase;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

/** Web Controller que muestra las interfaces gráficas de usuario usando JSP
 * 
 * @pdOid 92064e53-c525-47c2-a549-ba94650b40ac */
@Controller
public class OperacionesIUController extends ControllerBase{
   private Log loger = LogFactory.getLog(getClass());
   /** @pdRoleInfo migr=no name=SolicitudDevolucionService assc=association3 mult=1..1 */
   @Autowired
   private SolicitudDevolucionService solicitudDevolucionService;
   
   /** Permite el registro de una solicitud de devolución
    * 
    * @param model 
    * @param request
    * @pdOid 078963c2-b523-4228-b55a-78903367ea8a */
   @RequestMapping("/RegistrarDevolucion.htm")
   public String registrarSolicitudDevolucion(@ModelAttribute("model") ModelFormRegistroDevolucion model, HttpServletRequest request) {
      UsuarioBean usuario = getUsuarioBean(request);
      if(GenericFunctions.isBlankOrNull(model.getOpcion())){
         List<Mensaje> mensajes = solicitudDevolucionService.verificarCondicionHabilitado(usuario.getNumRUC());
         if(!GenericFunctions.isListEmptyOrNull(mensajes)){
            model.setMensajes(mensajes);
            return "PaginaError";
         } else {
            List<NameValuePair> tiposSolicitud = solicitudDevolucionService.obtenerTiposSolicitud();
            request.setAttribute("tiposSolicitud", tiposSolicitud);
            model.setOpcion(ConstantesDevolucion.FORMULARIO_SELECCION);
            return "SeleccionarTipoSolicitud";
         }
         
      } else if (ConstantesDevolucion.FORMULARIO_SELECCION.equals(model.getOpcion())){
         //Se obtiene el modo de llenado
         model.setModoLlenado(solicitudDevolucionService.obtenerModoLlenado(
               model.getSolicitudDevolucion().getTipoSolicitud().getValue(),
               model.getSolicitudDevolucion().getTributo().getValue()));
         
         //Se determina el modo de registro en función del modo de llenado.
         if(ConstantesDevolucion.MODO_LLENADO_MANUAL.equals(model.getModoLlenado())){
            
            // Se obtienen las formas de devolución válidas
            List<NameValuePair> formasDevolucion = solicitudDevolucionService.obtenerFormasDevolucion(
                  model.getSolicitudDevolucion().getTipoSolicitud().getValue(),
                  model.getSolicitudDevolucion().getTributo().getValue(),
                  usuario.getNumRUC()
                  );
            model.setOpcion(ConstantesDevolucion.FORMULARIO_REGISTRO);
            request.setAttribute("formasDevolucion", formasDevolucion);
            
            //Se obtiene la forma de devolución por defecto
            NameValuePair nv = solicitudDevolucionService.obtenerFormaDevolucionDefecto(
                  usuario.getNumRUC(),
                  model.getSolicitudDevolucion().getTipoSolicitud().getValue(),
                  model.getSolicitudDevolucion().getTributo().getValue());
            model.getSolicitudDevolucion().setIndicadorFormaDevolucion(nv);
            
            //Se obtiene el escrito fundamentado
            String escritoFundamentado = solicitudDevolucionService.obtenerEscritoFundamentado(
                  usuario.getNumRUC(),
                  model.getSolicitudDevolucion().getTipoSolicitud().getValue(),
                  model.getSolicitudDevolucion().getTributo().getValue())
                  //TODO : El reemplazo del tributo debe realizarce en el service
                  .replace("%TRIBUTO%", model.getSolicitudDevolucion().getTributo().getName());
            model.getSolicitudDevolucion().setEscritoFundamentado(escritoFundamentado);
            
            String textoAyudaArchivo = solicitudDevolucionService.obtenerTextoAyudaArchivoSustento(
                  model.getSolicitudDevolucion().getTipoSolicitud().getValue(),
                  model.getSolicitudDevolucion().getTributo().getValue());
            request.setAttribute("textoAyudaArchivo", textoAyudaArchivo);
            
            return "RegistroSolicitudDevolucion";
         } else if (ConstantesDevolucion.MODO_LLENADO_ASISTIDO.equals(model.getModoLlenado())){
            model.setOpcion(ConstantesDevolucion.FORMULARIO_BUSQUEDA_TRIBUTOS);
            return "BuscarTributosPendientesDevolucion";
         } else {
            throw new RuntimeException(
                  String.format("No se reconoce el modo de llenado [%s]. Posible error de programación.", model.getModoLlenado()));
         }
      } else {
         throw new RuntimeException(
               String.format("No se reconoce ha implementado la opción [%s]. Posible error de programación.", model.getOpcion()));
      }
      /*
         SI model.opcion == NULL o VACÍO THEN
            
            List<Mensaje> mensajes = solicitudDevolucionService.verificarCondicionHabilitado(ruc);
            IF mensajes <> vacio THEN
               //Mostrar interfaz de mensajes de error
            ELSE
               model.opcion = Constantes.FORMULARIO_SELECCION;
               Mostrar Interfaz de seleccion (IU0016)
            END IF
         END IF
         IF model.opcion = Constantes.FORMULARIO_SELECCION THEN
            modalidad = solicitudDevolucionService.obtenerModoLlenado
           IF modalidad = Constantes.MODO_LLENADO_ASISTIDO THEN
             
             model.opcion = Constantes.FORMULARIO_BUSQUEDA_TRIBUTOS
             Mostrar Interfaz de Busqueda de Tributos Pendientes (IU0014)
           ELSE IF modalidad = Constantes.MODO_LLENADO_MANUAL THEN
             
             model.opcion = Constantes.FORMULARIO_REGISTRO
             Mostrar Interfaz de Registro (IU0016)
           END IF
         END IF
         
         IF model.opcion = Constantes.FORMULARIO_REGISTRO THEN
            
         END IF
      */
   }
   
   /** Muestra la constancia de presentación para la Solicitud Devolucion con numeroDevolucion.
    * El objeto SolicitudDevolución se obtiene desde la sesión.
    * 
    * @param model 
    * @param request
    * @pdOid e56663a1-d995-4e1c-b10e-04e5e45a369f */
   @RequestMapping("/MostrarConstancia.htm")
   public String mostrarConstanciaPresentacion(@ModelAttribute("model") ModelFormRegistroDevolucion model, HttpServletRequest request) {
      model.setSolicitudDevolucion((SolicitudDevolucion) request.getSession().getAttribute("solicitudDevolucion"));
      if(model.getSolicitudDevolucion() == null){
         throw new BusinessException("No se ha encontrado el objeto de sesión solicitudDevolucion para poder mostrar la constancia de presentación",
               "Sr. Contribuyente, no se encuentra información de su sesión. Es probable que su sesión haya expirado.");
      }
      return "ConstanciaPresentacion";
   }


   @ExceptionHandler(BusinessException.class)
   public ModelAndView capturarBusinessException(BusinessException ex){
      loger.info(GenericFunctions.formatException("Error de negocio:", ex));

      ModelFormBase form = new ModelFormBase();
      form.addMensajes( new Mensaje(ResponseStatus.Fallo, ex.getMensajeNegocio()));
      return new ModelAndView("PaginaError","model",form );
   }
   
   @ExceptionHandler(Exception.class)
   public ModelAndView capturarException(Exception ex){
      loger.info(GenericFunctions.formatException("Error al intentar realizar la acción:", ex));
      ModelFormBase form = new ModelFormBase();
      form.addMensajes( new Mensaje(ResponseStatus.Fallo, Constantes.MSG_ERROR_GRAL_NEGOCIO));
      return new ModelAndView("PaginaError","model",form );
   }
}