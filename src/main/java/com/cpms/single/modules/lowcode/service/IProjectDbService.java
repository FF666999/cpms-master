package com.cpms.single.modules.lowcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.lowcode.dto.ProjectDbDTO;
import com.cpms.single.modules.lowcode.entity.ProjectDbEntity;
import com.cpms.single.modules.lowcode.vo.ProjectDbVO;

import java.util.List;


/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:39
 */
public interface IProjectDbService extends IService<ProjectDbEntity> {
    List<ProjectDbVO> listProjectDb(Long projectId);

    boolean addProjectDb(ProjectDbDTO projectDbDTO);

    boolean updateProjectDb(ProjectDbDTO projectDbDTO);

    boolean delProjectDb(ProjectDbDTO projectDbDTO);

}
