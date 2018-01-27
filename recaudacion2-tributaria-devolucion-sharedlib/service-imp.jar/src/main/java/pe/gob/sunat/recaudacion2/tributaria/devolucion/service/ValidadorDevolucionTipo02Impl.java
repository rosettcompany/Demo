/***********************************************************************
 * Module:  ValidadorDevolucionTipo02Impl.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ValidadorDevolucionTipo02Impl
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T3779FormularioDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5385CasPrimeraDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5386CasSegundaDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5387CasCuartaDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T9030CasCuartaDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5847CtlDeclDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasCuarta;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasPrimera;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillasSegunda;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.DevolucionesDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis.ParamDevolucionDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.TributoPendienteDevolucion;
import pe.gob.sunat.framework.security.Coder;
import pe.gob.sunat.framework.spring.util.cache2.bean.ParamBean;
import pe.gob.sunat.framework.spring.util.cache2.dao.ParamDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/** Implementación de validaciones para tipo de devolucion 02 - Pago Indevido o en exceso.
 * 
 * @pdOid 65b02848-f5c0-40db-8517-3e3541ac929d */
@Service
public class ValidadorDevolucionTipo02Impl implements ValidadorDevolucionBaseService {
   /** @pdRoleInfo migr=no name=T3779FormularioDAO assc=association10 mult=1..1 */
   @Autowired
   private T3779FormularioDAO t3779FormularioDAO;
   /** @pdRoleInfo migr=no name=T5385CasPrimeraDAO assc=association11 mult=1..1 */
   @Autowired
   private T5385CasPrimeraDAO t5385CasPrimeraDAO;
   /** @pdRoleInfo migr=no name=T5386CasSegundaDAO assc=association13 mult=1..1 */
   @Autowired
   private T5386CasSegundaDAO t5386CasSegundaDAO;
   /** @pdRoleInfo migr=no name=T5387CasCuartaDAO assc=association14 mult=1..1 */
   @Autowired
   private T5387CasCuartaDAO t5387CasCuartaDAO;
   /** @pdRoleInfo migr=no name=T9030CasCuartaDAO assc=association14 mult=1..1 */
   @Autowired
   private T9030CasCuartaDAO t9030CasCuartaDAO;
   /** @pdRoleInfo migr=no name=T5847CtlDeclDAO assc=association15 mult=1..1 */
   @Autowired
   private T5847CtlDeclDAO t5847CtlDeclDAO;
   /** @pdRoleInfo migr=no name=DevolucionesDAO assc=association21 mult=1..1 */
   @Autowired
   private DevolucionesDAO devolucionesDAO;
   /** @pdRoleInfo migr=no name=ParamDevolucionDAO assc=association20 mult=1..1 */
   @Autowired
   private ParamDevolucionDAO paramDevolucionDAO;
   
   private Log log = LogFactory.getLog(getClass());
   
   private Coder coder = new Coder();
   
   private SimpleDateFormat format;
   
   private DecimalFormat decimalFormat;
   
   /** Obtiene el Codigo de FORMULARIO VIRTUAL  RENTA ANUAL OTRAS RENTAS  según el periodo y tipo de declaración (Persona Natural, Otros)
    * 
    * @param periodo Indica el periodo del formulario a buscar
    * @param tipoPersona Indica el tipo de formulario renta (1 PPNN , 2 PPJJ)
    * @pdOid 9f85da98-63a7-4bbb-9551-9edeaa370c20 */
   private String obtenerCodigoFormularioRenta(String periodo, String tipoPersona) {
      
      List<ParamBean> params = paramDevolucionDAO.buscar(Constantes.PARAM_FORMULARIOS, ParamDAO.TIPO1);
      if(params == null || params.size() <= 0)
         throw new BusinessException("No se encuentra información del parámetro " + Constantes.PARAM_FORMULARIOS, Constantes.MSG_ERROR_GRAL_NEGOCIO);
      
      for (ParamBean paramBean : params) {
         //Se verifica si es formulario anual
         String strformanual = GenericFunctions.setDefaultToNull(paramBean.getDescripcion().substring(27,28),"0");
         if(!strformanual.equals("3"))
            continue;

         //Se verifica si es para persona natural
         String strpernat    = GenericFunctions.setDefaultToNull(paramBean.getDescripcion().substring(29,30), "0");
         if(!strpernat.equals(tipoPersona))
            continue;
         
         //Se verifica el periodo del formulario
         String periodoBean  = GenericFunctions.setDefaultToNull(paramBean.getDescripcion().substring(62,66),"0");
         int valPeriodo = Integer.parseInt(periodoBean) -1 - Integer.parseInt(periodo.substring(0,4));
         if(valPeriodo == 0)
            return paramBean.getCodigo();
      }
      
      throw new BusinessException(String.format("No se encontrado el número de formulario para el periodo %s con el tipo %s ", periodo.substring(0,4), tipoPersona),
            String.format("No se puede realizar la búsqueda para el periodo %s debido a que no cuenta aún con un formulario de declaración de renta definido. \n Por favor, intente con otro periodo.", periodo.substring(0,4)));
   }
   
   /** Genera un código HASH con los valores pasados como parámetros. Este hash debe ser usado para la invocación del registro del 1649 (Formulario Antiguo)
    * 
    * @param numeroRuc Número de RUC del contribuyente que solicita la devolución.
    * @param apellidosNombres Apellidos y Nombres del contribuyente que solicita la devolución.
    * @param telefono Teléfono del contribuyente que solicita la devolución
    * @param tipoSolicitud Tipo de Solicitud de devolución registrada
    * @param formaDevolucion Forma de devolución seleccionada por el contribuyente.
    * @param codigoFormularioAsociado Código del formulario asociado
    * @param nroOrdenAsociado Nro de Orden del formulario asociado
    * @param tributoAsociado Tributo Asociado
    * @param importe Importe solicitado a devolver por el contribuyente
    * @param periodoAsociado Periodo asociado
    * @param login Usuario del contribuyente usado para el registro de la devolución.
    * @pdOid 851d394c-19d7-4b06-82f0-70d672b16261 */
   private String generarHash1649(String numeroRuc, String apellidosNombres, String telefono, String tipoSolicitud, String formaDevolucion, String codigoFormularioAsociado, Integer nroOrdenAsociado, String tributoAsociado, Double importe, String periodoAsociado, String login) {
      if(GenericFunctions.isBlankOrNull(numeroRuc))
         throw new BusinessException("No se puede generar un código HASH sin especificar el número de RUC del contribuyente.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(apellidosNombres))
         throw new BusinessException("No se puede generar un código HASH sin especificar los Nombres y Apellidos del contribuyente.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(tipoSolicitud))
         throw new BusinessException("No se puede generar un código HASH sin especificar tipoSolicitud.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(importe == null || importe <= 0)
         throw new BusinessException("No se puede generar un código HASH con importe menor a 0.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(formaDevolucion))
         throw new BusinessException("No se puede generar un código HASH sin especificar formaDevolucion.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(codigoFormularioAsociado))
         throw new BusinessException("No se puede generar un código HASH sin especificar codigoFormularioAsociado.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(nroOrdenAsociado == null ||  nroOrdenAsociado <= 0)
         throw new BusinessException("No se puede generar un código HASH con nroOrdenAsociado < 0.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(tributoAsociado))
         throw new BusinessException("No se puede generar un código HASH sin especificar tributoAsociado.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(periodoAsociado))
         throw new BusinessException("No se puede generar un código HASH sin especificar periodoAsociado.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      if(GenericFunctions.isBlankOrNull(login))
         throw new BusinessException("No se puede generar un código HASH sin especificar login.", Constantes.MSG_ERROR_GRAL_NEGOCIO);
      
      String hash = String.format("010100010X|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|",
            numeroRuc,
            apellidosNombres,
            telefono,
            tipoSolicitud,
            formaDevolucion,
            codigoFormularioAsociado,
            nroOrdenAsociado.toString(),
            tributoAsociado,
            decimalFormat.format(importe),
            periodoAsociado,
            login,
            format.format(new Date()));
      return coder.encodeBase64(hash);
   }
   
   /** Devuelve el código de tipo de devolución de la cual se está implementando su respectiva validación
    * 
    * @pdOid ab37285b-9029-4450-9acf-8d62dc375f20 */
   public String getTipoDevolucion() {
      return ConstantesDevolucion.TIPDEV_PAGOINDEVIDOEXCESO;
   }
   
   /** @pdOid 1534c9df-8242-4677-b9dc-57e136fb2f73 */
   public ValidadorDevolucionTipo02Impl() {
      format = new SimpleDateFormat(Constantes.FORMAT_DATE_TIME);
      decimalFormat = (DecimalFormat)DecimalFormat.getInstance(new Locale("es__", "pe"));
      decimalFormat.applyPattern(Constantes.FORMAT_NUMBERS_SN_COMAS);
   }
   
   /** Obtiene los tributos pendientes de devolucion segun periodos según el tipo de Key
    * 
    * @param model
    * @pdOid 36e20f70-68f4-400a-bc8e-e6bd3b8bbd8f */
   public List<TributoPendienteDevolucion> obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model) {
      List<TributoPendienteDevolucion> tributosPendientes = new ArrayList<TributoPendienteDevolucion>();

      SolicitudDevolucion solModel =  model.getSolicitudDevolucion();
      //Se Obtiene el código del formulario de Renta
      String codigoFormularioRenta = obtenerCodigoFormularioRenta(solModel.getPeriodo(), "1");
      
      //Se obtiene el último formulario presentado
      ControlDeclaracion controlDecl = new ControlDeclaracion();
      controlDecl.setNumeroFormulario(codigoFormularioRenta);
      controlDecl.setRuc(solModel.getRuc());
      controlDecl.setIndicadorEstado(2);
      List<ControlDeclaracion> ctrlDeclraciones =  t5847CtlDeclDAO.findByControlDeclaracion(controlDecl);
      if(ctrlDeclraciones == null || ctrlDeclraciones.size() <=0)
        throw new BusinessException(String.format("No se ha encontrado una declaración FV %s en estado %s para el ruc %s .",
               codigoFormularioRenta,
               "2",
               solModel.getRuc()),
               String.format("Usted no cuenta con un formulario FV %s en estado presentado.",
                     codigoFormularioRenta),
               ResponseStatus.Peligro);
      
      ControlDeclaracion declaracionPresentada = ctrlDeclraciones.get(0);
      
      String[] tributos = {Constantes.COD_TRIBUTO_RENTA_PRIMERA,
            Constantes.COD_TRIBUTO_RENTA_SEGUNDA,
            Constantes.COD_TRIBUTO_RENTA_TRABAJO};
      List<String> tributosADevolver = new ArrayList<String>();
      
      Devolucion filterBean = new Devolucion();
      for (String tributo : tributos) {
         filterBean.setRuc(solModel.getRuc());
         filterBean.setPeriodoDocumento(solModel.getPeriodo().substring(0,4) + "13");
         filterBean.setTributo(new NameValuePair(tributo));

         log.info(String.format("Verificando devolucion para tributo %s periodo %s para el ruc %s.",
               filterBean.getTributo().getValue(),
               filterBean.getPeriodoDocumento(),
               solModel.getRuc()));
         
         //Se imprime información de la validación realizada
         log.info(String.format("Validando devolucion registrada para tributo %s para el ruc %s en el periodo %s.",
               filterBean.getTributo().getValue(),
               filterBean.getRuc(),
               filterBean.getPeriodoDocumento()));
         
         //Se obtienen las Devoluciones presentadas por el contribuyente
         List<Devolucion> devolucionesPresen = devolucionesDAO.findByDevolucion(filterBean);
         if(devolucionesPresen == null || devolucionesPresen.size() == 0){
            //El tributo no cuenta con una solicitud de dvolucion presentada
            tributosADevolver.add(tributo);
            continue;
         } else {
            // En caso contrario, se verifica el estado de sus solicitudes de devolución
            Devolucion devolucionMayor = devolucionesPresen.get(0);
            if(devolucionesPresen.size() > 1){
               for (Devolucion devolucion : devolucionesPresen) {
                  if(devolucion.getNumeroDevolucion().compareTo(devolucionMayor.getNumeroDevolucion()) < 0)
                     devolucionMayor = devolucion;
               }
            }
            if(ConstantesDevolucion.RES_DEV_DENEGADA.equals(devolucionMayor.getIndicadorResultado())
                  || ConstantesDevolucion.RES_DEV_RECHAZADA.equals(devolucionMayor.getIndicadorResultado())
                  || ConstantesDevolucion.RES_DEV_DESESTIMIENTO.equals(devolucionMayor.getIndicadorResultado())){
               //En aso de desestimiento
               tributosADevolver.add(tributo);
               continue;
            }
         }
      }

      //Se verifican las casillas del tributo
      for (String codigoTributo : tributosADevolver) {
         boolean generarTributo = false;
         Double montoSolicitar = 0.0 ;
         
         log.info(String.format("Verificando casillas tributo %s para la declracion %s.",
               codigoTributo,
               declaracionPresentada.getNumeroSecuencia().toString()));
         
         if(Constantes.COD_TRIBUTO_RENTA_PRIMERA.equals(codigoTributo)){
            List<CasillasPrimera> casillas = t5385CasPrimeraDAO.findByNumeroSecuencia(declaracionPresentada);
            if(casillas == null || casillas.size() <=0)
               continue;
            
            CasillasPrimera casilla = casillas.get(0);
            
            if(Constantes.UNO.equals(casilla.getCasilla160())){
               
               if(!GenericFunctions.isNumber(casilla.getCasilla159()))
                  continue;
               
               try{
                  montoSolicitar = Double.parseDouble(casilla.getCasilla159());
               } catch (Exception ex){
                  log.error(String.format("Error en la conversion casilla 159 %s.",
                        casilla.getCasilla159()));
                  continue;
               }
               
               if(montoSolicitar > 0)
                  generarTributo =  true;
            }
            
         } else if (Constantes.COD_TRIBUTO_RENTA_SEGUNDA.equals(codigoTributo)){
            List<CasillasSegunda> casillas = t5386CasSegundaDAO.findByNumeroSecuencia(declaracionPresentada);
            if(casillas == null || casillas.size() <=0)
               continue;
            
            CasillasSegunda casilla = casillas.get(0);
            
            if(Constantes.UNO.equals(casilla.getCasilla361())){
               
               if(!GenericFunctions.isNumber(casilla.getCasilla360()))
                  continue;
               
               try{
                  montoSolicitar = Double.parseDouble(casilla.getCasilla360());
               } catch (Exception ex){
                  log.error(String.format("Error en la conversion casilla 360 %s.",
                        casilla.getCasilla360()));
                  continue;
               }
               
               if(montoSolicitar > 0)
                  generarTributo =  true;
            }
            
         } else if (Constantes.COD_TRIBUTO_RENTA_TRABAJO.equals(codigoTributo)){
            List<CasillasCuarta> casillas=null;
            int intPeriod= Integer.parseInt(solModel.getPeriodo().substring(0,4));
            log.debug("Periodo--->");
            log.debug("Periodo--->"+intPeriod);
            if(2017<=intPeriod ){
               log.debug("t9030CasCuartaDAO--->");
            casillas = t9030CasCuartaDAO.findByNumeroSecuencia(declaracionPresentada);
            } else {
               log.debug("t9030CasCuartaDAO--->");
            casillas = t5387CasCuartaDAO.findByNumeroSecuencia(declaracionPresentada);
            }
            
            
            if(casillas == null || casillas.size() <=0)
               continue;
            
            CasillasCuarta casilla = casillas.get(0);
            if(!Constantes.UNO.equals(casilla.getCasilla140()))
               continue;
            
            if(!GenericFunctions.isNumber(casilla.getCasilla141()))
               continue;
            
            try{
               montoSolicitar = Double.parseDouble(casilla.getCasilla141());
            } catch (Exception ex){
               log.error(String.format("Error en la conversion casilla 141 %s.",
                     casilla.getCasilla141()));
               continue;
            }
            
            //Se verifica si solo presenta rentas de quinta
            if(GenericFunctions.isBlankNullorEquals(casilla.getCasilla509(),"0") &&
                  GenericFunctions.isBlankNullorEquals(casilla.getCasilla116(),"0")){
               if(GenericFunctions.isBlankNullorEquals(casilla.getCasilla514(),"0"))
                  continue;
            }
               
            
            if(montoSolicitar > 0)
               generarTributo =  true;
         } else {
            throw new BusinessException(String.format("No se ha implementado el tributo %s .", codigoTributo),
                  Constantes.MSG_ERROR_GRAL_NEGOCIO);
         }
         if(generarTributo){
            TributoPendienteDevolucion  trbpend = new TributoPendienteDevolucion();
            trbpend.setTributo(paramDevolucionDAO.getNameValuePair(Constantes.PARAM_TRIBUTOS,ParamDAO.TIPO1,codigoTributo, 7,39 ));
            trbpend.setFormulario(paramDevolucionDAO.getNameValuePair(Constantes.PARAM_FORMULARIOS_DESC,ParamDAO.TIPO1, declaracionPresentada.getNumeroFormulario(), 0,29));
            trbpend.setPeriodo(solModel.getPeriodo());
            trbpend.setMonto(montoSolicitar);
            trbpend.setNumeroOrdenFormulario(declaracionPresentada.getNumeroOrden());
            String hash = generarHash1649(solModel.getRuc(),
                  solModel.getApellidosNombres(),
                  "0",
                  getTipoDevolucion(),
                  "3",
                  declaracionPresentada.getNumeroFormulario(),
                  declaracionPresentada.getNumeroOrden(),
                  codigoTributo,
                  trbpend.getMonto(),
                  solModel.getPeriodo(),
                  solModel.getLogin());
            trbpend.setHash(hash);
            tributosPendientes.add(trbpend);
         }
      }
      return tributosPendientes;
   }
   
   /** Realiza las validaciones correspondientes según el tipo de solicitud registrada
    * 
    * @param solicitudDevolucion Solicitud de devolución a validar
    * @pdOid d261cc39-9db7-4671-8615-63585287f099 */
   public List<Mensaje> validarRegistroDeSolicitud(SolicitudDevolucion solicitudDevolucion) {
      // TODO: implement
      return null;
   }
   
   /** Realiza acciones de post el registro de la solicitud de devolución
    * 
    * @param solicitudDevolucion
    * @pdOid 4a48032b-bcfe-4a3a-af8a-3b140f21aafb */
   public List<Mensaje> realizarAccionesPostRegistro(SolicitudDevolucion solicitudDevolucion) {
      // TODO: implement
      return null;
   }

}