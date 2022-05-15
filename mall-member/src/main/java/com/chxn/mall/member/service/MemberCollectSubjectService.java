package com.chxn.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chxn.common.utils.PageUtils;
import com.chxn.mall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 16:54:44
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

