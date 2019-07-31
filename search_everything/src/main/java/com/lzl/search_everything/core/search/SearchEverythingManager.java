package com.lzl.search_everything.core.search;

import com.lzl.search_everything.config.searchEverythingConfig;
import com.lzl.search_everything.core.index.FileScan;
import com.lzl.search_everything.core.model.Condition;
import com.lzl.search_everything.core.model.Things;

import java.util.List;
import java.util.Set;

public class SearchEverythingManager {
    private final FileSearch fileSearch;
    private final FileScan fileScan;

    public SearchEverythingManager(FileSearch fileSearch, FileScan fileScan) {
        this.fileSearch = fileSearch;
        this.fileScan = fileScan;
    }

    /**
     * 检索
     */
    public List<Things> search(Condition condition){
        // 待扩展
        return this.fileSearch.search(condition);
    }

    /**
     * 索引
     */
    public void buildIndex(){
        // 目录
        Set<String> directories = searchEverythingConfig.getInstance().getIncludePath();
        this.fileScan.index("");
        for(String path:directories){
            new Thread(new Runnable() {
                @Override
                public void run() {
                SearchEverythingManager.this.fileScan.index(path);
                }
            }).start();
        }
    }
}
