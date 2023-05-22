-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2023 pada 14.35
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkiran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkirmasuk`
--

CREATE TABLE `parkirmasuk` (
  `notiket` varchar(100) NOT NULL,
  `tanggalmasuk` varchar(30) NOT NULL,
  `noplat` varchar(10) NOT NULL,
  `jeniskendaraan` varchar(10) NOT NULL,
  `jammasuk` varchar(10) NOT NULL,
  `tanggalkeluar` varchar(20) NOT NULL,
  `jamkeluar` varchar(20) NOT NULL,
  `tarif` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `parkirmasuk`
--

INSERT INTO `parkirmasuk` (`notiket`, `tanggalmasuk`, `noplat`, `jeniskendaraan`, `jammasuk`, `tanggalkeluar`, `jamkeluar`, `tarif`) VALUES
('001', '19-05-2023', 'AB 2345 ER', 'Mobil', '19:21:55', '', '', ''),
('002', '19-05-2023', 'B 1256 ER', 'Motor', '19:22:18', '', '', ''),
('003', '19-05-2023', 'AB 1256 WQ', 'Motor', '19:33:38', '', '', ''),
('004', '19-05-2023', 'W 1245 TR', 'Motor', '19:34:18', '', '', ''),
('005', '20-05-2023', 'AB 2345 ER', 'Motor', '11:02:32', '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`Username`, `Password`) VALUES
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `parkirmasuk`
--
ALTER TABLE `parkirmasuk`
  ADD PRIMARY KEY (`notiket`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
