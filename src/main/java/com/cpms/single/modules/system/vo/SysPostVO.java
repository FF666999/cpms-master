package com.cpms.single.modules.system.vo;

import com.cpms.framework.common.core.base.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/27 14:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPostVO extends BaseVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long postId;
    private String postName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tenantId;
    private String postDesc;
    private String postCode;
    private Integer postSort;
}
