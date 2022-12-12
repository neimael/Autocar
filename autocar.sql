-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2022 at 06:22 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticketautocar`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `Cin` varchar(20) NOT NULL,
  `Tele` int(20) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `name`, `Cin`, `Tele`, `Email`, `password`) VALUES
(2, 'Naima ELJID', 'JH69269', 625678909, 'naima.eljid03@gmail.com', 'naima'),
(3, 'Charifa MOUHDI', 'JH12345', 6456789, 'charifa@gmail.com', 'charifa');

-- --------------------------------------------------------

--
-- Table structure for table `paiement`
--

CREATE TABLE `paiement` (
  `id_paiement` int(11) NOT NULL,
  `numCard` int(16) NOT NULL,
  `codepin` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paiement`
--

INSERT INTO `paiement` (`id_paiement`, `numCard`, `codepin`) VALUES
(1, 123456789, 1234);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `villedepart` varchar(30) NOT NULL,
  `villedarriver` varchar(30) NOT NULL,
  `depart_time` date NOT NULL,
  `arriving_time` date DEFAULT NULL,
  `price` int(11) NOT NULL,
  `number_places` int(11) NOT NULL CHECK (`number_places` >= 0),
  `date_travel` date NOT NULL,
  `id_travel` int(11) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE `travel` (
  `id_travel` int(11) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `villedepart` varchar(30) NOT NULL,
  `villedarriver` varchar(30) NOT NULL,
  `depart_time` time NOT NULL,
  `arriving_time` time DEFAULT NULL,
  `price` float(11,0) NOT NULL,
  `number_places` int(11) NOT NULL CHECK (`number_places` >= 0),
  `date_travel` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `travel`
--

INSERT INTO `travel` (`id_travel`, `company_name`, `villedepart`, `villedarriver`, `depart_time`, `arriving_time`, `price`, `number_places`, `date_travel`) VALUES
(2, 'CTM', 'Agadir', 'Casablanca', '08:40:00', '21:00:00', 100, 30, '2023-02-27'),
(3, 'CTM', 'Agadir', 'Casablanca', '09:40:00', '23:00:00', 100, 30, '2023-04-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `Cin` (`Cin`);

--
-- Indexes for table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id_paiement`),
  ADD UNIQUE KEY `numCard` (`numCard`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `id_travel` (`id_travel`);

--
-- Indexes for table `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`id_travel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id_paiement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `travel`
--
ALTER TABLE `travel`
  MODIFY `id_travel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_travel`) REFERENCES `travel` (`id_travel`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
