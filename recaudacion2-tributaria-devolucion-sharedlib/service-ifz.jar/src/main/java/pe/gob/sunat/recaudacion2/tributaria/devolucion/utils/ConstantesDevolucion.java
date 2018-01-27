/***********************************************************************
 * Module:  ConstantesDevolucion.java
 * Author:  jmazuelos
 * Purpose: Defines the Class ConstantesDevolucion
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

import java.util.*;

/** @pdOid 39d00be3-22e7-4dc9-a784-b483a292a3fc */
public final class ConstantesDevolucion {
   /** INICIO TIPOS DE DEVOLUCIONES */
   public static final String TIPDEV_PAGOINDEVIDOEXCESO = "02";
   public static final String TIPDEV_NRUS = "28";
   /** FIN TIPOS DE DEVOLUCIONES */
   
   /** @pdOid a3bfe81c-7ca4-4680-b80a-dc87935791d5 */
   public static final String FORMULARIO_REGISTRO = "02";
   /** @pdOid 9f9df3a2-bacd-44ca-8fd0-459e7cbb8453 */
   public static final String FORMULARIO_SELECCION = "01";
   /** @pdOid 3391dfeb-339b-4106-97d2-4ba27a4d2311 */
   public static final String FORMULARIO_BUSQUEDA_TRIBUTOS = "03";
   /** @pdOid 575025bc-9621-4ade-b17e-2b4a1930d2f9 */
   public static final String MODO_LLENADO_ASISTIDO = "01";
   /** @pdOid f397b001-ac0a-4bb4-8f0b-b391e00f77ef */
   public static final String MODO_LLENADO_MANUAL = "02";
   
   public static final String SEQUENCIA_DEVOLUIONES = "sedevf4999";
   public static final String SEQUENCIA_DEVOLUIONES_CORRELATIVO = "sedevf4999corr";
   public static final String SEQUENCIA_NUMERO_DOCUMENTO = "sedevf1649nord";
   
   public static final String FORMATO_NUM_DEVOLUCION = "%s24%07d";
   
   public static final String DIRECTORY_BASE_DATA = "/data0/devoluciones/";
   public static final String DIRECTORY_PLANTILLAS = DIRECTORY_BASE_DATA + "plantillas/";
   public static final String DIRECTORY_TEMPORAL = DIRECTORY_BASE_DATA + "temporal/";
   
   /*Códigos de Formularios de Devolución*/
   public static final String CODIGO_FORMULARIO_INTERNET = "1649";
   public static final String CODIGO_FORMULARIO_INTRANET = "4949";
   
   
   public static final String TIPO_DOCUMENTO_ADJUNTO = "03";
   
   /* FORMAS DE DEVOLUCION*/
   public static final String FORMA_OPF = "3" ;
   public static final String FORMA_ABONO = "4" ;
   public static final String FORMA_CHEQUE = "2" ;
   
   
   /**
    * Indicador de Resolución de devolución
    */
   public static final String RES_DEV_DENEGADA = "4";
   public static final String RES_DEV_RECHAZADA = "S";
   public static final String RES_DEV_DESESTIMIENTO = "5";
   public static final String RES_DEV_IMPROCEDENTE = "3";
   
   /* CODIGOS ENTIDAD COR_ENT*/
   public static final String CORR_ENT_DEPENDENCIA = "8888";
   public static final String CORR_ENT_DOCUMENTO = "22";
   
   /*ESTADOS RUC*/
   public static final String RUC_DIR_HABIDO = "00";
   public static final String RUC_DIR_NO_HABIDO = "12";
   public static final String RUC_HABIDO = RUC_DIR_HABIDO;
   public static final String RUC_BAJA_DEFINITIVA = "10";
   public static final String RUC_BAJA_FALLECIMIENTO = "06";
   
   public static final String RUC_TIPO_DOC_DNI = "1";
   
   /* ESTADOS PARA VALIDACION*/
   public static final String[] ESTADOS_MODIFICACION_PENDIENTE = new String[] {"10","11","12","13","21","31"};
   public static final String[] FORMULARIOS_TEF = new String[] {"1611","1610"};
   
   /*PARAMETROS*/
   public static final String PRM_BANCOS_CCI = "RECAUDA_PRM_A88";
   public static final String PRM_VALORES_REGISTRO = "RECAUDA_PRM_B37";
   public static final String PRM_VALORES_NORMATIVOS = "RECAUDA_PRM_B38";
   
   public static final String INFORMACION_ADICIONAL_ABONO = "<li>El MONTO SOLICITADO será depositado a la cuenta especificada en su Código de Cuenta Interbancario – CCI.</li><li>En caso de haber problemas en el depósito o no ser válido el CCI, se modificará automáticamente la forma de devolución a OPF.</li>";
   public static final String INFORMACION_ADICIONAL_OPF = "<li>La forma de devolución mediante OPF no permite que un tercero con poder cobre el dinero en el Banco.</li>";
   public static final String INFORMACION_ADICIONAL_VACIA = "";
   
   public static final String TR_CCI = "<tr><td>CCI</td><td>: %s</td></tr>";
}



