package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.system.dto.QueryPostDTO;
import com.cpms.single.modules.system.dto.SysPostDTO;
import com.cpms.single.modules.system.entity.SysPostEntity;
import com.cpms.single.modules.system.vo.SysPostVO;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/27 14:21
 */
public interface ISysPostService extends IService<SysPostEntity> {
    BasePageVO<SysPostVO> listPost(QueryPostDTO listPostDTO);
    boolean addPost(SysPostDTO postDTO);
    boolean deletePost(SysPostDTO postDTO);
    boolean updatePost(SysPostDTO postDTO);
}
