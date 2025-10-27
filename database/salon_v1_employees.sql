-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: salon_v1
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `shift` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `specialization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'gpt1014@baret.pro','hoangtuan','951753698',2222222,'Sáng','tóc','Đang làm'),(2,'gpt1014@baret.pro','hoangtuan','951753698',2222222,'Sáng','tóc','Đang làm'),(3,'5@gmail.com','minh','1597755231',5555555,'Chiều','Nhuộm','Đang làm'),(4,'bit230468@st.cmcu.edu.vn','ădasd','0969096653',33333,'Chiều','Cắt tóc','Đang làm'),(5,'nhanvien5@salon.com','Nguyễn Văn A','0912345670',8500000,'Sáng','Cắt tóc','Đang làm'),
                               (6,'nhanvien6@salon.com','Trần Thị B','0912345671',9200000,'Chiều','Nhuộm','Đang làm'),
                               (7,'nhanvien7@salon.com','Lê Văn C','0912345672',8800000,'Tối','Gội đầu','Nghỉ phép'),
                               (8,'nhanvien8@salon.com','Phạm Thị D','0912345673',9700000,'Sáng','Massage','Đang làm'),
                               (9,'nhanvien9@salon.com','Vũ Minh E','0912345674',10200000,'Chiều','Trang điểm','Đang làm'),
                               (10,'nhanvien10@salon.com','Ngô Văn F','0912345675',8900000,'Tối','Cắt tóc','Đang làm'),
                               (11,'nhanvien11@salon.com','Hoàng Thị G','0912345676',11200000,'Sáng','Nhuộm','Đang làm'),
                               (12,'nhanvien12@salon.com','Đỗ Văn H','0912345677',9500000,'Chiều','Gội đầu','Nghỉ phép'),
                               (13,'nhanvien13@salon.com','Bùi Thị I','0912345678',10300000,'Tối','Massage','Đang làm'),
                               (14,'nhanvien14@salon.com','Đặng Văn K','0912345679',8600000,'Sáng','Trang điểm','Đang làm'),
                               (15,'nhanvien15@salon.com','Nguyễn Hoàng L','0912345680',12000000,'Chiều','Cắt tóc','Đang làm'),
                               (16,'nhanvien16@salon.com','Phan Thị M','0912345681',9100000,'Tối','Nhuộm','Nghỉ phép'),
                               (17,'nhanvien17@salon.com','Trương Văn N','0912345682',9400000,'Sáng','Gội đầu','Đang làm'),
                               (18,'nhanvien18@salon.com','Võ Thị O','0912345683',9900000,'Chiều','Massage','Đang làm'),
                               (19,'nhanvien19@salon.com','Mai Văn P','0912345684',8700000,'Tối','Trang điểm','Đang làm'),
                               (20,'nhanvien20@salon.com','Nguyễn Thị Q','0912345685',10800000,'Sáng','Cắt tóc','Đang làm'),
                               (21,'nhanvien21@salon.com','Trần Văn R','0912345686',11200000,'Chiều','Nhuộm','Nghỉ phép'),
                               (22,'nhanvien22@salon.com','Lê Thị S','0912345687',9300000,'Tối','Gội đầu','Đang làm'),
                               (23,'nhanvien23@salon.com','Phạm Văn T','0912345688',8900000,'Sáng','Massage','Đang làm'),
                               (24,'nhanvien24@salon.com','Vũ Thị U','0912345689',9500000,'Chiều','Trang điểm','Đang làm'),
                               (25,'nhanvien25@salon.com','Ngô Văn V','0912345690',8700000,'Tối','Cắt tóc','Đang làm'),
                               (26,'nhanvien26@salon.com','Hoàng Thị X','0912345691',9600000,'Sáng','Nhuộm','Đang làm'),
                               (27,'nhanvien27@salon.com','Đỗ Văn Y','0912345692',9100000,'Chiều','Gội đầu','Nghỉ phép'),
                               (28,'nhanvien28@salon.com','Bùi Thị Z','0912345693',10400000,'Tối','Massage','Đang làm'),
                               (29,'nhanvien29@salon.com','Đặng Văn A1','0912345694',9400000,'Sáng','Trang điểm','Đang làm'),
                               (30,'nhanvien30@salon.com','Nguyễn Văn A2','0912345695',10000000,'Chiều','Cắt tóc','Đang làm'),
                               (31,'nhanvien31@salon.com','Trần Thị A3','0912345696',9700000,'Tối','Nhuộm','Đang làm'),
                               (32,'nhanvien32@salon.com','Lê Văn A4','0912345697',8900000,'Sáng','Gội đầu','Nghỉ phép'),
                               (33,'nhanvien33@salon.com','Phạm Thị A5','0912345698',11500000,'Chiều','Massage','Đang làm'),
                               (34,'nhanvien34@salon.com','Vũ Minh A6','0912345699',8600000,'Tối','Trang điểm','Đang làm'),
                               (35,'nhanvien35@salon.com','Ngô Văn A7','0912345700',9800000,'Sáng','Cắt tóc','Đang làm'),
                               (36,'nhanvien36@salon.com','Hoàng Thị A8','0912345701',9400000,'Chiều','Nhuộm','Đang làm'),
                               (37,'nhanvien37@salon.com','Đỗ Văn A9','0912345702',10200000,'Tối','Gội đầu','Đang làm'),
                               (38,'nhanvien38@salon.com','Bùi Thị A10','0912345703',8900000,'Sáng','Massage','Đang làm'),
                               (39,'nhanvien39@salon.com','Đặng Văn A11','0912345704',9300000,'Chiều','Trang điểm','Đang làm'),
                               (40,'nhanvien40@salon.com','Nguyễn Văn A12','0912345705',9200000,'Tối','Cắt tóc','Nghỉ phép'),
                               (41,'nhanvien41@salon.com','Trần Thị A13','0912345706',9500000,'Sáng','Nhuộm','Đang làm'),
                               (42,'nhanvien42@salon.com','Lê Văn A14','0912345707',9700000,'Chiều','Gội đầu','Đang làm'),
                               (43,'nhanvien43@salon.com','Phạm Thị A15','0912345708',10800000,'Tối','Massage','Đang làm'),
                               (44,'nhanvien44@salon.com','Vũ Minh A16','0912345709',9900000,'Sáng','Trang điểm','Đang làm'),
                               (45,'nhanvien45@salon.com','Ngô Văn A17','0912345710',9400000,'Chiều','Cắt tóc','Đang làm'),
                               (46,'nhanvien46@salon.com','Hoàng Thị A18','0912345711',8600000,'Tối','Nhuộm','Đang làm'),
                               (47,'nhanvien47@salon.com','Đỗ Văn A19','0912345712',8900000,'Sáng','Gội đầu','Nghỉ phép'),
                               (48,'nhanvien48@salon.com','Bùi Thị A20','0912345713',9600000,'Chiều','Massage','Đang làm'),
                               (49,'nhanvien49@salon.com','Đặng Văn A21','0912345714',10000000,'Tối','Trang điểm','Đang làm'),
                               (50,'nhanvien50@salon.com','Nguyễn Văn A22','0912345715',8800000,'Sáng','Cắt tóc','Đang làm'),
                               (51,'nhanvien51@salon.com','Trần Thị A23','0912345716',9900000,'Chiều','Nhuộm','Đang làm'),
                               (52,'nhanvien52@salon.com','Lê Văn A24','0912345717',8700000,'Tối','Gội đầu','Đang làm'),
                               (53,'nhanvien53@salon.com','Phạm Thị A25','0912345718',9200000,'Sáng','Massage','Đang làm'),
                               (54,'nhanvien54@salon.com','Vũ Minh A26','0912345719',9600000,'Chiều','Trang điểm','Đang làm'),
                               (55,'nhanvien55@salon.com','Ngô Văn A27','0912345720',8900000,'Tối','Cắt tóc','Đang làm'),
                               (56,'nhanvien56@salon.com','Hoàng Thị A28','0912345721',9100000,'Sáng','Nhuộm','Đang làm'),
                               (57,'nhanvien57@salon.com','Đỗ Văn A29','0912345722',10000000,'Chiều','Gội đầu','Đang làm'),
                               (58,'nhanvien58@salon.com','Bùi Thị A30','0912345723',8700000,'Tối','Massage','Đang làm'),
                               (59,'nhanvien59@salon.com','Đặng Văn A31','0912345724',9800000,'Sáng','Trang điểm','Đang làm'),
                               (60,'nhanvien60@salon.com','Nguyễn Văn A32','0912345725',8900000,'Chiều','Cắt tóc','Đang làm'),
                               (61,'nhanvien61@salon.com','Trần Thị A33','0912345726',9500000,'Tối','Nhuộm','Nghỉ phép'),
                               (62,'nhanvien62@salon.com','Lê Văn A34','0912345727',10300000,'Sáng','Gội đầu','Đang làm'),
                               (63,'nhanvien63@salon.com','Phạm Thị A35','0912345728',8600000,'Chiều','Massage','Đang làm'),
                               (64,'nhanvien64@salon.com','Vũ Minh A36','0912345729',9600000,'Tối','Trang điểm','Đang làm'),
                               (65,'nhanvien65@salon.com','Ngô Văn A37','0912345730',9100000,'Sáng','Cắt tóc','Đang làm'),
                               (66,'nhanvien66@salon.com','Hoàng Thị A38','0912345731',9700000,'Chiều','Nhuộm','Đang làm'),
                               (67,'nhanvien67@salon.com','Đỗ Văn A39','0912345732',9200000,'Tối','Gội đầu','Đang làm'),
                               (68,'nhanvien68@salon.com','Bùi Thị A40','0912345733',10100000,'Sáng','Massage','Đang làm'),
                               (69,'nhanvien69@salon.com','Đặng Văn A41','0912345734',8900000,'Chiều','Trang điểm','Đang làm'),
                               (70,'nhanvien70@salon.com','Nguyễn Văn A42','0912345735',9400000,'Tối','Cắt tóc','Đang làm'),
                               (71,'nhanvien71@salon.com','Trần Thị A43','0912345736',8800000,'Sáng','Nhuộm','Đang làm'),
                               (72,'nhanvien72@salon.com','Lê Văn A44','0912345737',8900000,'Chiều','Gội đầu','Nghỉ phép'),
                               (73,'nhanvien73@salon.com','Phạm Thị A45','0912345738',9700000,'Tối','Massage','Đang làm'),
                               (74,'nhanvien74@salon.com','Vũ Minh A46','0912345739',9900000,'Sáng','Trang điểm','Đang làm'),
                               (75,'nhanvien75@salon.com','Ngô Văn A47','0912345740',8800000,'Chiều','Cắt tóc','Đang làm'),
                               (76,'nhanvien76@salon.com','Hoàng Thị A48','0912345741',9300000,'Tối','Nhuộm','Đang làm'),
                               (77,'nhanvien77@salon.com','Đỗ Văn A49','0912345742',10800000,'Sáng','Gội đầu','Đang làm'),
                               (78,'nhanvien78@salon.com','Bùi Thị A50','0912345743',9200000,'Chiều','Massage','Đang làm'),
                               (79,'nhanvien79@salon.com','Đặng Văn A51','0912345744',9500000,'Tối','Trang điểm','Đang làm'),
                               (80,'nhanvien80@salon.com','Nguyễn Văn A52','0912345745',8600000,'Sáng','Cắt tóc','Đang làm'),
                               (81,'nhanvien81@salon.com','Trần Thị A53','0912345746',9600000,'Chiều','Nhuộm','Đang làm'),
                               (82,'nhanvien82@salon.com','Lê Văn A54','0912345747',8700000,'Tối','Gội đầu','Nghỉ phép'),
                               (83,'nhanvien83@salon.com','Phạm Thị A55','0912345748',9100000,'Sáng','Massage','Đang làm'),
                               (84,'nhanvien84@salon.com','Vũ Minh A56','0912345749',9400000,'Chiều','Trang điểm','Đang làm'),
                               (85,'nhanvien85@salon.com','Ngô Văn A57','0912345750',10300000,'Tối','Cắt tóc','Đang làm'),
                               (86,'nhanvien86@salon.com','Hoàng Thị A58','0912345751',8700000,'Sáng','Nhuộm','Đang làm'),
                               (87,'nhanvien87@salon.com','Đỗ Văn A59','0912345752',9500000,'Chiều','Gội đầu','Đang làm'),
                               (88,'nhanvien88@salon.com','Bùi Thị A60','0912345753',8900000,'Tối','Massage','Đang làm'),
                               (89,'nhanvien89@salon.com','Đặng Văn A61','0912345754',9300000,'Sáng','Trang điểm','Đang làm'),
                               (90,'nhanvien90@salon.com','Nguyễn Văn A62','0912345755',10800000,'Chiều','Cắt tóc','Đang làm'),
                               (91,'nhanvien91@salon.com','Trần Thị A63','0912345756',9200000,'Tối','Nhuộm','Đang làm'),
                               (92,'nhanvien92@salon.com','Lê Văn A64','0912345757',8900000,'Sáng','Gội đầu','Đang làm'),
                               (93,'nhanvien93@salon.com','Phạm Thị A65','0912345758',9400000,'Chiều','Massage','Đang làm'),
                               (94,'nhanvien94@salon.com','Vũ Minh A66','0912345759',9900000,'Tối','Trang điểm','Đang làm'),
                               (95,'nhanvien95@salon.com','Ngô Văn A67','0912345760',8600000,'Sáng','Cắt tóc','Đang làm'),
                               (96,'nhanvien96@salon.com','Hoàng Thị A68','0912345761',9100000,'Chiều','Nhuộm','Đang làm'),
                               (97,'nhanvien97@salon.com','Đỗ Văn A69','0912345762',10200000,'Tối','Gội đầu','Đang làm'),
                               (98,'nhanvien98@salon.com','Bùi Thị A70','0912345763',8700000,'Sáng','Massage','Đang làm'),
                               (99,'nhanvien99@salon.com','Đặng Văn A71','0912345764',9400000,'Chiều','Trang điểm','Đang làm'),
                               (100,'nhanvien100@salon.com','Nguyễn Văn A72','0912345765',9500000,'Tối','Cắt tóc','Đang làm'),
                               (101,'nhanvien101@salon.com','Trần Thị A73','0912345766',8600000,'Sáng','Nhuộm','Đang làm'),
                               (102,'nhanvien102@salon.com','Lê Văn A74','0912345767',9400000,'Chiều','Gội đầu','Nghỉ phép'),
                               (103,'nhanvien103@salon.com','Phạm Thị A75','0912345768',9700000,'Tối','Massage','Đang làm'),
                               (104,'nhanvien104@salon.com','Vũ Minh A76','0912345769',9800000,'Sáng','Trang điểm','Đang làm');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-27 16:27:40
