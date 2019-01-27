
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
