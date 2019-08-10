package com.lzl.mySearchEverything.core.model;

import lombok.Data;
import lombok.Getter;

/**
 * 检索条件：按名字，按文件类型，对结果进行限制
 * 如对文件深度限制，对文件输出序列进行处理(按某个条件升序或降序输出)
 */
@Data
public class Condition {

    private String name;

    private String file_type;

    private Integer limit;

    // true -- 升序处理
    // false -- 降序处理
    private Boolean orderByAsc;


}
