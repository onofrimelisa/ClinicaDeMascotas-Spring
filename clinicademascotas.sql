-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 20-03-2020 a las 00:42:13
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinicademascotas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario_tiene_rol`
--

CREATE TABLE `Usuario_tiene_rol` (
  `id_usuario` bigint(20) NOT NULL,
  `id_rol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `Usuario_tiene_rol`
--

INSERT INTO `Usuario_tiene_rol` (`id_usuario`, `id_rol`) VALUES
(1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Usuario_tiene_rol`
--
ALTER TABLE `Usuario_tiene_rol`
  ADD KEY `FKrtnos2um01ol21nsxbxqg2sap` (`id_rol`),
  ADD KEY `FKeoa06yp0smskd4h2oclb1koep` (`id_usuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Usuario_tiene_rol`
--
ALTER TABLE `Usuario_tiene_rol`
  ADD CONSTRAINT `FKeoa06yp0smskd4h2oclb1koep` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FKrtnos2um01ol21nsxbxqg2sap` FOREIGN KEY (`id_rol`) REFERENCES `Rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
