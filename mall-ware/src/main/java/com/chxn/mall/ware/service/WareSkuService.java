package com.chxn.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chxn.common.utils.PageUtils;
import com.chxn.mall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:56:01
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

