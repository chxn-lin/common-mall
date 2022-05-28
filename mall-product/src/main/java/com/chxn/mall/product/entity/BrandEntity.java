package com.chxn.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.chxn.common.valid.ListValue;
import com.chxn.common.valid.groups.AddGroupInterface;
import com.chxn.common.valid.groups.UpdateGroupInterface;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 品牌
 * 
 * @author linshuncai
 * @email chxn_lin@163.com
 * @date 2022-05-15 09:54:24
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@NotNull(message = "不为空！", groups = {UpdateGroupInterface.class})
	@Null(message = "必须为空！", groups = {AddGroupInterface.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌的名称不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "logo不能为空")
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(val = {0, 1}, groups = {AddGroupInterface.class, UpdateGroupInterface.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	private String firstLetter;
	/**
	 * 排序
	 */
	private Integer sort;

}
