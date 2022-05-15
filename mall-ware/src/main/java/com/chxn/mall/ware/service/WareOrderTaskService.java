package com.chxn.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chxn.common.utils.PageUtils;
import com.chxn.mall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:56:02
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

