package com.lzl.search_everything.core.dao;

import com.lzl.search_everything.core.model.Condition;
import com.lzl.search_everything.core.model.Things;
import java.util.List;

/**
 * 业务层访问数据库
 */
public interface FileIndexDao {
    // 插入
    // 简历索引
    void index(Things things);
}
