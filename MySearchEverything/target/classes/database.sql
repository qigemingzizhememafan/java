create database if not exists my_searcheverything;
drop table file_index if exists;
create table if not exists file_index(
  name varchar(256) not null comment '文件名称',
  path varchar(1024) not null comment '文件路径',
  depth int default 0 comment '文件深度',
  file_type varchar(32) not null comment '文件类型'
);
