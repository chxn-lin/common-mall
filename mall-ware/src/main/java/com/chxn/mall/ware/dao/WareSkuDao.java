package com.chxn.mall.ware.dao;

import com.chxn.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:56:01
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
