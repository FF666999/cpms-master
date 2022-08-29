package com.cpms.single.modules.lowcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.single.modules.lowcode.dto.TableColumnDTO;
import com.cpms.single.modules.lowcode.entity.TableColumnEntity;
import com.cpms.single.modules.lowcode.mapper.TableColumnMapper;
import com.cpms.single.modules.lowcode.service.ITableColumnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:42
 */
@Service
public class TableColumnServiceImpl extends ServiceImpl<TableColumnMapper, TableColumnEntity> implements ITableColumnService {
    @Override
    public List<TableColumnEntity> listTableColumn(TableColumnDTO tableColumnDTO) {
        return null;
    }

    @Override
    public boolean addTableColumn(TableColumnDTO tableColumnDTO) {
        return false;
    }

    @Override
    public boolean updaTetableColumn(TableColumnDTO tableColumnDTO) {
        return false;
    }

    @Override
    public boolean delTableColumn(TableColumnDTO tableColumnDTO) {
        return false;
    }
}
