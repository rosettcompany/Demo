package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.Constantes;

public class StringTypeHandler implements TypeHandlerCallback {
      public Object getResult(ResultGetter getter) throws SQLException {
         String value = getter.getString();
         if(value ==null || value.isEmpty() || "-".equals(value))
            return null;
         return value;
      }

      public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
         if (parameter == null) {
            setter.setString(Constantes.DEFAULT_NULL_STRING);
         } else {
            setter.setString((String)parameter);
         }
      }

      public Object valueOf(String value) {
         return value;
      }

}
