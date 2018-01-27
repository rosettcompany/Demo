/***********************************************************************
 * Module:  GenericFunctions.java
 * Author:  jmazuelos
 * Purpose: Defines the Class GenericFunctions
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
/** Funciones de uso general
 * 
 * @pdOid 831750af-e92c-4f70-af66-6d3342e34b8c */
public class GenericFunctions {   /** Formato de fecha a ser usado en toda la aplicación
    * 
    * @pdOid 381b8211-7c42-4411-b2f2-e388f01c8c4c */
   static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
   
   
   private static final Pattern isDigit = Pattern.compile("^\\d*(\\.\\d+)?$"); 
   
   /** Convierte una cadena a fecha.
    * En caso de que la cadena esté vacía o null se
    * devuelve null
    * 
    * 
    * @param fecha
    * @exception ParseException
    * @pdOid fb5574fc-cf9a-4544-8310-2d9311ae1e4d */
   public static Date stringToNullDate(String fecha) throws ParseException {
      if(fecha == null || fecha.isEmpty())
         return null;
      return format.parse(fecha);
   }
   
   /**
    * Función que da formato a las excepciones para imprimirlas en el log
    * @param mensaje Mensaje personalizado a mostrar al momento de eimprimir la excepción.
    * @param ex Excepción a dar formato
    * @return
    */
   public static String formatException(String mensaje, Exception ex){
      StringBuilder bl = new StringBuilder();
      bl.append("\n");
      bl.append("###########################################################\n");
      bl.append("EXCEPCIÓN NO ESPERADA.\n");
      bl.append(String.format("Error de procesamiento : %s.\n",mensaje));
      bl.append(String.format("Tipo de Excepción: %s.\n",ex.getClass().getName()));
      bl.append(String.format("Mensaje de Excepción: %s.\n",ex.getMessage()));
      if(ex instanceof SQLException)
          bl.append(String.format("SQL: %s.\n",((SQLException)ex).getCause()));      	
      bl.append(String.format("Traza inversa:\n"));
      
      for (StackTraceElement element : ex.getStackTrace()) {
         bl.append(element.toString() + "\n");
      }
      bl.append("###########################################################");
      return bl.toString();
   }
   
   /**
    * Devuelve verdadero en caso de que la cadena value sea nula o vacia.
    * En caso contrario devuelve FALSE
    * @param value
    * @return
    */
   public static boolean isBlankOrNull(String value){
      if(value == null)
         return true;
      return value.isEmpty();
   }
   
   /**
    * Devuelve verdadero en caso de que la cadena value sea nula o vacia.
    * En caso contrario devuelve FALSE. Previamente realiza un TRIM a la cadena
    * @param value
    * @return
    */
   public static boolean isBlankOrNullTrim(String value){
      if(value == null)
         return true;
      return value.trim().isEmpty();
   }
   
   
   public static boolean isNumber(String value){
      boolean a = isBlankOrNullTrim(value);
      if(a)
         return false;
      return isDigit.matcher(value).matches();
   }
   
   /**
    * Devuelve verdadero en caso de que la cadena value sea nula o vacia.
    * En caso contrario devuelve FALSE
    * @param value
    * @return
    */
   public static boolean isBlankNullorEquals(String value, String valueToCompare){
      if(value == null)
         return true;
      if(value.isEmpty())
         return true;
      return value.equals(valueToCompare);
   }
   
   /***
    * Devuelve TRUE en caso de que la lista sea nula o vacía
    * @param lista
    * @return
    */
   public static boolean isListEmptyOrNull(List lista){
      if(lista == null)
         return true;
      return lista.isEmpty();
   }
   
   
   /**
    * En caso de que la cadena value sea vacia o nula, se devuelve el valor
    * de default_value. En caso contrario se devuelve el valor value
    * @param value
    * @param default_value
    * @return
    */
   public static String setDefaultToNull(String value, String default_value){
      if(isBlankOrNull(value))
         return default_value;
      return value;
   }
}