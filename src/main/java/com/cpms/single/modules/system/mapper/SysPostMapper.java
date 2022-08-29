package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryPostDTO;
import com.cpms.single.modules.system.entity.SysPostEntity;
import com.cpms.single.modules.system.vo.SysPostVO;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/27 14:18
 */
@DS("master")
public interface SysPostMapper extends BaseMapper<SysPostEntity> {
    int listPostCount(QueryPostDTO listPostDTO);
    List<SysPostVO> listPost(QueryPostDTO listPostDTO);
}
