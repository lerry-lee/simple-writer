
create database writer1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use writer1;

create table UserInfo(
id int primary key auto_increment,
username varchar(16),
password varchar(16)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table Report(
id int primary key auto_increment,
username varchar(16)  unique,
content text
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table Visits(
id int primary key auto_increment,
usersign varchar(16)  unique,
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;