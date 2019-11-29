-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-11-2019 a las 15:39:21
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
-- Estructura de tabla para la tabla `Evento`
--

CREATE TABLE `Evento` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diagnostico` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `droga` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `indicaciones` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `observaciones` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `mascota_id` bigint(20) NOT NULL,
  `tipo_id` bigint(20) NOT NULL,
  `usuario_creador_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FichaPublica`
--

CREATE TABLE `FichaPublica` (
  `id` bigint(20) NOT NULL,
  `apellido_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `color` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especie` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` datetime(6) DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `raza` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `senias` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Foto`
--

CREATE TABLE `Foto` (
  `id` bigint(20) NOT NULL,
  `contenido` longblob DEFAULT NULL,
  `mascota_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Mascota`
--

CREATE TABLE `Mascota` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especie` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `raza` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `senias` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `duenio_id` bigint(20) NOT NULL,
  `ficha_publica_id` bigint(20) DEFAULT NULL,
  `veterinario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Recordatorio`
--

CREATE TABLE `Recordatorio` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `creador_id` bigint(20) DEFAULT NULL,
  `evento_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rol`
--

CREATE TABLE `Rol` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `Rol`
--

INSERT INTO `Rol` (`id`, `nombre`) VALUES
(1, 'admin'),
(2, 'veterinario'),
(3, 'duenio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoEvento`
--

CREATE TABLE `TipoEvento` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `TipoEvento`
--

INSERT INTO `TipoEvento` (`id`, `nombre`) VALUES
(1, 'Visitas al veterinario'),
(2, 'Vacunaciones'),
(3, 'Enfermedades'),
(4, 'Intervenciones quirúrgicas'),
(5, 'Historial reproductivo'),
(6, 'Desparacitaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio_consultorio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  `matricula` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_consultorio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`id`, `activo`, `apellido`, `domicilio_consultorio`, `email`, `fecha_nacimiento`, `foto`, `matricula`, `nombre`, `nombre_consultorio`, `password`, `telefono`) VALUES
(1, b'1', 'Administrador', NULL, 'admin@admin.com', '1985-04-12', NULL, NULL, 'Administrador', NULL, '123456', '2221-411872');

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
-- Indices de la tabla `Evento`
--
ALTER TABLE `Evento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdlk4lgvep8skt9ibn9y3lhp2g` (`mascota_id`),
  ADD KEY `FKg7g6ksm3du6m6w03nwxk7ums7` (`tipo_id`),
  ADD KEY `FKol99rb2gjs5ox4isgvpiq2nrh` (`usuario_creador_id`);

--
-- Indices de la tabla `FichaPublica`
--
ALTER TABLE `FichaPublica`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Foto`
--
ALTER TABLE `Foto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm9pe6iq96gryas9lnc5v4u371` (`mascota_id`);

--
-- Indices de la tabla `Mascota`
--
ALTER TABLE `Mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKto0dxb07hihy1g4rn45xf4171` (`duenio_id`),
  ADD KEY `FKs0jn40b5vww9e8fgn6o8w5pde` (`ficha_publica_id`),
  ADD KEY `FKncnd66ed63q0grh89g2eulddl` (`veterinario_id`);

--
-- Indices de la tabla `Recordatorio`
--
ALTER TABLE `Recordatorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm5t05imdbxgbcobdldhgrfxkl` (`creador_id`),
  ADD KEY `FK90k3tyye63hb06q372u7jy5ka` (`evento_id`);

--
-- Indices de la tabla `Rol`
--
ALTER TABLE `Rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `TipoEvento`
--
ALTER TABLE `TipoEvento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Usuario_tiene_rol`
--
ALTER TABLE `Usuario_tiene_rol`
  ADD KEY `FKrtnos2um01ol21nsxbxqg2sap` (`id_rol`),
  ADD KEY `FKeoa06yp0smskd4h2oclb1koep` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Evento`
--
ALTER TABLE `Evento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `FichaPublica`
--
ALTER TABLE `FichaPublica`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Foto`
--
ALTER TABLE `Foto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Mascota`
--
ALTER TABLE `Mascota`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Recordatorio`
--
ALTER TABLE `Recordatorio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Rol`
--
ALTER TABLE `Rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `TipoEvento`
--
ALTER TABLE `TipoEvento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Evento`
--
ALTER TABLE `Evento`
  ADD CONSTRAINT `FKdlk4lgvep8skt9ibn9y3lhp2g` FOREIGN KEY (`mascota_id`) REFERENCES `Mascota` (`id`),
  ADD CONSTRAINT `FKg7g6ksm3du6m6w03nwxk7ums7` FOREIGN KEY (`tipo_id`) REFERENCES `TipoEvento` (`id`),
  ADD CONSTRAINT `FKol99rb2gjs5ox4isgvpiq2nrh` FOREIGN KEY (`usuario_creador_id`) REFERENCES `Usuario` (`id`);

--
-- Filtros para la tabla `Foto`
--
ALTER TABLE `Foto`
  ADD CONSTRAINT `FKm9pe6iq96gryas9lnc5v4u371` FOREIGN KEY (`mascota_id`) REFERENCES `Mascota` (`id`);

--
-- Filtros para la tabla `Mascota`
--
ALTER TABLE `Mascota`
  ADD CONSTRAINT `FKncnd66ed63q0grh89g2eulddl` FOREIGN KEY (`veterinario_id`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FKs0jn40b5vww9e8fgn6o8w5pde` FOREIGN KEY (`ficha_publica_id`) REFERENCES `FichaPublica` (`id`),
  ADD CONSTRAINT `FKto0dxb07hihy1g4rn45xf4171` FOREIGN KEY (`duenio_id`) REFERENCES `Usuario` (`id`);

--
-- Filtros para la tabla `Recordatorio`
--
ALTER TABLE `Recordatorio`
  ADD CONSTRAINT `FK90k3tyye63hb06q372u7jy5ka` FOREIGN KEY (`evento_id`) REFERENCES `Evento` (`id`),
  ADD CONSTRAINT `FKm5t05imdbxgbcobdldhgrfxkl` FOREIGN KEY (`creador_id`) REFERENCES `Usuario` (`id`);

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
