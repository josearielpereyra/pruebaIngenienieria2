-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 19, 2015 at 04:51 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `agenda`
--
CREATE DATABASE IF NOT EXISTS `agenda` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `agenda`;

-- --------------------------------------------------------

--
-- Table structure for table `contactos`
--

CREATE TABLE IF NOT EXISTS `contactos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `contactos`
--

INSERT INTO `contactos` (`id`, `nombre`, `apellidos`, `email`, `telefono`, `direccion`) VALUES
(1, 'Alexandra', 'Suarez De Jesus', 'theladyalexas.01hotmail.com', '829-265-0997', 'C/ Rene Marte # 158, Nagua'),
(2, 'Juan', 'Perez', 'juanperez18@hotmail.com', '809-888-9087', 'C/primera #25, Nagua'),
(3, 'Jose', 'De La Cruz', 'josedelacruz@micorreo.com', '809-666-7777', 'Calle Principal, San Fco. de Mac.'),
(17, 'Luis', 'Acosta', 'luisacosta@micorreo.com', '809-999-0987', 'lkasjdf;lkfsdja'),
(18, 'Ana', 'Montana', 'milysarrus@micorreo.com', '987-765-4321', 'Nagua'),
(19, 'Juan ', 'De Los Santos', 'yo@juancitosport.com', '111-222-3333', 'Santo Domingo Este'),
(20, 'Fermin', 'Guzman', 'ferminguz@gmail.com', '8295335090', 'Los Limones');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
