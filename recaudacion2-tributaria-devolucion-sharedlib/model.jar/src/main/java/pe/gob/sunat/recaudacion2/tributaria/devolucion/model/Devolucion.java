/***********************************************************************
 * Module:  Devolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class Devolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.model;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/** Solicitudes de devolución registradas por el contribuyente.
 * 
 * @pdOid 8898f869-41d0-4857-9662-e5a50cb148d9 */
public class Devolucion implements GenericModel {
   /** Número de Devolución (campo num_dev)
    * 
    * @pdOid 544265d3-9dd0-4885-857a-54d489646995 */
   private String numeroDevolucion;
   /** Código de dependencia (campo cod_dep)
    * 
    * @pdOid 57bd7add-f006-48cc-8da2-de97a40f4595 */
   private String codigoDependencia;
   /** Número de Lote (campo num_lot)
    * 
    * @pdOid 5db32614-b552-4239-b048-70136f109fd8 */
   private int numeroLote;
   /** Número correlativo (campo num_cor)
    * 
    * @pdOid 3f5c268b-f657-4b02-bf37-4cc057d0376d */
   private int numeroCorrelativo;
   /** Código de formulario (campo cod_for).
    * 4949 para INTRANET.
    * 1649 para INTERNET.
    * 
    * @pdOid 43125b7f-0df3-4451-b0a7-853ecb96dee4 */
   private String codigoFormulario;
   /** Número de documento (campo num_doc).
    * 
    * @pdOid 1c6318d4-d714-4db0-87c6-be808d9837a6 */
   private String numeroDocumento;
   /** Número de RUC (campo num_ruc).
    * 
    * @pdOid 70c1bd2f-c62d-40f2-8768-ad73e61ad232 */
   private String ruc;
   /** Fecha de documento (campo fec_doc).
    * 
    * @pdOid b63f39f8-7f37-4fa3-8690-aa31d4c03092 */
   @DateTimeFormat(pattern=ConstantesModel.DEFAULT_FECHA)
   private Date fechaDocumento;
   /** Código de tributo (campo cod_tri).
    * 
    * @pdOid 0152d809-f7fb-4d51-bdff-f532f12beee1 */
   private NameValuePair tributo;
   /** Periodo documento (campo per_doc).
    * 
    * @pdOid 1c175f70-28f6-4c35-a4b8-064612334d47 */
   private String periodoDocumento;
   /** Tipo de Solicitud (campo cod_tip_sol)
    * 
    * @pdOid 27f1a0b2-d9a3-4fae-be84-80260e412dc1 */
   private NameValuePair tipoSolicitud;
   /** Código Tipo SMOD (campo cod_tip_smod).
    * 
    * @pdOid 6eb87972-39c6-4fcc-9569-c8a028fbd5f7 */
   private String codigoTipoSmod;
   /** Código de formulario asociado (campo cod_for_aso).
    * 
    * @pdOid bc321f7d-a266-4f03-aced-f80e31abcc12 */
   private NameValuePair formularioAsociado;
   /** Número documento asociado (campo num_doc_aso).
    * 
    * @pdOid 7336d78c-8a40-42b9-b371-6107bd87adbc */
   private String numeroDocumentoAsociadio;
   /** Determina la forma de devolución del importe solicitado (campo ind_for_dev).
    * Los posibles valores están determinados en el parámetro 664
    * 
    * @pdOid f3e4121c-26ce-4258-8fd8-70afef1e55e1 */
   private NameValuePair indicadorFormaDevolucion;
   /** Indica el tipo de garantia (campo ind_tip_gar).
    * 
    * @pdOid 4ae782d1-1c72-417a-8a46-40ca348365ff */
   private String indicadorTipoGarantia;
   /** Indica el monto de la garantia (campo mto_gar).
    * 
    * @pdOid c6d554a3-cbe2-4fed-99a0-38caa63b10d3 */
   private Double montoGarantia;
   /** Indica el código del área evaluadora (campo cod_area_eva).
    * 
    * @pdOid 22d0e0fc-1394-411c-9ff7-22872cc02a0e */
   private String codigoAreaEvaluadora;
   /** Indicador Area Operativa (campo ind_area_ope).
    * 
    * @pdOid e9064279-dd1a-42bf-94bd-63a78acfb219 */
   private String indicadorAreaOperativa;
   /** Flag Cuenta Activa (campo flg_cta_act).
    * 
    * @pdOid 8853fe70-5394-42bb-97ca-3bab4e5b75d2 */
   private String flagCuentaActiva;
   /** Número de orden de fiscalización en caso de que se requiera la fiscalización del contribuyente antes de proceder con la devolución (campo num_ord_fis)
    * 
    * @pdOid f1b66fdd-4f3e-428d-9899-c230170d46ac */
   private String numeroOrdenFiscalizacion;
   /** Número de Resolución de Intendencia (campo num_ri).
    * 
    * @pdOid 517d1745-f670-4d5e-9914-bb8c1a700c06 */
   private String numeroResolucionIntendencia;
   /** Fecha de resolución de intendencia (campo fec_ri).
    * 
    * @pdOid 3788030b-d45f-464f-a91d-db82d120c299 */
   private Date fechaResolucionIntendencia;
   /** Indicador de Resultado de Devolución (campo ind_res_dev).
    * 
    * @pdOid 9ed75b07-3fe2-43b1-a439-0167f2ca69da */
   private String indicadorResultado;
   /** Código Dependencia Presentación (campo cod_dep_pres).
    * 
    * @pdOid b5684330-1b23-43ae-a62c-d2f6a9e75d93 */
   private String codigoDependenciaPresentacion;
   /** Indicador de tipo de cálculo de interes (campo ind_tip_int )
    * 
    * @pdOid 5b3b7c58-4709-4ed4-add4-49235e45fce4 */
   private String tipoCalculoInteres;
   /** Fecha de inicio de cálculo de interes (campo fec_ini_int)
    * 
    * @pdOid 7a06d6ca-4892-4747-861f-7f4b84b2ed92 */
   private Date fechaInicioCalculoInteres;
   /** Fecha fin del cálculo de interes (campo fec_ini_int)
    * 
    * @pdOid eeaaa59e-87f0-40d6-9033-4362f678ee0b */
   private Date fechaFinCalculoInteres;
   /** Numero de res coactiva que autoriza la retencion (campo num_res_ret)
    * 
    * @pdOid 555883b9-28f3-4627-84ab-c8e9fdacb030 */
   private String numeroResolucionCoactiva;
   /** Importe solicitado a devolucion (campo mto_solicitado).
    * 
    * @pdOid f06bb294-b2f0-4b83-9357-73d96ea7c0f7 */
   @NumberFormat(pattern = ConstantesModel.DEFAULT_FORMAT_NUMBERS)
   private Double montoSolicitado;
   /** Monto reconocido (campo mto_reconocido)
    * 
    * @pdOid 3756f5c1-3f01-468d-8cd6-f5dcc6223c17 */
   private Double montoReconocido;
   /** Intereses reconocidos (campo mto_interes)
    * 
    * @pdOid 487947b3-7841-4f0b-a857-36ba4d89ae9d */
   private Double montoInteres;
   /** Monto a devolver (campo mto_devolver).
    * 
    * @pdOid 38eba7b7-f93c-4f20-ac84-5e3a1c46eb3f */
   private Double montoDevolver;
   /** Monto por aplicar con NCN (campo mto_compensado)
    * 
    * @pdOid a49e2408-f1bc-4273-b3e4-bc25f64e4215 */
   private Double montoCompensado;
   /** Monto compensado en auditoria ( campo mto_comp_aud)
    * 
    * @pdOid f9268aad-e4a5-4150-a236-c796f0f0839c */
   private Double montoCompensadoAuditoria;
   /** Monto retenido (campo mto_retenido)
    * 
    * @pdOid b8ca5cbd-d7ad-4c7e-8fd1-1f7161247675 */
   private Double montoRetenido;
   /** Indicador de estado de devolución (campo ind_est_dev).
    * 
    * @pdOid 08e44f99-f21f-4136-8d4b-ededdaf2b085 */
   private String indicadorEstado;
   /** Indicador de etapa de devolucion (campo ind_eta_dev).
    * 
    * @pdOid 506ed83c-28b5-4ad9-a785-22eebfdfd653 */
   private String indicadorEtapa;
   /** Fecha Proy Emisión y que se Imprime en los dov´s (campo fec_imp_dov)
    * 
    * @pdOid 921aadc9-e061-4a62-9b2f-01859a4f3ee8 */
   private Date fechaProyeccionEmision;
   /** Codigo de ente (campo cod_ente)
    * 
    * @pdOid cd5c8e08-d155-46c6-a8bb-73431c6cf30e */
   private String codigoEnte;
   /** Número de ciclo (campo num_ciclo)
    * 
    * @pdOid 5ec15475-cc7c-4389-bb31-ac3c9b16d4d8 */
   private int numeroCiclo;
   /** Fecha de documento asociado(campo fec_doc_aso))
    * 
    * @pdOid c4ed800f-bf5c-4f5b-a948-5dfd854ccb59 */
   private Date fechaDocumentoAsociado;
   
   /** @pdRoleInfo migr=no name=CasillaDevolucion assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   public java.util.List<CasillaDevolucion> casillaDevolucion;
   
   /** @pdOid cd171dd1-0980-4861-88d7-e8568c698948 */
   public String getCodigoFormulario() {
      return codigoFormulario;
   }
   
   /** @param newCodigoFormulario
    * @pdOid 58492cb0-c3ef-40c3-9da8-f271fae342c5 */
   public void setCodigoFormulario(String newCodigoFormulario) {
      codigoFormulario = newCodigoFormulario;
   }
   
   /** @pdOid 37799150-4b1b-4e93-99af-988abc16aa94 */
   public String getNumeroDevolucion() {
      return numeroDevolucion;
   }
   
   /** @param newNumeroDevolucion
    * @pdOid 16f6c529-6295-443b-9222-f3245b018a6c */
   public void setNumeroDevolucion(String newNumeroDevolucion) {
      numeroDevolucion = newNumeroDevolucion;
   }
   
   /** @pdOid c8637fde-8497-4778-9791-3ec7079ba124 */
   public NameValuePair getTipoSolicitud() {
      return tipoSolicitud;
   }
   
   /** @param newTipoSolicitud
    * @pdOid f87d46aa-af2f-40f3-9661-0ec2887e2467 */
   public void setTipoSolicitud(NameValuePair newTipoSolicitud) {
      tipoSolicitud = newTipoSolicitud;
   }
   
   /** @pdOid ec02a685-7b67-4099-a3b9-4c874a8509a9 */
   public String getIndicadorResultado() {
      return indicadorResultado;
   }
   
   /** @param newIndicadorResultado
    * @pdOid 53dbf483-9f52-4a87-9c8c-637466c9760f */
   public void setIndicadorResultado(String newIndicadorResultado) {
      indicadorResultado = newIndicadorResultado;
   }
   
   /** @pdOid 032795b2-d95f-48b9-9c90-60e5562bb1d5 */
   public NameValuePair getTributo() {
      return tributo;
   }
   
   /** @param newTributo
    * @pdOid 1b752b3e-be7f-4e60-9c28-6d318ba67c0c */
   public void setTributo(NameValuePair newTributo) {
      tributo = newTributo;
   }
   
   /** @pdOid cbb5f5d6-0c85-4040-a298-d3c7eb0fb4ba */
   public String getPeriodoDocumento() {
      return periodoDocumento;
   }
   
   /** @param newPeriodoDocumento
    * @pdOid 6227828c-fab4-4d0c-a7e8-8f6fae2539d6 */
   public void setPeriodoDocumento(String newPeriodoDocumento) {
      periodoDocumento = newPeriodoDocumento;
   }
   
   /** @pdOid 099dd88c-ec81-43f4-ad14-e1b27cfb1471 */
   public Double getMontoSolicitado() {
      return montoSolicitado;
   }
   
   /** @param newMontoSolicitado
    * @pdOid f46442fc-fda0-4f70-99cc-dee1b1e04057 */
   public void setMontoSolicitado(Double newMontoSolicitado) {
      montoSolicitado = newMontoSolicitado;
   }
   
   /** @pdOid 610734f0-dfce-401e-aef3-74fab42424d5 */
   public Double getMontoDevolver() {
      return montoDevolver;
   }
   
   /** @param newMontoDevolver
    * @pdOid 39c8435e-1cd6-42bc-90a6-68ea9b81ee57 */
   public void setMontoDevolver(Double newMontoDevolver) {
      montoDevolver = newMontoDevolver;
   }
   
   /** @pdOid 3f489faf-930e-436c-95e7-5b91aa320e27 */
   public String getNumeroDocumento() {
      return numeroDocumento;
   }
   
   /** @param newNumeroDocumento
    * @pdOid 290cff91-c8cb-487f-8b4c-0e5dc60a0ae8 */
   public void setNumeroDocumento(String newNumeroDocumento) {
      numeroDocumento = newNumeroDocumento;
   }
   
   /** @pdOid cf43448a-1af5-4465-81f7-1947c8b42cba */
   public String getRuc() {
      return ruc;
   }
   
   /** @param newRuc
    * @pdOid 53440d6f-cf1e-435a-a65a-9eee21414182 */
   public void setRuc(String newRuc) {
      ruc = newRuc;
   }
   
   /** @pdOid db0e4ae1-d715-49ad-b049-5a9028af3886 */
   public Date getFechaDocumento() {
      return fechaDocumento;
   }
   
   /** @param newFechaDocumento
    * @pdOid 8809fe05-e7a7-433a-8232-b2b4088793d4 */
   public void setFechaDocumento(Date newFechaDocumento) {
      fechaDocumento = newFechaDocumento;
   }
   
   /** @pdOid 5e08a55a-0de0-437d-b2f2-446a912ecd1d */
   public NameValuePair getFormularioAsociado() {
      return formularioAsociado;
   }
   
   /** @param newFormularioAsociado
    * @pdOid f5cab1e7-742e-412f-95e8-fecde1596963 */
   public void setFormularioAsociado(NameValuePair newFormularioAsociado) {
      formularioAsociado = newFormularioAsociado;
   }
   
   /** @pdOid 37ccefda-23d4-4f2f-b7ec-551600a38efb */
   public String getNumeroDocumentoAsociadio() {
      return numeroDocumentoAsociadio;
   }
   
   /** @param newNumeroDocumentoAsociadio
    * @pdOid 4fc96736-a922-42b2-837d-65037e15f013 */
   public void setNumeroDocumentoAsociadio(String newNumeroDocumentoAsociadio) {
      numeroDocumentoAsociadio = newNumeroDocumentoAsociadio;
   }
   
   /** @pdOid ab0cdbea-3e02-47bf-937d-9b64d4110765 */
   public String getIndicadorEstado() {
      return indicadorEstado;
   }
   
   /** @param newIndicadorEstado
    * @pdOid 57b59bb2-8e0c-459f-8366-7150747e127d */
   public void setIndicadorEstado(String newIndicadorEstado) {
      indicadorEstado = newIndicadorEstado;
   }
   
   /** @pdOid bed575a1-13e8-48f0-a39e-ade7d0d404b3 */
   public String getIndicadorEtapa() {
      return indicadorEtapa;
   }
   
   /** @param newIndicadorEtapa
    * @pdOid 83e12c0f-300c-4f8c-a4c1-9167d031c678 */
   public void setIndicadorEtapa(String newIndicadorEtapa) {
      indicadorEtapa = newIndicadorEtapa;
   }
   
   /** @pdOid 4616cd0b-f179-4dd3-9377-2899e79109d0 */
   public String getCodigoDependencia() {
      return codigoDependencia;
   }
   
   /** @param newCodigoDependencia
    * @pdOid fde29ea0-15ea-40bc-b205-f4f731184825 */
   public void setCodigoDependencia(String newCodigoDependencia) {
      codigoDependencia = newCodigoDependencia;
   }
   
   /** @pdOid 41851e19-88fa-498e-b389-15e706912ace */
   public int getNumeroLote() {
      return numeroLote;
   }
   
   /** @param newNumeroLote
    * @pdOid f1aa37b6-e24b-418f-9697-37dce418fb8f */
   public void setNumeroLote(int newNumeroLote) {
      numeroLote = newNumeroLote;
   }
   
   /** @pdOid 405938cd-56c3-4be7-9642-6305eae6e2cd */
   public int getNumeroCorrelativo() {
      return numeroCorrelativo;
   }
   
   /** @param newNumeroCorrelativo
    * @pdOid 6a6239a8-c004-4e5b-9c0c-9298f6c527cc */
   public void setNumeroCorrelativo(int newNumeroCorrelativo) {
      numeroCorrelativo = newNumeroCorrelativo;
   }
   
   /** @pdOid 5c4f59f6-831c-4256-bca7-0520afff2e05 */
   public String getCodigoTipoSmod() {
      return codigoTipoSmod;
   }
   
   /** @param newCodigoTipoSmod
    * @pdOid e9de298c-55bd-419e-87e5-066255dc6666 */
   public void setCodigoTipoSmod(String newCodigoTipoSmod) {
      codigoTipoSmod = newCodigoTipoSmod;
   }
   
   /** @pdOid 4e375a86-5edd-4424-8288-b1ee3d912ce6 */
   public NameValuePair getIndicadorFormaDevolucion() {
      return indicadorFormaDevolucion;
   }
   
   /** @param newIndicadorFormaDevolucion
    * @pdOid 2e655ced-a7b5-4ec3-a5bf-a922cfa4a51b */
   public void setIndicadorFormaDevolucion(NameValuePair newIndicadorFormaDevolucion) {
      indicadorFormaDevolucion = newIndicadorFormaDevolucion;
   }
   
   /** @pdOid fe12f35a-7870-4e5b-b578-483f1b4bbe12 */
   public String getIndicadorTipoGarantia() {
      return indicadorTipoGarantia;
   }
   
   /** @param newIndicadorTipoGarantia
    * @pdOid 2038f05d-a257-4ab9-8357-567a4ce06765 */
   public void setIndicadorTipoGarantia(String newIndicadorTipoGarantia) {
      indicadorTipoGarantia = newIndicadorTipoGarantia;
   }
   
   /** @pdOid dc12f0ff-59d4-4779-97c8-40a03a630219 */
   public Double getMontoGarantia() {
      return montoGarantia;
   }
   
   /** @param newMontoGarantia
    * @pdOid db1d0a1c-5632-4199-8c44-2c6a824f9069 */
   public void setMontoGarantia(Double newMontoGarantia) {
      montoGarantia = newMontoGarantia;
   }
   
   /** @pdOid d2417618-49f3-4436-b159-65ba58b97b64 */
   public String getCodigoAreaEvaluadora() {
      return codigoAreaEvaluadora;
   }
   
   /** @param newCodigoAreaEvaluadora
    * @pdOid 662ef4cd-790d-4dce-a6dd-ce4f7d674a71 */
   public void setCodigoAreaEvaluadora(String newCodigoAreaEvaluadora) {
      codigoAreaEvaluadora = newCodigoAreaEvaluadora;
   }
   
   /** @pdOid 0e8ac757-53c3-4722-b7e0-89dcf6e3b73e */
   public String getIndicadorAreaOperativa() {
      return indicadorAreaOperativa;
   }
   
   /** @param newIndicadorAreaOperativa
    * @pdOid 7b742e40-4512-4281-ac85-3dfa31a1cce1 */
   public void setIndicadorAreaOperativa(String newIndicadorAreaOperativa) {
      indicadorAreaOperativa = newIndicadorAreaOperativa;
   }
   
   /** @pdOid d63348f9-14e1-47d3-a5a1-cad396d44dd1 */
   public String getFlagCuentaActiva() {
      return flagCuentaActiva;
   }
   
   /** @param newFlagCuentaActiva
    * @pdOid 1cc75463-eb9e-4f40-86ec-10a4292a3035 */
   public void setFlagCuentaActiva(String newFlagCuentaActiva) {
      flagCuentaActiva = newFlagCuentaActiva;
   }
   
   /** @pdOid b6a26263-945f-4ab5-acd1-aa7e23d20736 */
   public String getNumeroOrdenFiscalizacion() {
      return numeroOrdenFiscalizacion;
   }
   
   /** @param newNumeroOrdenFiscalizacion
    * @pdOid ce25447f-8f16-4984-ae01-6ff49d46addf */
   public void setNumeroOrdenFiscalizacion(String newNumeroOrdenFiscalizacion) {
      numeroOrdenFiscalizacion = newNumeroOrdenFiscalizacion;
   }
   
   /** @pdOid 92fff24d-f12f-4578-ba4e-a131aa29269b */
   public String getNumeroResolucionIntendencia() {
      return numeroResolucionIntendencia;
   }
   
   /** @param newNumeroResolucionIntendencia
    * @pdOid 66fa08b4-0b91-4237-a25b-dd0f15065f47 */
   public void setNumeroResolucionIntendencia(String newNumeroResolucionIntendencia) {
      numeroResolucionIntendencia = newNumeroResolucionIntendencia;
   }
   
   /** @pdOid 55ff39b0-e7c1-41d3-acc2-bddb640120d9 */
   public Date getFechaResolucionIntendencia() {
      return fechaResolucionIntendencia;
   }
   
   /** @param newFechaResolucionIntendencia
    * @pdOid dd447e4c-f1a6-430a-89b7-ee748551a3eb */
   public void setFechaResolucionIntendencia(Date newFechaResolucionIntendencia) {
      fechaResolucionIntendencia = newFechaResolucionIntendencia;
   }
   
   /** @pdOid 573cc46d-92a7-41de-8be2-67a949ed8fb3 */
   public String getCodigoDependenciaPresentacion() {
      return codigoDependenciaPresentacion;
   }
   
   /** @param newCodigoDependenciaPresentacion
    * @pdOid 6fb76a15-51d6-4a4b-a893-1a8de19883dd */
   public void setCodigoDependenciaPresentacion(String newCodigoDependenciaPresentacion) {
      codigoDependenciaPresentacion = newCodigoDependenciaPresentacion;
   }
   
   /** @pdOid 35da3d2b-aab2-42d5-9ffe-48213a14d5a0 */
   public String getTipoCalculoInteres() {
      return tipoCalculoInteres;
   }
   
   /** @param newTipoCalculoInteres
    * @pdOid d5f9a312-5565-4460-b1f5-ca2b9eac52a8 */
   public void setTipoCalculoInteres(String newTipoCalculoInteres) {
      tipoCalculoInteres = newTipoCalculoInteres;
   }
   
   /** @pdOid f802cf0b-753d-4379-a093-9cabeef7fc9f */
   public Date getFechaInicioCalculoInteres() {
      return fechaInicioCalculoInteres;
   }
   
   /** @param newFechaInicioCalculoInteres
    * @pdOid 255904a2-ce9a-4110-beb3-7194eed355bc */
   public void setFechaInicioCalculoInteres(Date newFechaInicioCalculoInteres) {
      fechaInicioCalculoInteres = newFechaInicioCalculoInteres;
   }
   
   /** @pdOid e7b3e026-7710-4a46-993e-661770c7741c */
   public Date getFechaFinCalculoInteres() {
      return fechaFinCalculoInteres;
   }
   
   /** @param newFechaFinCalculoInteres
    * @pdOid 96afcf30-0018-4903-b625-459b6272a8e0 */
   public void setFechaFinCalculoInteres(Date newFechaFinCalculoInteres) {
      fechaFinCalculoInteres = newFechaFinCalculoInteres;
   }
   
   /** @pdOid 24adbdc2-060e-486c-849c-4340936616de */
   public String getNumeroResolucionCoactiva() {
      return numeroResolucionCoactiva;
   }
   
   /** @param newNumeroResolucionCoactiva
    * @pdOid a17c261b-35ff-41c1-b5bd-7f314478e29d */
   public void setNumeroResolucionCoactiva(String newNumeroResolucionCoactiva) {
      numeroResolucionCoactiva = newNumeroResolucionCoactiva;
   }
   
   /** @pdOid 5ffcfde0-3abe-4ec3-8fa1-4c99f986318f */
   public Double getMontoReconocido() {
      return montoReconocido;
   }
   
   /** @param newMontoReconocido
    * @pdOid 7a24b4c5-b08e-4a3f-83e3-03e3db896841 */
   public void setMontoReconocido(Double newMontoReconocido) {
      montoReconocido = newMontoReconocido;
   }
   
   /** @pdOid 27809305-edfe-4d38-a065-a744b069915f */
   public Double getMontoInteres() {
      return montoInteres;
   }
   
   /** @param newMontoInteres
    * @pdOid 5b16d718-a359-4604-b734-5a84069a32cf */
   public void setMontoInteres(Double newMontoInteres) {
      montoInteres = newMontoInteres;
   }
   
   /** @pdOid 1b4a4893-48f3-4c77-a47b-a76ea3fbc1c4 */
   public Double getMontoCompensado() {
      return montoCompensado;
   }
   
   /** @param newMontoCompensado
    * @pdOid 57134515-8d66-4cef-929a-d4f2f3def6fc */
   public void setMontoCompensado(Double newMontoCompensado) {
      montoCompensado = newMontoCompensado;
   }
   
   /** @pdOid 5c383326-db22-4930-8cb7-eccf8bea2b8a */
   public Double getMontoCompensadoAuditoria() {
      return montoCompensadoAuditoria;
   }
   
   /** @param newMontoCompensadoAuditoria
    * @pdOid a616b7a1-8f91-4d0c-a201-367b49c38ba1 */
   public void setMontoCompensadoAuditoria(Double newMontoCompensadoAuditoria) {
      montoCompensadoAuditoria = newMontoCompensadoAuditoria;
   }
   
   /** @pdOid 0ed680a4-8ce7-47af-9cbd-559c876a82fa */
   public Double getMontoRetenido() {
      return montoRetenido;
   }
   
   /** @param newMontoRetenido
    * @pdOid c9ceeeae-af76-42f4-986c-c73cc2f27ad5 */
   public void setMontoRetenido(Double newMontoRetenido) {
      montoRetenido = newMontoRetenido;
   }
   
   /** @pdOid f7a207a4-95fc-4e85-9b98-df15cc1cad95 */
   public Date getFechaProyeccionEmision() {
      return fechaProyeccionEmision;
   }
   
   /** @param newFechaProyeccionEmision
    * @pdOid 00e8d0a9-903a-452c-a848-cd5c7115da67 */
   public void setFechaProyeccionEmision(Date newFechaProyeccionEmision) {
      fechaProyeccionEmision = newFechaProyeccionEmision;
   }
   
   /** @pdOid 1c2a0a74-a10d-489a-8ed7-a8393d2a7687 */
   public String getCodigoEnte() {
      return codigoEnte;
   }
   
   /** @param newCodigoEnte
    * @pdOid a2615781-7639-42c8-bf88-b9b23eac7bea */
   public void setCodigoEnte(String newCodigoEnte) {
      codigoEnte = newCodigoEnte;
   }
   
   /** @pdOid 277aa402-5c1c-40aa-9ace-42e81ab77593 */
   public int getNumeroCiclo() {
      return numeroCiclo;
   }
   
   /** @param newNumeroCiclo
    * @pdOid 0550c7c8-79fd-47cf-bad9-4cb1ed1e723f */
   public void setNumeroCiclo(int newNumeroCiclo) {
      numeroCiclo = newNumeroCiclo;
   }
   
   /** @pdOid 6fdfd6b1-05fb-498a-9b63-88132bc0094a */
   public Date getFechaDocumentoAsociado() {
      return fechaDocumentoAsociado;
   }
   
   /** @param newFechaDocumentoAsociado
    * @pdOid fd678e08-3f3c-494e-8fda-3cc87666ffc5 */
   public void setFechaDocumentoAsociado(Date newFechaDocumentoAsociado) {
      fechaDocumentoAsociado = newFechaDocumentoAsociado;
   }

}