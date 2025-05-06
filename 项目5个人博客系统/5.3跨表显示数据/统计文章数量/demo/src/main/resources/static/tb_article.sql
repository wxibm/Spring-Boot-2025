-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydata
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `tb_article`
--

DROP TABLE IF EXISTS `tb_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `article_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `article_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `article_id_UNIQUE` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article`
--

LOCK TABLES `tb_article` WRITE;
/*!40000 ALTER TABLE `tb_article` DISABLE KEYS */;
INSERT INTO `tb_article` VALUES (1,'静夜思','床前明月光，疑是地上霜。举头望明月，低头思故乡。',1),(2,'早发白帝城','朝辞白帝彩云间，千里江陵一日还。两岸猿声啼不住，轻舟已过万重山。',1),(3,'黄鹤楼送孟浩然之广陵','故人西辞黄鹤楼，烟花三月下扬州。孤帆远影碧空尽，唯见长江天际流。',1),(4,'望庐山瀑布','日照香炉生紫烟，遥看瀑布挂前川。飞流直下三千尺，疑是银河落九天。',1),(5,'临江仙·夜饮东坡醒复醉','夜饮东坡醒复醉，归来仿佛三更。家童鼻息已雷鸣。敲门都不应，倚杖听江声。长恨此身非我有，何时忘却营营。夜阑风静縠纹平。小舟从此逝，江海寄余生。',2),(6,'水调歌头·黄州快哉亭赠张偓佺','落日绣帘卷，亭下水连空。知君为我新作，窗户湿青红。长记平山堂上，欹枕江南烟雨，杳杳没孤鸿。认得醉翁语，山色有无中。一千顷，都镜净，倒碧峰。忽然浪起，掀舞一叶白头翁。堪笑兰台公子，未解庄生天籁，刚道有雌雄。一点浩然气，千里快哉风。',2),(7,'苏幕遮·怀旧','碧云天，黄叶地，秋色连波，波上寒烟翠。山映斜阳天接水，芳草无情，更在斜阳外。黯乡魂，追旅思，夜夜除非，好梦留人睡。明月楼高休独倚，酒入愁肠，化作相思泪。',2),(8,'桂枝香·金陵怀古','登临送目，正故国晚秋，天气初肃。千里澄江似练，翠峰如簇。归帆去棹残阳里，背西风，酒旗斜矗。彩舟云淡，星河鹭起，画图难足。念往昔，繁华竞逐，叹门外楼头，悲恨相续。千古凭高对此，谩嗟荣辱。六朝旧事随流水，但寒烟衰草凝绿。至今商女，时时犹唱，后庭遗曲。',2),(9,'天净沙 秋思','枯藤老树昏鸦，小桥流水人家，古道西风瘦马。夕阳西下，断肠人在天涯。',3),(10,'骤雨打新荷','绿叶阴浓，遍池亭水阁，偏趁凉多。海榴初绽，朵朵簇红罗。乳燕雏莺弄语，有高柳鸣蝉相和。骤雨过，似琼珠乱撒，打遍新荷。人生百年有几，念良辰美景，休放虚过。穷通前定，何用苦张罗。命友邀宾玩赏，对芳樽浅酌低歌。且酩酊，任他两轮日月，来往如梭。',3),(11,'折桂令 拟张鸣善','草茫茫秦汉陵阙，世代兴亡，却便似月影圆缺。山人家堆案图书，当窗松桂，满地薇蕨。侯门深何须刺谒？白云自可怡悦。到如今世事难说，天地间不见一个英雄，不见一个豪杰！',3),(12,'咏柳','碧玉妆成一树高，万条垂下绿丝绦。不知细叶谁裁出，二月春风似剪刀。',1);
/*!40000 ALTER TABLE `tb_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_article_class`
--

DROP TABLE IF EXISTS `tb_article_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_article_class` (
  `article_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`article_class_id`),
  UNIQUE KEY `article_class_id_UNIQUE` (`article_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article_class`
--

LOCK TABLES `tb_article_class` WRITE;
/*!40000 ALTER TABLE `tb_article_class` DISABLE KEYS */;
INSERT INTO `tb_article_class` VALUES (1,'唐诗'),(2,'宋词'),(3,'元曲'),(4,'散文'),(5,'小说');
/*!40000 ALTER TABLE `tb_article_class` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 16:25:29
