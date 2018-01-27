/***********************************************************************
 * Module:  FuncionesGenericas.java
 * Author:  jmazuelos
 * Purpose: Defines the Class FuncionesGenericas
 ***********************************************************************/

package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

import java.io.File;
import java.io.IOException;

import pe.gob.sunat.framework.util.io.factory.DescargaFactory;

/** @pdOid 00a340c1-4cbd-44cd-a56c-8e4085631311 */
public class FuncionesGenericas {
   /** Grabar un archivo ubicado en la ruta hacia la tabla archbin. Si el registro es satisfactorio, se devuelve un identificador del archivo registrado.
    * 
    * @param rutaArchivo 
    * @param idDocumentoAsociado
    * @exception IOException
    * @pdOid ac0cbdae-3953-4207-9d76-3f0c4daf959d */
   public static int grabarArchivoArchBin(File rutaArchivo, int idDocumentoAsociado) throws IOException {
      int num_id=new DescargaFactory().getCargador(DescargaFactory.FISCALIZACION).cargar(rutaArchivo,
            0,
            false,
            idDocumentoAsociado);
      return num_id;
   }
   
}