BaseDao类中定义了连接mysql的方法，运行前请修改用户名和密码，并建立所需的数据库和表


create database writer1;

use writer1;

create table HttpRequestInfo(
  Id int primary key auto_increment,
  Date varChar(200),
  Url varCHar(200),
  Method char(4),
  Ip char(15),
  Param varChar(200),
  Status int,
  TimeConsuming int
);