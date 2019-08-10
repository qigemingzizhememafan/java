package com.lzl.mySearchEverything.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum FileType {
    IMG("png","jpg","gif","jpeg"),
    DOC("ppt","pptx","doc","docx","pdf"),
    BIN("exe","sh","jar","msi"), // sh:linux/unix的脚本文件 msi:windows installer的数据包
    ARCHIVE("zip","rar"),
    OTHER("*");

    // 每个对象都有自己的Set，不同的对象，不同的new
    Set<String> extend = new HashSet<>();

    // 枚举就像一个高级的多例模式，每一个枚举对象就是一个类的不同对象
    // 每一个对象中的所有扩展名组成它的构造方法的参数
    FileType(String ... extendName){
        this.extend.addAll(Arrays.asList(extendName));
    }

    // 根据文件扩展名拿到文件类型
    public static FileType lookupTypeByExtend(String extendName){
        // 遍历FileType的对象，找到匹配的文件类型
        for(FileType fileType : FileType.values()){
            if(fileType.extend.contains(extendName)){
                return fileType;
            }
        }
        return OTHER;
    }

    // 根据枚举对象的名字，拿到这个名字所对应的对象
    // 有了对象就可以使用那些扩展名之类的属性了
    public static FileType lookupTypeByName(String name){
        for(FileType fileType : FileType.values()){
            if(fileType.name().equals(name)){
                return fileType;
            }
        }
        return FileType.OTHER;
    }
//   测试代码，已通过
//    public static void main(String[] args) {
//        System.out.println(lookupTypeByExtend("gif"));
//        System.out.println(lookupTypeByExtend("pdf"));
//        System.out.println(lookupTypeByExtend("jar"));
//        System.out.println(lookupTypeByExtend("zip"));
//        System.out.println(lookupTypeByExtend("C"));
//        System.out.println(lookupTypeByName("IMG"));
//        System.out.println(lookupTypeByName("DOC"));
//        System.out.println(lookupTypeByName("BIN"));
//        System.out.println(lookupTypeByName("ARCHIVE"));
//        System.out.println(lookupTypeByName("HH"));
//    }
}
