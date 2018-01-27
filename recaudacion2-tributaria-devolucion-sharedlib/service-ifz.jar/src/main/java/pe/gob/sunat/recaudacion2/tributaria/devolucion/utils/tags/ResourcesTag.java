package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ResourcesTag extends SimpleTagSupport  {
	String tipo; 
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void doTag() throws JspException, IOException {
		JspContext pageContext = (JspContext) getJspContext();
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		if("css".equals(tipo)){
			sb.append("<link href=\"/a/js/libs/bootstrap/3.3.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
			sb.append("<link href=\"/a/js/libs/bootstrap/3.3.2/plugins/bootstrap-datetimepicker-3.1.3/css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" />");
			sb.append("<link href=\"/a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/media/css/jquery.dataTables.min.css\" rel=\"stylesheet\" />");
			sb.append("<link href=\"/a/js/libs/bootstrap/3.3.2/plugins/jquery-validation-1.14.0/css/jquery.validate.min.css\" rel=\"stylesheet\" />");
			sb.append("<link href=\"/a/css/fpe/select.dataTables.min.css\" rel=\"stylesheet\" />");
			sb.append("<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->");
			sb.append("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->");
			sb.append("<!--[if lt IE 9]>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/html5shiv/3.7.2/html5shiv.min.js\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/respond/1.4.2/respond.min.js\"></script>");
			sb.append("<![endif]-->");
		} else {
			sb.append("<script src=\"/a/js/libs/jquery/1.11.2/jquery.min.js\"></script>");
			sb.append("<script src=\"/a/js/general/jquery_alert.js\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/js/bootstrap.min.js\"></script>");
			sb.append("<script src=\"/a/js/general/bootstrap-filestyle.min.js\"></script>");
			sb.append("<script src=\"/a/js/general/moment-with-locales.js\" type=\"text/javascript\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/bootstrap-datetimepicker-3.1.3/js/es.js\" type=\"text/javascript\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/bootstrap-datetimepicker-3.1.3/js/bootstrap-datetimepicker.min.js\" type=\"text/javascript\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/jquery.inputmask-3.1/dist/jquery.inputmask.bundle.min.js\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/jquery-validation-1.13.1/dist/jquery.validate.min.js\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/jquery-validation-1.13.1/dist/jquery.validate.min.js\"></script>");
			sb.append("<script src=\"/a/js/libs/bootstrap/3.3.2/plugins/jquery.blockUI-2.56.0/jquery.blockUI.js\" ></script>");
			sb.append("<script src=\"/a/js/fpe/jquery.dataTables.min.js\"></script>");
			sb.append("<script src=\"/a/js/fpe/dataTables.select.min.js\"></script>");
			sb.append("<script src=\"/a/js/general/jquery_plugin.js\"></script>");
			sb.append("<script src=\"/a/js/general/jqueryvalidate_methods.js\"></script>");
		}
		out.println(sb.toString());
	}
}

