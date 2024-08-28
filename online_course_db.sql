-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: online_course_db
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Programming Basics','Courses introducing fundamental programming concepts and languages.'),(2,'Mathematics','Courses covering basic arithmetic, algebra, and other foundational math topics.'),(3,'English Language','Courses focused on improving reading, writing, and speaking skills in English.'),(4,'Science','Courses introducing basic concepts in physics, chemistry, and biology.'),(5,'History','Courses covering significant historical events and periods.'),(6,'Geography','Courses on the study of the earth, its environments, and human interactions.'),(7,'Art','Courses on basic drawing, painting, and art appreciation.'),(8,'Music','Courses on music theory, instruments, and basic composition.'),(9,'Physical Education','Courses on physical fitness, sports, and healthy living.'),(10,'Technology','Courses introducing basic computer skills, software, and the internet.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `category` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `description` text,
  `price` double NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `cover_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_idx` (`category`),
  KEY `teacher_id_idx` (`teacher_id`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Introduction to Python',1,NULL,'Learn the basics of Python programming, a popular language for beginners.',499000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(2,'JavaScript Fundamentals',1,NULL,'A course on the fundamentals of JavaScript, the language of the web.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(3,'Getting Started with Java',1,NULL,'An introductory course on Java programming for beginners.',599000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(4,'C++ for Beginners',1,NULL,'Learn C++ programming from scratch with hands-on exercises.',549000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(5,'Basic Arithmetic',2,NULL,'Understand the fundamentals of arithmetic operations and their applications.',299000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(6,'Introduction to Geometry',2,NULL,'A course on the basic concepts of geometry and spatial reasoning.',349000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(7,'Algebra 101',2,NULL,'Learn the foundational concepts of algebra and solve simple equations.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(8,'Trigonometry Essentials',2,NULL,'An introductory course on trigonometric functions and their applications.',449000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(9,'English Vocabulary Builder',3,NULL,'Expand your English vocabulary with this comprehensive course.',249000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(10,'Basic English Grammar',3,NULL,'Learn the basics of English grammar to improve your writing and speaking.',299000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(11,'Conversational English',3,NULL,'A course focused on improving your English speaking skills.',349000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(12,'English Reading Comprehension',3,NULL,'Enhance your reading skills and understanding of English',299000,NULL,NULL,'https://t3.ftcdn.net/jpg/04/60/01/36/360_F_460013622_6xF8uN6ubMvLx0tAJECBHfKPoNOR5cRa.jpg'),(13,'Basic Physics Concepts',4,NULL,'An introductory course on the fundamental concepts of physics.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(14,'Chemistry for Beginners',4,NULL,'Learn the basics of chemistry, including atoms, molecules, and reactions.',449000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(15,'Introduction to Biology',4,NULL,'A course covering the basic principles of biology and life sciences.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(16,'Earth Science Fundamentals',4,NULL,'Learn about the earth, its processes, and natural phenomena.',349000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(17,'Introduction to World Geography',6,NULL,'Explore the physical and political features of the world.',299000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(18,'Climate and Weather',6,NULL,'Understand the basics of climate, weather patterns, and their effects.',349000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(19,'Geographical Information Systems',6,NULL,'An introductory course on GIS and its applications.',499000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(20,'Environmental Geography',6,NULL,'Learn about the relationship between humans and their environment.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(21,'Piano for Beginners',8,NULL,'Learn the basics of playing the piano, including notes and simple songs.',299000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(22,'Guitar Basics',8,NULL,'An introductory course on playing the guitar, including chords and strumming.',349000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(23,'Music Theory 101',8,NULL,'Understand the basic concepts of music theory and how to read sheet music.',299000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(24,'Singing Techniques',8,NULL,'Improve your singing with basic techniques and vocal exercises.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(25,'Basic Computer Skills',10,NULL,'Learn essential computer skills, including using the internet and software.',249000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(26,'Introduction to Web Development',10,NULL,'A course on building simple websites using HTML, CSS, and JavaScript.',399000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(27,'Introduction to Databases',10,NULL,'Learn the basics of databases, including SQL and data management.',449000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(28,'Getting Started with Cloud Computing',10,NULL,'An introductory course on cloud computing concepts and platforms.',499000,NULL,NULL,'https://img.freepik.com/free-psd/engraved-black-logo-mockup_125540-223.jpg'),(31,'Yasuo',1,NULL,'sdafas4657890[-213123123',300000,NULL,NULL,'https://res.cloudinary.com/dteetn5a5/image/upload/v1724171789/tixgtz2zkvufihavdwbc.png');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `url` text NOT NULL,
  `course_id` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_document_id_idx` (`course_id`),
  CONSTRAINT `course_document_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  `completed_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `progress` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id_idx` (`course_id`),
  KEY `student_course_idx` (`student_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `student_course` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `status` tinyint DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_assignment_idx` (`course_id`),
  CONSTRAINT `course_assignment` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `course_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `lecturecol` varchar(45) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_lecture_idx` (`course_id`),
  CONSTRAINT `course_lecture` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES (1,'Giới thiệu về Python','Bài học này giới thiệu ngôn ngữ lập trình Python, bao gồm cú pháp cơ bản và các ứng dụng của nó.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=_uQrJ0TkZlc'),(2,'Cài đặt và thiết lập Python','Hướng dẫn từng bước cách cài đặt Python trên các hệ điều hành khác nhau.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=YYXdXT2l-Gg'),(3,'Các kiểu dữ liệu trong Python','Tìm hiểu về các kiểu dữ liệu khác nhau trong Python như int, float, string và list.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=khKv-8q7YmY'),(4,'Cấu trúc điều khiển trong Python','Tổng quan về các cấu trúc điều khiển trong Python như câu lệnh if và vòng lặp.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=6iF8Xb7Z3wQ'),(5,'Hàm trong Python','Bài học này hướng dẫn cách định nghĩa và sử dụng hàm trong Python để tổ chức mã lệnh.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=NSbOtYzIQI0'),(6,'Làm việc với danh sách và từ điển','Tìm hiểu cách thao tác với danh sách (list) và từ điển (dictionary) trong Python để lưu trữ và quản lý dữ liệu.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=daefaLgNkw0'),(7,'Lập trình hướng đối tượng trong Python','Giới thiệu về các khái niệm lập trình hướng đối tượng trong Python, bao gồm lớp và đối tượng.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=JeznW_7DlB0'),(8,'Xử lý tệp tin trong Python','Bài học này sẽ dạy cách đọc và ghi tệp tin bằng Python.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=Uh2ebFW8OYM'),(9,'Modules và Packages trong Python','Tìm hiểu về modules và packages trong Python, và cách import và sử dụng chúng trong dự án của bạn.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=CqvZ3vGoGs0'),(10,'Xử lý lỗi trong Python','Hiểu cách xử lý lỗi và ngoại lệ trong Python để viết mã lệnh bền vững hơn.',1,NULL,NULL,NULL,'https://www.youtube.com/watch?v=NIWwJbo-9_8'),(11,'Giới thiệu về JavaScript','Bài học này sẽ giới thiệu về ngôn ngữ lập trình JavaScript, bao gồm lịch sử và các ứng dụng chính của nó.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=upDLs1sn7g4'),(12,'Cài đặt môi trường phát triển JavaScript','Hướng dẫn cách thiết lập môi trường phát triển để bắt đầu viết mã JavaScript.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=q-yGGn4dTyk'),(13,'Cú pháp cơ bản của JavaScript','Tìm hiểu về cú pháp cơ bản trong JavaScript như khai báo biến, câu lệnh điều kiện, và vòng lặp.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=W6NZfCO5SIk'),(14,'Hàm trong JavaScript','Hướng dẫn cách định nghĩa và sử dụng hàm trong JavaScript để tái sử dụng mã lệnh.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=9emXNzqCKyg'),(15,'Làm việc với mảng (array) trong JavaScript','Bài học này giới thiệu cách tạo và thao tác với mảng trong JavaScript.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=hefbDRqj-Fk'),(16,'Lập trình hướng đối tượng trong JavaScript','Giới thiệu về lập trình hướng đối tượng trong JavaScript, bao gồm các khái niệm về đối tượng, lớp và kế thừa.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=PFmuCDHHpwk'),(17,'DOM (Document Object Model) trong JavaScript','Tìm hiểu cách sử dụng JavaScript để thao tác với DOM, từ đó thay đổi nội dung và kiểu dáng của trang web.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=wiozYyXQEVk'),(18,'Sự kiện (Event) trong JavaScript','Hướng dẫn cách xử lý các sự kiện trong JavaScript như click, hover, và submit.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=RqQ1d1qEWlE'),(19,'AJAX và Fetch API trong JavaScript','Bài học này sẽ giới thiệu cách sử dụng AJAX và Fetch API để thực hiện các yêu cầu HTTP không đồng bộ.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=PoRJizFvM7s'),(20,'Xử lý lỗi và gỡ lỗi trong JavaScript','Tìm hiểu cách xử lý lỗi và gỡ lỗi mã JavaScript để đảm bảo ứng dụng hoạt động mượt mà.',2,NULL,NULL,NULL,'https://www.youtube.com/watch?v=H_7T0k65y8Y'),(21,'Giới thiệu về Java','Bài học này giới thiệu về ngôn ngữ lập trình Java, lịch sử và các ứng dụng chính của nó.',3,NULL,NULL,NULL,'https://www.youtube.com/watch?v=eIrMbAQSU34'),(22,'Cài đặt môi trường phát triển Java','Hướng dẫn cài đặt JDK và thiết lập môi trường để phát triển ứng dụng Java.',3,NULL,NULL,NULL,'https://www.youtube.com/watch?v=IJ-PJbvJBGs'),(23,'Cú pháp cơ bản của Java','Tìm hiểu về cú pháp cơ bản trong Java như khai báo biến, câu lệnh điều kiện và vòng lặp.',3,NULL,NULL,NULL,'https://www.youtube.com/watch?v=grEKMHGYyns'),(24,'Hàm và phương thức trong Java','Hướng dẫn cách định nghĩa và sử dụng hàm (phương thức) trong Java để tổ chức mã lệnh.',3,NULL,NULL,NULL,'https://www.youtube.com/watch?v=YmP7iqI_l8s'),(25,'Lập trình hướng đối tượng trong Java','Giới thiệu về lập trình hướng đối tượng trong Java, bao gồm các khái niệm về lớp, đối tượng và kế thừa.',3,NULL,NULL,NULL,'https://www.youtube.com/watch?v=HCj2xgo9alI'),(26,'Giới thiệu về C++','Bài học này giới thiệu về ngôn ngữ lập trình C++, lịch sử và các ứng dụng chính của nó.',4,NULL,NULL,NULL,'https://www.youtube.com/watch?v=vLnPwxZdW4Y'),(27,'Cài đặt môi trường phát triển C++','Hướng dẫn cài đặt trình biên dịch và thiết lập môi trường để phát triển ứng dụng C++.',4,NULL,NULL,NULL,'https://www.youtube.com/watch?v=1W4oyuOdXv8'),(28,'Cú pháp cơ bản của C++','Tìm hiểu về cú pháp cơ bản trong C++ như khai báo biến, câu lệnh điều kiện và vòng lặp.',4,NULL,NULL,NULL,'https://www.youtube.com/watch?v=mUQZ1qmKlLY'),(29,'Hàm và hàm thành viên trong C++','Hướng dẫn cách định nghĩa và sử dụng hàm trong C++ để tổ chức mã lệnh.',4,NULL,NULL,NULL,'https://www.youtube.com/watch?v=fkRyt9KUBI0'),(30,'Lập trình hướng đối tượng trong C++','Giới thiệu về lập trình hướng đối tượng trong C++, bao gồm các khái niệm về lớp, đối tượng và kế thừa.',4,NULL,NULL,NULL,'https://www.youtube.com/watch?v=xnqTKD8uD64');
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `course_id` int NOT NULL,
  `feedback` text,
  `score` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_rate_idx` (`course_id`),
  KEY `user_rate_idx` (`user_id`),
  CONSTRAINT `course_rate` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `user_rate` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `exercise_id` int NOT NULL,
  `student_id` int NOT NULL,
  `content` text NOT NULL,
  `score` int DEFAULT NULL,
  `feedback` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exercise_idx` (`exercise_id`),
  KEY `student_exercise_idx` (`student_id`),
  CONSTRAINT `exercise` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`id`),
  CONSTRAINT `student_exercise` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(45) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'DHThanh','123456','ROLE_TEACHER','Dương Hữu Thành',NULL,'thanhduong123@gmail.com',NULL,'male',NULL,NULL,NULL),(7,'ThanhNTN','123456','ROLE_TEACHER','Nguyễn Thị Ngọc Thanh',NULL,'ngocthanh@gmail.com',NULL,'female',NULL,NULL,NULL),(8,'NgVan7','123456','ROLE_TEACHER','Nguyễn Văn Bảy',NULL,'NVBay@gmail.com',NULL,'male',NULL,NULL,NULL),(9,'NgocTran','123456','ROLE_TEACHER','Trần Ngọc Trân',NULL,'NgocTran@gmail.com',NULL,'female',NULL,NULL,NULL),(10,'NghiaDeepTry','123456','ROLE_TEACHER','NghiaDepTrai','1234567890','NghiaDepTraiPro123',NULL,'male','2024-08-22 19:51:32',NULL,NULL),(11,'NamDepTrai','123456','ROLE_TEACHER','Nam Ekko','1234567890','Nam12345@gmail.com',NULL,'male','2024-08-22 19:57:31',NULL,NULL),(12,'nam1609','123456','ROLE_STUDENT','Nam Lại','123456','nam1609@gmail.com',NULL,'male',NULL,NULL,NULL),(13,'nghiaaaaa','123','ROLE_STUDENT','Huỳnh Trọng Nghĩa','123456','nghia@example.com',NULL,'male',NULL,NULL,NULL),(26,'nghiaadmin123','$2a$10$Q3Scx42nygMtQXmIemy0WOYNUk3hT/9dHi2ReHgZEhZtizB.CNT/K','ROLE_ADMIN','Huá»³nh NghÄ©a','123456789','nghiaadmin@example.com',NULL,'male','2024-08-23 23:02:05',NULL,NULL),(27,'namadmin123','$2a$10$5PqpDPiD3wlwmOQTQaDHe.9uLjSjq.nefPsF9wd/qrFN2ot5j3SDK','ROLE_ADMIN','Láº¡i Nam','12345678','namadmin@example.com',NULL,'male','2024-08-23 23:02:43',NULL,NULL),(28,'Æ°qer','12324421','teacher','Huá»³nh Trá»ng NghÄ©a','12345678','nghia22102002@gmail.com',NULL,'Nam','2024-08-25 16:14:43',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 19:48:06
