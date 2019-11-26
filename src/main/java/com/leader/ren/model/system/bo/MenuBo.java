package com.leader.ren.model.system.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单Bo
 *
 * @author 王泽志
 * date 2018/11/30 16:57
 */
@Data
@ApiModel(value = "菜单请求实体")
public class MenuBo implements Serializable {

	private static final long serialVersionUID = -5258552132842005106L;

	/**
	 * 筛选文本
	 */
	private String filterText;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 父级主键
	 */
	private Long parentId;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 链接
	 */
	private String href;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 顺序
	 */
	private Integer order;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 状态
	 */
	private Integer status = 1;

	/**
	 * 创建人员
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createAt;

	/**
	 * 更新人员
	 */
	private Long updateBy;

	/**
	 * 更新时间
	 */
	private Date updateAt;
}
