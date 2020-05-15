package com.xhx.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhx.demo.framework.vo.BaseResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("index")
@Api(value = "概述", tags = "概述")
public class IndexController {

	@GetMapping("index")
	@ApiOperation(value = "hello")
	public BaseResponse<String> index() {
		return BaseResponse.success("程序已启动");
	}

}
