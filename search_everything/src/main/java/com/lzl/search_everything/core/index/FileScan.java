package com.lzl.search_everything.core.index;

import com.lzl.search_everything.core.dao.DataSourceFactory;
import com.lzl.search_everything.core.dao.impl.FileIndexDaoImpl;
import com.lzl.search_everything.core.index.impl.FileScanImpl;
import com.lzl.search_everything.core.interceptor.FileInterceptor;
import com.lzl.search_everything.core.interceptor.impl.FileIndexInterceptor;
import com.lzl.search_everything.core.interceptor.impl.FilePrintInterceptor;
import com.lzl.search_everything.core.model.Things;

public interface FileScan {
    // 遍历Path
    void index(String path);

    // 遍历的拦截器
    void interceptor(FileInterceptor interceptor);

    public static void main(String[] args) {
        DataSourceFactory.initDatabase();
        FileScan scan = new FileScanImpl();
        FileInterceptor printInterceptor = new FilePrintInterceptor();
        scan.interceptor(printInterceptor);
        FileInterceptor fileInterceptor = new FileIndexInterceptor((new
                FileIndexDaoImpl(DataSourceFactory.dataSource())));
        scan.interceptor(fileInterceptor);
        scan.index("D\\MATLAB");

    }
}
