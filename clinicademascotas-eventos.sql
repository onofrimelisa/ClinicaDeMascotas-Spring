-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 29, 2020 at 10:36 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinicademascotas`
--

-- --------------------------------------------------------

--
-- Table structure for table `Evento`
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
  `recordar_duenio` bit(1) NOT NULL,
  `recordar_veterinario` bit(1) NOT NULL,
  `mascota_id` bigint(20) NOT NULL,
  `tipo_id` bigint(20) NOT NULL,
  `usuario_creador_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Evento`
--

INSERT INTO `Evento` (`id`, `descripcion`, `diagnostico`, `droga`, `fecha`, `indicaciones`, `observaciones`, `peso`, `recordar_duenio`, `recordar_veterinario`, `mascota_id`, `tipo_id`, `usuario_creador_id`) VALUES
(1, 'Preguntar al veterinario sobre próxima fecha para desparasitación', '', '', '2020-05-06', '', '', NULL, b'0', b'0', 43, 1, 2),
(2, 'Consulta sobre alergia', '', '', '2020-04-01', '', '', NULL, b'0', b'0', 43, 1, 2),
(3, 'Vacuna antirrábica', '', '', '2020-01-07', '', 'Volver el próximo año', NULL, b'0', b'0', 43, 2, 2),
(4, 'Vacuna trivalente', 'Frente a la panleucopenia, el calcivirus y la rinotraqueitis.', '', '2020-05-22', 'Volver el próximo mes', '', 3.5, b'0', b'0', 22, 2, 2),
(5, 'Vacuna trivalente', 'Frente a la panleucopenia, el calcivirus y la rinotraqueitis.', '', '2020-06-24', 'Fin del tratamiento', '', 3.5, b'0', b'0', 22, 2, 2),
(6, 'Vacunación pentavalente', '', '', '2020-05-29', 'Cada dos meses', '', 6, b'0', b'0', 1, 2, 3),
(7, 'Preguntar sobre uñas rojizas, pesar', '', '', '2020-04-01', '', '', NULL, b'0', b'0', 1, 1, 3),
(8, 'Alergia en la mañana', '', '', '2020-06-18', '', '', 0.152, b'0', b'0', 38, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `FichaPublica`
--

CREATE TABLE `FichaPublica` (
  `id` bigint(20) NOT NULL,
  `apellido_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `color` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especie` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` datetime(6) DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `raza` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `senias` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono_duenio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `FichaPublica`
--

INSERT INTO `FichaPublica` (`id`, `apellido_duenio`, `color`, `email_duenio`, `especie`, `fecha_nacimiento`, `foto`, `nombre`, `nombre_duenio`, `raza`, `senias`, `sexo`, `telefono_duenio`) VALUES
(1, 'Onofri', 'Blanco', 'melisa@gmail.com', 'PERRO', '2020-04-28 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fwalli4?alt=media&token=aeb3d35f-3933-43c3-b74c-38728e2cb691', 'Walli', 'Melisa', 'Caniche', 'Con manchitas marrones', 'MASCULINO', '4853775'),
(2, 'Onofri', 'Marrón', 'melisa@gmail.com', 'TORTUGA', '2020-04-07 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Ftortuga-2_opt?alt=media&token=eda4d2e2-279f-49c1-a1a3-b168a2a0f62d', 'Florcita', 'Melisa', NULL, 'Manchas oscuras', 'FEMENINO', '4853775'),
(22, 'Repetto', 'Marrón', 'lorenzo@gmail.com', 'GATO', '2020-04-05 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fraca2?alt=media&token=a397b552-01c3-447e-98fa-6e404c9404fd', 'Raquel', 'Lorenzo', NULL, 'Manchas claritas', 'FEMENINO', '156423589'),
(37, 'Repetto', 'Rosa', 'lorenzo@gmail.com', 'PEZ', '2020-04-05 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fpez?alt=media&token=d3a0f1b0-f68c-4c0c-895d-50ef1b57647c', 'Jesse', 'Lorenzo', NULL, 'Con líneas de colores', 'MASCULINO', '156423589'),
(38, 'Repetto', 'Naranja', 'lorenzo@gmail.com', 'HAMSTER', '2020-04-06 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fhamster?alt=media&token=4c6e7fd0-3a23-4d3c-9f14-66b92f0b8896', 'Flavio', 'Lorenzo', NULL, 'Gordito', 'MASCULINO', '156423589'),
(39, 'Repetto', 'Blanco', 'antonio@gmail.com', 'PERRO', '1998-11-10 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fperro2?alt=media&token=b8e06a39-acf4-463e-847a-d1a25ccb594d', 'Manchi', 'Antonio', NULL, 'Con manchas negras', 'FEMENINO', '4987662'),
(40, 'Lemos', 'Marroncito', 'gabriela@gmail.com', 'PERRO', '1998-02-10 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fperro?alt=media&token=7d8d5be4-f876-4111-a4b4-494b50c86fbc', 'León', 'Gabriela', 'Golden', NULL, 'MASCULINO', '4759662'),
(41, 'Mura', 'Celeste', 'camila@gmail.com', 'AVE', '1998-07-14 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fpajaro?alt=media&token=22f6abac-cdb5-4c32-8184-f75dad29f871', 'Camilo', 'Camila', NULL, 'Plumas de todos colores', 'MASCULINO', '4857996'),
(42, 'Taus', 'Marrón', 'marcela@gmail.com', 'GATO', '2020-03-10 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fgato-marron_0?alt=media&token=138788f9-b98c-4dbb-86ef-4302147a4942', 'Marta', 'Marcela', NULL, 'Con manchas', 'FEMENINO', '156849723'),
(43, 'Mayoro', 'Negro', 'eugenia@gmail.com', 'PERRO', '1998-03-12 00:00:00.000000', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fdalma?alt=media&token=5a06cb08-3f89-4088-a6b9-afaf3dfff1e4', 'Dalma', 'Eugenia', NULL, 'Con manchas blancas', 'FEMENINO', '4857796');

-- --------------------------------------------------------

--
-- Table structure for table `Mascota`
--

CREATE TABLE `Mascota` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especie` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `raza` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `senias` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `duenio_id` bigint(20) NOT NULL,
  `ficha_publica_id` bigint(20) DEFAULT NULL,
  `veterinario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Mascota`
--

INSERT INTO `Mascota` (`id`, `color`, `especie`, `fecha_nacimiento`, `foto`, `nombre`, `raza`, `senias`, `sexo`, `duenio_id`, `ficha_publica_id`, `veterinario_id`) VALUES
(1, 'Blanco', 'PERRO', '2020-04-28', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fwalli4?alt=media&token=aeb3d35f-3933-43c3-b74c-38728e2cb691', 'Walli', 'Caniche', 'Con manchitas marrones', 'MASCULINO', 3, 1, 5),
(2, 'Marrón', 'TORTUGA', '2020-04-07', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Ftortuga-2_opt?alt=media&token=eda4d2e2-279f-49c1-a1a3-b168a2a0f62d', 'Florcita', '', 'Manchas oscuras', 'FEMENINO', 3, 2, 5),
(22, 'Marrón', 'GATO', '2020-04-05', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fraca2?alt=media&token=a397b552-01c3-447e-98fa-6e404c9404fd', 'Raquel', '', 'Manchas claritas', 'FEMENINO', 4, 22, 2),
(37, 'Rosa', 'PEZ', '2020-04-05', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fpez?alt=media&token=d3a0f1b0-f68c-4c0c-895d-50ef1b57647c', 'Jesse', '', 'Con líneas de colores', 'MASCULINO', 4, 37, 2),
(38, 'Naranja', 'HAMSTER', '2020-04-06', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fhamster?alt=media&token=4c6e7fd0-3a23-4d3c-9f14-66b92f0b8896', 'Flavio', '', 'Gordito', 'MASCULINO', 4, 38, NULL),
(39, 'Blanco', 'PERRO', '1998-11-10', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fperro2?alt=media&token=b8e06a39-acf4-463e-847a-d1a25ccb594d', 'Manchi', '', 'Con manchas negras', 'FEMENINO', 6, 39, NULL),
(40, 'Marroncito', 'PERRO', '1998-02-10', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fperro?alt=media&token=7d8d5be4-f876-4111-a4b4-494b50c86fbc', 'León', 'Golden', '', 'MASCULINO', 7, 40, 2),
(41, 'Celeste', 'AVE', '1998-07-14', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fpajaro?alt=media&token=22f6abac-cdb5-4c32-8184-f75dad29f871', 'Camilo', '', 'Plumas de todos colores', 'MASCULINO', 8, 41, NULL),
(42, 'Marrón', 'GATO', '2020-03-10', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fgato-marron_0?alt=media&token=138788f9-b98c-4dbb-86ef-4302147a4942', 'Marta', '', 'Con manchas', 'FEMENINO', 12, 42, NULL),
(43, 'Negro', 'PERRO', '1998-03-12', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/mascotas%2Fdalma?alt=media&token=5a06cb08-3f89-4088-a6b9-afaf3dfff1e4', 'Dalma', '', 'Con manchas blancas', 'FEMENINO', 2, 43, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Rol`
--

CREATE TABLE `Rol` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Rol`
--

INSERT INTO `Rol` (`id`, `nombre`) VALUES
(1, 'admin'),
(2, 'veterinario'),
(3, 'duenio');

-- --------------------------------------------------------

--
-- Table structure for table `TipoEvento`
--

CREATE TABLE `TipoEvento` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `TipoEvento`
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
-- Table structure for table `Usuario`
--

CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio_consultorio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `matricula` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_consultorio` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Usuario`
--

INSERT INTO `Usuario` (`id`, `activo`, `apellido`, `domicilio_consultorio`, `email`, `fecha_nacimiento`, `foto`, `matricula`, `nombre`, `nombre_consultorio`, `password`, `telefono`) VALUES
(1, b'1', 'Administrador', NULL, 'admin@admin.com', '1985-04-12', NULL, NULL, 'Administrador', NULL, '123456', '2221-411872'),
(2, b'1', 'Mayoro', '466 número 589', 'eugenia@gmail.com', '1974-07-14', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fusuario?alt=media&token=cd070d4d-e1d9-4385-8c67-b543d7e80620', '789568/8', 'Eugenia', 'Las Lilas', '123456', '4857796'),
(3, b'1', 'Onofri', NULL, 'melisa@gmail.com', '1998-06-09', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fmedico?alt=media&token=5628a8a0-b3a1-466f-ac34-712e37f90acf', NULL, 'Melisa', NULL, '123456', '4853775'),
(4, b'1', 'Repetto', NULL, 'lorenzo@gmail.com', '1994-06-09', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2FMauro-profile-picture?alt=media&token=851cbf6d-6ce2-4b67-88ee-68af75cc8b32', NULL, 'Lorenzo', NULL, '123456', '156423589'),
(5, b'1', 'Fabiani', 'Calle 11 y 522', 'ruben@gmail.com', '1974-03-10', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fmedico2?alt=media&token=aa22b2e5-9037-45d1-8c77-ee18d9d8351c', '16894/5', 'Rubén', 'Cuatro Patas', '123456', '156984723'),
(6, b'1', 'Repetto', NULL, 'antonio@gmail.com', '1990-07-09', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fmedico5?alt=media&token=7913b8a4-5615-451b-8a07-43e551b940a3', NULL, 'Antonio', NULL, '123456', '4987662'),
(7, b'1', 'Lemos', 'Calle 52 esq. 20', 'gabriela@gmail.com', '1993-11-10', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fmedico7?alt=media&token=dcdc8bc6-7704-4138-918b-3c04d0585478', '65482/8', 'Gabriela', 'Nuestros amigos', '123456', '4759662'),
(8, b'1', 'Mura', NULL, 'camila@gmail.com', '1994-07-04', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fusuario3?alt=media&token=dd14bc22-36d3-4347-90f2-ea07b3fd0138', NULL, 'Camila', NULL, '123456', '4857996'),
(9, b'1', 'Magaldi', 'Calle 12 e/ 17 y 19', 'marcos@gmail.com', '1997-07-15', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fmedico6?alt=media&token=0fe5c210-69aa-4554-a3a1-4c560d793d26', '594687/8', 'Marcos', 'Las Perlas', '123456', '15689472'),
(10, b'1', 'Romero', 'Camino Centenario 158', 'filomena@gmail.com', '2000-07-03', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fusuario2?alt=media&token=e162a90b-63f5-4c87-adde-bad395a08044', '123695/7', 'Filomena', 'Trudis Gonnet', '123456', '15694823'),
(11, b'1', 'Gómez', '12 e/ 18 y 19', 'facundo@gmail.com', '1974-02-09', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2Fhombre-sonriente-que-gusta-idea-espacio-copia_23-2148221727?alt=media&token=df73951c-c4c5-42ed-a15c-a5972445127c', '1368/7', 'Facundo', 'Las Perlitas', '123456', '4569821'),
(12, b'1', 'Taus', NULL, 'marcela@gmail.com', '1997-02-11', 'https://firebasestorage.googleapis.com/v0/b/clinicademascotas-711e6.appspot.com/o/usuarios%2FHolidays?alt=media&token=deeab0a0-a29a-440b-a500-89c98fb8d764', NULL, 'Marcela', NULL, '123456', '156849723');

-- --------------------------------------------------------

--
-- Table structure for table `Usuario_tiene_rol`
--

CREATE TABLE `Usuario_tiene_rol` (
  `id_usuario` bigint(20) NOT NULL,
  `id_rol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Usuario_tiene_rol`
--

INSERT INTO `Usuario_tiene_rol` (`id_usuario`, `id_rol`) VALUES
(1, 1),
(3, 3),
(4, 3),
(5, 2),
(6, 3),
(8, 3),
(9, 2),
(10, 2),
(11, 2),
(2, 2),
(2, 3),
(7, 3),
(7, 2),
(12, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Evento`
--
ALTER TABLE `Evento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdlk4lgvep8skt9ibn9y3lhp2g` (`mascota_id`),
  ADD KEY `FKg7g6ksm3du6m6w03nwxk7ums7` (`tipo_id`),
  ADD KEY `FKol99rb2gjs5ox4isgvpiq2nrh` (`usuario_creador_id`);

--
-- Indexes for table `FichaPublica`
--
ALTER TABLE `FichaPublica`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Mascota`
--
ALTER TABLE `Mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKto0dxb07hihy1g4rn45xf4171` (`duenio_id`),
  ADD KEY `FKs0jn40b5vww9e8fgn6o8w5pde` (`ficha_publica_id`),
  ADD KEY `FKncnd66ed63q0grh89g2eulddl` (`veterinario_id`);

--
-- Indexes for table `Rol`
--
ALTER TABLE `Rol`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `TipoEvento`
--
ALTER TABLE `TipoEvento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Usuario_tiene_rol`
--
ALTER TABLE `Usuario_tiene_rol`
  ADD KEY `FKrtnos2um01ol21nsxbxqg2sap` (`id_rol`),
  ADD KEY `FKeoa06yp0smskd4h2oclb1koep` (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Evento`
--
ALTER TABLE `Evento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `FichaPublica`
--
ALTER TABLE `FichaPublica`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `Mascota`
--
ALTER TABLE `Mascota`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `Rol`
--
ALTER TABLE `Rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `TipoEvento`
--
ALTER TABLE `TipoEvento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Evento`
--
ALTER TABLE `Evento`
  ADD CONSTRAINT `FKdlk4lgvep8skt9ibn9y3lhp2g` FOREIGN KEY (`mascota_id`) REFERENCES `Mascota` (`id`),
  ADD CONSTRAINT `FKg7g6ksm3du6m6w03nwxk7ums7` FOREIGN KEY (`tipo_id`) REFERENCES `TipoEvento` (`id`),
  ADD CONSTRAINT `FKol99rb2gjs5ox4isgvpiq2nrh` FOREIGN KEY (`usuario_creador_id`) REFERENCES `Usuario` (`id`);

--
-- Constraints for table `Mascota`
--
ALTER TABLE `Mascota`
  ADD CONSTRAINT `FKncnd66ed63q0grh89g2eulddl` FOREIGN KEY (`veterinario_id`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FKs0jn40b5vww9e8fgn6o8w5pde` FOREIGN KEY (`ficha_publica_id`) REFERENCES `FichaPublica` (`id`),
  ADD CONSTRAINT `FKto0dxb07hihy1g4rn45xf4171` FOREIGN KEY (`duenio_id`) REFERENCES `Usuario` (`id`);

--
-- Constraints for table `Usuario_tiene_rol`
--
ALTER TABLE `Usuario_tiene_rol`
  ADD CONSTRAINT `FKeoa06yp0smskd4h2oclb1koep` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FKrtnos2um01ol21nsxbxqg2sap` FOREIGN KEY (`id_rol`) REFERENCES `Rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
