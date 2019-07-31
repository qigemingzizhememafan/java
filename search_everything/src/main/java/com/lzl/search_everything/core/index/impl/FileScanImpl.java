package com.lzl.search_everything.core.index.impl;

import com.lzl.search_everything.config.searchEverythingConfig;
import com.lzl.search_everything.core.dao.DataSourceFactory;
import com.lzl.search_everything.core.dao.impl.FileIndexDaoImpl;
import com.lzl.search_everything.core.index.FileScan;
import com.lzl.search_everything.core.interceptor.FileInterceptor;
import com.lzl.search_everything.core.interceptor.impl.FileIndexInterceptor;
import com.lzl.search_everything.core.interceptor.impl.FilePrintInterceptor;

import java.io.File;
import java.util.LinkedList;

public class FileScanImpl implements FileScan {
    // DAO
    private searchEverythingConfig config = searchEverythingConfig.getInstance();

    private LinkedList<FileInterceptor> interceptors = new LinkedList<>();

    // 扫描遍历
    @Override
    public void index(String path) {
        File file = new File(path);
        System.out.println(file.toString());
//        List<File> fileList = new ArrayList<>();
        // 是文件
        if(file.isFile()){
            // D:\c\d\f.pdf 如果父目录与我们要排除的目录相等，抛弃该文件
            if(config.getExcludePath().contains(file.getPath())){
                return;
           }
//           else{
//                fileList.add(file);
//            }
        }else {  // 是目录
            if (config.getExcludePath().contains(path)) {
                return;
            } else {
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        String ppath=f.getAbsolutePath();
                        System.out.println(ppath);
                        index(ppath);
                    }
                }
            }
        }
            // File Directory 对文件和目录都建索引
            for(FileInterceptor interceptor : this.interceptors){
                interceptor.apply(file);
            }

        }

    @Override
    public void interceptor(FileInterceptor interceptor) {
        this.interceptors.add(interceptor);
    }
//        // 把上面读取到的文件变成things，写入数据库
//        for(File f : fileList){
//            // File -> things
//
//        }



    // 测试file能否直接到达interceptor，测试通过
//    public static void main(String[] args) {
//        FileScanImpl scan = new FileScanImpl();
//        FileInterceptor printInterceptor = new FilePrintInterceptor();
//        scan.interceptor(printInterceptor);
//        FileIndexInterceptor fileIndexInterceptor = new
//                FileIndexInterceptor(new FileIndexDaoImpl(DataSourceFactory.dataSource()));
//        scan.interceptor(fileIndexInterceptor);
//        scan.index("D:\\MATLAB代码");
//    }
}
