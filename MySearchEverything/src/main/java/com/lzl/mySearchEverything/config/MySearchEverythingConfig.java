package com.lzl.mySearchEverything.config;

import lombok.Getter;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
@Getter
/**
 * 索引的配置类
 */
public class MySearchEverythingConfig {

    private static volatile MySearchEverythingConfig config;

    // 索引包含的路径
    private Set<String> includePath = new HashSet<>();

    // 索引排除的路径
    private Set<String> excludePath = new HashSet<>();

    // 检索最大的返回数量
    private Integer maxReturn;

    // 深度排序方式:默认升序
    private Boolean deptOrderAsc = true;

    // 设置H2数据库路径
    private String path = System.getProperty("user.dir") + File.separator + "database";

    private MySearchEverythingConfig(){
    }

    public void initDefaultPathConfig(){
        // 1,获取文件系统
        FileSystem fileSystem = FileSystems.getDefault();
        // 2,要遍历的目录:即C\D\E\F盘
        Iterable<Path> iterable = fileSystem.getRootDirectories();
        iterable.forEach(path1 -> config.includePath.add(path.toString()));
        // 3,要排除的目录
        //windows ： C:\Windows C:\Program Files (x86) C:\Program Files  C:\ProgramData
        //linux : /tmp /etc /root
        String osName = System.getProperty("os.name");
        if(osName.startsWith("Windows")){
            config.excludePath.add("C:\\Windows");
            config.excludePath.add("C:\\Program Files (x86)");
            config.excludePath.add("C:\\Program Files");
            config.excludePath.add("C:\\ProgramData");
        }else{
            config.excludePath.add(" /tmp");
            config.excludePath.add(" /etc");
            config.excludePath.add(" /root");
        }
    }

    public static MySearchEverythingConfig getInstance(){
        if(config == null){
            synchronized (MySearchEverythingConfig.class){
                if(config == null){
                    config = new MySearchEverythingConfig();
                    config.initDefaultPathConfig();
                }
            }
        }
        return  config;
    }

    public static void main(String[] args) {
        System.out.println(MySearchEverythingConfig.getInstance().getExcludePath());
    }
}
