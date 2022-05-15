package com.chxn.mall.member.dao;

import com.chxn.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:54:44
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
