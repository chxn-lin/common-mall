package com.chxn.mall.order.dao;

import com.chxn.mall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:57:12
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}
