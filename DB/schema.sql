# DB 생성
DROP DATABASE IF EXISTS jspboard;
CREATE DATABASE jspboard;

# DB 선택
USE jspboard;

# 게시물 테이블 생성
CREATE TABLE article (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	memberId INT(10) UNSIGNED NOT NULL,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(200) NOT NULL,
	content LONGTEXT NOT NULL
);

# 회원 테이블 생성
CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(100) NOT NULL UNIQUE,
	loginPw CHAR(100) NOT NULL,
	`name` CHAR(100) NOT NULL,
	email CHAR(100) NOT NULL UNIQUE
);

# 회원 테이블 데이터 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = '1234',
`name` = '관리자',
email = 'admin@test.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = '1234',
`name` = '유저1',
email = 'user1@test.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = '1234',
`name` = '유저2',
email = 'user2@test.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user3',
loginPw = '1234',
`name` = '유저3',
email = 'user3@test.com';

# 테스트 게시물 데이터 생성
INSERT INTO article
SET memberId = 2,
regDate = NOW(),
updateDate = NOW(),
title = '제목1',
content = '내용1';

INSERT INTO article
SET memberId = 2,
regDate = NOW(),
updateDate = NOW(),
title = '제목2',
content = '내용2';

INSERT INTO article
SET memberId = 2,
regDate = NOW(),
updateDate = NOW(),
title = '제목3',
content = '내용3';

# 랜덤하게 테스트 데이터 생성
INSERT INTO article(memberId, regDate, updateDate, title, content)
SELECT 2,
NOW(),
NOW(),
CONCAT('제목-', FLOOR(RAND() * 100)),
CONCAT('내용-', FLOOR(RAND() * 100))
FROM article;