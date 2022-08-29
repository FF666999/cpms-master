package com.cpms.single.modules.system.dto;

import lombok.Data;

/**
 * @author gulang
 * @Description:
 * @time: 2021/9/29 9:51
 */
@Data
public class QueryMenuDTO {
    private String name;
    private String code;
    private String alias;
    private Integer type;
}
