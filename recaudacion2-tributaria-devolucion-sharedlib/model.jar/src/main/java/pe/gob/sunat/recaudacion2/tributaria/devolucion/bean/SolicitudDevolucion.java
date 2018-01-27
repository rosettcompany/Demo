/***********************************************************************
 * Module:  SolicitudDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class SolicitudDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.CasillaDevolucion;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

/** @pdOid df9297be-b9f1-4273-9212-c0981d9390f1 */
public class SolicitudDevolucion extends pe.gob.sunat.recaudacion2.tributaria.devolucion.model.Devolucion {
   /*CASILLAS*/
   static final String CASILLA_RUC ="002";
   static final String CASILLA_NOMBRE ="003";
   static final String CASILLA_NUMERO_ORDEN ="004";
   static final String CASILLA_CODIGO_AREA_EVALUADORA ="006";
   static final String CASILLA_NUMERO_FORMULARIO ="009";
   static final String CASILLA_FECHA_RECEPCION ="013";
   static final String CASILLA_TELEFONO ="028";
   static final String CASILLA_FORMA_DEVOLUCION ="039";
   static final String CASILLA_TIPO_SOLICITUD ="101";
   static final String CASILLA_IMPORTE_SOLICITADO ="102";
   static final String CASILLA_FORMULARIO_ASOCIADO ="103";
   static final String CASILLA_NUMERO_FORMULARIO_ASOCIADO ="105";
   static final String CASILLA_NUMERO_PERIODO_TRIBUTARIO ="106";
   static final String CASILLA_NUMERO_CODIGO_TRIBUTO ="107";
   static final String CASILLA_ESCRITO_FUNDAMENTADO_1 ="500";
   static final String CASILLA_ESCRITO_FUNDAMENTADO_2 ="501";
   static final String CASILLA_NUMERO_CCI ="900";
   static final String CASILLA_NUMERO_ORIGEN_SOL ="902";
   static final String INDICADOR_ACTIVO ="1";
   static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
   
   /** @pdOid 8b0f1740-077a-4035-8a31-12514d3dc9e5 */
   private String login;
   /** @pdOid 9b3aad3e-b1fc-46a0-a662-6a5ff3e2ba69 */
   private String apellidosNombres;
   /** @pdOid 5c424d0e-582f-4406-a69a-5951180aa9ea */
   private String periodo;
   /** @pdOid 9c264439-3efb-40d5-9257-fa4cc2541f3f */
   private String telefono;
   /** @pdOid 1cdc6207-a5fe-49a7-925d-fbc7191ebd91 */
   private String cci;
   /** @pdOid d03457db-9da8-44d7-a479-961819ead9e5 */
   private MultipartFile archivoSustento;
   /** @pdOid 8c4cb247-7ab2-48ed-af0b-4b2080d9935b */
   private String escritoFundamentado;
   /** @pdOid 293eb40c-f693-4a85-a9f5-25deef51a792 */
   private int codigoArchivoSustento;
   
   /** @pdRoleInfo migr=no name=FormularioAsociado assc=association4 mult=0..1 type=Aggregation */
   protected FormularioAsociado formularioAsociado;
   
   /** @pdRoleInfo migr=no name=TributoPendienteDevolucion assc=association1 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Aggregation */
   public java.util.List<TributoPendienteDevolucion> tributoPendienteDevolucion;
   
   /** @pdOid f024fa2e-8d93-4066-a006-cc49840d8066 */
   public String getLogin() {
      return login;
   }
   
   /** @param newLogin
    * @pdOid e2153ba1-9920-45d0-8c12-0ceaafb784e7 */
   public void setLogin(String newLogin) {
      login = newLogin;
   }
   
   /** @pdOid 59d3ad17-a39e-4b9e-a92c-a04adcdeb0a0 */
   public String getApellidosNombres() {
      return apellidosNombres;
   }
   
   /** @param newApellidosNombres
    * @pdOid 10570dbf-cd01-4dd8-a887-5886ea69caa1 */
   public void setApellidosNombres(String newApellidosNombres) {
      apellidosNombres = newApellidosNombres;
   }
   
   /** @pdOid f0729fb7-d35a-48ae-bce9-fb04a3b87269 */
   public String getPeriodo() {
      return periodo;
   }
   
   /** @param newPeriodo
    * @pdOid 13bb11c9-e658-4969-92fc-b4fd45ccbe22 */
   public void setPeriodo(String newPeriodo) {
      periodo = newPeriodo;
   }
   
   /** @pdOid ad5e4579-8783-49c3-ba3b-a3902a042176 */
   public String getTelefono() {
      return telefono;
   }
   
   /** @param newTelefono
    * @pdOid 908cc35c-4c2e-480d-9cc7-3ca1c341b068 */
   public void setTelefono(String newTelefono) {
      telefono = newTelefono;
   }
   
   /** @pdOid f616ecbb-e025-49fb-8af3-20ef021e7281 */
   public String getCci() {
      return cci;
   }
   
   /** @param newCci
    * @pdOid 8c14a967-6e97-4167-bccb-6d954169abfe */
   public void setCci(String newCci) {
      cci = newCci;
   }
   
   /** @pdOid 393c4fdd-f012-4003-bb49-434175f2dd58 */
   public MultipartFile getArchivoSustento() {
      return archivoSustento;
   }
   
   /** @param newArchivoSustento
    * @pdOid 541c3cd5-90af-4255-a794-89b419b4a9fe */
   public void setArchivoSustento(MultipartFile newArchivoSustento) {
      archivoSustento = newArchivoSustento;
   }
   
   /** @pdOid 301e7cf0-605e-446d-92e9-3d3dcec324a1 */
   public String getEscritoFundamentado() {
      return escritoFundamentado;
   }
   
   /** @param newEscritoFundamentado
    * @pdOid 2a4451e3-d94a-4f68-ab1c-2bc7c68a7731 */
   public void setEscritoFundamentado(String newEscritoFundamentado) {
      escritoFundamentado = newEscritoFundamentado;
   }
   
   /** @pdOid e7c7f20d-55c6-40dc-b71c-d573c6e3902c */
   public int getCodigoArchivoSustento() {
      return codigoArchivoSustento;
   }
   
   /** @param newCodigoArchivoSustento
    * @pdOid 751c4470-f931-4069-ab66-6a4ddff00178 */
   public void setCodigoArchivoSustento(int newCodigoArchivoSustento) {
      codigoArchivoSustento = newCodigoArchivoSustento;
   }
   
   /** Devuelve una cadena de texto que determina si se presentó o no el archivo de sustento
    * 
    * @pdOid 67db4e23-52f7-4a8c-8274-40d606eb554e */
   public String getPresentoArchivoSustento() {
      if(codigoArchivoSustento > 0)
         return "SI";
      return "NO";
   }
   /** Obtiene una lista de casillas de devolución a ser registradas
    * 
    * @pdOid 8c970211-e6e4-4a0e-bfac-29a152d17075 */
   public List<CasillaDevolucion> getCasillas() {
      List<CasillaDevolucion> casillas = new ArrayList<CasillaDevolucion>();
      casillas.add(new CasillaDevolucion(this, CASILLA_RUC, this.getRuc()));
      casillas.add(new CasillaDevolucion(this, CASILLA_NOMBRE, this.getApellidosNombres()));
      casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_ORDEN, this.getNumeroDocumento()));
      casillas.add(new CasillaDevolucion(this, CASILLA_CODIGO_AREA_EVALUADORA, this.getCodigoAreaEvaluadora()));
      casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_FORMULARIO, this.getCodigoFormulario()));
      casillas.add(new CasillaDevolucion(this, CASILLA_FECHA_RECEPCION, FORMAT_YYYYMMDD.format(getFechaDocumento())));
      casillas.add(new CasillaDevolucion(this, CASILLA_TELEFONO, this.telefono));
      casillas.add(new CasillaDevolucion(this, CASILLA_FORMA_DEVOLUCION, this.getIndicadorFormaDevolucion().getValue()));
      casillas.add(new CasillaDevolucion(this, CASILLA_TIPO_SOLICITUD, this.getTipoSolicitud().getValue()));
      casillas.add(new CasillaDevolucion(this, CASILLA_IMPORTE_SOLICITADO,String.valueOf(this.getMontoSolicitado())));
      casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_PERIODO_TRIBUTARIO,this.getPeriodoDocumento()));
      casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_CODIGO_TRIBUTO,this.getTributo().getValue()));
      casillas.add(new CasillaDevolucion(this, CASILLA_ESCRITO_FUNDAMENTADO_1,this.getEscritoFundamentado().substring(0, 249)));
      if(this.getEscritoFundamentado().length() > 249)
            casillas.add(new CasillaDevolucion(this, CASILLA_ESCRITO_FUNDAMENTADO_2,this.getEscritoFundamentado().substring(249)));
      if(this.cci != null && !this.cci.isEmpty())
         casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_CCI,this.cci));
      casillas.add(new CasillaDevolucion(this, CASILLA_NUMERO_ORIGEN_SOL,INDICADOR_ACTIVO));
      return casillas;
   }
   
   /** Establece el conjunto de casillas de devolución
    * 
    * @param casillas
    * @pdOid 79a9385e-3617-41ae-bc9a-6277af4e535e */
   public void setCasillas(List<CasillaDevolucion> casillas) {
      // TODO: implement
   }

}
