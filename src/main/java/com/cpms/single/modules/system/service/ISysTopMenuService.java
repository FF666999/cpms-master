package com.cpms.single.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.system.dto.SysTopMenuDTO;
import com.cpms.single.modules.system.entity.SysTopMenuEntity;
import com.cpms.single.modules.system.vo.SysTopMenuVO;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/30 14:05
 */
public interface ISysTopMenuService extends IService<SysTopMenuEntity> {
   List<SysTopMenuVO> getTopMenu();

   boolean deleteTopMenu(SysTopMenuDTO sysTopMenuDTO);

   boolean addTopMenu(SysTopMenuDTO sysTopMenuDTO);

   boolean updateTopMenu(SysTopMenuDTO sysTopMenuDTO);

   List<SysTopMenuVO> listTopMenu();

   boolean configTopMenu(SysTopMenuDTO sysTopMenuDTO);
}
