package com.cpms.single.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.framework.common.utils.CsBeanUtil;
import com.cpms.framework.common.utils.CsSecureUtil;
import com.cpms.single.common.constants.SystemConstant;
import com.cpms.single.modules.system.dto.SysTopMenuDTO;
import com.cpms.single.modules.system.entity.SysTopMenuEntity;
import com.cpms.single.modules.system.mapper.SysTopMenuMapper;
import com.cpms.single.modules.system.service.ISysTopMenuService;
import com.cpms.single.modules.system.vo.SysTopMenuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/30 14:07
 */
@Service
public class SysTopMenuServiceImpl extends ServiceImpl<SysTopMenuMapper, SysTopMenuEntity> implements ISysTopMenuService {
    @Resource
    private SysTopMenuMapper sysTopMenuMapper;


    @Override
    public List<SysTopMenuVO> getTopMenu() {
        return listTopMenu();
    }

    @Override
    public boolean deleteTopMenu(SysTopMenuDTO sysTopMenuDTO) {
        LambdaUpdateWrapper<SysTopMenuEntity> updateWrapper = Wrappers.<SysTopMenuEntity>lambdaUpdate()
                .set(SysTopMenuEntity::getDelFlag, SystemConstant.DEL_FLAG_DELETED)
                .eq(SysTopMenuEntity::getUserId,CsSecureUtil.getUser().getUserId())
                .eq(SysTopMenuEntity::getTopMenuId,sysTopMenuDTO.getTopMenuId());
        return this.update(updateWrapper);
    }

    @Override
    public boolean addTopMenu(SysTopMenuDTO sysTopMenuDTO) {
        SysTopMenuEntity sysTopMenuEntity = new SysTopMenuEntity();
        CsBeanUtil.copyProperties(sysTopMenuDTO,sysTopMenuEntity);
        sysTopMenuEntity.setUserId(CsSecureUtil.getUser().getUserId());
        return this.save(sysTopMenuEntity);
    }

    @Override
    public boolean updateTopMenu(SysTopMenuDTO sysTopMenuDTO) {
        LambdaUpdateWrapper<SysTopMenuEntity> updateWrapper = Wrappers.<SysTopMenuEntity>lambdaUpdate()
                .set(SysTopMenuEntity::getTopMenuName, sysTopMenuDTO.getTopMenuName())
                .set(SysTopMenuEntity::getPath, sysTopMenuDTO.getPath())
                .set(SysTopMenuEntity::getSort, sysTopMenuDTO.getSort())
                .set(SysTopMenuEntity::getType, sysTopMenuDTO.getType())
                .set(SysTopMenuEntity::getIcon, sysTopMenuDTO.getIcon())
                .eq(SysTopMenuEntity::getUserId,CsSecureUtil.getUser().getUserId())
                .eq(SysTopMenuEntity::getTopMenuId,sysTopMenuDTO.getTopMenuId());
        return this.update(new SysTopMenuEntity(),updateWrapper);
    }

    @Override
    public List<SysTopMenuVO> listTopMenu() {
        QueryWrapper<SysTopMenuEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("del_flag", SystemConstant.DEL_FLAG_NOT_DELETED);
        wrapper.eq("user_id",CsSecureUtil.getUser().getUserId());
        List<SysTopMenuEntity> sysTopMenuEntities = sysTopMenuMapper.selectList(wrapper);
        return convertTopMenuToVo(sysTopMenuEntities);
    }

    @Override
    public boolean configTopMenu(SysTopMenuDTO sysTopMenuDTO) {
        LambdaUpdateWrapper<SysTopMenuEntity> updateWrapper = Wrappers.<SysTopMenuEntity>lambdaUpdate()
                .set(SysTopMenuEntity::getRelationMenuIds, sysTopMenuDTO.getRelationMenuIds())
                .eq(SysTopMenuEntity::getUserId,CsSecureUtil.getUser().getUserId())
                .eq(SysTopMenuEntity::getTopMenuId,sysTopMenuDTO.getTopMenuId());
        return this.update(updateWrapper);
    }

    private List<SysTopMenuVO> convertTopMenuToVo(List<SysTopMenuEntity> sysTopMenuEntities){
        List<SysTopMenuVO> topMenuList;
        topMenuList = sysTopMenuEntities.stream().map(e->{
            SysTopMenuVO sysTopMenuVO = new SysTopMenuVO();
            sysTopMenuVO.setSort(e.getSort());
            sysTopMenuVO.setTopMenuId(e.getTopMenuId());
            sysTopMenuVO.setTopMenuName(e.getTopMenuName());
            sysTopMenuVO.setPath(e.getPath());
            sysTopMenuVO.setCreateTime(e.getCreateTime());
            sysTopMenuVO.setUpdateTime(e.getUpdateTime());
            sysTopMenuVO.setCreateBy(e.getCreateBy());
            sysTopMenuVO.setUpdateBy(e.getUpdateBy());
            sysTopMenuVO.setRelationMenuIds(e.getRelationMenuIds());
            sysTopMenuVO.setType(e.getType());
            sysTopMenuVO.setIcon(e.getIcon());
            return  sysTopMenuVO;
        }).sorted(Comparator.comparing(SysTopMenuVO::getSort).reversed()).collect(Collectors.toList());
        return topMenuList;
    }
}
