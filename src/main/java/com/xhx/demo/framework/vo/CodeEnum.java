package com.xhx.demo.framework.vo;

/**
 * 结果返回错误码
 * @author xhx
 *
 */
public enum CodeEnum {

	/****************
	 * 00 统一code
	 ****************/
	SUCCESS("00000", "请求成功")
	,USER_EXIST("00001", "用户已存在")
	,USER_NOT_EXIST("00004", "用户不存在")
	,PARAM_FORMAT_ERROR_DATE("00301", "日期格式错误")
	,PARAM_FORMAT_ERROR_DATA("00302", "数据格式错误")
	,REQUEST_FAILS("-00001", "请求失败")
	,CODE_11007("10007", "参数异常"),;

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private CodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getShow() {
		return this.code + " " + this.desc;
	}

}
