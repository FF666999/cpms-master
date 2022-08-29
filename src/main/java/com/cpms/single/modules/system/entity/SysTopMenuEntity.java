package com.cpms.single.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cpms.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/30 13:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("cpms_system_top_menu")
public class SysTopMenuEntity extends BaseEntity {
    /**
     *  指定自增策略
     */
    @TableId(value = "top_menu_id",type = IdType.ASSIGN_ID)
    private Long topMenuId;
    private Long userId;
    private String topMenuName;
    private String relationMenuIds;
    private String path;
    private Integer sort;
    private Integer type;
    private String icon;
}
