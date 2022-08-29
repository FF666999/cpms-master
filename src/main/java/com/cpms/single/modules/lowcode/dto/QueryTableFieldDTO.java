package com.cpms.single.modules.lowcode.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author gulang
 * @Description:
 * @time: 2022/2/18 14:52
 */
@Data
@Builder
public class QueryTableFieldDTO {
    private List<String> tableNames;
    private String dbName;
    private Long dbId;
}
