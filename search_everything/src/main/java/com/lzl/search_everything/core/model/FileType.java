package com.lzl.search_everything.core.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * FileType模型类表示文件的扩展类归类
 */
public enum FileType {
    IMG("jpg","jpeg","png","bmp","gif"),
    DOC("doc","docx","pdf","ppt","pptx","xls"),
    BIN("exe","jar","sh","msi","shell"),
    ARCHIVE("zip","rar"),
    OTHER("*");

    // 不允许重复
    // 存储扩展名
    private Set<String> extend = new HashSet<>();
    FileType(String...extend){
        this.extend.addAll(Arrays.asList(extend));
    }

    // 根据文件扩展名获取文件类型
    public static FileType lookupFileType(String extend){
        for(FileType fileType:FileType.values()){
            if(fileType.extend.contains(extend)){
                return  fileType;
            }
        }
        return FileType.OTHER;
    }

    // 根据文件类型找到文件扩展名
    public static FileType lookupByName(String name){
        for(FileType fileType:FileType.values()){
            if(fileType.name().equals(name)){
                return fileType;
            }
        }
        return FileType.OTHER;
    }

    public static void main(String[] args) {
        System.out.println(FileType.lookupFileType("png"));
        System.out.println(FileType.lookupFileType("java"));
        System.out.println(FileType.lookupByName("jpg"));
    }
}
