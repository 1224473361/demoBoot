package com.xhx.demo.framework.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhx.demo.framework.vo.BaseResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 利用aop打印controller返回日志
 * 
 * @author xhx
 *
 */
@Aspect
@Component
@Slf4j
public class WebLogAcpect {

	/**
	 * 定义切点
	 */
	@Pointcut("execution(* com.wx.demo.web.*.*(..))")
	public void webLog() {
		////
	}

	/**
	 * @param ret
	 * @return
	 */
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public Object doAfterReturn(Object ret) {
		// 抓取request
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		return showResult(ret, request);
	}

	/**
	 * 打印http请求结果
	 * 
	 * @param ajax
	 * @param request
	 * @return
	 */
	private Object showResult(Object ajax, HttpServletRequest request) {
		if (ajax instanceof BaseResponse) {
			log.info("请求URL:{},处理结果:{}", request.getRequestURL(), JSONObject.toJSONString(ajax));
		} else {
			log.info("请求URL:{},处理结果:{}", request.getRequestURL(), ajax);
		}
		return ajax;
	}

	/**
	 * 配置前置通知
	 * 
	 * @param joinPoint
	 */
	@Before("webLog()")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		// 获取传入的参数
		StringBuilder param = new StringBuilder();
		int length = args.length;
		for (int i = 0; i < length; i++) {
			param.append(args[i]);
			if (i < length - 1) {
				param.append(" -> ");
			}
		}
		// 获取当前被切的类
		String className = joinPoint.getTarget().getClass().getSimpleName();
		// 获取当前执行的方法
		String methodName = joinPoint.getSignature().getName();
		String json = "";
		try {
			json = JSONArray.toJSONString(args);
		} catch (Exception e) {
			log.error("http参数日志，参数转换异常：{}", e.getMessage());
		}

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		log.info("请求URL:{},处理方法:{},请求参数:{}", request.getRequestURL(), className + "." + methodName, json);
	}
}
