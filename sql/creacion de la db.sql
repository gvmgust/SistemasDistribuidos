CREATE DATABASE `sistemasdistribuidos` DEFAULT CHARACTER SET latin1;

USE `sistemasdistribuidos`;

CREATE TABLE `candidato` (
  `id_cand` int(3) NOT NULL,
  `Candidato` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `eleccion` (
  `id_elec` int(11) NOT NULL,
  `inic_inscrip` datetime NOT NULL,
  `fin_inscrip` datetime DEFAULT NULL,
  `inicio` datetime NOT NULL,
  `fin` datetime NOT NULL,
  PRIMARY KEY (`id_elec`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `persona` (
  `ci` varchar(10) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido_paterno` varchar(40) NOT NULL,
  `apellido_materno` varchar(40) NOT NULL,
  `Direccion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `postulantes` (
  `id_ele` int(8) NOT NULL,
  `id_cand` int(8) NOT NULL,
  `votos` int(11) DEFAULT '0',
  PRIMARY KEY (`id_ele`,`id_cand`),
  KEY `id_cand` (`id_cand`),
  CONSTRAINT `postulantes_ibfk_2` FOREIGN KEY (`id_ele`) REFERENCES `eleccion` (`id_elec`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `postulantes_ibfk_1` FOREIGN KEY (`id_cand`) REFERENCES `candidato` (`id_cand`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `votacion` (
  `id_ele` int(11) NOT NULL,
  `ci` varchar(10) NOT NULL,
  PRIMARY KEY (`id_ele`,`ci`),
  KEY `ci` (`ci`),
  CONSTRAINT `votacion_ibfk_2` FOREIGN KEY (`id_ele`) REFERENCES `eleccion` (`id_elec`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `votacion_ibfk_1` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

