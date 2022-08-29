package com.cpms.single.modules.system.dto;

import com.cpms.framework.mybatis.groups.AddGroup;
import com.cpms.framework.mybatis.groups.DeleteGroup;
import com.cpms.framework.mybatis.groups.OtherGroup;
import com.cpms.framework.mybatis.groups.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/23 15:14
 */
@Data
public class SysTopMenuDTO {
    @NotNull(message="topMenuId不能为空",groups = {UpdateGroup.class, DeleteGroup.class,OtherGroup.class})
    private Long topMenuId;

    @NotBlank(message="topMenuName不能为空",groups = {UpdateGroup.class, AddGroup.class})
    @NotNull(message="topMenuName不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private String topMenuName;

    @NotBlank(message="icon不能为空",groups = {UpdateGroup.class, AddGroup.class})
    @NotNull(message="icon不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private String icon;

    @NotBlank(message="relationMenuIds不能为空",groups = {OtherGroup.class})
    @NotNull(message="relationMenuIds不能为空",groups = {OtherGroup.class})
    private String relationMenuIds;

    @NotNull(message="type不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private Integer type;

    private String path;

    @NotNull(message="sort不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private Integer sort;
}
