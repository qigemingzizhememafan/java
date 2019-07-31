package com.lzl.search_everything.core.dao;

import com.lzl.search_everything.core.model.Condition;
import com.lzl.search_everything.core.model.Things;
import java.util.List;

/**
 * 业务层访问数据库的CRUD
 */
public interface FileIndexDao {
    // 插入
    // 建立索引
    void insert(Things things);
    List<Things> search(Condition condition);
}
