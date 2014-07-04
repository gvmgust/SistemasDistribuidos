ALTER TABLE `candidato` CHANGE `id_cand` `id_opc` INT(3) NOT NULL, CHANGE `Candidato` `Opciones` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL; 
RENAME TABLE `candidato` TO `sistemasdistribuidos`.`opciones`; 
ALTER TABLE `postulantes` CHANGE `id_cand` `id_opc` INT(8) NOT NULL; 