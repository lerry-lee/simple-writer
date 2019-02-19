
create database writer1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use writer1;

create table HttpRequestInfo(
  id int primary key auto_increment,
  date varChar(200),
  url varCHar(200),
  method char(4),
  ip char(15),
  param varChar(200),
  status int,
  timeConsuming int
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table UserInfo(
id int primary key auto_increment,
username varchar(20),
password varchar(20)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table Report(
id int primary key auto_increment,
username varchar(20)  unique,
content text
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table Visits(
id int primary key auto_increment,
username varchar(20)  unique,
times int
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;