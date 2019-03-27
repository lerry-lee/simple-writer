
create database writer1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use writer1;

-- 用户表
create table User(
id int primary key auto_increment,
username varchar(16),
password varchar(16)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 学术写作报告表
create table Report(
id int primary key auto_increment,
username varchar(16)  unique,
content text
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 访问量表
create table Visits(
id int primary key auto_increment,
sign varchar(16)  unique,
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 帖子表
CREATE TABLE posts(
id int primary key auto_increment,
username varchar(16),
sdate varchar(10),
category varchar(30),
dianzan int,
content text,
title varchar(80)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 评论表
create table comments(
id int primary key auto_increment,
sid int,
comment text,
cdate varchar(10),
foreign key (sid) references share(id) on delete cascade
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 建议表
create table contact(
id int primary key auto_increment,
useranme VARCHAR(16),
name varchar(32),
email varchar(32),
comments text
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;