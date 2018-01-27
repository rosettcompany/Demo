/***********************************************************************
 * Module:  SolicitudDevolucionServiceImpl.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SolicitudDevolucionServiceImpl
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillaDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DatosSecundarios;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DocumentoAsociado;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1693;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ResponsableEtapa;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.DevolucionesDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T8232InfoAyudaDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ibatis.ParamDevolucionDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ArrayListExtended;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesMensajes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.FuncionesGenericas;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;
import pe.gob.sunat.servicio.registro.model.dao.DdpDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T1113BueConDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T3617DctosAsocDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.CasDevDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TCorrEntDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.TRespEtaDevDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.ParamLocalDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.TributoPendienteDevolucion;
import pe.gob.sunat.framework.spring.util.cache2.bean.ParamBean;
import pe.gob.sunat.framework.spring.util.cache2.dao.ParamDAO;
import pe.gob.sunat.framework.spring.util.dao.SequenceDAO;
import pe.gob.sunat.framework.spring.util.jdbc.datasource.lookup.DataSourceContextHolder;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

/** Implementación de servicio de SolcitudDevolucionService
 * 
 * @pdOid 40fb48d9-2068-44b4-b513-11cda358167d */
@Service
public class SolicitudDevolucionServiceImpl implements SolicitudDevolucionService {
   private Log loger = LogFactory.getLog(getClass());
   private HashMap<String, ValidadorDevolucionBaseService> validadoresService = null;
   /** @pdRoleInfo migr=no name=ValidadorDevolucionBaseService assc=association8 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   @Autowired
   private java.util.List<ValidadorDevolucionBaseService> validadorDevolucionBaseService;
   /** @pdRoleInfo migr=no name=DevolucionesDAO assc=association12 mult=1..1 */
   @Autowired
   private DevolucionesDAO devolucionesDAO;
   /** @pdRoleInfo migr=no name=ContribuyenteService assc=association17 mult=1..1 */
   @Autowired
   private ContribuyenteService contribuyenteService;
   /** @pdRoleInfo migr=no name=T8232InfoAyudaDAO assc=association18 mult=1..1 */
   @Autowired
   private T8232InfoAyudaDAO t8232InfoAyudaDAO;
   /** @pdRoleInfo migr=no name=ParamDevolucionDAO assc=association19 mult=1..1 */
   @Autowired
   private ParamDevolucionDAO paramDevolucionDAO;
   /** @pdRoleInfo migr=no name=T1113BueConDAO assc=association22 mult=1..1 */
   @Autowired
   private T1113BueConDAO t1113BueConDAO;
   /** @pdRoleInfo migr=no name=T3617DctosAsocDAO assc=association25 mult=1..1 */
   @Autowired
   private T3617DctosAsocDAO t3617DctosAsocDAO;
   /** @pdRoleInfo migr=no name=CasDevDAO assc=association26 mult=1..1 */
   @Autowired
   private CasDevDAO casDevDAO;
   /** @pdRoleInfo migr=no name=TCorrEntDAO assc=association27 mult=1..1 */
   @Autowired
   private TCorrEntDAO tCorrEntDAO;
   /** @pdRoleInfo migr=no name=TRespEtaDevDAO assc=association28 mult=1..1 */
   @Autowired
   private TRespEtaDevDAO tRespEtaDevDAO;
   /** @pdRoleInfo migr=no name=ParamLocalDAO assc=association30 mult=1..1 */
   @Autowired
   private ParamLocalDAO paramLocalDAO;
   @Autowired
   private SequenceDAO sequenceDAO;
   @Autowired
   private DdpDAO ddpDAO;
   @Autowired
   private JavaMailSender javaMailSender;
   @Autowired
   private InternetAddress defaultInternetAddress;

   private static StringBuffer PALNTILLA_CONSTANCIA = null;
   private static String BANCOS_HABILITADOS = null;
   
   /** Se verifica que no exista una solicitud con el mismo Tipo Devolucion, Tributo y periodo (1649 o 4949) 
    * En caso de no cumplir con la validación se devuelve un objeto Mensaje, en caso contrario se devuelve null.
    * 
    * @param solicitudDevolucion
    * @pdOid ba0903fb-5599-4213-a03f-35bc1456e62e */
   private Mensaje verificarSolicitudDevolucionPresentada(SolicitudDevolucion solicitudDevolucion) {
      boolean existeDevolucion = true; 
      List<Devolucion> devolucionesPresen = devolucionesDAO.findByDevolucion(solicitudDevolucion);
      if(!GenericFunctions.isListEmptyOrNull(devolucionesPresen)) {
         // Se han encotrado devoluciones, se verifica el estado de  la mayor
         Devolucion devolucionMayor = devolucionesPresen.get(0);
         if(devolucionesPresen.size() > 1){
            for (Devolucion devolucion : devolucionesPresen) {
               if(devolucion.getNumeroDocumento().compareTo(devolucionMayor.getNumeroDocumento()) > 0)
                  devolucionMayor = devolucion;
            }
         }
         
         loger.info(String.format("Devolución analizada num_doc %s", devolucionMayor.getNumeroDocumento()));
         
         if(ConstantesDevolucion.RES_DEV_DENEGADA.equals(devolucionMayor.getIndicadorResultado())
               || ConstantesDevolucion.RES_DEV_RECHAZADA.equals(devolucionMayor.getIndicadorResultado())
               || ConstantesDevolucion.RES_DEV_DESESTIMIENTO.equals(devolucionMayor.getIndicadorResultado())
               || ConstantesDevolucion.RES_DEV_IMPROCEDENTE.equals(devolucionMayor.getIndicadorResultado())){
            //En aso de desestimiento
            existeDevolucion = false;
         }
      } else {
         existeDevolucion = false;
      }
      
      if(existeDevolucion)
         return new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_PENDIENTE);
      return null;
   }
   
   /** Se verifica el llenado correcto del periodo en la solicitud de devolución:
    *   - El formato del periodo debe estar deacorde al tipo de devolución
    *   - En periodo se debe encontrar dentro del periodo mínimo de registro
    * En caso de no cumplir con la validación se devuelve un objeto Mensaje, en caso contrario se devuelve null.
    * 
    * @param solicitudDevolucion
    * @pdOid ebda7635-ba77-480c-877b-2bbc437ed798 */
   private Mensaje verificarPeriodo(SolicitudDevolucion solicitudDevolucion) {
      // TODO: Se debe obtener la información del parametro B37 
      //       FUNCION 03 - 08   PERIODO MINIMO DE REGISTRO
      //       FUNCION 10 - 15   PERIODO MÁXIMO DE REGISTRO
      //       Para el requerimiento de RUS se realizará en el código fuente
      int periodo = Integer.parseInt(solicitudDevolucion.getPeriodoDocumento());
      if(periodo < 200401)
         return new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_PERIODO_ANTERIOR_MINIMO);
      return null;
   }
   
   /** Se verifica el llenado correcto de la forma de devolucion y los datos asociados en la solicitud de devolucion:
    *   - Si la forma de devolución es Abono en Cuenta, el monto solicitado debe ser menor igual a 100 000 soles.
    *   - Si la forma de devolucion es Abono en Cuenta, el contribuyente debe ser persona Natural 
    *   - Si la forma de devolucion es Abono en cuenta, el CCI debe pertenecer a los bancos asociados (parametro A88) 
    *   - Si la forma de devolucion es Abono en cuenta, y el CCI corresponde al banco de la nación , el CCI debe ser de Ahorros o Cuenta Corriente 
    *   - Si la forma de Devolucion es Abono en cuenta o OPF el tipo de documento del RUC Debe Ser DNI
    * En caso de no cumplir con la validación se devuelve una lista de objetos Mensaje, en caso contrario se devuelve null.
    * 
    * @param solicitudDevolucion
    * @pdOid 1d1dfa3a-bc13-4b7e-9cc4-72819d2f1137 */
   private List<Mensaje> verificarFormaDevolucion(SolicitudDevolucion solicitudDevolucion) {
      List<Mensaje> mensajes= new ArrayListExtended<Mensaje>();
      
      String formaDevolucion = solicitudDevolucion.getIndicadorFormaDevolucion().getValue();
      boolean tieneDNI = ConstantesDevolucion.RUC_TIPO_DOC_DNI.equals(contribuyenteService.tipoDocumentoRegistradoPadronRuc(solicitudDevolucion.getRuc()));
      boolean isPersonaNatural = contribuyenteService.isPersonaNatural(solicitudDevolucion.getRuc());
      if(ConstantesDevolucion.FORMA_ABONO.equals(formaDevolucion)
            || ConstantesDevolucion.FORMA_OPF.equals(formaDevolucion)) {
         if(!tieneDNI && isPersonaNatural) {
            mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_NO_DNI));
         }
         
         if (!isPersonaNatural)
            mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion,
                  String.format(ConstantesMensajes.MSJ_DEVOLUCION_FORMA_NO_PERSONA_NATURAL,
                        solicitudDevolucion.getIndicadorFormaDevolucion().getName())));
      }
      
      if(ConstantesDevolucion.FORMA_ABONO.equals(formaDevolucion)) {
         //Se realizan las validaciones de ABONO en CUENTA
         if(GenericFunctions.isBlankOrNull(solicitudDevolucion.getCci()))
            mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_CCI));
         else {
            if(solicitudDevolucion.getCci().length() != 20 || !solicitudDevolucion.getCci().matches("^[0-9]+$")) {
               mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_CCI_INVALIDO));
            } else {
               // Se verifica si el código de CCI corresponde a uno de los bancos autorizados
               String codigoBanco = solicitudDevolucion.getCci().substring(0,3);
               String bancoDesc = paramDevolucionDAO.obtenerDescripcion(ConstantesDevolucion.PRM_BANCOS_CCI,  ParamDAO.TIPO1, codigoBanco);
               if(GenericFunctions.isBlankOrNull(bancoDesc)){
                  mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, 
                        String.format(ConstantesMensajes.MSJ_DEVOLUCION_FORMA_BANCO_NO_HABILITADO, BANCOS_HABILITADOS)));
               }
               else{
                  if(codigoBanco.equals("018")){
                     String digito = String.valueOf(solicitudDevolucion.getCci().charAt(8));
                     if(!(digito.equals("4") || digito.equals("0"))){
                        mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_BANCO_NACION_NO_VALIDO));
                     }
                  }
              }
            }
         }
         String montoAbono = paramDevolucionDAO.obtenerDescripcionTipo1(ConstantesDevolucion.PRM_VALORES_NORMATIVOS, "0001").substring(70).trim();
         int montoMax = Integer.parseInt(montoAbono);
         if(solicitudDevolucion.getMontoSolicitado() > montoMax)
            mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_ABONO_MTO_MAXIMO));
         
      } else if (ConstantesDevolucion.FORMA_CHEQUE.equals(formaDevolucion)) {
         if(isPersonaNatural && tieneDNI){
            String montoCheque =paramDevolucionDAO.obtenerDescripcionTipo1(ConstantesDevolucion.PRM_VALORES_NORMATIVOS, "0002").substring(70).trim();
            int montoMax = Integer.parseInt(montoCheque);
            if(solicitudDevolucion.getMontoSolicitado() < montoMax)
               mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_DEVOLUCION_FORMA_CHEQUE_MTO_MAXIMO));
         }
      }
      
      if(GenericFunctions.isListEmptyOrNull(mensajes))
         return null;
      return mensajes;
   }
   
   /** Envia un correo electrónico al área operativa en caso de que el contribuyente que haya presentado la Solicitud Devolución sea BUC (Buen Contribuyente).
    * 
    * @param solicitudDevolucion
    * @throws SQLException 
    * @pdOid d1c4e839-4f64-4903-9445-970584e4e2dc */
   private boolean enviarCorreoSiBUC(SolicitudDevolucion solicitudDevolucion) throws Exception {
      int cantidad = t1113BueConDAO.obtenerCantidadRegistros(solicitudDevolucion.getRuc());
      if(cantidad >= 0) {
         //Se obtiene el código de la intendencia:
         NameValuePair uuoo = paramLocalDAO.getNameValuePairByDependencia("648", solicitudDevolucion.getCodigoDependencia());
         if(uuoo == null)
            return false;
         //Se invoca un servicio para obtener los datos del Intendente de la UUOO
         RestTemplate rest = new RestTemplate();
         HashMap<String, String> datos_uuoo = rest.getForObject("http://api.sunat.peru/v1/recurso/humano/personal/e/unidadesorganicas/{code}", HashMap.class, uuoo.getValue());
         if(!GenericFunctions.isBlankOrNull(datos_uuoo.get("codJefatura"))) {
            //Se obtiene el correo del jefe de la UUOO
            HashMap<String, String> result = rest.getForObject("http://api.sunat.peru/v1/recurso/humano/personal/e/personalsunat/{code}", HashMap.class, datos_uuoo.get("codJefatura"));
            if(!GenericFunctions.isBlankOrNull(result.get("dirCorreo"))) {
               String mensaje = "El contribuyente %s con RUC %s ha presentado una solicitud de devolución, por lo que deberá ser atendido en el plazo previsto en el Decreto Supremo de Buenos contribuyentes.";
               MimeMessage message = javaMailSender.createMimeMessage();
               MimeMessageHelper helper = new MimeMessageHelper(message);
               helper.setTo(result.get("dirCorreo"));
               helper.setText(String.format(mensaje,
                        solicitudDevolucion.getApellidosNombres(),
                        solicitudDevolucion.getRuc()),
                     true);
               helper.setSubject("Buenos Contribuyentes - Atención de Solicitud de Devolución");
               helper.setFrom(defaultInternetAddress);
               loger.info(String.format("Enviando correo electrónico BUC a %s.", result.get("dirCorreo")));
               javaMailSender.send(message);
            }
         }
      }
      return false;
   }
   
   /** Realiza las validaciones correspondientes según el tipo de solicitud registrada
    * 
    * @param solicitudDevolucion Solicitud de devolución a validar
    * @throws Exception 
    * @pdOid 5d3bf643-2f78-4f4c-b162-35395f0f71e0 */
   private List<Mensaje> validarRegistroSolicitud(SolicitudDevolucion solicitudDevolucion) throws Exception {
      List<Mensaje> mensajes = new ArrayListExtended<Mensaje>();
      
      //Se verifica si el contribuyente presentó la solicitud
      mensajes.add(verificarSolicitudDevolucionPresentada(solicitudDevolucion));
      
      //Se verifica si el periodo registrado es correcto
      mensajes.add(verificarPeriodo(solicitudDevolucion));
      
      //Se verifica si el la forma de devolución es correcta
      mensajes.addAll(verificarFormaDevolucion(solicitudDevolucion));
      
      //Se realizan las validaciones propias según el tipo de solicitud
      ValidadorDevolucionBaseService service = obtenerValidadorService(solicitudDevolucion.getTipoSolicitud());
      mensajes.addAll(service.validarRegistroDeSolicitud(solicitudDevolucion));
      
      if(GenericFunctions.isListEmptyOrNull(mensajes))
         return null;
      return mensajes;
   }
   
   /** Realiza acciones de post el registro de la solicitud de devolución
    * 
    * @param solicitudDevolucion
    * @throws Exception 
    * @pdOid 81f0b206-a8d9-4287-8eb6-e0f9d0a8c8ef */
   private void realizarAccionesPostRegistro(SolicitudDevolucion solicitudDevolucion) throws Exception {
      ValidadorDevolucionBaseService service = validadoresService.get(solicitudDevolucion.getTipoSolicitud().getValue());
      if(service == null)
         throw new RuntimeException(String.format("No se ha encontrado un ValidadorDevolucionBaseService para el tipo de devolución [%s].", solicitudDevolucion.getTipoSolicitud().getValue()));
      
      //Envio de correo electrónico en caso de ser BUC
      enviarCorreoSiBUC(solicitudDevolucion);
      
      service.realizarAccionesPostRegistro(solicitudDevolucion);
   }
   
   /** Obtiene el validador personalizado según el tipo de solicitud
    * 
    * @param tipoSolicitud Tipo de solicitud.
    * @pdOid b1b5109b-3cd1-4cdf-9c3d-b389a945eb9c */
   private ValidadorDevolucionBaseService obtenerValidadorService(NameValuePair tipoSolicitud) {
      if(tipoSolicitud == null || GenericFunctions.isBlankOrNull(tipoSolicitud.getValue()))
         throw new RuntimeException(String.format("El parámetro model debe contener un dato en el atributo solicitudDevolucion.TipoSolicitud ."));
      
      ValidadorDevolucionBaseService service = validadoresService.get(tipoSolicitud.getValue());
      if(service == null)
         throw new RuntimeException(String.format("No se ha encontrado un ValidadorDevolucionBaseService para el tipo de devolución [%s].", tipoSolicitud));
      return service;
   }
   
   /** Obtiene un objeto Solicitud de Devolucion con atributos necesarios para la generación de una constancia de presentación
    * 
    * @param numeroDevolucion Número de devolucion
    * @pdOid 149e6f3a-0ca2-4af6-9281-150bcbf9724c */
   public SolicitudDevolucion obtenerConstanciaPresentacion(String numeroDevolucion) {
      // TODO: implement
      return null;
   }
   
   /** Obtiene los tributos pendientes de devolucion segun periodos según el tipo de Key
    * 
    * @param model
    * @pdOid 3a60fe62-4152-478a-8d7d-91a87ddea035 */
   public List<TributoPendienteDevolucion> obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model) {
      DataSourceContextHolder.setKeyDataSource(Constantes.DATASOURCE_READ_KEY);
      ValidadorDevolucionBaseService service = obtenerValidadorService(model.getSolicitudDevolucion().getTipoSolicitud());
      return service.obtenerTributosPendientesDevolucion(model);
   }
   
   /** Registra la devolucion en la base de datos
    * 
    * @param devolucion
    * @throws Exception 
    * @throws  
    * @pdOid feabbac5-c4ff-4205-acf4-44a2408b43c1 */
   public List<Mensaje> registrarSolicitudDevolucion(SolicitudDevolucion devolucion) throws Exception {
      DataSourceContextHolder.setKeyDataSource(Constantes.DATASOURCE_READ_KEY);
      //Se realizan las validaciones de registro
      List<Mensaje> mensajes = validarRegistroSolicitud(devolucion);
      if(!GenericFunctions.isListEmptyOrNull(mensajes))
         return mensajes;
      
      //Se realizan las validaciones propias 
      ValidadorDevolucionBaseService service = obtenerValidadorService(devolucion.getTipoSolicitud());
      service.validarRegistroDeSolicitud(devolucion);
      
      // Se obtiene la dependencia del contribuyente
      Map<String, String> datos_ruc = ddpDAO.findByPK(devolucion.getRuc());
      String dependencia = datos_ruc.get("ddp_numreg").trim();
      devolucion.setCodigoDependencia(dependencia);
      
      //Se establece el número de orden de la devolución
      Long numeroDevolucion =sequenceDAO.getNextSequence(ConstantesDevolucion.SEQUENCIA_DEVOLUIONES + dependencia);
      devolucion.setNumeroDevolucion(String.format(ConstantesDevolucion.FORMATO_NUM_DEVOLUCION,
            dependencia,
            numeroDevolucion));
      
      //Se establece el número de orden 
      Long numeroCorrelativo = sequenceDAO.getNextSequence(ConstantesDevolucion.SEQUENCIA_DEVOLUIONES_CORRELATIVO);
      devolucion.setNumeroCorrelativo(Integer.valueOf(numeroCorrelativo.toString()));
      
      //Se obtiene el número de lote
      int lote = tCorrEntDAO.obtenerCorrelativo(ConstantesDevolucion.CORR_ENT_DEPENDENCIA, ConstantesDevolucion.CORR_ENT_DOCUMENTO);
      if(numeroCorrelativo <= 1)
         tCorrEntDAO.actualizarCorrelativo(ConstantesDevolucion.CORR_ENT_DEPENDENCIA, ConstantesDevolucion.CORR_ENT_DOCUMENTO, ++lote);
      devolucion.setNumeroLote(lote);

      //Se establece el número de documento
      if(ConstantesDevolucion.CODIGO_FORMULARIO_INTERNET.equals(devolucion.getCodigoFormulario())) {
         Long numeroDocumento = sequenceDAO.getNextSequence(ConstantesDevolucion.SEQUENCIA_NUMERO_DOCUMENTO);
         devolucion.setNumeroDocumento(String.valueOf(numeroDocumento));
      }
      
      //Se establece el área evaluadora
      int areaEvaluadora = Integer.parseInt(dependencia);
      areaEvaluadora++;
      devolucion.setCodigoAreaEvaluadora(String.format("%03d", areaEvaluadora));
      
      //Se establece el ente
      HashMap<String, String> ente = tCorrEntDAO.obtenerEnte(devolucion.getTipoSolicitud().getValue(),
            devolucion.getTributo().getValue(),
            Constantes.DEFAULT_NULL_DATE);
      devolucion.setCodigoEnte(ente.get("ente"));
      
      //Se establece la fecha de presentación
      devolucion.setFechaDocumento(new Date());
      devolucion.setIndicadorEtapa(Constantes.INDICADOR_INACTIVO);
      devolucion.setIndicadorEstado(Constantes.INDICADOR_INACTIVO);
      devolucion.setIndicadorTipoGarantia(Constantes.INDICADOR_INACTIVO);
      devolucion.setIndicadorAreaOperativa(Constantes.INDICADOR_INACTIVO);
      devolucion.setIndicadorResultado(Constantes.INDICADOR_INACTIVO);
      devolucion.setIndicadorAreaOperativa(Constantes.INDICADOR_ACTIVO);
      devolucion.setFlagCuentaActiva(Constantes.INDICADOR_ACTIVO);
      
      devolucion.setTipoCalculoInteres(Constantes.INDICADOR_ACTIVO);
      devolucion.setCodigoTipoSmod(devolucion.getTipoSolicitud().getValue());
      
      devolucion.setNumeroCiclo(1);
      devolucion.setMontoCompensado(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoCompensadoAuditoria(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoDevolver(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoGarantia(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoInteres(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoReconocido(Constantes.DOUBLE_DEFECTO);
      devolucion.setMontoRetenido(Constantes.DOUBLE_DEFECTO);
      
      devolucion.setFechaDocumentoAsociado(Constantes.DEFAULT_NULL_DATE);
      devolucion.setFechaFinCalculoInteres(Constantes.DEFAULT_NULL_DATE);
      devolucion.setFechaInicioCalculoInteres(Constantes.DEFAULT_NULL_DATE);
      devolucion.setFechaProyeccionEmision(Constantes.DEFAULT_NULL_DATE);
      devolucion.setFechaResolucionIntendencia(Constantes.DEFAULT_NULL_DATE);
      
      //Se verifica si hay un archivo adjunto 
      if(devolucion.getArchivoSustento() != null) {
         if(devolucion.getArchivoSustento().getSize() <= 0)
            throw new BusinessException(String.format("El archivo %s adjuntado tiene un tamaño 0", devolucion.getArchivoSustento().getOriginalFilename()),
                  "El archivo que ha adjuntado está vacío. Por favor, seleccione otro archivo.");

         if(!devolucion.getArchivoSustento().getOriginalFilename().toLowerCase().endsWith("pdf"))
            throw new BusinessException(String.format("El archivo %s adjuntado no es un pdf", devolucion.getArchivoSustento().getOriginalFilename()),
                  "La extensión del archivo de sustento debe ser pdf");

         Path rut = Paths.get(ConstantesDevolucion.DIRECTORY_TEMPORAL + "/" +devolucion.getArchivoSustento().getOriginalFilename());
         File fl = rut.toFile();
         devolucion.getArchivoSustento().transferTo(fl);
         int numero = FuncionesGenericas.grabarArchivoArchBin(fl, 0);
         fl.delete();
         if(numero <= 0) {
            throw new BusinessException(String.format("No se ha podido cargar el archivo %s al archbin", fl.getPath()), Constantes.MSG_ERROR_GRAL_NEGOCIO);
         }
         devolucion.setCodigoArchivoSustento(numero);
      }
      
      // Se realiza el grabado en la base de datos, la grabación es transaccional
      grabarDevolucion(devolucion);
      
      //Se verifica que se haya asignado un número de devolución.
      if(GenericFunctions.isBlankOrNull(devolucion.getNumeroDevolucion()))
         throw new BusinessException("Se ha realizado el grabado de la devolución, pero no se ha seteado el número de devolución. Posible error de programación",
               Constantes.MSG_ERROR_GRAL_NEGOCIO);
      
      // Se realizan las acciones de post registro
      try {
         realizarAccionesPostRegistro(devolucion);
      } catch (Exception e ) {
         // Los errores de acciones posteriores al registro son ignorados.
         loger.info(GenericFunctions.formatException("Error No critico al realizar acciones de POST-REGISTRO ", e));
      }
      
      return null;
   }
   
   /** Obtiene la lista de Tipos de Solicitud de Devoluciones habilitadas
    * 
    * @pdOid 8be6c1ad-fc84-4772-a4b7-e51e8a57bb9c */
   public List<NameValuePair> obtenerTiposSolicitud() {
      // TODO: Se debe obtener la información del parametro B37 
      //       ARGUMENTO 01 - 02 CÓDIGO DEL TIPO DE DEVOLUCION
      //       Para el requerimiento de RUS se realizará en el código fuente
      List<NameValuePair> solis = new ArrayList<NameValuePair>();
      solis.add(new NameValuePair("PAGOS INDEBIDOS Y/O EN EXCESO", "02" ));
      solis.add(new NameValuePair("PERCEPCIÓN SUJETOS NO AFECTOS AL IGV - NUEVO RUS", "28" ));
      return solis;
   }
   
   /** Obtiene una lista de los Tributos Asociados al Tipo de devolución
    * 
    * @param tipoDevolucion Tipo de Devolución
    * @pdOid f8a23aa6-f6e3-4f32-9ce9-da817ac75524 */
   public List<NameValuePair> obtenerTributosPorTipoSolicitud(String tipoDevolucion) {
      // TODO: Se debe obtener la información del parametro B37 
      //       ARGUMENTO 03 - 08 CÓDIGO DEL TIPO DE TRIBUTO
      //       Para el requerimiento de RUS se realizará en el código fuente
      /* la lista de tributos se obtendria con el siguiente query
     SELECT TXTS.T01_ARGUMENTO[1,2] T01_ARGUMENTO,
       TRIM(TRIB.T01_ARGUMENTO) || '-' || TRIB.T01_FUNCION[8,38]
        || ' (' || TRIM(TRIB.T01_FUNCION[1,7]) || ')'
        FROM T01PARAM TXTS,
             T01PARAM TRIB
       WHERE TRIB.T01_NUMERO = '123'
         AND TRIB.T01_TIPO   = 'D' 
         AND TRIB.T01_ARGUMENTO[1,1] = '0'
         AND TXTS.T01_NUMERO = 'B37'
         AND TXTS.T01_TIPO   = 'D' 
         AND TRIM(TRIB.T01_ARGUMENTO) = TRIM(TXTS.T01_ARGUMENTO[3,8]) 
      */
      List<NameValuePair> solis = new ArrayList<NameValuePair>();
      if("02".equals(tipoDevolucion)){
         solis.add(new NameValuePair("3072 RTA.-REGULARIZ.-RTA. DE CAPITAL (RTARCA)", "030702"));
         solis.add(new NameValuePair("3073 RTA.-REGULARIZ.-RTA. DE TRABAJO (RTARTR)", "030703"));
         solis.add(new NameValuePair("3074 RTA.-REGULARIZ.-RTA.2DA.CATEG.  (RTARSE)", "030704"));
      } else {
         solis.add(new NameValuePair("1011 IGV - OPER. INT. - CTA. PROPIA  (IGVICP)", "010101"));
      }
      return solis;
   }
   
   /** Obtiene el escrito fundamentado según Tipo de Devolución y Tributo
    * 
    * @param ruc 
    * @param tipoDevolucion 
    * @param tributo
    * @pdOid 2dd0adb2-a39e-403f-b03e-d069b81b5027 */
   public String obtenerEscritoFundamentado(String ruc, String tipoDevolucion, String tributo) {
      Map<String, String> datos_ruc = ddpDAO.findByPK(ruc);
      // TODO: Se debe obtener la información de la tabla T8232InfoAyudaDAO
      //       Para el requerimiento de RUS se realizará en el código fuente
      return "Yo, %RAZON_SOCIAL% identificado con RUC %RUC% solicito la devolución del tributo %TRIBUTO% correspondiente al período %PERIODO% por el monto de %IMPORTE% por el motivo siguiente: Pago indebido o Pago en exceso del tributo  (Originado mediante Retenciones o Percepciones del IGV, pago adelantado del tributo, u otro motivo)."
            .replace("%RUC%", ruc)
            .replace("%RAZON_SOCIAL%", datos_ruc.get("ddp_nombre").trim());
   }
   
   /** Obtiene la forma de devolción por defecto según tipo de solicitud y tributo.
    * 
    * @param ruc 
    * @param tipoDevolucion 
    * @param tributo
    * @pdOid 5c753340-3c01-4519-b821-91459cdbe275 */
   public NameValuePair obtenerFormaDevolucionDefecto(String ruc, String tipoDevolucion, String tributo) {
      // TODO: Se debe obtener la información del parametro B37 
      //       FUNCIÓN 38 - 41   FORMA DE DEVOLUCION POR DEFECTO
      //       Para el requerimiento de RUS se realizará en el código fuente

      //TODO: Se elimina el registro de abono en cuenta a solicitud del usuario  
      /*if(ConstantesDevolucion.RUC_TIPO_DOC_DNI.equals(contribuyenteService.tipoDocumentoRegistradoPadronRuc(ruc)) 
            && contribuyenteService.isPersonaNatural(ruc))
         return new NameValuePair("Abono en Cuenta", "4");
      else*/
         return null;
   }
   
   /** Obtiene una lista de formas de devolución
    * 
    * @param tipoDevolucion Código del tipo de devolución
    * @param tributo Código del Tributo
    * @param ruc RUC del contribuyente
    * @pdOid d2139c8b-93cc-4f89-ab38-0ff27dda788f */
   public List<NameValuePair> obtenerFormasDevolucion(String tipoDevolucion, String tributo, String ruc) {
      // TODO: Se debe obtener la información del parametro B37 
      //       FUNCIÓN 29 - 36   FORMAS DE DEVOLUCIÓN HABILITADAS
      //       Para el requerimiento de RUS se realizará en el código fuente
      List<NameValuePair> formasDevolucion = new ArrayList<NameValuePair>();
      formasDevolucion.add(new NameValuePair("OPF", ConstantesDevolucion.FORMA_OPF));
      formasDevolucion.add(new NameValuePair("Cheque", ConstantesDevolucion.FORMA_CHEQUE));
      
      //TODO: Se elimina el registro de abono en cuenta a solicitud del usuario
      //formasDevolucion.add(new NameValuePair("Abono en Cuenta", ConstantesDevolucion.FORMA_ABONO));
      return formasDevolucion;
   }
   
   /** Obtiene el modo de llenado asociado al Tipo de Devolución y el Tributo Seleccionado
    * 
    * @param tipoDeDevolucion Tipo de Devolución por el cual se va a solicitar la devolución
    * @param tributo Tributo por el cual se va a solicitar la devolución.
    * @pdOid a32c1773-9cce-42c7-8e06-71005f3e0508 */
   public String obtenerModoLlenado(String tipoDeDevolucion, String tributo) {
      // TODO: Se debe obtener la información del parametro B37 
      //       FUNCIÓN 21 - 21   INDICADOR DEL MODO DE LLENADO (1 Asistido, 2 Manual)
      //       Para el requerimiento de RUS se realizará en el código fuente
      if("02".equals(tipoDeDevolucion))
         return ConstantesDevolucion.MODO_LLENADO_ASISTIDO;
      return ConstantesDevolucion.MODO_LLENADO_MANUAL;
   }
   
   /** Obtiene el texto de ayuda relacionado al archivo de sustento a ser adjunato. El texto se obtiene en función 
    * 
    * @param tipoDevolucion Tipo de Devolución
    * @param tributo Tributo
    * @pdOid 928a6fcd-f0d6-40e4-abb2-7410828f38cf */
   public String obtenerTextoAyudaArchivoSustento(String tipoDevolucion, String tributo) {
      // TODO: Se debe obtener la información de la tabla T8232InfoAyudaDAO
      //       Para el requerimiento de RUS se realizará en el código fuente
      return "Relación de los proveedores que le efectuaron la percepción del IGV.";
   }
   
   /** Realiza las validaciones relacionadas antes del llenado de datos de la solicitud de devolución. Las validaciones realizadas son las siguientes:
    *  - Valida si el RUC se encuentra con Baja Definitiva: 
    *     - Por fallecimiento.
    *     - Baja definitiva cuyo motivo de baja no es fallecimiento.
    * - Valida si el RUC tiene estado distinto a ACTIVO.
    * - Valida si su condición domiciliaria es diferente a la de HABIDO.
    * 
    * 
    * @param ruc
    * @pdOid 51f539d1-b0b0-4278-abe7-4d03654e4627 */
   public List<Mensaje> verificarCondicionHabilitado(String ruc) {
      List<Mensaje> mensajes = new ArrayList<Mensaje>();
      Map<String, String> datos_ruc = ddpDAO.findByPK(ruc);
      
      // Se evalua el estado del contribuyente
      String estado = datos_ruc.get("ddp_estado");
      if(contribuyenteService.isPersonaNatural(ruc)) {
         if(ConstantesDevolucion.RUC_BAJA_DEFINITIVA.equals(estado)) {
            DatosSecundarios datosSecundarios = contribuyenteService.obtenerDatosSecundarios(ruc);
            if(ConstantesDevolucion.RUC_BAJA_FALLECIMIENTO.equals(datosSecundarios.getMotivoDeBaja()))
               mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_CONTRIBUYENTE_FALLECIMIENTO));
            else
               mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_CONTRIBUYENTE_BAJA));
         } else {
            if(!ConstantesDevolucion.RUC_HABIDO.equals(estado))
               mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_CONTRIBUYENTE_NO_ACTIVO));
         }
      }

      // Se evalua la condición de domicilio del contribuyente
      String condicion = datos_ruc.get("ddp_flag22");
      if(ConstantesDevolucion.RUC_DIR_NO_HABIDO.equals(condicion))
         mensajes.add(new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_CONTRIBUYENTE_NO_HABIDO));

      if(GenericFunctions.isListEmptyOrNull(mensajes))
         return null;
      return mensajes;
   }
   
   /** Obtiene el texto en formato HTML relacionado a la información importante a tomar en cuenta según forma de devolución.
    * 
    * @param ruc 
    * @param formaDevolucion
    * @pdOid dbfec5d4-e1be-4952-b33e-8b0e329e2671 */
   public String obtenerInformacionImportantePorFormaDevolucion(String ruc, String formaDevolucion) {
      // TODO: Se debe obtener la información de la tabla T8232InfoAyudaDAO
      //       Para el requerimiento de RUS se realizará en el código fuente
      Map<String, String> datos_ruc = ddpDAO.findByPK(ruc);
      String informacion = null;
      if(formaDevolucion.equals("4"))
         informacion = "<p>El depósito Importe solicitado se hará a la cuenta CCI (Código de Cuenta Interbancario) que usted ha registrado en el presente formulario.<br />Considerar lo siguiente:</p><ul><li>El CCI debe corresponder a una cuenta bancaria en Soles.</li><li>La cuenta de ahorros debe estar registrada a nombre de : %RAZON_SOCIAL%</li></ul><p>En caso de haber problemas en el depósito o no ser válido el CCI, se modificará automáticamente la forma de devolución a OPF.</p>";
      else if (formaDevolucion.equals("3"))
         informacion = "<p>La forma de devolución mediante OPF no permite que un tercero con poder cobre el dinero en el Banco.</p>";
      if(informacion!= null)
         informacion = informacion
         .replace("%RUC%", ruc)
         .replace("%RAZON_SOCIAL%", datos_ruc.get("ddp_nombre").trim());
      return informacion;
   }
   
   /** Envia un correo electrónico al contribuyente con la información de su constancia de presentación.
    * 
    * @param solicitudDevolucion 
    * @param correoElectronico
    * @throws MessagingException 
    * @throws UnsupportedEncodingException 
    * @pdOid 9fca31af-3e9e-40ec-b26e-71032832c0bc */
   public void enviarConstanciaCorreoElectronico(SolicitudDevolucion solicitudDevolucion, String correoElectronico) throws MessagingException {
      String info = ConstantesDevolucion.INFORMACION_ADICIONAL_VACIA;
      if(ConstantesDevolucion.FORMA_OPF.equals(solicitudDevolucion.getIndicadorFormaDevolucion().getValue()))
         info = ConstantesDevolucion.INFORMACION_ADICIONAL_OPF;
      if(ConstantesDevolucion.FORMA_ABONO.equals(solicitudDevolucion.getIndicadorFormaDevolucion().getValue()))
         info = ConstantesDevolucion.INFORMACION_ADICIONAL_ABONO;
      String mensaje = new String(PALNTILLA_CONSTANCIA)
            .replaceAll("\\$\\$Tipo\\$\\$", solicitudDevolucion.getTipoSolicitud().getValueName())
            .replaceAll("\\$\\$NumRUC\\$\\$", solicitudDevolucion.getRuc())
            .replaceAll("\\$\\$NomContribuyente\\$\\$", solicitudDevolucion.getApellidosNombres())
            .replaceAll("\\$\\$Telefono\\$\\$", solicitudDevolucion.getTelefono())
            .replaceAll("\\$\\$FormularioSolDev\\$\\$", "1649")
            .replaceAll("\\$\\$NumOrden\\$\\$", solicitudDevolucion.getNumeroDocumento())
            .replaceAll("\\$\\$Periodo\\$\\$", solicitudDevolucion.getPeriodoDocumento())
            .replaceAll("\\$\\$FormaDevolucion\\$\\$", solicitudDevolucion.getIndicadorFormaDevolucion().getName())
            .replaceAll("\\$\\$Monto\\$\\$", Constantes.DECIMAL_FORMAT.format(solicitudDevolucion.getMontoSolicitado()))
            .replaceAll("\\$\\$Tributo\\$\\$", solicitudDevolucion.getTributo().getName())
            .replaceAll("\\$\\$Fecha\\$\\$", Constantes.DATE_FORMAT_DDMMYYYY.format(solicitudDevolucion.getFechaDocumento()))
            .replaceAll("\\$\\$escrito\\$\\$", solicitudDevolucion.getEscritoFundamentado())
            .replaceAll("\\$\\$ArchivoSustento\\$\\$", solicitudDevolucion.getPresentoArchivoSustento())
            .replaceAll("\\$\\$cci\\$\\$", solicitudDevolucion.getCci() != null ? String.format(ConstantesDevolucion.TR_CCI, solicitudDevolucion.getCci()) : ConstantesDevolucion.INFORMACION_ADICIONAL_VACIA)
            .replaceAll("\\$\\$infoAdicional\\$\\$", info);
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message);
      helper.setTo(correoElectronico);
      helper.setText(mensaje, true);
      helper.setSubject("Solicitud Devolucion");
      helper.setFrom(defaultInternetAddress);
      javaMailSender.send(message);
   }
   
   /** Inicializa todos los servicios de validación encontrados al momento de terminar la carga de SPRING.
    * @throws Exception 
    * 
    * @pdOid e0f1bb1d-843c-4d74-b778-32d9c03100ac */
   @PostConstruct
   public void inicializarServiciosValidacion() throws Exception {
      validadoresService = new HashMap<String, ValidadorDevolucionBaseService>();
      for (ValidadorDevolucionBaseService service : validadorDevolucionBaseService) {
         validadoresService.put(service.getTipoDevolucion(), service);
      }
      
      if(PALNTILLA_CONSTANCIA != null )
         return;
      // Se carga la plantilla
      BufferedReader lector = new BufferedReader(new FileReader(ConstantesDevolucion.DIRECTORY_PLANTILLAS + "PLANTILLA_CONSTANCIA.html"));
      PALNTILLA_CONSTANCIA = new StringBuffer();
      String linea;
      while((linea = lector.readLine()) != null) 
         PALNTILLA_CONSTANCIA.append(linea + "\n");
      lector.close();
      if(BANCOS_HABILITADOS == null) {
         BANCOS_HABILITADOS = "";
         List<ParamBean> params = paramDevolucionDAO.buscarTipo1(ConstantesDevolucion.PRM_BANCOS_CCI);
         for (ParamBean object : params) {
            BANCOS_HABILITADOS += "<br />" + object.getDescripcion().substring(0, 80).trim();
         }
      }
      
   }
   
   /** Graba la solicitud de devolución en la base de datos. Esta función maneja transacciones.
    * 
    * @param solicitud
    * @pdOid a12f6357-4356-4c88-8217-609e2bd0c646 */
   @Transactional(readOnly = false, rollbackFor=Exception.class, isolation = Isolation.READ_UNCOMMITTED)
   public void grabarDevolucion(SolicitudDevolucion solicitud) {
      DataSourceContextHolder.setKeyDataSource(Constantes.DATASOURCE_TRANSACTIONAL_KEY);
      //Registro de la devolución
      devolucionesDAO.insert(solicitud);
      
      //Se graban las casillas
      List<CasillaDevolucion> casillas = solicitud.getCasillas();
      for (CasillaDevolucion casillaDevolucion : casillas) {
         casDevDAO.insert(casillaDevolucion);
      }
      
      //Se registra en la tabla responsable
      ResponsableEtapa rp = new ResponsableEtapa();
      rp.setDevolucion(solicitud);
      rp.setFechaEtapa(solicitud.getFechaDocumento());
      rp.setCodigoRegistroResponsable("9999");
      rp.setIndicadorEtapa(Constantes.INDICADOR_ACTIVO);
      rp.setNumeroCiclo(solicitud.getNumeroCiclo());
      tRespEtaDevDAO.insert(rp);
      
      //Se registra el archivo adjunto, en caso de que exista
      if(solicitud.getCodigoArchivoSustento() > 0) {
         DocumentoAsociado documento = new DocumentoAsociado();
         documento.setDevolucion(solicitud);
         documento.setDescripcion(solicitud.getArchivoSustento().getOriginalFilename());
         documento.setFechaActualizacion(solicitud.getFechaDocumento());
         documento.setFechaAsociacion(solicitud.getFechaDocumento());
         documento.setIndicadorEstado(Constantes.INDICADOR_ESTADO_INICIAL);
         documento.setNumeroId(solicitud.getCodigoArchivoSustento());
         documento.setTipoDocumento(ConstantesDevolucion.TIPO_DOCUMENTO_ADJUNTO);
         documento.setUsuarioActualiza(solicitud.getLogin());
         documento.setUsuarioActualiza(solicitud.getLogin());
         t3617DctosAsocDAO.insert(documento);
      }
   }

}