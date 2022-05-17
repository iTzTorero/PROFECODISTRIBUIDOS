-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2022 a las 07:41:02
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
-- Base de datos: `usuario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `tipoUsuario` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `tipoUsuario`, `nombre`, `email`, `telefono`, `contrasenia`) VALUES
(1, 'profeco', 'Profeco', 'profeco.gob.mexico@gmail.com', '6871797787', 'admin'),
(2, 'Mercado', 'Oxxo', 'juantamazula60@gmail.com', '112123132', 'oxxo123'),
(3, 'Mercado', 'Oxxo', 'grupooxxomexico@gmail.com', '123123123', 'oxxo123'),
(4, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(5, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(6, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(7, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(8, 'Profeco', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(9, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(10, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina'),
(11, 'Consumidor', 'Carmina Moreno', 'carminamoreno29@gmail.com', '123123123', 'carmina');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
