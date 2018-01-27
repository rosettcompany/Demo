
SELECT * FROM bditsgme@d01_central:t1506programa
WHERE tip_invoca    = 1 des_contexto = '/ol-ti-itdevolucion-registro'

UPDATE bditsgme@d01_central:t1506programa 
   SET des_servlet  = '/RegistrarDevolucion.htm' ,
      des_nombre    = 'Registro de Solicitud de Devolución 1649',
      des_tags      = 'PE|presenta 1649',
      tip_invoca    = 1
 WHERE des_contexto = '/ol-ti-itdevolucion-registro'