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
-- Volcado de datos para la tabla `Rol`
--

INSERT INTO `Rol` (`id`, `nombre`) VALUES
(1, 'admin'),
(2, 'veterinario'),
(3, 'duenio');


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


--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`id`, `activo`, `apellido`, `domicilio_consultorio`, `email`, `fecha_nacimiento`, `foto`, `matricula`, `nombre`, `nombre_consultorio`, `password`, `telefono`) VALUES
(1, b'1', 'Administrador', NULL, 'admin@admin.com', '1985-04-12', NULL, NULL, 'Administrador', NULL, '123456', '2221-411872');


--
-- Volcado de datos para la tabla `Usuario_tiene_rol`
--

INSERT INTO `Usuario_tiene_rol` (`id_usuario`, `id_rol`) VALUES
(1, 1);



COMMIT;
--
-- Índices para tablas volcadas
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
