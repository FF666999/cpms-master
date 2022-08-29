package com.cpms.single.modules.lowcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.lowcode.dto.TableColumnDTO;
import com.cpms.single.modules.lowcode.entity.TableColumnEntity;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:41
 */
public interface ITableColumnService extends IService<TableColumnEntity> {
    List<TableColumnEntity> listTableColumn(TableColumnDTO tableColumnDTO);

    boolean addTableColumn(TableColumnDTO tableColumnDTO);

    boolean updaTetableColumn(TableColumnDTO tableColumnDTO);

    boolean delTableColumn(TableColumnDTO tableColumnDTO);
}
