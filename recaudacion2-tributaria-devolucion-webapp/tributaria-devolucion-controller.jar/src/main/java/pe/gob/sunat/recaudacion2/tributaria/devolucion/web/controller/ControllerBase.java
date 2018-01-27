package pe.gob.sunat.recaudacion2.tributaria.devolucion.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.BusinessException;
import pe.gob.sunat.tecnologia.menu.bean.UsuarioBean;

public class ControllerBase {

   public UsuarioBean getUsuarioBean(HttpServletRequest request){
      UsuarioBean user = (UsuarioBean)WebUtils.getSessionAttribute(request, "usuarioBean");
      if(user == null)
         throw new BusinessException("No se ha encontrado al usuario de sesión",
               "No se ha encontrado información acerca de la sesión. Ingrese nuevamente.");
      return user;
   }
}
