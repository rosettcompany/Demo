/***********************************************************************
 * Module:  TributoPendienteDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class TributoPendienteDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.serializer.DoubleSerializer;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/** @pdOid 99a94e88-3bfb-4dbb-b29f-07428c69ce1c */
public class TributoPendienteDevolucion {
   /** Preiodo del formulario presentado
    * 
    * @pdOid 3db8a43b-debf-4373-8f88-aba42ddc0d58 */
   private String periodo;
   /** Número de formualrio base presentado
    * 
    * @pdOid 39ec76de-992f-4047-92ca-2ddee785c46a */
   private NameValuePair formulario;
   /** Número de orden del formulario presentado
    * 
    * @pdOid 474c8c78-0257-4639-b1b2-6219a28c542c */
   private Integer numeroOrdenFormulario;
   /** Número de tributo
    * 
    * @pdOid ed4332f4-6e9a-4624-a9f0-c931925919c3 */
   private NameValuePair tributo;
   /** Monto pendiente de devolución consignado en el formulario origen
    * 
    * @pdOid b3c04dc6-92bb-4d73-9658-0cab7e4218d7 */
   @JsonSerialize(using = DoubleSerializer.class)
   private Double monto;
   /** @pdOid 3c5a50b5-7dbc-4db6-9751-04177d42697a */
   private String hash;
   
   /** @pdOid e6c1c7df-1d23-44f9-a5fa-0b2da7db67cc */
   public String getPeriodo() {
      return periodo;
   }
   
   /** @param newPeriodo
    * @pdOid e348d21f-d633-4999-ac5a-3781ee908d0e */
   public void setPeriodo(String newPeriodo) {
      periodo = newPeriodo;
   }
   
   /** @pdOid d831efc4-3c24-4b2d-a0a6-b3760c35c585 */
   public NameValuePair getFormulario() {
      return formulario;
   }
   
   /** @param newFormulario
    * @pdOid d621fd48-64ee-4959-ba58-fc0860367cf0 */
   public void setFormulario(NameValuePair newFormulario) {
      formulario = newFormulario;
   }
   
   /** @pdOid 7834243c-c0b0-4920-a9ca-e3e54fc514e9 */
   public Integer getNumeroOrdenFormulario() {
      return numeroOrdenFormulario;
   }
   
   /** @param newNumeroOrdenFormulario
    * @pdOid 347df38e-1ece-44b0-ad55-b08b9c1b2f83 */
   public void setNumeroOrdenFormulario(Integer newNumeroOrdenFormulario) {
      numeroOrdenFormulario = newNumeroOrdenFormulario;
   }
   
   /** @pdOid 40d9db74-23e8-47aa-b436-8aa8fb37684b */
   public NameValuePair getTributo() {
      return tributo;
   }
   
   /** @param newTributo
    * @pdOid cb49b4df-85e1-4bb2-ade4-4f68b587d4ee */
   public void setTributo(NameValuePair newTributo) {
      tributo = newTributo;
   }
   
   /** @pdOid 5beb941b-df66-4ca3-ae3d-be3285508c36 */
   public Double getMonto() {
      return monto;
   }
   
   /** @param newMonto
    * @pdOid 02de2c1f-fd5c-4a0b-b954-6ed2d0e560f4 */
   public void setMonto(Double newMonto) {
      monto = newMonto;
   }
   
   /** @pdOid 0ec9200b-379a-4477-aab0-817dab5234be */
   public String getHash() {
      return hash;
   }
   
   /** @param newHash
    * @pdOid 8d7bf490-2c43-48e0-bfbe-f1686c1eb8b7 */
   public void setHash(String newHash) {
      hash = newHash;
   }

}