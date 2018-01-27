/***********************************************************************
 * Module:  ValidadorDevolucionTipo28Impl.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ValidadorDevolucionTipo28Impl
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DeclaracionDeterminativa;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Formulario1693;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Hvp;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Vfp;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.HvpDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.VfpDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ArrayListExtended;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesMensajes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T03DJCabDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T1254DocabDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.TributoPendienteDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.Mensaje;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ModelFormRegistroDevolucion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.SolicitudDevolucion;

import java.text.ParseException;
import java.util.*;

/** Implementación de validaciones para tipo de devolución 28 - NUEVO RUS
 * 
 * @pdOid 51c4d838-5c23-4aa3-896f-a7019dbb38ff */
@Service
public class ValidadorDevolucionTipo28Impl implements ValidadorDevolucionBaseService {
   /** @pdRoleInfo migr=no name=HvpDAO assc=association6 mult=1..1 */
   @Autowired
   private HvpDAO hvpDAO;
   /** @pdRoleInfo migr=no name=VfpDAO assc=association7 mult=1..1 */
   @Autowired
   private VfpDAO vfpDAO;
   /** @pdRoleInfo migr=no name=T03DJCabDAO assc=association9 mult=1..1 */
   @Autowired
   private T03DJCabDAO t03DJCabDAO;
   /** @pdRoleInfo migr=no name=T1254DocabDAO assc=association23 mult=1..1 */
   @Autowired
   private T1254DocabDAO t1254DocabDAO;
   
   private static final String[] TIRBUTOS_VFP = new String[] {"041000"};
   private static final String[] TIRBUTOS_HVP = new String[] {"040001","041000"};
   
   /** Se verifica que el RUC se encuentre afecto al NRUS.
    * En caso de no cumplir con la validación se devuelve un objeto Mensaje, en caso contrario se devuelve null.
    * 
    * @param solicitudDevolucion
    * @throws ParseException 
    * @pdOid 6d73765c-a9ce-414d-b3a2-0ec52ae3d305 */
   private Mensaje verificarAfectoARus(SolicitudDevolucion solicitudDevolucion) throws ParseException {
      Date fechaPeriodo = Constantes.PERIODO_DATE_FORMAT.parse(solicitudDevolucion.getPeriodoDocumento());

      boolean afectoVFPRUS = false;
      List<Vfp> vfps = vfpDAO.findByRucTributos(solicitudDevolucion.getRuc(),
            TIRBUTOS_VFP);
      if(!GenericFunctions.isListEmptyOrNull(vfps)) {
         for (Vfp vfp : vfps) {
            Date fechaVigencia = vfp.getFechaVigencia();
            if(fechaVigencia.compareTo(fechaPeriodo) <= 0) {
               afectoVFPRUS = true;
               break;
            }
         }
      }
      if (afectoVFPRUS)
         return null;
      
      boolean afectoHVPRUS = false;
      List<Hvp> hvps = hvpDAO.findByRucTributos(solicitudDevolucion.getRuc(),
            TIRBUTOS_HVP);
      if(!GenericFunctions.isListEmptyOrNull(hvps)) {
         for (Hvp hvp : hvps) {
            Date fechaIni = hvp.getFechaVigencia();
            Date fechaFin = hvp.getFechaBaja();
            if(fechaIni.compareTo(fechaPeriodo) <= 0 
                  && fechaFin.compareTo(fechaPeriodo) >= 0) {
               afectoHVPRUS = true;
               break;
            }
         }
      }
      
      if(!afectoHVPRUS)
         return new Mensaje(ResponseStatus.ErrorValidacion,ConstantesMensajes.MSJ_NO_RUS );
      return null;
   }
   
   /** Se verifica que el RUC tenga un formulario 1610 o 1611  en el periodo indicado.
    * En caso de no cumplir con la validación se devuelve un objeto Mensaje, en caso contrario se devuelve null.
    * 
    * @param solicitudDevolucion
    * @pdOid 50b23d72-4671-45ce-b9d6-4476f67e2db6 */
   private Mensaje verificarRegistro16101616(SolicitudDevolucion solicitudDevolucion) {
      List<DeclaracionDeterminativa> lista = t03DJCabDAO.findByRucPerFor(solicitudDevolucion.getRuc(),
            solicitudDevolucion.getPeriodoDocumento(),
            ConstantesDevolucion.FORMULARIOS_TEF);
      
      if(GenericFunctions.isListEmptyOrNull(lista))
         return new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_NO_FORMULARIO_TEF);
      else {
         for (DeclaracionDeterminativa declaracionDeterminativa : lista) {
            List<Formulario1693> modificaciones = t1254DocabDAO.findBy("1693",
                  declaracionDeterminativa.getNabono(),
                  "1611",
                  String.valueOf(declaracionDeterminativa.getNumeroOrden()),
                  ConstantesDevolucion.ESTADOS_MODIFICACION_PENDIENTE);
            if(!GenericFunctions.isListEmptyOrNull(modificaciones))
               return new Mensaje(ResponseStatus.ErrorValidacion, ConstantesMensajes.MSJ_MODIFICACION_DATOS);
         }
      }
      return null;
   }
   
   /** Devuelve el código de tipo de devolución de la cual se está implementando su respectiva validación
    * 
    * @pdOid e16205f9-e79a-4c74-8134-cff0006bb250 */
   public String getTipoDevolucion() {
      return ConstantesDevolucion.TIPDEV_NRUS;
   }
   
   /** Obtiene los tributos pendientes de devolucion segun periodos según el tipo de Key
    * 
    * @param model
    * @pdOid 74bd8a7e-b1a3-4fdf-b6f8-92dfcdc23c60 */
   public List<TributoPendienteDevolucion> obtenerTributosPendientesDevolucion(ModelFormRegistroDevolucion model) {
      // TODO: implement
      return null;
   }
   
   /** Realiza las validaciones correspondientes según el tipo de solicitud registrada
    * 
    * @param solicitudDevolucion Solicitud de devolución a validar
    * @throws Exception 
    * @pdOid a25dfc90-bd73-4216-96cc-f6efae78e358 */
   public List<Mensaje> validarRegistroDeSolicitud(SolicitudDevolucion solicitudDevolucion) throws Exception {
      List<Mensaje> mensajes = new ArrayListExtended<Mensaje>();
      mensajes.add(verificarAfectoARus(solicitudDevolucion));
      mensajes.add(verificarRegistro16101616(solicitudDevolucion));
      
      if(GenericFunctions.isListEmptyOrNull(mensajes))
         return null;
      return mensajes;
   }
   
   /** Realiza acciones de post el registro de la solicitud de devolución
    * 
    * @param solicitudDevolucion
    * @pdOid 06280471-6894-4027-ae5a-b2e7c32d9311 */
   public List<Mensaje> realizarAccionesPostRegistro(SolicitudDevolucion solicitudDevolucion) {
      // TODO: implement
      return null;
   }

}