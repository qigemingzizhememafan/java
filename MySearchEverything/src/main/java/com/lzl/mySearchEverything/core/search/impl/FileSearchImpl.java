package com.lzl.mySearchEverything.core.search.impl;

import com.lzl.mySearchEverything.core.dao.FileIndexDao;
import com.lzl.mySearchEverything.core.dao.impl.FileIndexDaoImpl;
import com.lzl.mySearchEverything.core.model.Condition;
import com.lzl.mySearchEverything.core.model.Thing;
import com.lzl.mySearchEverything.core.search.FileSearch;

import java.util.ArrayList;
import java.util.List;


public class FileSearchImpl implements FileSearch {
    // 这是业务层，我们希望它只是去使用检索和索引，不希望它直接与数据库产生关系
    // 因此我们通过Dao层来实现具体功能，并直接与数据库打交道
    private FileIndexDao fileIndexDao;

    public FileSearchImpl(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }

    @Override
    public List<Thing> search(Condition condition) {
        if (condition == null) {
            return new ArrayList<>();
        }
        return this.fileIndexDao.search(condition);
    }
}
