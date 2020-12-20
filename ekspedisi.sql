-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2018 at 09:06 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ekspedisi`
--

-- --------------------------------------------------------

--
-- Table structure for table `ms_administrator`
--

CREATE TABLE IF NOT EXISTS `ms_administrator` (
  `id` int(11) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(32) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_administrator`
--

INSERT INTO `ms_administrator` (`id`, `username`, `password`, `jenis`, `email`, `flag_active`) VALUES
(1, 'admin', '803e652392bb4e4d898adf4b3ccae56d', 'admin', 'hafiizhekom@yahoo.com', 1),
(2, 'nyanyang', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'nyanyang@yahoo.com', 1),
(3, 'dio', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'dio@yahoo.com', 0),
(4, 'vincent', '803e652392bb4e4d898adf4b3ccae56d', 'admin', 'vincent@yahoo.com', 0),
(8, 'annisa', '803e652392bb4e4d898adf4b3ccae56d', 'admin', 'annisa@yahoo.com', 1),
(9, 'ronny', '803e652392bb4e4d898adf4b3ccae56d', 'admin', 'ronny@yahoo.com', 1),
(10, 'reza', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'reza@yahoo.com', 1),
(11, 'raka', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'raka@yahoo.com', 1),
(12, 'yudhi', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'yudhi@yahoo.com', 1),
(13, 'budi', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'budi@yahoo.com', 1),
(14, 'andi', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'andi@yahoo.com', 1),
(15, 'danang', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'danang@yahoo.com', 1),
(16, 'dudung', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'dudung@yahoo.com', 1),
(17, 'maman', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'maman@yahoo.com', 1),
(18, 'mamat', '803e652392bb4e4d898adf4b3ccae56d', 'staff', 'mamat@yahoo.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_kecamatan`
--

CREATE TABLE IF NOT EXISTS `ms_kecamatan` (
  `id` int(11) NOT NULL,
  `id_kota` int(11) NOT NULL,
  `kecamatan` varchar(50) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_kecamatan`
--

INSERT INTO `ms_kecamatan` (`id`, `id_kota`, `kecamatan`, `flag_active`) VALUES
(1, 1, 'Kemayoran', 1),
(6, 1, 'Johar', 1),
(7, 11, 'Tanon', 1),
(8, 1, 'Sawah Besar', 1),
(9, 1, 'Gambir', 1),
(10, 1, 'Tanah Abang', 1),
(11, 1, 'Menteng', 1),
(12, 1, 'Senen', 1),
(13, 1, 'Cempaka Putih', 1),
(14, 1, 'Johar Baru', 1),
(15, 8, 'Koja', 1),
(16, 8, 'Tanjung Priok', 1),
(17, 8, 'Kelapa Gading', 1),
(18, 8, 'Cilincing', 1),
(19, 8, 'Pademangan', 1),
(20, 8, 'Penjaringan', 1),
(21, 3, 'Kramat Jati', 1),
(22, 3, 'Duren Sawit', 1),
(23, 3, 'Jatinegara', 1),
(24, 3, 'Pulo Gadung', 1),
(25, 11, 'Tangen', 1),
(26, 11, 'Sumberlawang', 1),
(27, 11, 'Sukodono', 1),
(28, 11, 'Sidoharjo', 1),
(29, 11, 'Sambungmacan', 1),
(30, 11, 'Sragen', 1),
(31, 11, 'Sambirejo', 1),
(32, 11, 'Plupuh', 1),
(33, 11, 'Ngrampal', 1),
(34, 11, 'Mondokan', 1),
(35, 11, 'Miri', 1),
(36, 11, 'Masaran', 1),
(37, 11, 'Kedawung', 1),
(38, 11, 'Karangmalang', 1),
(39, 11, 'Kalijambe', 1),
(40, 11, 'Jenar', 1),
(41, 11, 'Gondang', 1),
(42, 11, 'Gesi', 1),
(43, 11, 'Gemolong', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_kota`
--

CREATE TABLE IF NOT EXISTS `ms_kota` (
  `id` int(11) NOT NULL,
  `id_provinsi` int(11) NOT NULL,
  `kota` varchar(50) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_kota`
--

INSERT INTO `ms_kota` (`id`, `id_provinsi`, `kota`, `flag_active`) VALUES
(1, 12, 'Jakarta Pusat', 1),
(2, 14, 'Solo', 1),
(3, 12, 'Jakarta Timur', 1),
(4, 12, 'Jakarta  Barat', 1),
(7, 12, 'Jakarta  Selatan', 1),
(8, 12, 'Jakarta  Utara', 1),
(9, 14, 'Semarang', 1),
(10, 13, 'Bandung', 1),
(11, 14, 'Sragen', 1),
(18, 1, 'Aceh Barat', 1),
(19, 1, 'Aceh Barat Daya', 1),
(20, 1, 'Aceh Besar', 1),
(21, 1, 'Aceh Jaya', 1),
(22, 1, 'Aceh Selatan', 1),
(24, 2, 'Batubara', 1),
(25, 2, 'Dairi', 1),
(26, 2, 'Karo', 1),
(27, 14, 'Banjarnegara', 1),
(28, 14, 'Batang', 1),
(29, 14, 'Banyumas', 1),
(30, 14, 'Boyolali', 1),
(31, 14, 'Brebes', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_kurir`
--

CREATE TABLE IF NOT EXISTS `ms_kurir` (
  `id` int(11) NOT NULL,
  `nama_kurir` varchar(50) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_kurir`
--

INSERT INTO `ms_kurir` (`id`, `nama_kurir`, `flag_active`) VALUES
(1, 'Nyanyang', 1),
(2, 'Habib', 0),
(3, 'Nanda', 0),
(4, 'Yudhi', 1),
(5, 'Musa', 1),
(6, 'Lawe', 1),
(7, 'Geovanta', 1),
(8, 'Gabriel', 1),
(9, 'Ronaldo', 1),
(10, 'Febrianto', 1),
(11, 'Rival', 1),
(12, 'Rovendo', 1),
(13, 'Kenny', 1),
(14, 'Doel', 1),
(15, 'Nano', 1),
(16, 'Taka', 1),
(17, 'Hideto', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_layanan`
--

CREATE TABLE IF NOT EXISTS `ms_layanan` (
  `id` int(11) NOT NULL,
  `nama_layanan` varchar(50) NOT NULL,
  `kode_layanan` varchar(10) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_layanan`
--

INSERT INTO `ms_layanan` (`id`, `nama_layanan`, `kode_layanan`, `flag_active`) VALUES
(1, 'Reguler', 'REG', 1),
(2, 'Exclusive', 'EXC', 0),
(3, 'VeryLate', 'VLT', 1),
(4, 'Biasa', 'BSA', 1),
(5, 'Luar Biasa', 'LBA', 1),
(6, 'Mantap', 'MTP', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_provinsi`
--

CREATE TABLE IF NOT EXISTS `ms_provinsi` (
  `id` int(10) NOT NULL,
  `provinsi` varchar(50) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_provinsi`
--

INSERT INTO `ms_provinsi` (`id`, `provinsi`, `flag_active`) VALUES
(1, 'Nanggroe Aceh Darussalam', 1),
(2, 'Sumatera Utara', 1),
(3, 'Sumatera Barat', 1),
(4, 'Riau', 1),
(5, 'Kepulauan Riau', 1),
(6, 'Kepulauan Bangka-Belitung', 1),
(7, 'Jambi', 1),
(8, 'Bengkulu', 1),
(9, 'Sumatera Selatan', 1),
(10, 'Lampung', 1),
(11, 'Banten', 1),
(12, 'DKI Jakarta', 1),
(13, 'Jawa Barat', 1),
(14, 'Jawa Tengah', 1),
(15, 'Daerah Istimewa Yogyakarta  ', 1),
(16, 'Jawa Timur', 1),
(17, 'Bali', 1),
(18, 'Nusa Tenggara Barat', 1),
(19, 'Nusa Tenggara Timur', 1),
(20, 'Kalimantan Barat', 1),
(21, 'Kalimantan Tengah', 1),
(22, 'Kalimantan Selatan', 1),
(23, 'Kalimantan Timur', 1),
(24, 'Gorontalo', 1),
(25, 'Sulawesi Selatan', 1),
(26, 'Sulawesi Tenggara', 1),
(27, 'Sulawesi Tengah', 1),
(28, 'Sulawesi Utara', 1),
(29, 'Sulawesi Barat', 1),
(30, 'Maluku', 1),
(31, 'Maluku Utara', 0),
(32, 'Papua Barat', 1),
(33, 'Papua', 1),
(34, 'Kalimantan Utara', 1),
(35, 'test', 0),
(36, 'testlagi', 0),
(37, 'ES', 0),
(38, 'ER', 0),
(39, 'sad', 0),
(40, 'saddsdf', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ms_tarif`
--

CREATE TABLE IF NOT EXISTS `ms_tarif` (
  `id` int(11) NOT NULL,
  `id_kecamatan_asal` int(11) NOT NULL,
  `id_kecamatan_tujuan` int(11) NOT NULL,
  `id_layanan` int(11) NOT NULL,
  `durasi_pengiriman` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_tarif`
--

INSERT INTO `ms_tarif` (`id`, `id_kecamatan_asal`, `id_kecamatan_tujuan`, `id_layanan`, `durasi_pengiriman`, `harga`, `flag_active`) VALUES
(1, 2, 7, 1, 2, 12000, 0),
(2, 4, 7, 1, 2, 11000, 0),
(3, 3, 7, 1, 2, 13000, 0),
(4, 3, 6, 3, 2, 7000, 0),
(5, 4, 1, 1, 1, 5000, 0),
(6, 21, 13, 1, 1, 12000, 1),
(7, 22, 13, 1, 1, 11000, 1),
(8, 24, 11, 1, 1, 13000, 1),
(9, 1, 8, 1, 1, 9000, 1),
(10, 7, 7, 1, 3, 21000, 0),
(11, 1, 7, 1, 3, 21000, 1),
(12, 1, 7, 3, 7, 13000, 1),
(13, 13, 10, 4, 3, 20000, 1),
(14, 21, 21, 2, 3, 25000, 1),
(15, 10, 8, 3, 3, 20000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ms_usaha`
--

CREATE TABLE IF NOT EXISTS `ms_usaha` (
  `id` int(11) NOT NULL,
  `nama_usaha` varchar(50) NOT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `kode_pos` varchar(5) DEFAULT NULL,
  `flag_active` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_usaha`
--

INSERT INTO `ms_usaha` (`id`, `nama_usaha`, `alamat`, `kode_pos`, `flag_active`) VALUES
(9, 'PT. TARUNA BANGSA', 'Jl. Test', '10640', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tr_detail_pengiriman`
--

CREATE TABLE IF NOT EXISTS `tr_detail_pengiriman` (
  `id` int(11) NOT NULL,
  `id_pengiriman` int(11) NOT NULL,
  `keterangan_barang` varchar(100) NOT NULL,
  `berat_barang` int(11) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tr_detail_pengiriman`
--

INSERT INTO `tr_detail_pengiriman` (`id`, `id_pengiriman`, `keterangan_barang`, `berat_barang`, `flag_active`) VALUES
(1, 9, 'Keset', 1, 1),
(2, 9, 'Kemeja', 3, 1),
(3, 10, 'Apple', 2, 1),
(4, 10, 'Vas', 32, 0),
(5, 10, 'Banana', 2, 0),
(6, 11, 'TV', 2, 1),
(7, 11, 'Baju', 1, 1),
(8, 12, 'Keyboard', 2, 1),
(9, 12, 'Mouse', 1, 1),
(10, 12, 'Monitor', 2, 1),
(11, 13, 'Pakaian', 1, 1),
(12, 13, 'Tas', 1, 1),
(46, 45, 'Lampu', 1, 1),
(47, 45, 'Flashdisk', 1, 1),
(48, 46, 'Gelas', 1, 1),
(49, 46, 'Keyboard', 2, 1),
(50, 47, 'Sepatu', 1, 1),
(51, 47, 'Buku', 1, 1),
(52, 45, 'Lampu', 1, 1),
(53, 45, 'Flashdisk', 1, 1),
(54, 46, 'Gelas', 1, 1),
(55, 46, 'Keyboard', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tr_head_pengiriman`
--

CREATE TABLE IF NOT EXISTS `tr_head_pengiriman` (
  `id` int(11) NOT NULL,
  `nama_pengirim` varchar(50) NOT NULL,
  `nama_penerima` varchar(50) NOT NULL,
  `id_kecamatan_pengirim` int(11) NOT NULL,
  `id_kecamatan_penerima` int(11) NOT NULL,
  `alamat_penerima` text NOT NULL,
  `tanggal` datetime NOT NULL,
  `tanggal_kirim` date NOT NULL,
  `tanggal_tiba` date NOT NULL,
  `total_berat` int(11) NOT NULL,
  `kode_layanan` varchar(10) NOT NULL,
  `id_kurir` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `hari` int(11) NOT NULL,
  `verifikasi` tinyint(1) NOT NULL DEFAULT '0',
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tr_head_pengiriman`
--

INSERT INTO `tr_head_pengiriman` (`id`, `nama_pengirim`, `nama_penerima`, `id_kecamatan_pengirim`, `id_kecamatan_penerima`, `alamat_penerima`, `tanggal`, `tanggal_kirim`, `tanggal_tiba`, `total_berat`, `kode_layanan`, `id_kurir`, `harga`, `hari`, `verifikasi`, `flag_active`) VALUES
(3, 'Guntur', 'Tirta', 2, 7, 'Jl. Neraka', '2016-12-10 15:32:42', '2017-01-19', '2012-01-01', 7, 'REG', 1, 84000, 2, 0, 0),
(4, 'Anjas', 'Nico', 2, 7, 'Jl. Neraka', '2016-12-11 00:22:54', '2017-02-16', '2012-01-01', 8, 'REG', 1, 96000, 2, 1, 0),
(5, 'Hasbi', 'Amir', 2, 7, 'Jl. Neraka', '2016-12-11 00:25:01', '2016-12-21', '2012-01-01', 10, 'REG', 1, 120000, 2, 0, 0),
(6, 'Supratna', 'Asep', 2, 7, 'Jl. Dago', '2016-12-11 00:26:40', '2016-12-15', '2012-01-01', 2, 'REG', 1, 24000, 2, 0, 0),
(7, 'Dede', 'Dudu', 2, 7, 'Jl. Neraka', '2016-12-11 00:28:01', '2016-12-23', '2012-01-01', 0, 'REG', 1, 0, 2, 0, 0),
(8, 'sadasd', 'asdasd', 2, 7, 'Jl. Neraka', '2016-12-11 00:30:07', '2016-12-15', '2016-12-21', 14, 'REG', 1, 168000, 2, 1, 0),
(9, 'sadasdas', 'sadasdsa', 2, 7, 'dasdsad', '2016-12-11 00:31:04', '2016-12-15', '2012-01-01', 4, 'REG', 1, 48000, 2, 0, 0),
(10, 'Test', 'Tust', 2, 7, 'sasda', '2016-12-11 00:34:51', '2016-12-15', '2016-12-21', 36, 'REG', 1, 432000, 2, 1, 0),
(11, 'Rozaq', 'Wahyudi', 1, 7, 'Jl. Mayor Suharto No. 6', '2016-12-22 18:07:30', '2017-01-11', '2012-01-01', 3, 'REG', 1, 63000, 3, 0, 1),
(12, 'Andi', 'Yanuar', 24, 11, 'Jl. Menteng, Kb. Sirih, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10340, Indonesia', '2016-12-22 18:09:07', '2016-12-22', '2016-12-22', 5, 'REG', 3, 65000, 1, 1, 1),
(13, 'Asep', 'Padmo', 1, 7, 'Jl. Sukodono, Tanon', '2016-12-22 18:16:28', '2017-02-08', '2012-01-01', 2, 'VLT', 1, 26000, 7, 0, 1),
(45, 'Sandi', 'Habib', 1, 29, 'Jl. Bekasi Jaya', '2016-12-25 00:30:07', '2016-12-25', '2016-12-28', 2, 'REG', 2, 9000, 3, 1, 0),
(46, 'Dio', 'Vincent', 1, 29, 'Jl. Bekasi Jaya', '2016-12-25 00:30:10', '2016-12-25', '2016-12-28', 3, 'REG', 2, 9000, 3, 1, 0),
(47, 'Dio', 'Vincent', 21, 13, 'Jl. Neraka', '2017-01-04 15:31:11', '2017-01-10', '2017-01-04', 2, 'REG', 1, 24000, 1, 1, 0),
(48, 'Sandi', 'Habib', 1, 29, 'Jl. Bekasi Jaya', '2016-12-25 00:30:07', '2016-12-25', '2012-01-01', 2, 'REG', 2, 9000, 3, 0, 1),
(49, 'Dio', 'Vincent', 1, 29, 'Jl. Bekasi Jaya', '2016-12-25 00:30:10', '2016-12-25', '2012-01-01', 3, 'REG', 2, 9000, 3, 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ms_administrator`
--
ALTER TABLE `ms_administrator`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`), ADD UNIQUE KEY `username_2` (`username`), ADD UNIQUE KEY `username_3` (`username`), ADD UNIQUE KEY `username_4` (`username`);

--
-- Indexes for table `ms_kecamatan`
--
ALTER TABLE `ms_kecamatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_kota`
--
ALTER TABLE `ms_kota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_kurir`
--
ALTER TABLE `ms_kurir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_layanan`
--
ALTER TABLE `ms_layanan`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `kode_layanan` (`kode_layanan`), ADD UNIQUE KEY `kode_layanan_2` (`kode_layanan`);

--
-- Indexes for table `ms_provinsi`
--
ALTER TABLE `ms_provinsi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_tarif`
--
ALTER TABLE `ms_tarif`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_usaha`
--
ALTER TABLE `ms_usaha`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_detail_pengiriman`
--
ALTER TABLE `tr_detail_pengiriman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_head_pengiriman`
--
ALTER TABLE `tr_head_pengiriman`
  ADD PRIMARY KEY (`id`), ADD KEY `kecamatan_pengirimz` (`id_kecamatan_penerima`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ms_administrator`
--
ALTER TABLE `ms_administrator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `ms_kecamatan`
--
ALTER TABLE `ms_kecamatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `ms_kota`
--
ALTER TABLE `ms_kota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `ms_kurir`
--
ALTER TABLE `ms_kurir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `ms_layanan`
--
ALTER TABLE `ms_layanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `ms_provinsi`
--
ALTER TABLE `ms_provinsi`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `ms_tarif`
--
ALTER TABLE `ms_tarif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `ms_usaha`
--
ALTER TABLE `ms_usaha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tr_detail_pengiriman`
--
ALTER TABLE `tr_detail_pengiriman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `tr_head_pengiriman`
--
ALTER TABLE `tr_head_pengiriman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=50;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tr_head_pengiriman`
--
ALTER TABLE `tr_head_pengiriman`
ADD CONSTRAINT `kecamatan_pengirimz` FOREIGN KEY (`id_kecamatan_penerima`) REFERENCES `ms_kecamatan` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
