package com.cpms.single.modules.system.vo;

import com.cpms.framework.common.core.node.BaseTreeNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gulang
 * @Description:
 * @time: 2021/10/10 18:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTreeVO extends BaseTreeNode<DeptTreeVO> {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;
    private String deptName;
}
