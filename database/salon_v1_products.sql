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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `price` double DEFAULT NULL,
                            `quantity_in_stock` int DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;

INSERT INTO `products` (`id`, `brand`, `name`, `price`, `quantity_in_stock`) VALUES
                                                                                 (1,'L\'Oreal','Dầu gội phục hồi hư tổn',150000,50),
(2,'L\'Oreal','Dầu xả dưỡng ẩm chuyên sâu',160000,60),
                                                                                 (3,'TRESemmé','Dầu gội suôn mượt tự nhiên',130000,75),
                                                                                 (4,'TRESemmé','Kem ủ tóc phục hồi keratin',180000,40),
                                                                                 (5,'Dove','Dầu gội mềm mượt tự nhiên',110000,85),
                                                                                 (6,'Dove','Kem xả dưỡng tóc bóng mượt',115000,80),
                                                                                 (7,'Pantene','Dầu gội ngăn rụng tóc',120000,90),
                                                                                 (8,'Pantene','Serum dưỡng tóc chuyên sâu',200000,55),
                                                                                 (9,'Wella','Thuốc nhuộm nâu lạnh',250000,35),
                                                                                 (10,'Wella','Thuốc nhuộm đen ánh tím',270000,25),
                                                                                 (11,'Schwarzkopf','Dầu gội bạc màu nhuộm',220000,40),
                                                                                 (12,'Schwarzkopf','Kem ủ phục hồi tóc hư tổn',280000,50),
                                                                                 (13,'Moroccanoil','Serum dưỡng tóc Argan',320000,30),
                                                                                 (14,'Moroccanoil','Dầu dưỡng bóng mượt',350000,25),
                                                                                 (15,'Revlon','Thuốc uốn tóc mềm tự nhiên',300000,20),
                                                                                 (16,'Revlon','Xịt dưỡng bảo vệ tóc',190000,45),
                                                                                 (17,'Tigi','Dầu gội tái tạo tóc hư tổn',210000,60),
                                                                                 (18,'Tigi','Dầu xả bảo vệ màu nhuộm',220000,55),
                                                                                 (19,'L\'Oreal','Kem dưỡng tóc khô xơ',200000,65),
                                                                                    (20,'L'Oreal'''Oreal','Kem dưỡng tóc khô xơ',200000,65),
                                                                                    (20,'L'Oreal','Keo xịt tóc cứng',180000,70),
                                                                                 (21,'Pantene','Serum dưỡng tóc bóng mượt',250000,40),
                                                                                 (22,'Dove','Xịt dưỡng tóc chống khô xơ',160000,50),
                                                                                 (23,'TRESemmé','Dầu gội dành cho tóc nhuộm',180000,75),
                                                                                 (24,'Wella','Kem nhuộm phủ bạc tự nhiên',260000,20),
                                                                                 (25,'Schwarzkopf','Mặt nạ tóc siêu mềm mượt',300000,25),
                                                                                 (26,'Moroccanoil','Tinh dầu phục hồi tóc',400000,18),
                                                                                 (27,'Tigi','Sữa rửa tóc thảo mộc',150000,80),
                                                                                 (28,'Revlon','Thuốc nhuộm ánh đồng',270000,30),
                                                                                 (29,'L\'Oreal','Dầu gội bạc màu highlight',210000,55),
(30,'Dove','Kem ủ tóc suôn mượt',170000,60),
(31,'Pantene','Tinh dầu dưỡng tóc bóng khỏe',190000,50),
(32,'Wella','Serum phục hồi tóc yếu',350000,25),
(33,'TRESemmé','Dầu gội bồng bềnh tự nhiên',145000,75),
(34,'Schwarzkopf','Keo giữ nếp tóc lâu',180000,40),
(35,'Revlon','Dầu xả dưỡng tóc mềm mại',200000,55),
(36,'Moroccanoil','Dầu gội Argan dưỡng tóc',320000,35),
(37,'L'Oreal','Thuốc nhuộm ánh đỏ rượu vang',260000,25),
                                                                                 (38,'Dove','Dầu gội thảo dược thiên nhiên',140000,90),
                                                                                 (39,'TRESemmé','Kem dưỡng ẩm phục hồi tóc khô',185000,45),
                                                                                 (40,'Pantene','Dầu xả phục hồi tóc hư tổn',160000,75),
                                                                                 (41,'Wella','Mặt nạ dưỡng tóc chuyên sâu',330000,20),
                                                                                 (42,'Schwarzkopf','Thuốc uốn tóc định hình',290000,30),
                                                                                 (43,'Moroccanoil','Serum phục hồi bóng tóc',360000,22),
                                                                                 (44,'Revlon','Dầu gội dành cho tóc yếu',210000,50),
                                                                                 (45,'L\'Oreal','Xịt dưỡng tóc giữ nếp lâu',190000,65),
(46,'Tigi','Dầu gội dành cho tóc uốn',175000,55),
(47,'Dove','Tinh dầu dưỡng tóc thiên nhiên',200000,70),
(48,'Pantene','Kem ủ phục hồi tóc nhuộm',190000,60),
(49,'Wella','Thuốc nhuộm ánh nâu lạnh',270000,40),
(50,'Schwarzkopf','Xịt dưỡng bóng tóc',250000,35),
(51,'Moroccanoil','Dầu gội phục hồi Argan',340000,28),
(52,'Revlon','Serum bảo vệ tóc khỏi nhiệt',280000,45),
(53,'TRESemmé','Dầu gội phục hồi tóc yếu',150000,80),
(54,'L'Oreal','Kem nhuộm phủ bạc siêu mịn',290000,30),
                                                                                 (55,'Dove','Dầu gội mềm mượt tự nhiên',120000,85),
                                                                                 (56,'Pantene','Dầu dưỡng tóc bóng khỏe',200000,50),
                                                                                 (57,'Wella','Mặt nạ phục hồi tóc khô',320000,20),
                                                                                 (58,'Schwarzkopf','Kem ủ tóc collagen',310000,25),
                                                                                 (59,'Tigi','Keo xịt tóc siêu cứng',170000,60),
                                                                                 (60,'Revlon','Serum dưỡng tóc bóng mượt',270000,35),
                                                                                 (61,'Moroccanoil','Dầu dưỡng bóng tóc',350000,30),
                                                                                 (62,'L\'Oreal','Tinh dầu phục hồi tóc nhuộm',260000,45),
                                                                                    (63,''Pantene','Kem xả dành cho tóc hư tổn',150000,80),
                                                                                    (64,'Dove','Xịt dưỡng tóc mềm mại',160000,70),
                                                                                    (65,'Wella','Kem nhuộm ánh tím',280000,30),
                                                                                    (66,'Schwarzkopf','Thuốc uốn xoăn tự nhiên',300000,25),
                                                                                    (67,'Tigi','Serum dưỡng tóc bóng khỏe',260000,40),
                                                                                    (68,'Revlon','Dầu gội dưỡng màu nhuộm',240000,50),
                                                                                    (69,'L'Oreal','Dầu gội phục hồi tóc yếu',200000,55),
                                                                                 (70,'TRESemmé','Kem dưỡng tóc suôn mượt',180000,60),
                                                                                 (71,'Dove','Dầu gội dành cho tóc gãy rụng',150000,75),
                                                                                 (72,'Pantene','Dầu xả phục hồi tóc khô',170000,70),
                                                                                 (73,'Wella','Dầu nhuộm ánh đồng tự nhiên',250000,35),
                                                                                 (74,'Schwarzkopf','Serum dưỡng tóc bóng khỏe',300000,28),
                                                                                 (75,'Moroccanoil','Dầu dưỡng Argan cao cấp',400000,20),
                                                                                 (76,'Tigi','Kem xả phục hồi tóc yếu',190000,60),
                                                                                 (77,'Revlon','Tinh dầu dưỡng tóc mềm mượt',280000,45),
                                                                                 (78,'L'Oreal','Keo xịt tóc siêu giữ nếp',200000,55),
                                                                                    (70,'Dove','Dầu gội dành cho tóc dầu',130000,80),
                                                                                    (80,'Pantene','Serum dưỡng bóng tóc',230000,45),
                                                                                    (81,'Wella','Kem ủ tóc ánh nâu tự nhiên',270000,30),
                                                                                    (82,'Schwarzkopf','Dầu gội phục hồi tóc yếu',310000,25),
                                                                                    (83,'Moroccanoil','Serum dưỡng tóc chuyên sâu',360000,22),
                                                                                    (84,'TRESemmé','Dầu gội dành cho tóc hư tổn',150000,90),
                                                                                    (85,'L'Oreal','Thuốc nhuộm ánh hạt dẻ',280000,35),
                                                                                 (86,'Dove','Kem ủ dưỡng tóc mềm mượt',180000,65),
                                                                                 (87,'Pantene','Dầu xả bảo vệ tóc nhuộm',190000,75),
                                                                                 (88,'Wella','Thuốc uốn tóc tự nhiên',290000,30),
                                                                                 (89,'Schwarzkopf','Xịt dưỡng tóc chống khô xơ',260000,40),
                                                                                 (90,'Moroccanoil','Dầu Argan dưỡng bóng',370000,18),
                                                                                 (91,'Tigi','Kem nhuộm tóc ánh đỏ',260000,25),
                                                                                 (92,'Revlon','Serum dưỡng tóc giữ màu',240000,50),
                                                                                 (93,'L'Oreal','Dầu gội phủ bạc tự nhiên',210000,60),
(94,'Dove','Dầu xả tái tạo tóc yếu',150000,85),
(95,'Pantene','Kem xả phục hồi tóc nhuộm',160000,70),
(96,'Wella','Thuốc nhuộm ánh đồng sáng',280000,35),
(97,'Schwarzkopf','Keo xịt tóc mềm nhẹ',230000,50),
(98,'Moroccanoil','Tinh dầu Argan dưỡng tóc',380000,25),
(99,'Tigi','Kem ủ dưỡng tóc hư tổn',220000,45),
(100,'Revlon','Xịt dưỡng tóc bóng mượt',260000,40);

/*!40000 ALTER TABLE `products` ENABLE KEYS */;
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
