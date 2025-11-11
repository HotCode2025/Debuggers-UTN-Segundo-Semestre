-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 11-11-2025 a las 00:38:52
-- Versión del servidor: 5.7.25
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemaventas_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `telefono`, `correo`, `direccion`) VALUES
(1, 'Distribuidora San Rafael', '', '', 'Av. San Martin 120 - Barrio Centro'),
(2, 'Supermercado Córdoba', '', '', 'Av. Colon 500 - Barrio Cerro'),
(3, 'Pepe y hijos S.A.', '', '', 'Ruta 40 km 500'),
(4, 'Distribuidora Cuyanos', '', '', 'Av. Gral Paz 1584 - Barrio Terminal'),
(5, 'Supermercado El Nono', '', '', 'Rio Negro 17 - Real del Padre'),
(6, 'Autoservicio Atuel Norte', '', '', 'Ruta 143 S/N - Atuel Norte'),
(7, 'Autoservicio Real', '', '', 'Rio Negro 594 - Real del Padre'),
(8, 'Venta Mostrador', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `puesto` varchar(50) NOT NULL,
  `sueldo` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `nombre`, `apellido`, `dni`, `direccion`, `telefono`, `correo`, `puesto`, `sueldo`) VALUES
(1, 'Kevin', '', '11111111', 'Calle 1 Nro 123', '1234567890', 'correo1@hotmail.com', '', 0.00),
(2, 'Enzo', '', '11111112', 'Calle 2 Nro 123', '1234567890', 'correo2@hotmail.com', '', 0.00),
(3, 'Alberto', '', '11111113', 'Calle 3 Nro 333', '351-123456', 'correo3@gmail.com', 'Cajero', 50000.00),
(4, 'Noelia', '', '11111114', 'Calle 4 Nro 123', '1234567890', 'correo4@hotmail.com', '', 0.00),
(5, 'Federico', '', '11111115', 'Calle 5 Nro 123', '1234567890', 'correo5@hotmail.com', '', 0.00),
(6, 'Celeste', '', '11111116', 'Calle 6 Nro 123', '1234567890', 'correo6@hotmail.com', '', 0.00),
(7, 'Bruno', '', '11111117', 'Calle 7 Nro 123', '1234567890', 'correo7@hotmail.com', '', 0.00),
(8, 'Jairo', '', '11111118', 'Calle 8 Nro 123', '1234567890', 'correo8@hotmail.com', '', 0.00),
(9, 'Alan', '', '11111119', 'Calle 9 Nro 123', '1234567890', 'correo9@hotmail.com', '', 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioVenta` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precioVenta` decimal(8,2) NOT NULL,
  `idProveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precioVenta`, `idProveedor`) VALUES
(1, 'Botella Coca Cola x1,5 L', 2500.00, 1),
(2, 'Lata Coca Cola x473 cm3', 1500.00, 1),
(3, 'Botella Sprite x1,5 L', 2000.00, 1),
(4, 'Lata Cerveza x473 cm3', 1000.00, 3),
(5, 'Botella Coca-Cola x2,25 L', 4500.00, 1),
(6, 'Bot. Cerveza Quilmes x1 lt', 2700.00, 3),
(7, 'Caramelo Misky x400 unid.', 1800.00, 7),
(8, 'Galletas Bagley x 400gr', 450.00, 3),
(9, 'Papel Higienico x4 unid', 789.00, 6),
(10, 'Rollo de cocina x3 unid', 749.00, 6),
(11, 'Salame metro Lario x kg', 1100.00, 2),
(12, 'Empanadas', 1500.00, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `Representante` varchar(50) NOT NULL,
  `tipoproductos` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `nombre`, `telefono`, `correo`, `direccion`, `Representante`, `tipoproductos`) VALUES
(1, 'Coca Cola', NULL, NULL, 'Ruta 19 km 220 - Córdoba', '', ''),
(2, 'Fiambres Lario', NULL, NULL, 'Av. San Martin 900 - Barrio San Fernando', '', ''),
(3, 'Distr. Panella', NULL, NULL, 'Av. Estanislao Salas 123 - Centro', '', ''),
(4, 'Cereales El Diamante', NULL, NULL, 'Ruta 146 s/n - Cuadro Nacional', '', ''),
(5, 'Hipermercados Diarco', NULL, NULL, 'Estanislao Salas y Av. Mitre - Centro', '', ''),
(6, 'Distribuidora San Isidro', NULL, NULL, 'Av. Alberdi 3500 - Bº Alberdi', '', ''),
(7, 'Distribuidora Golosur', NULL, NULL, 'Gral Pueyrredon 657 - Centro', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id`, `idProducto`, `idProveedor`, `cantidad`) VALUES
(1, 1, 1, 50),
(2, 5, 1, 50),
(3, 1, 1, 50),
(4, 3, 1, 50),
(5, 7, 7, 50),
(6, 12, 6, 50),
(7, 2, 5, 50),
(8, 4, 6, 50),
(9, 6, 2, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_empleado` int(11) NOT NULL,
  `fecha_venta` datetime NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `id_cliente`, `id_empleado`, `fecha_venta`, `total`) VALUES
(1, 5, 1, '2025-11-07 16:53:16', 16500.00),
(3, NULL, 1, '2025-11-07 19:10:42', 6500.00),
(4, 3, 1, '2025-11-07 19:12:02', 4000.00),
(5, 1, 1, '2025-11-07 19:45:32', 27000.00),
(6, 5, 1, '2025-11-07 20:20:33', 13500.00),
(7, 1, 1, '2025-11-07 20:32:57', 6500.00),
(8, 4, 1, '2025-11-07 20:36:03', 6500.00),
(9, 1, 1, '2025-11-07 21:35:56', 32500.00),
(10, 1, 1, '2025-11-07 21:40:54', 94000.00),
(11, 1, 1, '2025-11-07 21:53:04', 2000.00),
(12, NULL, 1, '2025-11-10 21:30:28', 7500.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas_detalle`
--

CREATE TABLE `ventas_detalle` (
  `id` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas_detalle`
--

INSERT INTO `ventas_detalle` (`id`, `id_venta`, `id_producto`, `cantidad`, `precio_unitario`, `subtotal`) VALUES
(1, 1, 1, 5, 2500.00, 12500.00),
(2, 1, 3, 2, 2000.00, 4000.00),
(3, 3, 1, 1, 2500.00, 2500.00),
(4, 3, 3, 2, 2000.00, 4000.00),
(5, 4, 3, 2, 2000.00, 4000.00),
(6, 5, 1, 4, 2500.00, 10000.00),
(7, 5, 3, 4, 2000.00, 8000.00),
(8, 5, 5, 2, 4500.00, 9000.00),
(9, 6, 5, 3, 4500.00, 13500.00),
(10, 7, 3, 1, 2000.00, 2000.00),
(11, 7, 5, 1, 4500.00, 4500.00),
(12, 8, 3, 1, 2000.00, 2000.00),
(13, 8, 5, 1, 4500.00, 4500.00),
(14, 9, 1, 1, 2500.00, 2500.00),
(15, 9, 3, 15, 2000.00, 30000.00),
(16, 10, 3, 20, 2000.00, 40000.00),
(17, 10, 5, 12, 4500.00, 54000.00),
(18, 11, 3, 1, 2000.00, 2000.00),
(19, 12, 1, 3, 2500.00, 7500.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `ventas_detalle`
--
ALTER TABLE `ventas_detalle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_producto` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `ventas_detalle`
--
ALTER TABLE `ventas_detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas_detalle`
--
ALTER TABLE `ventas_detalle`
  ADD CONSTRAINT `ventas_detalle_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas_detalle_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
