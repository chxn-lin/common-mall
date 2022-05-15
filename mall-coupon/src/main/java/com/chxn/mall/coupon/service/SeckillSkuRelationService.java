package com.chxn.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chxn.common.utils.PageUtils;
import com.chxn.mall.coupon.entity.SeckillSkuRelationEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:58:23
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

