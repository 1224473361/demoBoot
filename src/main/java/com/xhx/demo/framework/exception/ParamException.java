package com.xhx.demo.framework.exception;

import com.xhx.demo.framework.vo.CodeEnum;

/**
 * 校验接口参数时抛出的异常
 * 
 * @author xhx
 *
 */
public class ParamException extends RuntimeException {
	private static final long serialVersionUID = 2591564221796356342L;

	private final CodeEnum cenum;
	private final String msg;

	public CodeEnum getCenum() {
		return cenum;
	}

	public String getMsg() {
		return msg;
	}

	public ParamException(CodeEnum cenum) {
		super("【" + cenum.getCode() + "】" + cenum.getDesc());
		this.cenum = cenum;
		this.msg = "";
	}

	public ParamException(CodeEnum cenum, String msg) {
		super("【" + cenum.getCode() + "】" + cenum.getDesc() + " " + msg);
		this.cenum = cenum;
		this.msg = msg;
	}

}
