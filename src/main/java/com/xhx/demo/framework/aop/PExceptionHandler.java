package com.xhx.demo.framework.aop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xhx.demo.framework.exception.ParamException;
import com.xhx.demo.framework.vo.BaseResponse;
import com.xhx.demo.framework.vo.CodeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 通用web请求异常处理
 * @author xhx
 *
 */
@ControllerAdvice
@Slf4j
public class PExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public BaseResponse<Object> handle(Exception e) {
		ServletRequestAttributes aa = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = aa.getRequest();
		log.info("错误URL：{}", request.getRequestURL());
		log.info("异常信息：{}", e.getMessage());

		if (e instanceof ParamException) {
			// 封装参数异常
			ParamException pe = (ParamException) e;
			return BaseResponse.fail(pe.getCenum(), pe.getMsg());
		} else if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
			return BaseResponse.fail(CodeEnum.CODE_11007,
					me.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		}
		log.info("异常详情：{}", e);
		return BaseResponse.fail(CodeEnum.REQUEST_FAILS);
	}

}
