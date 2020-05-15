package com.xhx.demo.framework.vo;

import lombok.Data;

/**
 * 请求返回对象
 * 
 * @author xhx
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> {

	private String code;

	private T data;

	private String msg;

	public BaseResponse(String code, String msg, T data) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	/**
	 * 封装成功结果
	 * 
	 * @param <T>
	 * @param enums
	 * @param data
	 * @return
	 */
	public static <T> BaseResponse<T> success() {
		return success(CodeEnum.SUCCESS, null);
	}

	/**
	 * 封装成功结果
	 * 
	 * @param <T>
	 * @param enums
	 * @param data
	 * @return
	 */
	public static <T> BaseResponse<T> success(T data) {
		return success(CodeEnum.SUCCESS, data);
	}

	/**
	 * 封装成功结果
	 * 
	 * @param <T>
	 * @param enums
	 * @param data
	 * @return
	 */
	public static <T> BaseResponse<T> success(CodeEnum enums, T data) {
		return new BaseResponse<>(enums.getCode(), enums.getDesc(), data);
	}

	/**
	 * 封装错误返回
	 * 
	 * @param <T>
	 * @param enums
	 * @param msg
	 * @return
	 */
	public static <T> BaseResponse<T> fail(CodeEnum enums, String msg) {
		return new BaseResponse<>(enums.getCode(), enums.getDesc() + " " + msg, null);
	}

	/**
	 * 封装错误返回
	 * 
	 * @param <T>
	 * @param enums
	 * @param msg
	 * @return
	 */
	public static <T> BaseResponse<T> fail(CodeEnum enums, String msg, T data) {
		return new BaseResponse<>(enums.getCode(), enums.getDesc() + " " + msg, data);
	}

	/**
	 * 封装错误返回
	 * 
	 * @param <T>
	 * @param enums
	 * @param msg
	 * @return
	 */
	public static <T> BaseResponse<T> fail(CodeEnum enums) {
		return new BaseResponse<>(enums.getCode(), enums.getDesc(), null);
	}

}
