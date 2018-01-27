
--Obtener las declaraciones de formulario asociado  
 SELECT num_ejercicio,
        num_formul,
        num_ord,
        num_ruc,
        num_revision,
        fec_revision,
        num_sec,
        ind_actual,
        ind_estado,
        ind_proceso,
        fec_creacion
        FROM pdtinternet@d01_central:T5847CTLDECL
        WHERE 1 =1
          AND num_formul = '0703' -- Anual renta 201613
          AND ind_estado = 2
          --AND num_ruc = ?
          Order by fec_revision desc

SELECT * from pdtinternet@d01_central:T5847CTLDECL where num_sec = 1036547
-- Verificar las casillas de cuarta
SELECT FIRST 100 num_sec,          cas_360,           cas_361     
   FROM pdtinternet@d01_central:T5386CASSEGUNDA
   WHERE cas_360 is not null

-- Obtener declaraciones 
SELECT num_ejercicio,
        num_formul,
        num_ord,
        num_ruc,
        num_revision,
        fec_revision,
        num_sec,
        ind_actual,
        ind_estado,
        ind_proceso,
        fec_creacion
        FROM pdtinternet@d01_central:T5847CTLDECL where num_sec IN (
						SELECT num_sec
						  FROM pdtinternet@d01_central:t5385casprimera
						  WHERE CAS_159 > 0
						  and  CAS_160 = '1'
						  )
			AND num_ord <> 0;
           
--SE OBTIENEN LOS RUCS DE PRUEBAS PARA RENTA 201613 
SELECT FIRST 10 COD_USUARIO[1,11], * 
  FROM BDITSGME@D01_CENTRAL:USUARIO 
 WHERE COD_USUARIO[1,11] IN (SELECT 
        num_ruc
        FROM pdtinternet@d01_central:T5847CTLDECL where num_sec IN (
                  SELECT num_sec
                    FROM pdtinternet@d01_central:t5385casprimera
                    WHERE CAS_159 > 0
                    and  CAS_160 = '1'
                    )
         AND num_ord <> 0);

-- Verificar devoluciones presentadas por RUC:
SELECT * FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10000006390'); 


|select first+1 per_doc,cod_for,num_doc  
   from t3779formulario where cod_for = ? and num_doc = ? and per_doc = ? and ind_est_for in ('01','02')