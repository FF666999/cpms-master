package com.cpms.single.modules.lowcode.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.framework.common.utils.CsBeanUtil;
import com.cpms.single.modules.lowcode.dto.ProjectDbDTO;
import com.cpms.single.modules.lowcode.entity.ProjectDbEntity;
import com.cpms.single.modules.lowcode.mapper.ProjectDbMapper;
import com.cpms.single.modules.lowcode.service.IProjectDbService;
import com.cpms.single.modules.lowcode.vo.ProjectDbVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:40
 */
@Service
public class ProjectDbServiceImpl extends ServiceImpl<ProjectDbMapper, ProjectDbEntity> implements IProjectDbService {
    @Override
    public List<ProjectDbVO> listProjectDb(Long projectId) {
        List<ProjectDbEntity> projectDbList = this.getBaseMapper()
                .selectList(Wrappers.<ProjectDbEntity>lambdaQuery().eq(ProjectDbEntity::getProjectId, projectId));
        return CsBeanUtil.copyList(projectDbList,ProjectDbVO.class,"dbPassword","dbIpPort","dbUser");
    }

    @Override
    public boolean addProjectDb(ProjectDbDTO projectDbDTO) {
        return false;
    }

    @Override
    public boolean updateProjectDb(ProjectDbDTO projectDbDTO) {
        return false;
    }

    @Override
    public boolean delProjectDb(ProjectDbDTO projectDbDTO) {
        return false;
    }

}
