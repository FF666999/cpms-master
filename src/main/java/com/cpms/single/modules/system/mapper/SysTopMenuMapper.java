package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.entity.SysTopMenuEntity;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/30 14:03
 */
@DS("master")
public interface SysTopMenuMapper extends BaseMapper<SysTopMenuEntity> {
}
