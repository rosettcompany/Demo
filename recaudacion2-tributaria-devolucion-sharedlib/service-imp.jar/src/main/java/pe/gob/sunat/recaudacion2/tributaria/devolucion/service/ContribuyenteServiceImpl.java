/***********************************************************************
 * Module:  ContribuyenteServiceImpl.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ContribuyenteServiceImpl
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.DdsDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.DatosSecundarios;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.ConstantesDevolucion;
import pe.gob.sunat.servicio.registro.model.dao.DdpDAO;

import java.util.*;

/** @pdOid eecc2cb1-ad28-4a73-8ae6-1aa273d8550d */
@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
   /** @pdRoleInfo migr=no name=DdsDAO assc=association29 mult=1..1 */
   @Autowired
   private DdsDAO ddsDAO;
   @Autowired
   private DdpDAO ddpDAO;
   
   /** Determina si el contribuyente es persona natural. Devuelve TRUE en caso de ser persona natural, en caso contrario devuelve FALSE
    * 
    * @param ruc
    * @pdOid 68d6e49b-772d-4494-8aef-307dc4520a47 */
   public boolean isPersonaNatural(String ruc) {
      Map<String, String> datos_ruc = ddpDAO.findByPK(ruc);
      return "01".equals(datos_ruc.get("ddp_identi")) || "02".equals(datos_ruc.get("ddp_identi"));
   }
   
   /** Devuelve el tipo de documento registrado en el padrón RUC para el contribuyente con el numero de ruc indicado.
    * 
    * @param ruc Número de RUC del contribuyente
    * @pdOid e9990068-81d6-46a3-8390-5257fbfac32c */
   public String tipoDocumentoRegistradoPadronRuc(String ruc) {
      DatosSecundarios datos = obtenerDatosSecundarios(ruc);
      return datos.getTipoDocumentoIdentidad();
   }
   
   /** Obtiene los datos secundarios del contribuyente según su numeroRUC
    * 
    * @param numeroRUC Número de RUC
    * @pdOid a1bff22a-f934-4e79-89c2-0da6dc41b50c */
   public DatosSecundarios obtenerDatosSecundarios(String numeroRUC) {
      DatosSecundarios datos = ddsDAO.findDatosSecundariosByRuc(numeroRUC);
      if(datos == null)
         throw new BusinessException(String.format("No se ha encontrado datos en la DDS para el ruc %s", numeroRUC),
               Constantes.MSG_ERROR_GRAL_NEGOCIO);
      return datos;
   }

}