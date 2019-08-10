package com.lzl.mySearchEverything.core.index;

import com.lzl.mySearchEverything.core.interceptor.FileInterceptor;

import java.io.File;
import java.util.List;

/**
 * 此处索引我们只是遍历所有文件
 * 并不对索引得到的结果直接处理
 * 当我们拿到这些结果时，可能会对这些结果做各种各样的操作
 * 因此我们引入一个中间接口：拦截器接口，专门应用这些得到的文件
 */
public interface FileScan {
    // 遍历文件
    void index(String path);

    // 遍历拦截器
    void iterator(FileInterceptor interceptor);

}
