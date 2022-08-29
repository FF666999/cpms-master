package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.system.dto.QueryMenuDTO;
import com.cpms.single.modules.system.dto.SysMenuDTO;
import com.cpms.single.modules.system.entity.SysMenuEntity;
import com.cpms.single.modules.system.vo.SysMenuVO;
import com.cpms.single.modules.system.vo.SysRouteVO;

import java.util.List;


/**
 * @author gulang
 * @Description:
 * @time: 2021/8/7 20:51
 */
public interface ISysMenuService extends IService<SysMenuEntity> {
    SysRouteVO leftMenu(Long topMenuId);

    boolean addMenu(SysMenuDTO sysMenuDTO);

    boolean updateMenu(SysMenuDTO sysMenuDTO);

    boolean deleteMenu(SysMenuDTO sysMenuDTO);

    List<SysMenuVO> listMenu(QueryMenuDTO listMenuDTO);

    List<SysMenuVO> userOwnedMenus();
    List<SysMenuVO> tenantOwnedMenus();
    List<SysMenuVO> selectMenuByTenantId(Long tenantId);
}
