-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2022 a las 07:40:40
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `persistenciamercado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleoferta`
--

CREATE TABLE `detalleoferta` (
  `iddetalleoferta` int(11) NOT NULL,
  `idoferta` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `idoferta` int(11) NOT NULL,
  `descuento` float NOT NULL,
  `duracion` int(11) NOT NULL,
  `descripcion` varchar(140) NOT NULL,
  `idmercado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `descripcion` varchar(140) NOT NULL,
  `imagen` blob DEFAULT NULL,
  `categoria` int(11) NOT NULL,
  `idmercado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `precio`, `descripcion`, `imagen`, `categoria`, `idmercado`) VALUES
(3, 'atun', 20.3, 'Atun en agua', NULL, 2, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalleoferta`
--
ALTER TABLE `detalleoferta`
  ADD PRIMARY KEY (`iddetalleoferta`),
  ADD KEY `idoferta1` (`idoferta`),
  ADD KEY `idproducto3` (`idproducto`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`idoferta`),
  ADD KEY `idmercado2` (`idmercado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`),
  ADD KEY `idmercado` (`idmercado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalleoferta`
--
ALTER TABLE `detalleoferta`
  MODIFY `iddetalleoferta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `idoferta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleoferta`
--
ALTER TABLE `detalleoferta`
  ADD CONSTRAINT `idoferta1` FOREIGN KEY (`idoferta`) REFERENCES `oferta` (`idoferta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idproducto3` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `idmercado2` FOREIGN KEY (`idmercado`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `idmercado` FOREIGN KEY (`idmercado`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
