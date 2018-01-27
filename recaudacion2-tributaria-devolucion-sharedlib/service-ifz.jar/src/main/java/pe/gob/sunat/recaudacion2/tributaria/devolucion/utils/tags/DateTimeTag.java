package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTimeTag extends SimpleTagSupport  {

	private String path;
	private String cssClass;
	
		
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void doTag() throws JspException, IOException {
		JspContext pageContext = (JspContext) getJspContext();
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"input-group input-append date\"  id=\"dtp" + path +"\">");
		//sb.append("<form:input path=\""+path+"\" class=\""+cssClass+"\" />");
		sb.append("<input type=\"text\" id=\""+path+"\" name=\""+path+"\" class=\""+cssClass+"\" />");
		sb.append("<span class=\"input-group-addon add-on\"><span class=\"glyphicon glyphicon-calendar\"></span></span>");
		sb.append("</div>");
		out.println(sb.toString());
	}
}