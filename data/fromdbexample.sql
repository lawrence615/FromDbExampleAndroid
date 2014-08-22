-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 22, 2014 at 04:42 PM
-- Server version: 5.5.38-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fromdbexample`
--

-- --------------------------------------------------------

--
-- Table structure for table `responses`
--

CREATE TABLE IF NOT EXISTS `responses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `phone` int(10) NOT NULL,
  `response` text NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `responses`
--

INSERT INTO `responses` (`id`, `name`, `phone`, `response`, `created`) VALUES
(1, 'Joseph Kaberia', 722584569, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '2014-08-22 09:44:39'),
(2, 'Mary Muthoni', 723251478, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '2014-08-22 09:44:32'),
(3, 'Stacey Nashoka', 712789645, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '2014-08-22 09:45:28'),
(4, 'John Doe', 728964712, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '2014-08-22 09:46:30'),
(5, 'Nana Wambui', 789251478, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '2014-08-22 09:47:25');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
