package com.lzl.search_everything.core.search.impl;
import com.lzl.search_everything.core.dao.FileIndexDao;
import com.lzl.search_everything.core.model.Condition;
import com.lzl.search_everything.core.model.Things;
import com.lzl.search_everything.core.search.FileSearch;
import java.util.List;

public class FileSearchImpl implements FileSearch {

    private final FileIndexDao fileIndexDao;

    public FileSearchImpl(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }

    @Override
    public List<Things> search(Condition condition) {
        // 数据库的处理逻辑
        return this.fileIndexDao.search(condition);
    }
}
