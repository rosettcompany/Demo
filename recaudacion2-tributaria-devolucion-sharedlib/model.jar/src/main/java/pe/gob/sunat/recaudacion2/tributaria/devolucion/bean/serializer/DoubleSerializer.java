package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean.serializer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import pe.gob.sunat.recaudacion2.tributaria.devolucion.model.ConstantesModel;


public class DoubleSerializer extends JsonSerializer<Double> {
	DecimalFormat format = (DecimalFormat)DecimalFormat.getInstance(new Locale("es__", "pe"));
	@Override
	public void serialize(Double paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
			throws IOException, JsonProcessingException {
		//format.format(paramT)
		//paramJsonGenerator.writeString(String.format("%.2f", paramT));
		format.applyPattern(ConstantesModel.DEFAULT_FORMAT_NUMBERS);
		String a = format.format(paramT);
		paramJsonGenerator.writeString(a);
	}
}
