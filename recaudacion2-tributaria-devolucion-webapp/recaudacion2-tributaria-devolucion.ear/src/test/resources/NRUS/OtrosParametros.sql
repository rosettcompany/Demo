
SELECT * FROM t01param WHERE t01_numero = 129;

//Obtener buen contribuyente
ddp.ejecutaStoreBuenContribuyente('104585895');

//DevTipo01Bean
//findArgumento
SELECT *, t01_argumento, t01_funcion[63,66] FROM t01param
 WHERE t01_numero= '129'
 --  AND t01_tipo = 'D'
   AND t01_funcion[28]='3' AND t01_funcion[30]='2' 
   AND t01_argumento IN (SELECT DISTINCT cof_formul  FROM cof 
 WHERE cof_codtri = '030801') 
   AND t01_funcion[63,66] = ;


SELECT * , t01_funcion[17,26]FROM t01param 
 WHERE t01_numero = 695; //t01_funcion[17,26]
   AND t01_tipo = 'D'
   AND t01_argumento = 'periodo';
   
/**Consulta por par�metro las casillas del formulario 4949*/
--DevCons.PRM_CSLL_DESC 191
--DevCons.FRM_SOLI_DEVO 4949
SELECT TRIM(T01_ARGUMENTO[5,8]) AS T01_ARGUMENTO, 
       TRIM(T01_FUNCION[1,26]) AS T01_FUNCION ,
       *
  FROM T01PARAM 
 WHERE T01_NUMERO ='191' 
    AND T01_TIPO = 'D'
    AND T01_ARGUMENTO[1,4]='4949' 
  ORDER BY 1 ;
  
  
/** Lista los formularios usandos cuando menos en un tipo de solicitud */
--DevCons.PRM_FORM 101
--DevCons.PRM_FXTS 245
SELECT TRIM(FXTS.T01_ARGUMENTO) AS T01_ARGUMENTO, 
       TRIM(FXTS.T01_ARGUMENTO) || ' ' || TRIM(FRML.T01_FUNCION[1,25]) 
       AS T01_FUNCION 
  FROM T01PARAM FRML, T01PARAM FXTS 
 WHERE FRML.T01_NUMERO = '101'
   AND FRML.T01_TIPO = 'D'
   AND FXTS.T01_NUMERO ='245' 
   AND FXTS.T01_TIPO = 'D' 
   AND TRIM(FRML.T01_ARGUMENTO) = TRIM(FXTS.T01_ARGUMENTO) 
 ORDER BY 1;
 
 /** Lista los Tributos por tipo de Solicitud */
 --DevCons.PRM_TRIB 123
 --DevCons.TRB_SUNT 0
 --DevCons.PRM_TXTS 246
 SELECT TRIM(TRIB.T01_ARGUMENTO) AS T01_ARGUMENTO,
        TRIM(TXTS.T01_FUNCION)  AS T01_FUNCION 
   FROM T01PARAM TRIB, T01PARAM TXTS 
  WHERE TRIB.T01_NUMERO = '123' --PRM_TRIB
    AND TRIB.T01_TIPO   = 'D' 
    AND TRIB.T01_ARGUMENTO[1,1] = '0' -- Tributo Activo
    AND TXTS.T01_NUMERO = '246' --PRM_TXTS
    AND TXTS.T01_TIPO   = 'D' 
    AND TRIM(TRIB.T01_ARGUMENTO[2,4] || TRIB.T01_ARGUMENTO[6]) = TRIM(TXTS.T01_ARGUMENTO) 
  ORDER BY 1;

/** Lista los tributos usandos cuando menos en un tipo de solicitud */
 --DevCons.PRM_TRIB 123
 --DevCons.TRB_SUNT 0
 --DevCons.PRM_TXTS 246
SELECT TRIM(TRIB.T01_ARGUMENTO) AS T01_ARGUMENTO, 
       TRIM(TXTS.T01_ARGUMENTO) || ' ' || 
       TRIM(TRIB.T01_FUNCION[8,38]) || ' (' || TRIM(TRIB.T01_FUNCION[1,6]) || ')'
    AS T01_FUNCION 
  FROM T01PARAM TRIB, T01PARAM TXTS 
 WHERE TRIB.T01_NUMERO = '123' 
   AND TRIB.T01_TIPO   = 'D' 
   AND TRIB.T01_ARGUMENTO[1,1] = '0' 
   AND TXTS.T01_NUMERO = '246' 
   AND TXTS.T01_TIPO   = 'D' 
   AND TRIM(TRIB.T01_ARGUMENTO[2,4] || TRIB.T01_ARGUMENTO[6]) = TRIM(TXTS.T01_ARGUMENTO) 
 ORDER BY 1;


/** Lista las Formas de Devolucion V�lidas*/
--DevCons.PRM_FRM_DEV   664
--DevCons.PRM_FDEV_ACTV 1 //1 = activo 
SELECT TRIM(T01_ARGUMENTO) AS T01_ARGUMENTO, TRIM(T01_FUNCION[1,15])
    AS T01_FUNCION 
  FROM T01PARAM 
 WHERE T01_NUMERO ='664'
   AND T01_TIPO = 'D' 
   AND T01_FUNCION[31] = '1'
 ORDER BY 1;
 
 /** Lista las areas acotadoras*/
--DevCons.PRM_AREA_ACOT 243
SELECT TRIM(T01_ARGUMENTO[2,4]) 
    AS T01_ARGUMENTO, T01_FUNCION 
  FROM T01PARAM 
 WHERE T01_NUMERO ='243'
   AND T01_TIPO = 'D' 
 ORDER BY 1;

/** Lista la tasa de UIT por a�o*/
--DevCons.PRM_UIT
SELECT TRIM(T01_ARGUMENTO[1,4]) 
    AS T01_ARGUMENTO, T01_FUNCION 
  FROM T01PARAM 
 WHERE T01_NUMERO ='404' 
   AND T01_TIPO = 'D'
 ORDER BY 1;

/** Lista de Bancos Activos*/
--DevCons.PRM_BANC     004
--DevCons.PRM_BNC_ACTV 1
SELECT T01_ARGUMENTO, T01_FUNCION[1,25] 
    AS T01_FUNCION
  FROM T01PARAM 
 WHERE T01_NUMERO ='004'
   AND T01_TIPO = 'D' 
   AND T01_FUNCION[60] = '1' 
 ORDER BY 1 


/** Lista de Compa��as Aseguradoras*/
--DevCons.PRM_COMP_ASEG     365
SELECT T01_ARGUMENTO, T01_FUNCION[1,20] AS T01_FUNCION
  FROM T01PARAM 
 WHERE T01_NUMERO ='365' 
   AND T01_TIPO = 'D' 
 ORDER BY 1;

/** Lista los tipos de documentos que garantizan la devoluci�n */
--DevCons.PRM_TIP_GAR 669
SELECT TRIM(T01_ARGUMENTO) AS T01_ARGUMENTO, TRIM(T01_FUNCION[1,30]) 
    AS T01_FUNCION 
  FROM T01PARAM 
 WHERE T01_NUMERO ='669'
   AND T01_TIPO = 'D'
 ORDER BY 1 
 
--DevCons.PRM_TIP_GAR     669
--DevCons.PRM_TIPGAR_ACTV 1
 SELECT TRIM(T01_ARGUMENTO) 
     AS T01_ARGUMENTO, TRIM(T01_FUNCION[1,30])
     AS T01_FUNCION 
   FROM T01PARAM 
  WHERE T01_NUMERO ='669' 
    AND T01_TIPO = 'D'
    AND T01_FUNCION[41] = '1' 
  ORDER BY 1 

/** Lista los tipos de resultado de la devoluci�n */
-- 
SELECT TRIM(COD_GLO) AS COD_GLO, TRIM(NOM_GLO) 
    AS NOM_GLO 
  FROM GLOSAS 
 WHERE NOM_COL = 'ind_res_dev' 
   AND flg_col = '1'


/** Lista los Formularios por a�o a partir del 2015 para Persona Juridica*/
--DevCons.PRM_FRM_ANIO    129
--DevCons.PRM_FORM_ANUAL  3
--DevCons.PRM_PER_JURID   2
--DevCons.PRM_VIGEN_ANUAL 2016
SELECT TRIM(T01_ARGUMENTO) 
    AS T01_ARGUMENTO, 
       TO_CHAR((Cast(T01_FUNCION[63,66] as int)-1))
    AS T01_FUNCION 
  FROM T01PARAM 
 WHERE T01_NUMERO ='129'
   AND T01_TIPO = 'D'
   AND T01_FUNCION[28] = '3' 
   AND t01_funcion[30] = '2' 
   AND T01_FUNCION[63,66] >= '2016' 
 ORDER BY 1

/** Lista de Bancos asociados para el registro por CCI*/
--DevCons.PRM_BANCOS_CCI A88
SELECT t01_argumento, t01_funcion[1,80] 
  FROM t01param 
 WHERE t01_numero = 'A88' 
   AND t01_funcion[81]  = '1'


--T03DAO
SELECT * FROM t01param WHERE t01_numero = '140'
// PARAMETRO 140-CASILLAS POR FORMULARIO
           String arg = "t01_argumento[1,4] ".concat(formularios);
           String funcion = "t01_funcion[1,11]='"
                            .concat(tributo6.substring(0, 2)).concat(" ")
                            .concat(tributo6.substring(2, 4)).concat(" ")
                            .concat(tributo6.substring(4)).concat(" 05'");

           String query = "SELECT t01_numero, t01_tipo, t01_argumento, t01_funcion "
                          + "FROM t01param  "
                          + "WHERE t01_numero = '140' "
                          + "AND t01_tipo = 'D' " + "AND " + arg + " AND " + funcion;

-----------------------------------------------------------------------
-- ELIMINAR DEVOLUCI�N
-----------------------------------------------------------------------
DELETE FROM rfisca@d01_bancos:t5106detsolcam
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t5105solmoddev 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:dov_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:resp_eta_dev       
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:nid_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:mant_dev           
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:imp_ent_dev        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:pesca_dev          
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:cp_dev             
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:edi_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:cas_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:lc_dev             
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:edi_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:aut_bol_dev        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:tra_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:fil_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:per_dev_cab        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t4836ctr_envbuzdev 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t1930doc_sus_dev   
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:dev_pre_con        
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:ctr_dev            
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t3617dctosasoc     
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t3616_detvalcomp   
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t5105solmoddev     
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM rfisca@d01_bancos:t5050tipvalor 
WHERE num_dev 
IN (SELECT num_dev FROM rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701');
DELETE FROM  rfisca@d01_bancos:devoluciones  
WHERE  num_ruc = 15600021530 AND per_doc = '201701';
SELECT * FROM  rfisca@d01_bancos:devoluciones  
WHERE  num_ruc IN (15600021530, 10407836559, 10028419274);

SELECT * FROM cas_dev WHERE num_dev IN ( '0023240601208','0083240200579');
SELECT * FROM t3617dctosasoc  WHERE num_dev IN ( '0023240601208','0083240200579');
SELECT * FROM resp_eta_dev WHERE num_dev IN ( '0023240601208', '0083240200579');



SELECT FIRST 1 * FROM recauda@d01_central:vfp WHERE vfp_numruc = '15600021530'


//AFECTO NUEVO RUSS
INSERT INTO recauda@d01_central:vfp 
       (vfp_numruc, vfp_codtri, vfp_fecvig,
        vfp_fecalt, vfp_exodes, vfp_exohas,
        vfp_exodis, vfp_sispag, vfp_frepag,
         vfp_pervsp, vfp_sigmin, vfp_impmin,
          vfp_gesmin, vfp_indalt, vfp_tipins,
           vfp_condes, vfp_conhas, vfp_condis,
            vfp_esta_a, vfp_esta_e, vfp_esta_c,
             vfp_userna, vfp_fecact)
VALUES ('10407836559', '041000', TODAY - 300,
		 TODAY - 300, '1/1/1', '1/1/1',
		  '-', '-', '-',
		   '000101', '-', 0, '-',
		    '0', '1', '1/1/1', '1/1/1',
		     '-', '0', '1',
		     '1', 'JD3BEHUZ', today);

-- Inserci�n de formulario 1611
INSERT INTO recauda@d01_central:t03djcab (t03nabono, t03nresumen, t03ncaratula, t03codresumen, t03formulario, t03folio, t03norden, t03lltt_ruc, t03indica, t03periodo, t03f_presenta, t03autorden, t03nrocheque, t03bcolibrad, t03rechazado, t03rectifica, t03nrosemana, t03sintotal, t03cnumero, t03ecaptura, t03digit1, t03digit2, t03digit3, t03digit4, t03digit5, t03digit6, t03estado)
VALUES ('99949999', '02999072464', '52322', '4010', '1611', 1, 231207324, '10407836559', '0', '201612', '02/11/2017', '1', '0', '00', '0', 0, '0', '0', '0023', '1', '2', '05', '0', '0', '0', '0', '21');



select dds_motbaj, dds_docide, * from dds 
select * from t01param where t01_numero='011' --motivo baja
select * from t01param where t01_numero='026' --condicion de domicilio
select * from t01param where t01_numero='178' -- Estados del contribuyente.

SELECT * FROM recauda@d01_centralruc:ddp WHERE ddp_estado ='10'


SELECT  first 1 dds_docide, dds_motbaj,  * FROM dds




 select num_cor           from cor_ent
cadNumOrden= numLote

SELECT * FROM t8001cci

SELECT * FROM recauda@d01_centralruc:ddp WHERE ddp_numruc IN ('10028346358')
SELECT * FROM recauda@d01_centralruc:dds WHERE dds_numruc IN ('15600021530')
 
UPDATE  recauda@d01_centralruc:ddp SET DDP_ESTADO = '00' WHERE ddp_numruc IN ('10028346358')

SELECT t8001cci.*
FROM t8001cci,
     recauda@d01_centralruc:ddp
     
WHERE trim(num_docidenti) = trim(ddp_numruc)
AND num_docidenti = '10028419274'


'10067734357'
'10069665832'

SELECT FIRST 1 * FROM ddp


SELECT num_ruc FROM rfisca@d01_bancos:devoluciones 
WHERE cod_tip_sol = 28
  AND fec_doc > TODAY - 700
  AND num_ruc IN (SELECT ddp_numruc FROM recauda@d01_centralruc:ddp )
GROUP BY num_ruc

SELECT * FROM rfisca@d01_bancos:devoluciones 
WHERE cod_tip_sol = 28
  AND fec_doc > TODAY - 700
  AND num_ruc IN (SELECT ddp_numruc FROM recauda@d01_centralruc:ddp  )


SELECT * FROM rfisca@d01_bancos:resp_eta_dev


SELECT FIRST 200 * FROM rfisca@d01_bancos:devoluciones 






select cab.num_correlativo
from t1254docab cab,
     t1256dodet det,
     t1255veredicto ver
where cab.num_correlativo=det.num_correlativo
     and   cab.num_correlativo=ver.num_correlativo
     and   ver.ind_activo='1' 
---     and   cab.num_ruc = ''
--                         and   ver.fec_accion between
     and   ver.cod_estado IN ('10','11','12','13','21','31') 
--                         and   cab.cod_depdestin=? 
order by ver.fec_accion 



SELECT FIRST 1 * FROM recauda:t1441f697pcab



 SELECT cod_for  FROM sol_comp 
  WHERE num_ruc = ? 
    AND cod_tri = ? 
	AND cod_for_ori = ? 
	AND num_doc_ori = ? 
	AND ind_ori_com = '2' 
	AND cod_eta_sol in ('01','02','03')
  ORDER BY nro_orden 

SELECT t03nabono  FROM t03djcab WHERE t03periodo ='201701' AND t03formulario IN ("1610", "1611") AND t03lltt_ruc =?

SELECT *  FROM t03djcab WHERE t03periodo ='201701' AND t03formulario IN ("1610", "1611") AND t03lltt_ruc =?




SELECT max(t03nabono)  FROM t03djcab


SELECT * FROM devoluciones WHERE num_ruc = '10407836559'

SELECT num_ejercicio,                num_formul,                num_ord,                num_ruc,                num_revision,                fec_revision,                num_sec,                ind_actual,                ind_estado,                ind_proceso,                fec_creacion
 FROM pdtinternet@d01_central:T5847CTLDECL          
WHERE num_formul = '0703'           
AND ind_estado = '2'                        
AND num_ruc = '10407836559'            
Order by fec_revision desc



 select num_corr, * from cor_ent where cod_dep = '8888' and cod_doc = '22'


SELECT FIRST 1 *      
FROM recauda@d01_centralruc:dds 
where dds_docide = '1'


INSERT INTO recauda@d01_central:dds 
SELECT first 1 '10028346358', dds_telef1, dds_telef2,
       dds_telef3, dds_numfax, dds_pasapo, 
       dds_licenc, dds_contab, dds_factur, 
       dds_consti, dds_ficha, dds_inicio, 
       dds_cierre, dds_fecven, dds_califi,
        dds_domici, dds_orient, dds_patron, 
        dds_ejempl, dds_motemi, dds_nomcom,
         dds_aparta, dds_paispa, dds_nfolio, 
         dds_asient, dds_comext, dds_centro, 
         dds_motbaj, dds_docide, dds_nrodoc,
          dds_sexo, dds_nacion, dds_fecnac,
           dds_userna, dds_fecact
FROM recauda@d01_centralruc:dds 
where dds_docide = '1';

WHERE dds_numruc = '17600028774' AND dds_telef1 = '-' AND dds_telef2 = '-' AND dds_telef3 = '-' AND dds_numfax = '-' AND dds_pasapo = '-' AND dds_licenc = '-' AND dds_contab = '-' AND dds_factur = '-' AND dds_consti = '1/1/1' AND dds_ficha = '-' AND dds_inicio = '06/02/2017' AND dds_cierre = '-' AND dds_fecven = '1/1/1' AND dds_califi = '-' AND dds_domici = '-' AND dds_orient = '-' AND dds_patron = '-' AND dds_ejempl = '-' AND dds_motemi = '-' AND dds_nomcom = '-' AND dds_aparta = '-' AND dds_paispa = '-' AND dds_nfolio = '-' AND dds_asient = '-' AND dds_comext = '-' AND dds_centro = '-' AND dds_motbaj = '-' AND dds_docide = '1' AND dds_nrodoc = '-' AND dds_sexo = '-' AND dds_nacion = '-' AND dds_fecnac = '1/1/1' AND dds_userna = 'conweb' AND dds_fecact = '06/02/2017 01:37:12';



INSERT INTO recauda@d01_centralruc:dds 

dds_numruc = '10028346358'

SELECT argumento, funcion FROM param_local       WHERE numero = 648        AND tipo = 'D'        AND cod_dep = '0023';
SELECT argumento, funcion FROM param_local       WHERE numero = 648        AND tipo = 'D'        AND cod_dep = '0023';
SELECT * FROM t03djcab WHERE t03formulario = '1610';

-- Unidad organizacional
SELECT FIRST 1 * FROM sp@d01_ina:t12uorga WHERE t12cod_uorga = '6E5100';
--WHERE t02cod_pers='4111'; --0023t02cod_uorg='6E5100' AND t02cod_uorgl='6E5100'        6E5100;
UPDATE sp@d01_ina:t12uorga SET T12COD_jefat = 'QZ91' WHERE t12cod_uorga = '6E5100' 
SELECT * FROM sp@d01_ina:correos
INSERT INTO sp@d01_ina:correos (cod_pers, smtp, alias)
VALUES ('QZ91', 'jmazuelos@sunat.gob.pe', 'jmazuelos');
