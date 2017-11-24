-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-11-2017 a las 20:46:32
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `inmobiliaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_comuna`
--

CREATE TABLE IF NOT EXISTS `tb_comuna` (
  `ID_COMUNA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_COMUNA`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Volcado de datos para la tabla `tb_comuna`
--

INSERT INTO `tb_comuna` (`ID_COMUNA`, `DESCRIPCION`) VALUES
(1, 'COLINA'),
(2, 'LAMPA'),
(3, 'TIL TIL'),
(4, 'PIRQUE'),
(5, 'PUENTE ALTO'),
(6, 'SAN JOSÉ DE MAIPO'),
(7, 'BUIN'),
(8, 'CALERA DE TANGO'),
(9, 'PAINE'),
(10, 'SAN BERNARDO'),
(11, 'ALHUÉ'),
(12, 'CURACAVÍ'),
(13, 'MARÍA PINTO'),
(14, 'MELIPILLA'),
(15, 'SAN PEDRO'),
(16, 'CERRILLOS'),
(17, 'CERRO NAVIA'),
(18, 'CONCHALÍ'),
(19, 'EL BOSQUE'),
(20, 'ESTACIÓN CENTRAL'),
(21, 'HUECHURABA'),
(22, 'INDEPENDENCIA'),
(23, 'LA CISTERNA'),
(24, 'LA GRANJA'),
(25, 'LA FLORIDA'),
(26, 'LA PINTANA'),
(27, 'LA REINA'),
(28, 'LAS CONDES'),
(29, 'LO BARNECHEA'),
(30, 'LO ESPEJO'),
(31, 'LO PRADO'),
(32, 'MACUL'),
(33, 'MAIPÚ'),
(34, 'ÑUÑOA'),
(35, 'PEDRO AGUIRRE CERDA'),
(36, 'PEÑALOLÉN'),
(37, 'PROVIDENCIA'),
(38, 'PUDAHUEL'),
(39, 'QUILICURA'),
(40, 'QUINTA NORMAL'),
(41, 'RECOLETA'),
(42, 'RENCA'),
(43, 'SAN MIGUEL'),
(44, 'SAN JOAQUÍN'),
(45, 'SAN RAMÓN'),
(46, 'SANTIAGO'),
(47, 'VITACURA'),
(48, 'EL MONTE'),
(49, 'ISLA DE MAIPO'),
(50, 'PADRE HURTADO'),
(51, 'PEÑAFLOR'),
(52, 'TALAGANTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_departamento`
--

CREATE TABLE IF NOT EXISTS `tb_departamento` (
  `ID_DEPARTAMENTO` int(10) NOT NULL AUTO_INCREMENT,
  `ID_EDIFICIO` varchar(4) NOT NULL,
  `NUMERO` int(4) NOT NULL,
  `RESIDENTE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_DEPARTAMENTO`),
  KEY `ID_EDIFICIO` (`ID_EDIFICIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_edificio`
--

CREATE TABLE IF NOT EXISTS `tb_edificio` (
  `ID_EDIFICIO` varchar(4) NOT NULL,
  `NOM_EDIFICIO` varchar(50) NOT NULL,
  `DIRECCION` varchar(50) NOT NULL,
  `ID_COMUNA` int(3) NOT NULL,
  `POSEE_PERM_MUN` int(1) DEFAULT '0',
  PRIMARY KEY (`ID_EDIFICIO`),
  KEY `ID_COMUNA` (`ID_COMUNA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_edificio`
--

INSERT INTO `tb_edificio` (`ID_EDIFICIO`, `NOM_EDIFICIO`, `DIRECCION`, `ID_COMUNA`, `POSEE_PERM_MUN`) VALUES
('papo', 'El edificio rojo', 'san camilo 69', 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `RUT` varchar(10) NOT NULL,
  `NOM_USUARIO` varchar(50) NOT NULL,
  `CONTRASENA` varchar(50) NOT NULL,
  PRIMARY KEY (`RUT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_departamento`
--
ALTER TABLE `tb_departamento`
  ADD CONSTRAINT `tb_departamento_ibfk_1` FOREIGN KEY (`ID_EDIFICIO`) REFERENCES `tb_edificio` (`ID_EDIFICIO`);

--
-- Filtros para la tabla `tb_edificio`
--
ALTER TABLE `tb_edificio`
  ADD CONSTRAINT `tb_edificio_ibfk_1` FOREIGN KEY (`ID_COMUNA`) REFERENCES `tb_comuna` (`ID_COMUNA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
