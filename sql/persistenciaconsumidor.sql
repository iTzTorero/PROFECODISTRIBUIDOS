-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2022 a las 07:40:26
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
-- Base de datos: `persistenciaconsumidor`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallewishlist`
--

CREATE TABLE `detallewishlist` (
  `iddetallewishlist` int(11) NOT NULL,
  `idwishlist` int(11) NOT NULL,
  `idconsumidor` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `idreporte` int(11) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `idmercado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`idreporte`, `descripcion`, `idproducto`, `idmercado`) VALUES
(3, 'Publicidad falsa', 3, 3),
(4, 'Muy caro', 3, 2),
(5, 'Muy caro', 3, 2),
(6, 'Muy caro', 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `review`
--

CREATE TABLE `review` (
  `idreview` int(11) NOT NULL,
  `contenido` varchar(140) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `idconsumidor` int(11) NOT NULL,
  `idmercado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `review`
--

INSERT INTO `review` (`idreview`, `contenido`, `calificacion`, `idconsumidor`, `idmercado`) VALUES
(3, 'Excelente mercado', 5, 6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wishlist`
--

CREATE TABLE `wishlist` (
  `idwishlist` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallewishlist`
--
ALTER TABLE `detallewishlist`
  ADD PRIMARY KEY (`iddetallewishlist`),
  ADD KEY `idwishlist` (`idwishlist`),
  ADD KEY `idproducto3` (`idproducto`),
  ADD KEY `idconsumidor2` (`idconsumidor`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`idreporte`),
  ADD KEY `idmercado1` (`idmercado`),
  ADD KEY `idproducto1` (`idproducto`);

--
-- Indices de la tabla `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`idreview`),
  ADD KEY `idconsumidor` (`idconsumidor`),
  ADD KEY `idmercado` (`idmercado`);

--
-- Indices de la tabla `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`idwishlist`),
  ADD KEY `idusuario2` (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallewishlist`
--
ALTER TABLE `detallewishlist`
  MODIFY `iddetallewishlist` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `idreporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `review`
--
ALTER TABLE `review`
  MODIFY `idreview` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `idwishlist` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallewishlist`
--
ALTER TABLE `detallewishlist`
  ADD CONSTRAINT `idconsumidor2` FOREIGN KEY (`idconsumidor`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idproducto3` FOREIGN KEY (`idproducto`) REFERENCES `persistenciamercado`.`producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idwishlist` FOREIGN KEY (`idwishlist`) REFERENCES `wishlist` (`idwishlist`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `idmercado1` FOREIGN KEY (`idmercado`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idproducto1` FOREIGN KEY (`idproducto`) REFERENCES `persistenciamercado`.`producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `idconsumidor` FOREIGN KEY (`idconsumidor`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idmercado` FOREIGN KEY (`idmercado`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `idusuario2` FOREIGN KEY (`idusuario`) REFERENCES `usuario`.`usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
