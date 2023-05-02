-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for quanlychitieu
CREATE DATABASE IF NOT EXISTS `quanlychitieu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `quanlychitieu`;

-- Dumping structure for table quanlychitieu.budget
CREATE TABLE IF NOT EXISTS `budget` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(512) NOT NULL,
  `soTien` int(11) NOT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  `danhMuc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table quanlychitieu.budget: ~3 rows (approximately)
INSERT INTO `budget` (`ID`, `username`, `soTien`, `ngayBatDau`, `ngayKetThuc`, `danhMuc`) VALUES
	(32, 'thanhdat1', 50000000, '2023-04-30', '2023-06-30', 'Quần áo'),
	(33, 'thanhdat1', 70000000, '2023-04-30', '2024-04-30', 'Giáo dục'),
	(34, 'thanhdat1', 20000000, '2023-02-28', '2023-04-20', 'Quần áo');

-- Dumping structure for table quanlychitieu.category
CREATE TABLE IF NOT EXISTS `category` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(512) NOT NULL,
  `danhMuc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `icon` varchar(512) DEFAULT NULL,
  `loai` bit(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table quanlychitieu.category: ~13 rows (approximately)
INSERT INTO `category` (`ID`, `username`, `danhMuc`, `icon`, `loai`) VALUES
	(1, 'thanhdat1', 'Ăn uống', 'cutlery.png', b'0'),
	(2, 'thanhdat1', 'Quần áo', 'tshirt.png', b'0'),
	(3, 'thanhdat1', 'Phí giao lưu', 'partyIcon.png', b'0'),
	(4, 'thanhdat1', 'Giáo dục', 'book.png', b'0'),
	(5, 'thanhdat1', 'Y tế', 'syringe.png', b'0'),
	(6, 'thanhdat1', 'Phí liên lạc', 'phone.png', b'0'),
	(8, 'thanhdat1', 'Tiền điện nước', 'electric.png', b'0'),
	(9, 'thanhdat1', 'Tiền lương', 'luong.png', b'1'),
	(10, 'thanhdat1', 'Tiền phụ cấp', 'phucap.png', b'1'),
	(11, 'thanhdat1', 'Tiền thưởng', 'thuong.png', b'1'),
	(12, 'thanhdat1', 'Thu nhập phụ', 'phu.png', b'1'),
	(13, 'thanhdat1', 'Đầu tư', 'dautu.png', b'1'),
	(14, 'thanhdat1', 'Thu nhập tạm thời', 'tam.png', b'1');

-- Dumping structure for table quanlychitieu.setting
CREATE TABLE IF NOT EXISTS `setting` (
  `username` varchar(512) DEFAULT NULL,
  `hoVaten` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(512) NOT NULL,
  `soDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table quanlychitieu.setting: ~1 rows (approximately)
INSERT INTO `setting` (`username`, `hoVaten`, `email`, `soDienThoai`) VALUES
	('thanhdat1', 'Nguyễn Thành Đạt', 'thanhdatnguyen211103@gmail.com', '0985592136');

-- Dumping structure for table quanlychitieu.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(512) NOT NULL,
  `danhMuc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngayGiaoDich` date NOT NULL,
  `soTien` int(255) NOT NULL,
  `ghiChu` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `loai` bit(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table quanlychitieu.transaction: ~59 rows (approximately)
INSERT INTO `transaction` (`ID`, `username`, `danhMuc`, `ngayGiaoDich`, `soTien`, `ghiChu`, `loai`) VALUES
	(16, 'thanhdat1', 'Ăn uống', '2023-04-20', 21000, '', b'0'),
	(17, 'thanhdat1', 'Giáo dục', '2023-04-20', 21000, '', b'0'),
	(19, 'thanhdat1', 'Giáo dục', '2023-04-20', 20000, '', b'0'),
	(20, 'thanhdat1', 'Quần áo', '2023-04-20', 31000, '', b'0'),
	(21, 'thanhdat1', 'Quần áo', '2023-04-17', 31000, '', b'0'),
	(27, 'thanhdat1', 'Ăn uống', '2023-05-02', 21312313, '13123', b'0'),
	(32, 'thanhdat1', 'Tiền lương', '2023-04-22', 2000000, '', b'1'),
	(35, 'thanhdat1', 'Tạm thời', '2023-05-02', 21312313, '13123', b'1'),
	(37, 'thanhdat1', 'Ăn uống', '2023-04-23', 2000000, '', b'0'),
	(45, 'thanhdat1', 'Tiền phụ cấp', '2023-04-22', 500000, '', b'1'),
	(46, 'thanhdat1', 'Tiền nhà', '2023-04-24', 10000, '', b'0'),
	(49, 'thanhdat1', 'Thu nhập phụ', '2023-04-22', 21000, '', b'1'),
	(52, 'thanhdat1', 'Y tế', '2023-05-02', 10000000, 'Chỉnh sửa DAO2', b'0'),
	(53, 'thanhdat1', 'Giáo dục', '2023-06-01', 1000000, '', b'0'),
	(54, 'thanhdat1', 'Điện nước', '2023-06-09', 2500000, '', b'0'),
	(56, 'thanhdat1', 'Ăn uống', '2023-04-24', 15644, '4234', b'0'),
	(59, 'thanhdat1', 'Tiền phụ cấp', '2023-05-07', 3500000, 'chỉnh sửa DAO1', b'1'),
	(61, 'thanhdat1', 'Phụ', '2023-06-07', 3000000, 'lương', b'1'),
	(62, 'thanhdat1', 'Quần áo', '2021-11-11', 20000000, 'dattesst', b'0'),
	(63, 'thanhdat1', 'Y tế', '2022-11-11', 10000000, 'dat', b'0'),
	(64, 'thanhdat1', 'Giáo dục', '2024-11-11', 30000000, NULL, b'0'),
	(65, 'thanhdat1', 'Ăn uống', '2025-11-11', 40000000, NULL, b'0'),
	(66, 'thanhdat1', 'Y tế', '2026-11-11', 20000000, NULL, b'0'),
	(68, 'thanhdat1', 'Tiền Lương', '2024-04-25', 20000000, NULL, b'1'),
	(69, 'thanhdat1', 'Tiền Lương', '2025-04-25', 50000000, NULL, b'1'),
	(70, 'thanhdat1', 'Tiền Lương', '2027-04-25', 20000000, NULL, b'1'),
	(71, 'thanhdat1', 'Tiền Lương', '2026-04-25', 30000000, NULL, b'1'),
	(72, 'thanhdat1', 'Y tế', '2023-04-26', 1234560, 'sau khi cấp tiến', b'0'),
	(73, 'thanhdat1', 'Cub', '2023-04-26', 1234560, 'sau khi cấp tiến', b'0'),
	(75, 'thanhdat1', 'Tiền nhà', '2023-04-27', 100000, '', b'0'),
	(76, 'thanhdat1', 'Quần áo', '2023-04-27', 500000, 'aaaa', b'0'),
	(77, 'thanhdat1', 'Tiền lương', '2023-04-27', 500000, 'aa', b'1'),
	(78, 'thanhdat1', 'Ăn uống', '2023-04-27', 5000000, '', b'0'),
	(79, 'thanhdat1', 'Y tế', '2023-04-27', 200000, '', b'0'),
	(80, 'thanhdat1', 'Quần áo', '2023-04-27', 5000000, '', b'0'),
	(81, 'thanhdat1', 'Giáo dục', '2023-04-29', 1000000, 'chỉnh sửa dao', b'0'),
	(85, 'thanhdat1', 'Cub', '2023-04-29', 100000, 'thêm DAO chi', b'0'),
	(86, 'thanhdat1', 'Tiền thưởng', '2023-04-29', 2000000, '', b'1'),
	(87, 'thanhdat1', 'Phí liên lạc', '2023-04-29', 0, 'thêm 1', b'0'),
	(88, 'thanhdat1', 'Ăn uống', '2023-04-29', 1000000, '', b'0'),
	(89, 'thanhdat1', 'Quần áo', '2023-04-29', 1000000, '', b'0'),
	(90, 'thanhdat1', 'Phí liên lạc', '2023-05-01', 2000000, 'test Ngân Sách', b'0'),
	(91, 'thanhdat1', 'Phí liên lạc', '2023-04-29', 2000000, '100', b'0'),
	(92, 'thanhdat1', 'Phí liên lạc', '2023-04-29', 3000000, 'test Ngân sách', b'0'),
	(95, 'thanhdat1', 'Tiền Lương', '2022-04-30', 30000000, NULL, b'1'),
	(96, 'thanhdat1', 'Tiền Lương', '2021-04-30', 40000000, NULL, b'1'),
	(97, 'thanhdat1', '', '2023-01-01', -20000000, NULL, b'0'),
	(98, 'thanhdat1', '', '2019-04-30', 25000000, NULL, b'0'),
	(99, 'thanhdat1', '', '2020-04-30', 15000000, NULL, b'0'),
	(100, 'thanhdat1', '', '2020-04-30', 20000000, NULL, b'1'),
	(101, 'thanhdat1', '', '2019-04-30', 15000000, NULL, b'1'),
	(102, 'thanhdat1', 'Y tế', '2023-04-30', 0, '', b'0'),
	(103, 'thanhdat1', 'Tiền lương', '2023-05-01', 0, '', b'1'),
	(104, 'thanhdat1', 'Tiền lương', '2023-05-01', 20000, '', b'1'),
	(105, 'thanhdat1', 'Giáo dục', '2023-05-01', 1000000, '', b'0'),
	(106, 'thanhdat1', 'Y tế', '2023-05-01', 0, '', b'0'),
	(107, 'thanhdat1', 'Phí liên lạc', '2023-05-01', 0, '', b'0'),
	(109, 'thanhdat1', 'Tiền nhà', '2023-05-01', 1000000, '', b'0'),
	(110, 'thanhdat1', 'Tiền phụ cấp', '2023-05-01', 1000000, '', b'1');

-- Dumping structure for table quanlychitieu.user
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(512) NOT NULL,
  `password` varchar(512) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table quanlychitieu.user: ~1 rows (approximately)
INSERT INTO `user` (`username`, `password`) VALUES
	('thanhdat1', '12345678');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
