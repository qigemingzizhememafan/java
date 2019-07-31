package com.lzl.search_everything.core.interceptor;

import java.io.File;

// 拦截器(或处理器)我们从磁盘上读到了大量的文件，
// 我们现在要做的是把它转换成Things并写入数据库
// 但可能在以后的应用中，我们要对这些文件进行别的操作(打印之类的)
// 因此建立该接口
@FunctionalInterface
public interface FileInterceptor {
    void apply(File file);
}
