package com.lzl.search_everything.core.model;

import lombok.Data;

//@lombok.Setter
//@lombok.Getter
@Data  // getter setter toString生成完成
public class Things {
    /**
     * 文件名称（不含路径）
     * File D:/a/b/hello.txt  --> hello.txt
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件路径深度
     */
    private Integer depth;

    /**
     * 文件类型
     */
    private FileType fileType;

}
