/***********************************************************************
 * Module:  NameValuePair.java
 * Author:  jmazuelos
 * Purpose: Defines the Class NameValuePair
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

import java.util.*;

/** @pdOid c4935f6e-9224-4f5e-99bb-a0f940293fd9 */
public class NameValuePair {
   /** @pdOid 1834008e-b519-4b2a-9ad4-65e277276429 */
   private String name;
   /** @pdOid 451ffd90-059a-474b-ae10-3e928b29559c */
   private String value;
   
   public NameValuePair(){
      
   }
   
   public NameValuePair(String nameValue, String valueValue){
      name = nameValue;
      value = valueValue;
   }
   
   public NameValuePair(String valueValue){
      String[] lista = valueValue.split("\\|");
      value = lista[0];
      if(lista.length > 1)
         name = lista[1];
   }
   
   /** @pdOid a159c230-07fb-4471-87e8-5e26497ee499 */
   public String getName() {
      return name;
   }
   
   /** @param newName
    * @pdOid 3f3422c6-5d42-4bad-92a5-0312b42e48eb */
   public void setName(String newName) {
      name = newName;
   }
   
   /** @pdOid bf89cba3-6d77-44cd-b1e5-eea3ae9f9ddb */
   public String getValue() {
      return value;
   }
   
   /** @param newValue
    * @pdOid dac07084-3b0d-4bd6-bdef-b94620984a2e */
   public void setValue(String newValue) {
      value = newValue;
   }
   
   public String getValueName(){
      if(name !=null)
         return String.format("%s %s", value, name);
      return String.format("%s", value);
   }
   
   
   public String getSerializedValue(){
      return value + "|" + name;
   }

   @Override
   public String toString() {
      return value + '|' + name;
   }
}