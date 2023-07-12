-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: gamedb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'jeff','12345'),(2,'john','67890'),(3,'ken','77777'),(4,'jason','66666'),(5,'bay','99887');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_description`
--

DROP TABLE IF EXISTS `game_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_description` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ch_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `en_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dev_yaer` int(11) DEFAULT NULL,
  `description` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_description`
--

LOCK TABLES `game_description` WRITE;
/*!40000 ALTER TABLE `game_description` DISABLE KEYS */;
INSERT INTO `game_description` VALUES ('G001','臥龍：蒼天隕落','Wo Long: Fallen Dynasty',2023,'是光榮特庫摩推出的以中國歷史中的三國時代為背景的歷史奇幻類動作角色扮演遊戲，講述的是時值公元184年，東漢末年，身為義勇兵的主人公在征討黃巾軍的途中偶然邂逅了一位少年，並從此被捲入了陰謀重重的亂世之中]。'),('G002','零～濡鴉之巫女～','Fatal Frame: Maiden of Black Water',2014,'是日式心理恐怖遊戲系列零的第五作，「日上山」自古以來就被視為靈場而受到崇拜，其周邊地區有著特殊的信仰傳承。在這座山上「水」被視為御靈體，而有著「人生而自水，亦自水歸還」的輪迴觀念。為此，人們相信若是「欲迎向死亡者」造訪此山，並在碰觸此山之水時臨終，將能獲得正式的死亡。'),('G003','隻狼：暗影雙死','Sekiro: Shadows Die Twice',2019,'是由From Software開發與動視發行，於2019年3月22日發售的動作冒險遊戲。本作的總監為宮崎英高，遊戲背景設定在日本戰國時代末期，在名為「葦名國」的架空舞台展開。講述忍者隻狼從葦名武士手上拯救其主人之經歷。'),('G004','暗黑破壞神 4 ','Diablo IV',2023,'是暴雪娛樂開發的一款大型線上多人動作角色扮演遊戲，該作為《暗黑破壞神系列》的第四部作品。遊戲於2019年11月1日舉辦的暴雪嘉年華開幕式上正式公布，於2023年6月5日發行。'),('G005','霍格華茲的傳承','Hogwarts Legacy',2023,'是由艾薇嵐奇軟體開發、港口鑰遊戲發行的開放世界動作角色扮演遊戲。該遊戲以魔法世界為背景，並基於J·K·羅琳所創作的《哈利波特》系列小說改編。設定於19世紀，玩家可以選擇自己的霍格華茲學院，並在霍格華茲魔法與巫術學院上課，並且展開冒險。'),('G006','惡靈古堡 4 重製版 ','Resident Evil 4',2022,'是一款由卡普空開發及發行的第三人稱射擊恐怖遊戲。本作是2005年《惡靈古堡4》的重製作品。描述主角里昂·史考特·甘乃迪某日奉命到西班牙某村莊營救被拐去的總統女兒愛旭莉·葛拉漢。到達該處後里昂發現所有村民皆與他敵對，且在對抗時發現他們效忠於一個名為光明教團的邪教團體。因此里昂最嚴苛的冒險就此展開。'),('G007','零～月蝕的假面～','Fatal Frame: Mask of the Lunar Eclipse',2008,'是特庫摩出品的恐怖生存遊戲零系列的第四作，故事講述島上的五名少女在舉行這一儀式時神秘失蹤，雖然後來她們都被刑警找到，但無一例外地都失去了相關的記憶，為了調查此事，餘下的三人中，意志堅定的麻生海咲在月森圓香的陪同下來到朧月島；而本作的主角水無月流歌為了找回失去的記憶，也在海咲和圓香之後踏上了朧月島的地界'),('G008','閃電風暴 大型電玩年表','Ray\'z Arcade Chronology',2023,'本作是以遙遠的未來為背景的飛行射擊遊戲，收錄了《閃電風暴》系列的街機版三部曲《RAYFORCE》、《RAYSTORM》和《RAYCRISIS》移植的作品，並追加收錄《RAYSTORM NEO-HD》和《RAYCRISIS HD》兩款高解析度版的移植作品。'),('G009','雷電 III x MIKADO MANIAX ','RAIDEN III × MIKADO MANIAX',2023,'《雷電》系列是由 1990 年首部上市的捲軸射擊遊戲，因簡單的操作方法與戰鬥後的產生的碎片殘骸以點陣圖方式呈現獲得玩家好評，《雷電 III》和《雷電 IV》是系列中首部 3D 化作品。'),('G010','人中之龍 維新！極','Like a Dragon : ishin',2023,'這次的故事描述幕府末期，從「黑船來航」到「大政奉還」時代的故事，玩家飾演的是歷史上對該時代有重要影響的鄉士「坂本龍馬」。描述他為了找出殺害如同父親的兇手，來到京都調查「天念理心流」，進而以「齋藤一」的假名加入親幕府派的武裝集團「新選組」，調查兇手並捲入更大事件的故事。'),('G011','航海王 時光旅詩','One Piece Odyssey',2023,'航海途中遭遇猛烈暴風雨的草帽一行人，漂流至一座山林蓊鬱被暴風雨包圍的神秘小島「瓦弗洛德」。大夥在島上遇見厭惡海賊的少女莉姆，她擁有特殊力量，可以在觸碰時奪走所碰對象的能力。於是眾人不慎被奪走的力量化為魂晶，四散到整座島上。但也因為少女，草帽一行人得以回到「記憶中的場所」，'),('G012','西部魔域','Evil West',2022,'以吸血鬼威脅西部為舞台的《西部魔域（Evil West）》，故事描述黑暗威脅吞噬了美國的邊疆地帶。玩家身為機密吸血鬼獵殺組織中最後幾名成員之一，在深沉恐懼從幽影中現身之際，只有玩家能守護人類。如今你必須挺身而出，成為狂野西部的超級英雄，剷除吸血鬼的威脅，拯救美國。'),('G013','戰神：諸神黃昏','God of War: Ragnarök',2022,'該遊戲為「戰神系列」第九部作品以及2018年《戰神》的續作，與前作一樣以北歐神話為基礎，古代挪威為背景。故事主題將圍繞使北歐神話終結的「諸神黃昏」。'),('G014','索尼克 未知邊境','Sonic Frontiers',2022,'在索尼克和他的朋友們在蟲洞中失散後，玩家將扮演索尼克，探索星落群島並收集混沌翡翠。在『索尼克 未知邊境』中，玩家能夠以索尼克特有的超音速動作在廣闊的島嶼中隨心所欲奔馳，這是一款自由自在的嶄新動作冒險遊戲。'),('G015','世界越野冠軍賽 Generations','WRC Generations',2022,'2022 年 WRC 將過渡到混合動力時代。這對拉力賽世界來說是一場革命，顯著影響性能、改變策略，並使駕駛和車隊適應。在遊戲玩法方面，新機制已整合成代表混合動力引擎的需求。為了取勝，你必須在所參加的特別賽段中，藉由調整引擎計畫，謹慎管理電池。'),('G016','惡靈古堡 8：村莊 黃金版','Resident Evil Village Golden Edition',2022,'故事的主角是伊森的女兒蘿絲‧溫徹斯。故事敘述長大成人的蘿絲，終日為了她身上強大的菌主之力所苦，不只是身上不時會有類似菌絲的分泌物，也時常能看到常人看不見的幻象。而在某日克里斯的隊友老牙找上了她，並告訴她根據米蘭達的筆記，他們發現了一個能去除菌主力量的神祕道具「淨化水晶」。但想要找到進一步的線索，蘿絲必須親自深入菌絲網路追查米蘭達的記憶。'),('G017','決勝時刻：現代戰爭 II ','Call of Duty: Modern Warfare II',2022,'是由Infinity Ward開發，由動視暴雪發行的第一人稱射擊遊戲。本作是《決勝時刻》系列第19部主要作品，為「現代戰爭」系列重啓《決勝時刻：現代戰爭》的續作，《決勝時刻：現代戰爭II 2022》為決勝時刻的遊戲玩法帶來了幾處巨大的變化，已經更新了一些新的變化，例如運動和合作模式中的先進人工智慧系統、水物理和游泳力學，以及大修的車輛系統。槍匠系統也進行了改造，允許玩家微調特定附件以適應他們的遊戲風格。'),('G018','英雄傳說 黎之軌跡 II','The Legend of Heroes Kuro no Kiseki：Crimson Sin',2023,'更加進化的共和國篇新章節，將以「軌跡」系列最新作品之姿登場！從原野戰鬥無縫銜接至指令戰鬥的獨特戰鬥系統，以及根據玩家採取的行動使LAW／GRAY／CHAOS參數變動的LGC陣營要素等 前作『英雄傳說 黎之軌跡』的優點在本作中都獲得承襲與改進，提供更舒適的遊玩體驗與更爽快的遊戲系統！'),('G019','星海遊俠 6：神授之力','Star Ocean: The Divine Force',2022,'由SQUARE ENIX和tri-Ace Inc.聯手打造的RPG 「 STAR OCEAN」系列最新作品。本作特點有立體的移動與探索 視線可及之處皆為冒險範圍以及擁有系列作中最快、最強動作系統的STAR OCEAN，無論是冒險還是戰鬥，都將帶來前所未有的自由體驗。玩家在天地間自由翱翔的同時還可享受爽快且富有挑戰性的戰鬥體驗。'),('G020','女神戰記 極樂淨土','Valkyrie Elysium',2022,'《女神戰記 極樂淨土》為「女神戰記」系列的最新作品，以北歐神話為主題，並用獨特的世界觀描繪了「人類的死亡」和「諸神的存在」。桜庭統的眾多名曲將為以精緻畫質呈現的全新「女神戰記」的世界錦上添花。而且本作還是該系列的第一款動作 RPG，戰鬥不僅保留了玩家熟悉的必殺技和連擊系統等，也進化得更加立體且速度感十足。'),('G021','瑪利歐賽車8 豪華版','Mario Kart 8',2017,'《瑪利歐賽車8》是一款賽車競速遊戲，玩家操作瑪利歐系列與其他任天堂遊戲角色進行賽車比賽。玩家可於場地上使用道具強化能力或阻礙對手。遊戲可選擇四種不同的難度，差異在於賽車移動的速度。「鏡像模式」可以反方向遊玩選擇的賽道。本作的特點為新增的「反重力模式」，玩家在特定賽道可於牆壁或上下顛倒的賽道中行駛，在反重力的區域中，玩家與其他玩家或障礙物碰撞時會使車輛加速。'),('G022','集合啦！動物森友會','Animal Crossing: New Horizons',2020,'本作是一款由任天堂企劃製作本部開發並由任天堂發行在任天堂Switch上的生活模擬遊戲。本作是動物森友會系列的第7款作品，也是系列首次繁體中文化和第二次簡體中文化，在遊戲，玩家可以蒐集樹枝、石頭、罐子等材料做出許多道具，使用「方程式」可以學習更多道具的製作。這些道具都有各自的功能，例如釣竿可以釣魚，玩家可以透過道具來捕捉各式魚類、海洋生物、昆蟲和採集化石，捕獲到的物品可以選擇販賣、製作傢俱/料理、用以裝飾或是捐贈給博物館。'),('G023','任天堂明星大亂鬥 特別版','Super Smash Bros. Ultimate',2018,'是一款由萬代南夢宮開發，並由任天堂發行於任天堂Switch平台上的格鬥遊戲。本作是任天堂明星大亂鬥系列的第五部作品，也是系列首次繁體中文化和第二次簡體中文化。本作最大的特色是集結了系列過往所有曾出現過的可遊玩角色，並在原有系統基礎新增加「命魂」系統，允許玩家在操控主要角色時使用「命魂」角色輔助玩家。'),('G024','薩爾達傳說 曠野之息','The Legend of Zelda: Breath of the Wild',2017,'本作是一款動作冒險遊戲，由任天堂企劃製作本部開發，任天堂於2017年發行在任天堂Switch和Wii U主機，為薩爾達傳說系列遊戲的第十八部。玩家在遊戲中操縱主角林克在世界中探索，從而擊敗災厄加儂，恢復被滅亡的海拉魯王國。'),('G025','寶可夢 劍／盾','Pokémon Sword & Shield',2019,'本作是由GAME FREAK開發，寶可夢公司與任天堂發行，並在任天堂Switch平台上發售的角色扮演遊戲，屬於寶可夢系列第八世代，也是令和時期的第一作主要遊戲，本作的冒險的舞台是以英國大不列顛島為原型的「伽勒爾地區」，主角與鄰居赫普在得到伽勒爾地區的冠軍丹帝的推薦信後，與各自的寶可夢展開冒險，並朝著成為當地的寶可夢訓練家比賽冠軍的目標而展開故事。'),('G026','超級瑪利歐 奧德賽','Super Mario Odyssey',2017,'本作是一款由任天堂企劃製作本部開發並由任天堂發行在任天堂Switch平台上的平台遊戲。本作是超級瑪利歐系列第7款3D平台遊戲[1]，也是系列睽違15年繼承《超級瑪利歐64》以及《超級瑪利歐陽光》高自由度的「箱庭探索3D瑪利歐」。故事為瑪利歐為了阻止碧姫公主和庫巴的婚禮，從蘑菇王國出走，和搭檔凱比一起前往未知的國家，發動投擲帽子等新能力，驅使「附身」能力到處奔走。'),('G027','寶可夢 朱／紫','Pokémon Scarlet & Violet',2022,'是一款由GAME FREAK開發，寶可夢公司與任天堂發行，並在任天堂Switch平台上發售的角色扮演遊戲，屬於寶可夢系列第九世代。在《寶可夢 朱／紫》中，玩家扮演橘子學院或葡萄學院的學生，並參加學院舉辦的尋寶活動。該活動鼓勵學生向外探索，尋找「寶物」。主角遇見失去戰鬥能力的傳說寶可夢故勒頓或密勒頓，該寶可夢會成為玩家的坐騎。之後玩家需進行三個故事：冠軍之路、星塵之路和傳說之路，以此展開冒險。'),('G028','超級瑪利歐派對','Super Mario Party',2018,'是由NDcube開發，任天堂發行的聚會遊戲。於2018年10月5日在任天堂Switch平台發售。本作是瑪利歐派對系列第十一部主遊戲，也是首次加入線上「聯網競獎」模式的作品。本作為瑪利歐派對系列中首次提供在線多人模式的作品。玩家可在該「聯網競獎」（Online Athlon）模式中與全球玩家遊玩80款遊戲。此外，在Mariothon模式中，玩家可參加5款隨機迷你遊戲。'),('G029','薩爾達無雙 災厄啟示錄','Hyrule Warriors: Age of Calamity',2020,'是一款任天堂Switch平台的無雙遊戲，本作與2014年的《薩爾達無雙》一樣，作為一款衍生作品，將任天堂的薩爾達傳說系列的世界觀和角色與光榮特庫摩的無雙系列的玩法結合在一起。《薩爾達無雙 災厄啟示錄》的背景設定在《薩爾達傳說 曠野之息》的100年前，林克和薩爾達公主必須在整個海拉魯集結盟友，抵禦邪惡的災厄加儂所領導的勢力，而災厄加儂正試圖重振旗鼓，摧毀海拉魯王國。'),('G030','健身環大冒險','Ring Fit Adventure',2019,'本遊戲最大的特點是伴隨推出的配件「健身環」（Ring-Con）；環內有擠壓感測器以感測玩家的動作，玩家需要將任天堂Switch的控制器Joy-Con拆下並分別安裝到Ring-Con和腿部固定帶上，並通過玩家自身的運動在遊戲中打敗怪獸。遊戲內以回合制角色扮演的冒險模式為主，玩家需要使用Ring-Con和腿部固定帶配合遊戲中的動作要求擊敗怪獸和闖關。此外遊戲也包含了健身小遊戲和健身鍛鍊的其他模式。'),('G031','精靈寶可夢 Let\'s Go！皮卡丘／Let\'s Go！伊布','Pokémon Let\'s Go, Pikachu! and Let\'s Go, Eevee!',2018,'是一款由GAME FREAK製作，任天堂發行的任天堂Switch角色扮演遊戲。遊戲採用系統上向《Pokémon GO》靠攏，取消了系列正統RPG作品中可以在野外與野生寶可夢戰鬥的設定，將僅可捕捉野生的寶可夢，並只能與訓練家進行戰鬥；此外遊戲將可以與《Pokémon GO》聯動，玩家可以將《Pokémon GO》中的第一世代寶可夢傳送到本作中。'),('G032','寶可夢 晶燦鑽石／明亮珍珠','Pokémon Brilliant Diamond & Shining Pearl',2021,'由ILCA開發，寶可夢公司發行，並在任天堂Switch平台上發售的角色扮演遊戲。本作是《寶可夢 鑽石／珍珠》的重製版，本作由日本開發商ILCA負責製作，為系列首度非GAME FREAK製作的本傳遊戲，並由ILCA的植田祐一及《寶可夢 鑽石／珍珠》的總監增田順一共同執導。'),('G033','寶可夢傳說 阿爾宙斯','Pokémon Legends Arceus',2022,'是一款由GAME FREAK開發，寶可夢公司發行，並在任天堂Switch平台上發售的動作角色扮演遊戲。故事發生在人類與寶可夢還未生活在一起的遙遠過去，主角作為駐紮在祝慶村的銀河隊的寶可夢調查員，為完成第一本寶可夢圖鑑而前往洗翠地區的各個地方調查，揭開寶可夢的生態之謎。'),('G034','斯普拉遁2','Splatoon 2',2017,'是任天堂開發並發行在任天堂Switch上的第三人稱射擊遊戲。本作時間設定為前作《斯普拉遁》兩年後，一眾角色將各主要建築移師到新的中心區，換上兩位新晉流行歌手報導各項遊戲消息，並有全新店主與轉職的舊老闆售賣各種產品。而在玩家角色抵達中心區的第一天，駐守中心區的大電池鯰魚和其他地區的小電池鯰魚突然如前作般再度消失，而前作負責報導新聞的一名歌手亦告失蹤。另一名歌手這時將玩家引領到不為人知的戰爭前線，期望對方可以在日常輕鬆對戰外，作為對抗組織4號成員破關解難，粉碎邪惡章魚的陰謀，找回一切。'),('G035','路易吉洋樓3','Luigi\'s Mansion 3',2019,'是一款由Next Level Games開發，並由任天堂於2019年10月31日發行於任天堂Switch平台的動作冒險遊戲。本作為《路易吉洋樓》系列的第三部作品。在遊戲中，玩家仍與往常一樣控制角色在洋樓中探險並使用鬼怪吸塵器捕捉鬼魂。但與之不同在於新增了多項角色能力和「傀易吉」模式。'),('G036','薩爾達傳說 王國之淚','The Legend of Zelda: Tears of the Kingdom',2023,'是一款由任天堂企劃製作本部開發並由任天堂發行在任天堂Switch上的開放世界動作冒險遊戲。本作為2017年發售的《薩爾達傳說 曠野之息》的續作，王國之淚在前作曠野之息的基礎上增加多種新玩法，主角林克在獲得勞魯的手臂後獲得許多新技能，遊戲中還新增許多道具與新特性，與林克的新技能組合出許多新玩法。'),('G037','斯普拉遁3','Splatoon 3',2022,'是任天堂於任天堂Switch推出的第三人稱射擊遊戲，本作遊戲舞台為「蠻頹地區」，與前兩作處於「尚興地區」的兩個都市中心截然不同。周遭一片荒漠之中，其核心地帶「蠻頹鎮」的市中心有來自各種時代和文化的建築物混雜在其中，亦是人口密集地區，被稱為「混沌街道」，對應前作《斯普拉遁2》最終祭典的獲勝方關鍵字「混沌」。'),('G038','瑪利歐派對 超級巨星','Mario Party Superstars',2021,'是一款由NDcube開發並由任天堂發行的瑪利歐派對系列作品，與前作不同的是，本作可以通過任天堂Switch的掌機模式和使用實體按鍵操作運行遊戲。本作基於任天堂64的三款瑪利歐派對系列遊戲，並重新製作精選出的100款小遊戲。'),('G039','Nintendo Switch 運動','Nintendo Switch Sports',2022,'是一款由任天堂企劃製作本部開發，任天堂發行於任天堂Switch的體育類電子遊戲，於2022年4月29日發售，支援繁簡中文。本作為Wii Sports系列的第四款作品。遊戲前作是《Wii運動》、《Wii 度假勝地》及《Wii 俱樂部》。'),('G040','魔物獵人 崛起','Monster Hunter Rise',2021,'是一款由卡普空開發並發行在任天堂Switch上的動作角色扮演遊戲。本作是繼《魔物獵人XX》後再度登陸任天堂Switch上的魔物獵人系列作品，與其他《魔物獵人》系列的遊戲一樣，《魔物獵人 崛起》中玩家扮演「獵人」角色，並參與獵殺或捕獲大型魔物的遊戲任務。遊戲中有多種武器、工具和環境來給魔物造成傷害或將其弱化，與此同時避免遭受牠們的攻擊而力盡倒地。成功完成任務後可以獲得從魔物上打掉的部位等戰利品，這些戰利品又能作為原料鍛造新的防具和武器，以便挑戰更強力的魔物，由此形成本遊戲的核心玩法循環。本作中有幾個系列舊作中回歸的魔物，也有一些為《崛起》中新開發的魔物[5]。《崛起》內有《魔物獵人X》和《世界》中的全部14種武器，包括各種類型的劍、盾、棍、弓和槍械等[6]。');
/*!40000 ALTER TABLE `game_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameinfo`
--

DROP TABLE IF EXISTS `gameinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameinfo` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` varchar(32) DEFAULT NULL,
  `developer` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `inchange` date DEFAULT NULL,
  `outchange` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameinfo`
--

LOCK TABLES `gameinfo` WRITE;
/*!40000 ALTER TABLE `gameinfo` DISABLE KEYS */;
INSERT INTO `gameinfo` VALUES ('G001','臥龍：蒼天隕落','PlayStation4/5','角色扮演','KOEI TECMO Games',1250,35,'2022-05-25','2023-04-26'),('G002','零～濡鴉之巫女～','PlayStation4/5','冒險','KOEI TECMO Games',1190,20,'2023-04-09','2023-04-20'),('G003','隻狼：暗影雙死','PlayStation4/5','動作','Form Software',1790,20,'2022-06-02','2022-07-01'),('G004','暗黑破壞神 4 ','PlayStation4/5','角色扮演','Blizzard Entertainment',2219,20,'2023-04-09','2023-04-28'),('G005','霍格華茲的傳承 ','PlayStation4/5','角色扮演','Avalanche',1890,20,'2023-01-06','2023-01-28'),('G006','惡靈古堡 4 重製版 ','PlayStation4/5','動作','CAPCOM',1590,20,'2023-02-09','2023-03-02'),('G007','零～月蝕的假面～','PlayStation4/5','冒險','KOEI TECMO Games',1590,20,'2022-08-08','2022-08-21'),('G008','閃電風暴 大型電玩年表 ','PlayStation4/5','射擊','TAITO',1590,20,'2023-01-09','2023-02-28'),('G009','雷電 III x MIKADO MANIAX ','PlayStation4/5','射擊','Game Center MIKADO',1590,20,'2023-01-06','2023-01-20'),('G010','人中之龍 維新！極 ','PlayStation4/5','動作','SEGA',1590,20,'2023-02-09','2023-02-28'),('G011','航海王 時光旅詩','PlayStation4/5','角色扮演','BANDAI NAMCO Entertainment',1590,20,'2023-05-04','2023-05-16'),('G012','西部魔域','PlayStation4/5','動作','Focus Home Interactive',1890,20,'2022-11-15','2022-12-16'),('G013','戰神：諸神黃昏','PlayStation4/5','動作','Sony interactive Entertainment',1790,20,'2022-11-26','2022-12-20'),('G014','索尼克 未知邊境','PlayStation4/5','動作','SEGA',1290,20,'2022-12-26','2023-01-20'),('G015','世界越野冠軍賽 Generations','PlayStation4/5','策略模擬','Nacon',1290,20,'2022-10-26','2022-11-05'),('G016','惡靈古堡 8：村莊 黃金版','PlayStation4/5','動作','SQUARE ENIX',1490,20,'2022-10-04','2022-10-16'),('G017','決勝時刻：現代戰爭 II ','PlayStation4/5','射擊','Activision',1590,20,'2022-12-01','2022-12-12'),('G018','英雄傳說 黎之軌跡 II ','PlayStation4/5','角色扮演','Falcom',1790,20,'2023-01-25','2023-02-05'),('G019','星海遊俠 6：神授之力','PlayStation4/5','角色扮演','SQUARE ENIX',1790,20,'2023-01-03','2023-01-30'),('G020','女神戰記 極樂淨土','PlayStation4/5','角色扮演','SQUARE ENIX',1790,20,'2023-01-19','2023-01-28'),('G021','瑪利歐賽車8 豪華版','Nintendo Switch','競速','任天堂情報開發本部',1350,20,'2022-08-17','2022-09-01'),('G022','集合啦！動物森友會','Nintendo Switch','生活模擬','任天堂企畫製作本部',1450,20,'2023-01-06','2023-01-11'),('G023','任天堂明星大亂鬥 特別版','Nintendo Switch','動作、格鬥','Sora萬代南夢宮工作室',1290,20,'2023-01-12','2023-01-30'),('G024','薩爾達傳說 曠野之息','Nintendo Switch','動作冒險、動作角色扮演','任天堂企畫製作本部',1650,20,'2023-04-05','2023-04-26'),('G025','寶可夢 劍／盾','Nintendo Switch','角色扮演','GAME FREAK',1390,20,'2023-03-09','2023-03-30'),('G026','超級瑪利歐 奧德賽','Nintendo Switch','平台動作冒險','1-UP工作室任天堂企劃製作本部',1290,20,'2023-02-15','2023-02-28'),('G027','寶可夢 朱／紫','Nintendo Switch','角色扮演','GAME FREAK',1390,20,'2023-03-14','2023-04-01'),('G028','超級瑪利歐派對','Nintendo Switch','聚會','NDcube',1490,20,'2022-12-12','2023-01-23'),('G029','薩爾達無雙 災厄啟示錄','Nintendo Switch','無雙、角色扮演','光榮特庫摩、Omega Force',1650,20,'2023-02-12','2023-03-02'),('G030','健身環大冒險','Nintendo Switch','體育健身、角色扮演','任天堂企畫製作本部',1790,20,'2023-03-06','2023-03-30'),('G031','精靈寶可夢 Let\'s Go！皮卡丘／Let\'s Go！伊布','Nintendo Switch','角色扮演','GAME FREAK',1390,20,'2022-09-09','2022-10-10'),('G032','寶可夢 晶燦鑽石／明亮珍珠','Nintendo Switch','角色扮演','ILCA',1290,20,'2022-05-15','2022-05-20'),('G033','寶可夢傳說 阿爾宙斯','Nintendo Switch','動作角色扮演','GAME FREAK',1590,20,'2023-01-12','2023-01-20'),('G034','斯普拉遁2','Nintendo Switch','第三人稱射擊','任天堂企劃製作本部',1490,20,'2023-02-02','2023-02-14'),('G035','路易吉洋樓3','Nintendo Switch','動作冒險','Next Level Games 任天堂企劃製作本部',1390,20,'2022-07-07','2022-07-30'),('G036','薩爾達傳說 王國之淚','Nintendo Switch','動作冒險、動作角色扮演','Grezzo 任天堂企劃製作本部',1650,20,'2023-05-15','2023-05-16'),('G037','斯普拉遁3','Nintendo Switch','第三人稱射擊','任天堂企劃製作本部',1380,20,'2023-02-10','2023-02-20'),('G038','瑪利歐派對 超級巨星','Nintendo Switch','聚會','NDcube',1290,20,'2022-12-25','2023-01-20'),('G039','Nintendo Switch 運動','Nintendo Switch','體育','任天堂企劃製作本部',1490,20,'2023-01-09','2023-01-20'),('G040','魔物獵人 崛起','Nintendo Switch','動作角色扮演','CAPCOM',1690,20,'2023-02-08','2023-02-21');
/*!40000 ALTER TABLE `gameinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackinghistory`
--

DROP TABLE IF EXISTS `trackinghistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trackinghistory` (
  `id` varchar(30) NOT NULL,
  `user` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `movement` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `gamename` varchar(50) DEFAULT NULL,
  `platform` varchar(30) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `developer` varchar(60) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `inchange` date DEFAULT NULL,
  `outchange` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackinghistory`
--

LOCK TABLES `trackinghistory` WRITE;
/*!40000 ALTER TABLE `trackinghistory` DISABLE KEYS */;
INSERT INTO `trackinghistory` VALUES ('222',NULL,NULL,NULL,NULL,'PS5','隨便','AAA',555,555,'2022-02-02','2020-02-02'),('G001',NULL,NULL,NULL,NULL,'PlayStation4/5','角色扮演','KOEI TECMO Games',1250,35,'2022-05-25','2023-04-26');
/*!40000 ALTER TABLE `trackinghistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gamedb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-12 14:40:49
