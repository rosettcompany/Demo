package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.NameValuePair;
import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;


public class NameValuePairTypeHandler  implements TypeHandlerCallback {
   public Object getResult(ResultGetter getter) throws SQLException {
      String value = getter.getString();
      if(value == null || value.isEmpty() || Constantes.DEFAULT_NULL_STRING.equals(value))
         return null;
      NameValuePair nv = new NameValuePair();
      nv.setValue(value);
      return nv;
   }

   public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
      if (parameter == null) {
         setter.setString(Constantes.DEFAULT_NULL_STRING);
      } else {
         NameValuePair nv = (NameValuePair) parameter;
         setter.setString(nv.getValue().trim());
      }
   }

   public Object valueOf(String value) {
      return new NameValuePair(value);
   }

}
