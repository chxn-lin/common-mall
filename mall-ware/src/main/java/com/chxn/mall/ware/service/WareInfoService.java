package com.chxn.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chxn.common.utils.PageUtils;
import com.chxn.mall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:56:02
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

