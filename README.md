# koscom

CREATE DATABASE koscomdb;

SHOW DATABASES;
CREATE USER 'koscom'@'%' IDENTIFIED BY '!koscom00';
GRANT ALL PRIVILEGES ON koscomdb.* TO 'koscom'@'%';

CREATE TABLE `tb_user` (
	`user_id` VARCHAR(50) NOT NULL COMMENT '아이디',
	`user_nm` VARCHAR(50) NULL COMMENT '이름',
	`addr` VARCHAR(500) NULL COMMENT '주소',
	`cell_phone` VARCHAR(50) NULL COMMENT '핸드폰',
	`agree_inform` VARCHAR(1) NULL DEFAULT 'N' COMMENT '개인정보 동의',
	`birth_dt` VARCHAR(8) NULL COMMENT '생일'
)
;

ALTER TABLE `tb_user`
	ADD PRIMARY KEY (`user_id`);

ALTER TABLE `tb_user`
	CHANGE COLUMN `user_id` `user_id` VARCHAR(50) NULL DEFAULT NULL COMMENT '아이디' FIRST;
	
