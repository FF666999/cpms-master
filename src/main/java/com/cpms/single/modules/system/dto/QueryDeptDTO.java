package com.cpms.single.modules.system.dto;

import com.cpms.framework.common.core.base.BasePageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/23 10:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryDeptDTO extends BasePageDTO {
    private String deptName;
    private Long tenantId;
    private String tenantName;
}
