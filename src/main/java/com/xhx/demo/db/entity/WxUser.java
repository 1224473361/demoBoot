package com.xhx.demo.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xhx
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户表")
@TableName(value = "wx_user")
public class WxUser extends Model<WxUser> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "id")
	private Integer id;

	/**
	 * 用户名称
	 */
	@ApiModelProperty(value = "用户名称")
	private String userName;

	/**
	 * 用户密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;

	/**
	 * 性别：0 未知， 1男， 1 女
	 */
	@ApiModelProperty(value = "性别")
	private Integer gender;

	/**
	 * 生日
	 */
	@ApiModelProperty(value = "生日")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthday;

	/**
	 * 最近一次登录时间
	 */
	@ApiModelProperty(value = "登录时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastLoginTime;

	/**
	 * 最近一次登录IP地址
	 */
	@ApiModelProperty(value = "ip")
	private String lastLoginIp;

	/**
	 * 0 普通用户，1 VIP用户，2 高级VIP用户
	 */
	@ApiModelProperty(value = "用户级别")
	private Integer userLevel;

	/**
	 * 用户昵称或网络名称
	 */
	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	/**
	 * 用户手机号码
	 */
	@ApiModelProperty(value = "用户手机号码")
	private String mobile;

	/**
	 * 用户头像图片
	 */
	@ApiModelProperty(value = "用户头像图片")
	private String avatar;

	/**
	 * 0 可用, 1 禁用, 2 注销
	 */
	@ApiModelProperty(value = "是否 可用")
	private Integer status;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	/**
	 * 逻辑删除
	 */
	@ApiModelProperty(value = "逻辑删除")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Boolean deleted;

	@ApiModelProperty(value = "年龄")
	private Integer age;

	@ApiModelProperty(value = "所在-省")
	private String province;

	@ApiModelProperty(value = "所在-市")
	private String city;

	@ApiModelProperty(value = "所在-区")
	private String county;

	@ApiModelProperty(value = "所在地区编码")
	private String areaCode;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
