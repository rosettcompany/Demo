package pe.gob.sunat.recaudacion2.tributaria.devolucion.bean;

public class BusinessException extends RuntimeException{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   private String  mensajeNegocio;
   private int status;
   
   public String getMensajeNegocio() {
      return mensajeNegocio;
   }
   
   public int getStatus(){
      return status;
   }
   
   public BusinessException(String mensajeTecnico, String mensajeNegocio){
     super(mensajeTecnico);
     this.mensajeNegocio = mensajeNegocio;
     this.status = ResponseStatus.Fallo;
   }
   
   public BusinessException(String mensajeTecnico, String mensajeNegocio, int status){
      super(mensajeTecnico);
      this.mensajeNegocio = mensajeNegocio;
      this.status = status;
    }
}
