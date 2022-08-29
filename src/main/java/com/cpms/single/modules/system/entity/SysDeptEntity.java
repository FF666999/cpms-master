package com.cpms.single.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cpms.framework.mybatis.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/20 17:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("cpms_system_dept")
public class SysDeptEntity extends TenantEntity {
    /**
     *  指定自增策略
     */
    @TableId(value = "dept_id",type = IdType.ASSIGN_ID)
    private Long deptId;
    private String deptName;
    private Long parentId;
    private String deptDesc;
    private Integer deptSort;
}
