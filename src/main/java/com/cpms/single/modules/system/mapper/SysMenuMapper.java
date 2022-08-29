package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryMenuDTO;
import com.cpms.single.modules.system.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gulang
 * @Description:
 * @time: 2021/8/7 20:50
 */
@DS("master")
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
    List<SysMenuEntity> queryRoleMenusOrButtons(@Param("list") List<Long> roleIds, @Param("type") Integer type);

    int listMenuCount(QueryMenuDTO listMenuDTO);

    List<SysMenuEntity> listMenu(QueryMenuDTO listMenuDTO);
}
