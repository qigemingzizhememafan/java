package com.lzl.mySearchEverything.core.model;

import lombok.Data;

// 文件信息抽象成Thing类，存储在数据库上
@Data
public class Thing {

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件深度
     */
    private Integer depth;

    /**
     * 文件类型
     */
    private FileType fileType;
}
