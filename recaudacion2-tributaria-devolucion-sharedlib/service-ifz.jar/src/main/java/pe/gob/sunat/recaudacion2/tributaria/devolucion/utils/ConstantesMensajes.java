package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

public class ConstantesMensajes {
   public static final String MSJ_CONTRIBUYENTE_FALLECIMIENTO = "Sr. Contribuyente, si usted es heredero por favor sírvase regularizar el motivo de la Baja por fallecimiento, en el centro de servicio más cercano.";
   public static final String MSJ_CONTRIBUYENTE_BAJA = "Sr. Contribuyente, su número de  RUC se encuentra con baja definitiva.";
   public static final String MSJ_CONTRIBUYENTE_NO_ACTIVO = "Sr. Contribuyente, Usted se encuentra en la ficha RUC en estado no Activo, por favor verificar.";
   public static final String MSJ_CONTRIBUYENTE_NO_HABIDO = "Sr. Contribuyente, Usted se encuentra en condición de NO HABIDO en su ficha RUC. Acérquese a un Centro de Servicios para regularizar su condición domiciliaria.";
   
   public static final String MSJ_MODIFICACION_DATOS = "Sr. Contribuyente, Usted tiene pendiente una Solicitud de Modificación de Datos por el mismo tributo y período.";
   public static final String MSJ_COMPENSACION_DATOS = "Sr. Contribuyente, Usted tiene pendiente una Solicitud de Modificación de Datos por el mismo tributo y período.";
   
   public static final String MSJ_DEVOLUCION_PENDIENTE = "Sr. Contribuyente, existe una solicitud de devolución presentada anteriormente por el mismo tipo de devolución, periodo y tributo.";
   public static final String MSJ_DEVOLUCION_PERIODO_ANTERIOR_MINIMO = "Sr. Contribuyente, el periodo debe ser mayor o igual a 200401.";
   public static final String MSJ_DEVOLUCION_FORMA_ABONO_MTO_MAXIMO = "Sr. Contribuyente, para la forma de devolución Abono en Cuenta el monto no debe superar los S/ 100 000.";
   public static final String MSJ_DEVOLUCION_FORMA_CHEQUE_MTO_MAXIMO= "Sr. Contribuyente, para la forma de devolución Cheque, el monto debe superar las 10 UIT vigente.";
   public static final String MSJ_DEVOLUCION_FORMA_CCI = "Ingrese número de CCI.";
   public static final String MSJ_DEVOLUCION_FORMA_CCI_INVALIDO = "Sr. Contribuyente, el número CCI registrado no es válido, intente nuevamente, si el error persiste consulte con su banco el número correcto. El número de CCI debe ser de 20 dígitos (sin guiones, espacios u otro carácter).";
   public static final String MSJ_DEVOLUCION_FORMA_BANCO_NO_HABILITADO = "Sr. Contribuyente, el número de CCI registrado no corresponde a una de las entidades asociadas para el depósito por abono en cuenta. Las entidades asociadas son: %s.";
   public static final String MSJ_DEVOLUCION_FORMA_BANCO_NACION_NO_VALIDO = "Sr. Contribuyente, el número de CCI registrado, no corresponde a una cuenta de ahorros o corriente en Soles válida para el Banco de la Nación.";
   public static final String MSJ_DEVOLUCION_FORMA_NO_PERSONA_NATURAL = "El contribuyente no es una persona natural por lo que no puede solicitar la devolución mediante %s, sólo mediante Cheque.";
   public static final String MSJ_DEVOLUCION_FORMA_NO_DNI = "Sr. Contribuyente, su documento de identificación en el RUC no corresponde a DNI, sólo puede solicitar devolución mediante Cheque.";
   
   public static final String MSJ_NO_FORMULARIO_TEF = "Sr. Contribuyente, Usted no ha presentado ningún Formulario TEF 1611 para el Periodo Solicitado.";
   public static final String MSJ_NO_RUS = "Sr. Contribuyente, no se encuentra afecto al NUEVO RUS para el periodo de solicitud de devolución.";
}
