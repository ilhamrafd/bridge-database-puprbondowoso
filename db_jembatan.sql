-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Okt 2020 pada 05.35
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jembatan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_akses`
--

CREATE TABLE `tbl_akses` (
  `id_akses` int(11) NOT NULL,
  `akses` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_akses`
--

INSERT INTO `tbl_akses` (`id_akses`, `akses`) VALUES
(1, 'Negara'),
(2, 'Provinsi'),
(3, 'Kabupaten');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kecamatan`
--

CREATE TABLE `tbl_kecamatan` (
  `id_kec` int(11) NOT NULL,
  `nama_kec` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_kecamatan`
--

INSERT INTO `tbl_kecamatan` (`id_kec`, `nama_kec`) VALUES
(1, 'Bondowoso'),
(2, 'Wringin'),
(3, 'Pakem'),
(4, 'Binakal'),
(5, 'Curahdami'),
(6, 'Pujer'),
(7, 'Wonosari'),
(8, 'Botolinggo'),
(9, 'Prajekan'),
(10, 'Grujugan'),
(11, 'Sempol'),
(12, 'Klabang'),
(13, 'Tapen'),
(14, 'Sukosari'),
(15, 'Sumber Wringin'),
(16, 'Maesan'),
(17, 'Taman Krocok'),
(18, 'Tegalampel'),
(19, 'Tenggarang'),
(20, 'Tlogosari'),
(21, 'Jambesari'),
(22, 'Cermee'),
(23, 'Tamanan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kondisi`
--

CREATE TABLE `tbl_kondisi` (
  `id_kondisi` int(11) NOT NULL,
  `kondisi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_kondisi`
--

INSERT INTO `tbl_kondisi` (`id_kondisi`, `kondisi`) VALUES
(1, 'Baik'),
(2, 'Rusak Ringan'),
(3, 'Rusak Sedang'),
(4, 'Rusak Berat');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_log`
--

CREATE TABLE `tbl_log` (
  `id` int(11) NOT NULL,
  `id_user` varchar(100) NOT NULL,
  `login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_log`
--

INSERT INTO `tbl_log` (`id`, `id_user`, `login`, `logout`) VALUES
(1, 'ilhamrafif', '2020-10-08 02:58:45', '2020-10-08 02:58:45'),
(2, 'ilhamrafif', '2020-10-08 02:59:38', '2020-10-08 02:59:38'),
(3, 'ilhamrafif', '2020-10-08 03:00:58', '2020-10-08 03:00:58'),
(4, 'ilhamrafif', '2020-10-08 03:06:39', '2020-10-08 03:07:00'),
(5, 'ilhamrafif', '2020-10-10 05:02:22', '2020-10-10 05:02:53'),
(6, 'admin', '2020-10-11 04:55:39', '2020-10-11 04:55:39'),
(7, 'admin', '2020-10-11 05:05:33', '2020-10-11 05:05:33'),
(8, 'admin', '2020-10-11 05:07:28', '2020-10-11 05:07:28'),
(9, 'admin', '2020-10-11 05:10:37', '2020-10-11 05:10:37'),
(10, 'admin', '2020-10-11 05:18:32', '2020-10-11 05:18:32'),
(11, 'admin', '2020-10-11 05:55:50', '2020-10-11 05:55:50'),
(12, 'admin', '2020-10-11 05:56:12', '2020-10-11 05:56:12'),
(13, 'admin', '2020-10-11 05:57:05', '2020-10-11 05:57:05'),
(14, 'admin', '2020-10-11 05:59:42', '2020-10-11 05:59:42'),
(15, 'admin', '2020-10-11 07:06:46', '2020-10-11 07:06:46'),
(16, 'admin', '2020-10-11 08:03:32', '2020-10-11 08:03:32'),
(17, 'admin', '2020-10-11 14:29:55', '2020-10-11 14:29:55'),
(18, 'admin', '2020-10-12 03:36:14', '2020-10-12 03:36:14'),
(19, 'admin', '2020-10-12 03:37:42', '2020-10-12 03:37:42'),
(20, 'admin', '2020-10-12 03:39:22', '2020-10-12 03:39:22'),
(21, 'admin', '2020-10-12 03:40:04', '2020-10-12 03:40:04'),
(22, 'admin', '2020-10-12 03:42:49', '2020-10-12 03:42:49'),
(23, 'admin', '2020-10-12 03:44:19', '2020-10-12 03:44:19'),
(24, 'admin', '2020-10-12 03:46:34', '2020-10-12 03:46:34'),
(25, 'admin', '2020-10-12 03:56:26', '2020-10-12 03:56:26'),
(26, 'admin', '2020-10-12 03:59:18', '2020-10-12 03:59:18'),
(27, 'admin', '2020-10-12 05:10:09', '2020-10-12 05:10:09'),
(28, 'admin', '2020-10-12 05:12:30', '2020-10-12 05:12:30'),
(29, 'admin', '2020-10-12 05:17:14', '2020-10-12 05:17:14'),
(30, 'admin', '2020-10-12 05:18:50', '2020-10-12 05:18:50'),
(31, 'admin', '2020-10-12 05:20:58', '2020-10-12 05:20:58'),
(32, 'admin', '2020-10-12 05:23:08', '2020-10-12 05:23:08'),
(33, 'admin', '2020-10-13 00:21:22', '2020-10-13 00:21:22'),
(34, 'admin', '2020-10-13 00:25:02', '2020-10-13 00:25:02'),
(35, 'admin', '2020-10-13 00:26:13', '2020-10-13 00:26:13'),
(36, 'admin', '2020-10-13 00:27:49', '2020-10-13 00:27:49'),
(37, 'admin', '2020-10-13 07:22:29', '2020-10-13 07:22:29'),
(38, 'admin', '2020-10-13 07:24:07', '2020-10-13 07:24:07'),
(39, 'admin', '2020-10-13 07:30:04', '2020-10-13 07:30:04'),
(40, 'admin', '2020-10-13 07:31:07', '2020-10-13 07:31:07'),
(41, 'admin', '2020-10-13 08:39:11', '2020-10-13 08:39:11'),
(42, 'admin', '2020-10-13 09:12:19', '2020-10-13 09:12:19'),
(43, 'admin', '2020-10-13 09:15:01', '2020-10-13 09:15:01'),
(44, 'admin', '2020-10-13 11:43:01', '2020-10-13 11:43:01'),
(45, 'admin', '2020-10-13 11:57:40', '2020-10-13 11:57:40'),
(46, 'admin', '2020-10-13 14:23:44', '2020-10-13 14:23:44'),
(47, 'admin', '2020-10-13 15:02:38', '2020-10-13 15:02:38'),
(48, 'admin', '2020-10-14 15:08:53', '2020-10-14 15:08:53'),
(49, 'admin', '2020-10-14 15:40:24', '2020-10-14 15:40:24');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` varchar(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_telp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `password`, `nama`, `jenis_kelamin`, `alamat`, `no_telp`) VALUES
('ilhamrafif', '030bdd37218c0ad35095abf3544ddc3f', 'Ilham Rafif Dhaifullah', 'Pria', 'Jln. Letnan Rantam 17', '085807234992'),
('admin', '21232f297a57a5a743894a0e4a801fc3', 'Admin', 'Pria', '-', '-');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_utama`
--

CREATE TABLE `tbl_utama` (
  `no_ruas` varchar(11) NOT NULL,
  `pangkal_ujung` varchar(100) NOT NULL,
  `id_kec` int(11) NOT NULL,
  `nama_jbt` varchar(100) NOT NULL,
  `jml` varchar(11) NOT NULL,
  `uk_panjang` varchar(11) NOT NULL,
  `uk_lebar` varchar(11) NOT NULL,
  `uk_lebartot` varchar(11) NOT NULL,
  `bangun_atas` varchar(100) NOT NULL,
  `bangun_bawah` varchar(100) NOT NULL,
  `id_kondisi` int(11) NOT NULL,
  `id_akses` int(11) NOT NULL,
  `koordinat` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `image2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_utama`
--

INSERT INTO `tbl_utama` (`no_ruas`, `pangkal_ujung`, `id_kec`, `nama_jbt`, `jml`, `uk_panjang`, `uk_lebar`, `uk_lebartot`, `bangun_atas`, `bangun_bawah`, `id_kondisi`, `id_akses`, `koordinat`, `image`, `image2`) VALUES
('152', 'Baratan - Ardisaeng', 4, 'Jembatan Andung Krajan', '1', '10.70m', '3.00m', '3.60', 'Pasangan Bata Lengkung', 'Pasangan Batu Kali', 4, 3, 'S09.290\'.190\" , E20.190\'.489\"', 'Andunsari 1.jpg', 'Andunsari 2.jpg'),
('232', 'Pancoran - Blumban', 1, 'Jembatan Blumban', '1', '7.00m', '4.70m', '5.00m', 'Beton Komposit Baja IWF', 'Pasangan Batu Kali', 1, 2, 'S20.109\'.290\" , E11.290\'.389\"', 'Blumban 1.jpg', 'Blumban 2.jpg'),
('186', 'Besuk - Botolinggo', 19, 'Jembatan Botolinggo', '1', '10.50m', '4.00m', '5.00m', 'Beton Komposit Baja IWF', 'Pasangan Batu Kali', 1, 2, 'S20.901\'.290\" , E30.290\'.489\"', 'Botolinggo 1.jpg', 'Botolinggo 2.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_akses`
--
ALTER TABLE `tbl_akses`
  ADD PRIMARY KEY (`id_akses`);

--
-- Indeks untuk tabel `tbl_kecamatan`
--
ALTER TABLE `tbl_kecamatan`
  ADD PRIMARY KEY (`id_kec`);

--
-- Indeks untuk tabel `tbl_kondisi`
--
ALTER TABLE `tbl_kondisi`
  ADD PRIMARY KEY (`id_kondisi`);

--
-- Indeks untuk tabel `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD KEY `id_jk` (`jenis_kelamin`);

--
-- Indeks untuk tabel `tbl_utama`
--
ALTER TABLE `tbl_utama`
  ADD KEY `id_akses` (`id_akses`),
  ADD KEY `id_kec` (`id_kec`),
  ADD KEY `id_kondisi` (`id_kondisi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_log`
--
ALTER TABLE `tbl_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tbl_utama`
--
ALTER TABLE `tbl_utama`
  ADD CONSTRAINT `tbl_utama_ibfk_1` FOREIGN KEY (`id_akses`) REFERENCES `tbl_akses` (`id_akses`),
  ADD CONSTRAINT `tbl_utama_ibfk_2` FOREIGN KEY (`id_kec`) REFERENCES `tbl_kecamatan` (`id_kec`),
  ADD CONSTRAINT `tbl_utama_ibfk_3` FOREIGN KEY (`id_kondisi`) REFERENCES `tbl_kondisi` (`id_kondisi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
