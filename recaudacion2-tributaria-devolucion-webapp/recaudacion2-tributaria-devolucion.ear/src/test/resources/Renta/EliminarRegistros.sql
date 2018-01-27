--Elimina registros de devoluciones 
DELETE FROM rfisca@d01_bancos:t5106detsolcam
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t5105solmoddev 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:anu_dov_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:dov_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:resp_eta_dev       
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:nid_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:mant_dev           
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:imp_ent_dev        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:pesca_dev          
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:cp_dev             
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:edi_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:cas_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:lc_dev             
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:edi_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:aut_bol_dev
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:tra_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:fil_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:per_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t4836ctr_envbuzdev 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t1930doc_sus_dev   
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:dev_pre_con        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:ctr_dev
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t3617dctosasoc     
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t3616_detvalcomp   
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t5105solmoddev     
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM rfisca@d01_bancos:t5050tipvalor 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') );

DELETE FROM  rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791') ;

SELECT ind_for_dev, cod_dep_pres, * FROM  rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN ('10005066404','10008354907', '10000017791');