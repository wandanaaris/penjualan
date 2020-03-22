-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2020 at 10:07 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(10) NOT NULL,
  `nm_barang` varchar(50) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `satuan` varchar(10) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_barang`, `nm_barang`, `harga`, `satuan`, `stok`) VALUES
('CR001', 'CHARGER TYPE C', 150000, 'UNIT', 30),
('HP001', 'ASUS ROG PHONE II', 9000000, 'UNIT', 10),
('HP002', 'IPHONE 8', 5000000, 'UNIT', 6),
('HP003', 'IPHONE X', 15000000, 'UNIT', 3),
('HP004', 'IPHONE 11', 20000000, 'UNIT', 10),
('HP005', 'SAMSUNG GALAXY 10', 15000000, 'UNIT', 5),
('PB001', 'ROBOT CH10 10000MAH', 250000, 'UNIT', 15),
('PB002', 'ROBOT CH20 20000MAH', 400000, 'UNIT', 15),
('PB003', 'XIAOMI PB 10000MAH', 200000, 'UNIT', 20),
('PB004', 'XIAOMI PB 30000MAH', 400000, 'UNIT', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pel` int(11) NOT NULL,
  `nm_pel` varchar(50) DEFAULT NULL,
  `alamat` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pel`, `nm_pel`, `alamat`) VALUES
(1, 'ARIS WANDANA', 'Pelalawan'),
(2, 'DICKY', 'Bandar Seikijang'),
(3, 'TOMMY', 'SIAK'),
(4, 'JOHAN', 'SIAK'),
(5, 'ANDRE', 'PEKANBARU'),
(6, 'TONO', 'PEKANBARU'),
(7, 'MARLIN', 'MINAS'),
(8, 'WAWAN', 'PERAWANG'),
(9, 'DODO', 'PERAWANG'),
(10, 'RAHAYU', 'PERAWANG'),
(11, 'Pandu', 'Pelalawan'),
(12, 'SAS', 'FDFDG'),
(20, 'RIS', 'SWAS'),
(30, 'SADF', 'ADSFF'),
(31, 'JONY SIMARTUPANG', 'Pekanbaru'),
(234, 'ARIS', 'WADAF');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `no_trans` varchar(10) NOT NULL,
  `tgl_trans` date DEFAULT NULL,
  `id_pel` int(11) DEFAULT NULL,
  `kd_barang` varchar(10) DEFAULT NULL,
  `jlh_transaksi` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`no_trans`, `tgl_trans`, `id_pel`, `kd_barang`, `jlh_transaksi`) VALUES
('2020001', '2020-01-05', 1, 'CR001', 1),
('2020002', '2020-01-07', 5, 'HP001', 2),
('2020003', '2020-01-10', 10, 'HP003', 3),
('2020004', '2020-01-20', 9, 'HP002', 1),
('2020005', '2020-01-21', 8, 'HP001', 1),
('2020006', '2020-01-29', 2, 'PB001', 1),
('2020007', '2020-02-01', 6, 'PB002', 1),
('2020008', '2020-02-05', 8, 'PB003', 1),
('2020009', '2020-02-08', 5, 'PB004', 1),
('2020010', '2020-02-12', 6, 'PB001', 1),
('2020011', '2020-03-08', 30, 'CR001', 1),
('2020012', '2020-03-22', 31, 'cr001', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pel`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_trans`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=235;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
