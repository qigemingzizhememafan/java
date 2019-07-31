package com.lzl.search_everything.core.interceptor.impl;

import com.lzl.search_everything.core.common.FileConverThings;
import com.lzl.search_everything.core.dao.FileIndexDao;
import com.lzl.search_everything.core.interceptor.FileInterceptor;
import com.lzl.search_everything.core.model.Things;

import java.io.File;

public class FileIndexInterceptor implements FileInterceptor {
    private final FileIndexDao fileIndexDao;

    public FileIndexInterceptor(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }

    @Override
    public void apply(File file) {
        Things things = FileConverThings.convert(file);
        fileIndexDao.insert(things);
    }
}
