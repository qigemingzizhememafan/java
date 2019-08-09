package com.lzl.myEverything.core.mudel;

import lombok.Getter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * FileType模型类表示文件的扩展名归类
 */
public enum FileType {
    IMG("jpg", "jpeg", "png", "bmp", "gif"),
    DOC("pdf", "docx", "doc", "ppt", "pptx", "xls", "xlsx", "txt"),
    BIN("exe", "jar", "sh", "msi", "shell"),
    ARCHIVE("zip", "rar"),
    OTHER("*");

    // 保存枚举对象的扩展名
    // Set不允许元素重复
    // 为什么不用TreeSet???
    // ???占位符？？？
    private Set<String> extend = new HashSet<>();

    FileType(String... extend) {
        // 数组转集合？？哪来的数组
        this.extend.addAll(Arrays.asList(extend));
    }

    // 根据文件扩展名获取文件类型
    // values()：返回枚举对象的对象数组
    public static FileType lookupFileTypeByExtend(String extend) {
        for (FileType fileType : FileType.values()) {
            if (fileType.extend.contains(extend)) {
                return fileType;
            }
        }
        return FileType.OTHER;
    }

    // 根据FileType的名字找FileType
    // FileType.name 就是那些 IMG，DOC，BIN之类的
    public static FileType lookupFileTypeByName(String name) {
        for (FileType fileType : FileType.values()) {
            if (fileType.name().equals(name)) {
                return fileType;
            }
        }
        return FileType.OTHER;
    }
}








    // 测试上面两个方法
//    public static void main(String[] args) {
//        //System.out.println(lookupTypeByEntend("jar"));
//        for (FileType fileType : FileType.values()) {
//            for (String name : fileType.extend) {
//                System.out.println(name);
//            }
//        }
//
//        for (String name : IMG.extend) {
//            System.out.println(name);
//        }
//    }
//}
