package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EditableDropDownTag extends SimpleTagSupport  {
   private String path;
   private String cssClass;
   private boolean readonly;
   private String placeHolder;
      
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
   
   public boolean isReadonly() {
      return readonly;
   }

   public void setReadonly(boolean readonly) {
      this.readonly = readonly;
   }

   public String getPlaceHolder() {
      return placeHolder;
   }

   public void setPlaceHolder(String placeHolder) {
      this.placeHolder = placeHolder;
   }

   public void doTag() throws JspException, IOException {
      JspContext pageContext = (JspContext) getJspContext();
      JspWriter out = pageContext.getOut();
      StringBuffer sb = new StringBuffer();
      sb.append("<div class=\"input-group dropdown\">");
      String sreadonly = "";
         if(readonly)
            sreadonly = "readonly=\"readonly\"";
      sb.append("<input type=\"text\" id=\""+path+"\" name=\""+path+"\" class=\"dropdown-toggle "+cssClass+"\" "+sreadonly+" placeHolder=\""+placeHolder+"\" />");
      sb.append("<ul class=\"dropdown-menu\"></ul>");
      sb.append("<span role=\"button\" class=\"input-group-addon dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
      sb.append("<span class=\"caret\"></span>");
      sb.append("</span>");
      sb.append("</div>");
      out.println(sb.toString());
   }
}

