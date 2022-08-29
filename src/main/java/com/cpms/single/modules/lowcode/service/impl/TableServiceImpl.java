package com.cpms.single.modules.lowcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.single.modules.lowcode.dto.TableDTO;
import com.cpms.single.modules.lowcode.entity.TableEntity;
import com.cpms.single.modules.lowcode.mapper.TableMapper;
import com.cpms.single.modules.lowcode.service.ITableService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:31
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, TableEntity> implements ITableService {
    @Override
    public List<TableEntity> listTable(TableDTO tableDTO) {
        return null;
    }

    @Override
    public boolean addTable(TableDTO tableDTO) {
        return false;
    }

    @Override
    public boolean updateTable(TableDTO tableDTO) {
        return false;
    }

    @Override
    public boolean delTable(TableDTO tableDTO) {
        return false;
    }
}
