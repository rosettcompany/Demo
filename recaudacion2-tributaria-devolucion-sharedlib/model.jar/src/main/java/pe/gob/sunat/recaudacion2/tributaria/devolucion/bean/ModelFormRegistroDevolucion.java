/***********************************************************************
 * Module:  ModelFormRegistroDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ModelFormRegistroDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** @pdOid 617d2075-f9e0-4c57-8515-0f51500078b6 */
public class ModelFormRegistroDevolucion extends ModelFormBase {
   /** @pdOid 68cb5741-7782-4dd0-bb25-7aad8014c44e
       @pdRoleInfo migr=yes name=SolicitudDevolucion assc=association3 mult=1..1 type=Composition */
   private SolicitudDevolucion solicitudDevolucion;
   /** Determinar el modo de registro a ser utilizado. Los posibles modos son los siguientes:
    *  - Llenado Manual, el contribuyente debe llenar todos los datos del formulario de solicitud de devoluciones.
    *  - Llenado Guiado, el contribuyente busca sus Tributos Pendientes de Devolución, al seleccionar uno, el sistema realiza el llenado completo del     formulario y lo muestra al contribuyente para su respectivo registro..
    * 
    * @pdOid 61f94de5-da72-44ff-8fac-5195facdeb81 */
   private String modoLlenado;
   
   /** @pdRoleInfo migr=no name=ConfiguracionRegistroSolicitudDevolucion assc=association5 mult=1..1 */
   private ConfiguracionRegistroSolicitudDevolucion configuracionRegistroSolicitudDevolucion;
   
   /** @pdOid 1a911162-40a5-4644-900d-4f850515ad48 */
   public SolicitudDevolucion getSolicitudDevolucion() {
      return solicitudDevolucion;
   }
   
   /** @param newSolicitudDevolucion
    * @pdOid 99e6b6b2-9e5e-4551-9835-84a790c7d509 */
   public void setSolicitudDevolucion(SolicitudDevolucion newSolicitudDevolucion) {
      solicitudDevolucion = newSolicitudDevolucion;
   }
   
   /** @pdOid 23b19028-1b4f-412f-ae3d-8a98de0c9395 */
   public String getModoLlenado() {
      return modoLlenado;
   }
   
   /** @param newModoLlenado
    * @pdOid 6e47dec3-4a17-47aa-978a-9a15022807fa */
   public void setModoLlenado(String newModoLlenado) {
      modoLlenado = newModoLlenado;
   }

}