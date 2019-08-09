-- 数据库脚本文件
-- 这里我们不需要自己再创建数据库了，H2这种内嵌数据库已经帮我们生成了一个本地文件
-- 数据库中的内容就在那里保存着

create database everything_g2;
use everything_g2;
drop table if exists thing;
create table if not exists thing(
  name varchar(64) not null comment '文件名称',
  path varchar(1024) not null comment '文件路径',
  depth int default 0 comment '文件深度',
  file_type varchar(10) not null comment '文件类型'
);