package com.lzl.mySearchEverything.core.dao;

import com.lzl.mySearchEverything.core.model.Condition;
import com.lzl.mySearchEverything.core.model.Thing;
import java.util.List;

public interface FileIndexDao {

    /**
     * 插入数据Thing
     *
     * @param thing
     */
    void insert(Thing thing);

    /**
     * 删除数据Thing
     *
     * @param thing
     */
    void delete(Thing thing);

    /**
     * 根据condition条件进行数据库的检索
     *
     * @param condition
     * @return
     */
    List<Thing> search(Condition condition);

}
