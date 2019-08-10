package com.lzl.mySearchEverything.core.search;

import com.lzl.mySearchEverything.core.model.Condition;
import com.lzl.mySearchEverything.core.model.Thing;

import java.util.List;

/**
 * 检索文件:根据Condition条件进行检索
 */
public interface FileSearch {
    List<Thing> search(Condition condition);
}
