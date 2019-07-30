package com.lzl.search_everything.core.model;

import lombok.Data;

/**
 * Condition：检索条件的模型类型
 */
@Data
public class Condition {
    private String name;
    private String fileType;
    // 限制搜索得到的文件数量
    private Integer limit;
    /**
     * 检索结果的文件信息depth排列规则
     * 默认是true --> asc
     * false --> 降序
     */
    private boolean orderByAsc;
}
