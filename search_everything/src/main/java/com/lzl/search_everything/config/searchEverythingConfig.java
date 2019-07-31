package com.lzl.search_everything.config;

import lombok.Getter;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * 配置类
 * 筛选掉不想遍历的文件
 */
@Getter // 不给Setter权限，防止被修改
public class searchEverythingConfig {

   private static volatile searchEverythingConfig config;

   // 文件路径不能重复，选Set

    /**
     * 建立索引的路径
     */
   private Set<String> includePath = new HashSet<>();
    /**
     * 排除索引的路径
     */
   private Set<String> excludePath = new HashSet<>();

   private searchEverythingConfig(){

   }

   public static searchEverythingConfig getInstance(){
       if(config == null){
           synchronized (searchEverythingConfig.class){
               if(config == null){
                   config = new searchEverythingConfig();
                   // 遍历的目录
                   //1,获取文件系统 --- 读取电脑中有几个硬盘
                  FileSystem fileSystem =  FileSystems.getDefault();
                  Iterable<Path> iterable = fileSystem.getRootDirectories();
                  iterable.forEach(path -> config.includePath.add(path.toString()));
                   // 排除的目录
                   // windows下的: c:\Windows C:\Program Files(x86)
                   // C:\Program Files C:\ProgramData  C:\Drivers
                   // Linux下的：/tmp  /etc
                   String osname = System.getProperty("os.name");
                   if(osname.startsWith("Windows")){
                       config.getExcludePath().add("c:\\Windows");
                       config.getExcludePath().add("C:\\Program Files(x86)");
                       config.getExcludePath().add("C:\\Program Files");
                       config.getExcludePath().add("C:\\ProgramData");
                       config.getExcludePath().add("C:\\Drivers");
                   }else{
                       config.getExcludePath().add("/tmp");
                       config.getExcludePath().add("/etc");
                       config.getExcludePath().add("/root");
                       config.getExcludePath().add("/boot");
                   }
               }
           }
       }
       return config;
   }
    // 测试遍历文件，测试正确
//    public static void main(String[] args) {
//        searchEverythingConfig config = searchEverythingConfig.getInstance();
//        System.out.println(config.getIncludePath());
//        System.out.println(config.getExcludePath());
//    }
}
