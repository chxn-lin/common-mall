package com.chxn.mall.product.dao;

import com.chxn.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 09:54:24
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
