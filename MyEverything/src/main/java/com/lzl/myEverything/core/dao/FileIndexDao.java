package com.lzl.myEverything.core.dao;

import com.lzl.myEverything.core.mudel.Condition;
import com.lzl.myEverything.core.mudel.Thing;

import java.sql.Connection;
import java.util.List;

/**
 * 数据索引的访问层，即数据库访问的对象
 */
public interface FileIndexDao {
    // 我们需要把Java的File对象抽象成Thing对象
    // 再把Thing存到我们数据库的表中(table)，变成一条条的记录(record)

    /**
     * 插入
     */
    void insert(Thing thing);

    /**
     * 查询
     */
    List<Thing> query(Condition condition);

    /**
     * 删除
     */
    void delete(Thing thing);


}
