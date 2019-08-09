package com.lzl.myEverything.core.mudel;

import lombok.Data;

/**
 * 要在数据库中保存的文件的信息
 */
@Data
public class Thing {

    // 文件名，不含路径
    private String name;

    // 文件路径
    private String path;

     // 文件路径深度
    private Integer depth;

    // 文件类型
    private FileType fileType;

}
