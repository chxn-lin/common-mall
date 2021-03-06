package com.chxn.mall.order.dao;

import com.chxn.mall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:57:12
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
