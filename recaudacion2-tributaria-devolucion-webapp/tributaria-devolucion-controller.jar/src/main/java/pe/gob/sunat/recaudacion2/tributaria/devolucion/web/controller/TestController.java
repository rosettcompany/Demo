package pe.gob.sunat.recaudacion2.tributaria.devolucion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.JSONResponse;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.ResponseStatus;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillaDevolucion;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ControlDeclaracion;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T3779FormularioDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T5386CasSegundaDAO;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.VfpDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.HvpDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.T8001cciDAO;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.dao.CasDevDAO;


import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.GenericFunctions;

@Controller
public class TestController {
   
   @Autowired
   public T5386CasSegundaDAO  t5386CasSegundaDAO;
   @Autowired
   public VfpDAO vfpdao;
   @Autowired
   public HvpDAO hvpdao;
   @Autowired
   public T8001cciDAO tccidao;
   @Autowired
   public CasDevDAO casdevdao;
   
   
   @ResponseBody 
   @RequestMapping(value="/Pruebat5386CasSegundaDAO", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerTributosPendientesDevolucion() {
      try{
         ControlDeclaracion ctrl = new ControlDeclaracion();
         ctrl.setNumeroSecuencia(1036547);
         Object a = t5386CasSegundaDAO.findByNumeroSecuencia(ctrl);
         return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      } catch (Exception ex){
         return new JSONResponse(ResponseStatus.Fallo, GenericFunctions.formatException("Error al intentar obtener los tributos pendientes de devolución:", ex));
      }
   }
   
   @ResponseBody 
   @RequestMapping(value="/PruebaVfpDAO", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerVFP() {
      
      String trib[]={"010101","030301","030308","030402","030502","052100","053100"};
      
      try{
         Object a = vfpdao.findByRucTributos("20556193879", trib);
         return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      } catch (Exception ex){
         return new JSONResponse(ResponseStatus.Fallo, GenericFunctions.formatException("Error al intentar obtener los VFP:", ex));
      }
   }
   
   @ResponseBody 
   @RequestMapping(value="/PruebaHvpDAO", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerHVP() {
      
      String trib[]={"010101","030301","030308","030402","030502","052100","053100"};
      
      try{
         Object a = hvpdao.findByRucTributos("10000008040", trib);
         return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      } catch (Exception ex){
         return new JSONResponse(ResponseStatus.Fallo, GenericFunctions.formatException("Error al intentar obtener los HVP:", ex));
      }
   }

   
   @ResponseBody 
   @RequestMapping(value="/PruebaCCIDAO", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse obtenerCCI() {
      
      try{
         Object a = tccidao.buscarCciPorRuc("10402849504");
         return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      } catch (Exception ex){
         return new JSONResponse(ResponseStatus.Fallo, GenericFunctions.formatException("Error al intentar obtener los CCI:", ex));
      }
   }
   
   @ResponseBody 
   @RequestMapping(value="/PruebaCasdev", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public JSONResponse insertarCasdev() {
      
      try{
         CasillaDevolucion cas = new CasillaDevolucion();
         Devolucion dev = new Devolucion();
         dev.setNumeroDevolucion("0023220000777");
         
         cas.setDevolucion(dev);
         cas.setCodigoCasilla("02");
         cas.setValorCasilla("");
                  
         Object a = casdevdao.insert(cas);
         return new JSONResponse(ResponseStatus.Correcto, "Correcto", a);
      } catch (Exception ex){
         return new JSONResponse(ResponseStatus.Fallo, GenericFunctions.formatException("Error al intentar INSERTAR CASDEV:", ex));
      }
   }
   
   

}
