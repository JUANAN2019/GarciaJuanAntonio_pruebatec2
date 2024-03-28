-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2024 a las 19:52:23
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `ID` bigint(20) NOT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDOS`, `DNI`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Garcia Galindo', '50866370F', 'juanan0@gmail.', 'Juan Antonio', '644907289'),
(2, 'Garcia Galindo', '45645454-F', 'marta@gmail.com', 'Marta', '555555555'),
(3, 'Gomez', '45645454-F', 'juanan0@ampa.es', 'Tomas', '532532532'),
(4, 'garcia', '543354334-E', 'juanan4@ampa.es', 'felipa', '644905432'),
(5, 'Garcia', '45645454-F', 'ana@gmail.com', 'Federico', '532532532'),
(6, 'Garcia', '65656565-F', 'ana@gmail.com', 'Ana', '555555555'),
(7, 'Gomez', '65656565-F', 'juanan0@ampa.es', 'Tomas', '532532532'),
(8, 'Gomez', '65656565-F', 'juanan0@ampa.es', 'Tomas', '555555555');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `ID` bigint(20) NOT NULL,
  `ESTADOTRAMITE` tinyint(1) DEFAULT 0,
  `FECHA` date DEFAULT NULL,
  `TRAMITE` varchar(255) DEFAULT NULL,
  `ciudadano_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`ID`, `ESTADOTRAMITE`, `FECHA`, `TRAMITE`, `ciudadano_id`) VALUES
(6, 1, '2024-03-30', 'alta_sepe', 1),
(7, 1, '2024-03-30', 'alta_sepe', 2),
(10, 1, '2024-03-30', 'alta_sepe', 5),
(12, 0, '2024-03-30', 'inscripcion_cursos', 5),
(13, 1, '2024-03-30', 'alta_sepe', 4),
(14, 0, '2024-03-30', 'alta_sepe', 4),
(15, 1, '2024-03-30', 'alta_sepe', 2),
(16, 0, '2024-03-30', 'sellar_paro', 6),
(17, 1, '2024-03-30', 'sellar_paro', 7),
(18, 1, '2024-03-30', 'alta_sepe', 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
