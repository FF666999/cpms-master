package com.cpms.single.modules.lowcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.lowcode.dto.ProjectDetailDTO;
import com.cpms.single.modules.lowcode.dto.QueryProjectDTO;
import com.cpms.single.modules.lowcode.entity.ProjectEntity;
import com.cpms.single.modules.lowcode.vo.ProjectDetailVO;


/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:33
 */
public interface IProjectService extends IService<ProjectEntity> {
    BasePageVO<ProjectDetailVO> listProject(QueryProjectDTO queryProjectDTO);

    boolean addProject(ProjectDetailDTO projectDTO);

    boolean updateProject(ProjectDetailDTO projectDTO);

    boolean delProject(ProjectDetailDTO projectDTO);
}
