package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ConstantesModel;

public class Constantes {
   public static final String MSG_ERROR_GRAL_NEGOCIO = "Estimado usuario, ocurrió un problema al procesar la información. Por favor intente nuevamente.";
   

   
   public static final String FORMAT_NUMBERS_SN_COMAS = "##0.00";
   public static final String FORMAT_DATE_TIME = "dd/MM/yyyy HH:mm:ss";
   
   public static final String PARAM_FORMULARIOS = "recaudaprm129";
   public static final String PARAM_FORMULARIOS_DESC = "recaudaprm101";
   public static final String PARAM_TRIBUTOS = "recaudaprm123";
   
   public static final String COD_TRIBUTO_RENTA_PRIMERA = "030702";
   public static final String COD_TRIBUTO_RENTA_SEGUNDA = "030704";
   public static final String COD_TRIBUTO_RENTA_TRABAJO = "030703";

   public static final String UNO = "1";
   public static final String CERO = "0";
   public static final String FORMATO_FECHA = "dd/MM/yyyy";
   
   public static final SimpleDateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
   public static final SimpleDateFormat DATE_FORMAT_DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
   public static final SimpleDateFormat PERIODO_DATE_FORMAT = new SimpleDateFormat("yyyyMM");
   public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(ConstantesModel.DEFAULT_FORMAT_NUMBERS);
   
   public static final String INDICADOR_INACTIVO = "0";
   public static final String INDICADOR_ACTIVO = "1";
   public static final String INDICADOR_ESTADO_INICIAL = "01";

   /*VALORES POR DEFECTO EN CASO DE NULOS*/
   public static final Double DOUBLE_DEFECTO = 0.00;
   public static final String DEFAULT_NULL_STRING = "-";
   public static final Date DEFAULT_NULL_DATE;
   static{
      try{
         DEFAULT_NULL_DATE = DATE_FORMAT_YYYYMMDD.parse("0001/01/01");
      }catch(final Exception ex){
          throw new RuntimeException("Error al crear la fecha nula por defecto.",ex);
      }  
   }
   
   /*CONSTANTES PARA EL USO DE POOLS*/
   public static final String DATASOURCE_READ_KEY = "c";
   public static final String DATASOURCE_TRANSACTIONAL_KEY = "g";
   public static final String DATASOURCE_XATRANSACTIONAL_KEY = "g";
   
}
