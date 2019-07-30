-- 不再需要创建数据库了，因为H2这种嵌入式数据库已经帮我们生成了个文件，我们的内容就在那里存着
-- 创建数据库表
drop table if exists file_index;
create table if not exists file_index(
  name varchar(256) not null comment '文件名称',
  path varchar(1024) not null comment '文件路径',
  depth int not null comment '文件路径深度',
  file_type varchar(32) not null comment '文件类型'
);
