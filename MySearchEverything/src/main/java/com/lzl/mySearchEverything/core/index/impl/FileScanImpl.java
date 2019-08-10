package com.lzl.mySearchEverything.core.index.impl;

import com.lzl.mySearchEverything.config.MySearchEverythingConfig;
import com.lzl.mySearchEverything.core.index.FileScan;
import com.lzl.mySearchEverything.core.interceptor.FileInterceptor;
import java.io.File;
import java.util.LinkedList;

public class FileScanImpl implements FileScan {

    private MySearchEverythingConfig config = MySearchEverythingConfig.getInstance();
    private LinkedList<FileInterceptor> interceptors = new LinkedList<>();

    @Override
    public void index(String path) {
        File file = new File(path);

        // file是文件，就不能看这个路径是否是被排除的路径
        // 而是看它上层路径是否被排除
        if(file.isFile()){
            if(config.getExcludePath().contains(file.getParent())){
                return;
            }
        }else{
            if(config.getExcludePath().contains(path)){
                return;
            }else{
                File[] files = file.listFiles();
                if(files != null){
                    for(File f : files){
                        index(f.getAbsolutePath());
                    }
                }
            }
        }
        for(FileInterceptor fileInterceptor : this.interceptors){
            fileInterceptor.apply(file);
        }
    }

    @Override
    public void iterator(FileInterceptor interceptor) {
        this.interceptors.add(interceptor);
    }

}
