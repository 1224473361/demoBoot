package com.xhx.demo.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhx.demo.db.entity.WxUser;
import com.xhx.demo.db.service.IWxUserService;
import com.xhx.demo.framework.vo.BaseResponse;
import com.xhx.demo.framework.vo.CodeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
@Api(value = "用户", tags = "用户")
@Validated
public class UserController {

	@Autowired
	private IWxUserService wxUserService;

	@PostMapping("listByPage")
	@ApiOperation(value = "分页获取所有用户")
	public BaseResponse<IPage<WxUser>> listByPage(
			@RequestParam(defaultValue = "1", value = "pageNum", required = false) int pageNum,
			@RequestParam(defaultValue = "10", value = "pageSize", required = false) int pageSize) {
		IPage<WxUser> list = this.wxUserService.getAllUsers(pageNum, pageSize);
		return BaseResponse.success(list);
	}

	@PostMapping("list")
	@ApiOperation(value = "获取所有用户")
	public BaseResponse<List<WxUser>> list() {
		List<WxUser> list = this.wxUserService.getAllUsers();
		return BaseResponse.success(list);
	}

	@GetMapping("detail")
	@ApiOperation(value = "获取用户详情")
	public BaseResponse<WxUser> detail(@NotNull Integer id) {
		WxUser user = this.wxUserService.getById(id);
		return BaseResponse.success(user);
	}

	@PostMapping("save")
	@ApiOperation(value = "保存用户信息")
	public BaseResponse<Boolean> save(@RequestBody WxUser user) throws UnknownHostException {
		if (user.getId() == null || user.getId().equals(0)) {
			user.setAddTime(new Date());
			user.setUpdateTime(new Date());
			user.setLastLoginIp(InetAddress.getLocalHost().getHostAddress());
			user.setDeleted(false);
			user.setStatus(0);
			user.setId(null);
		}
		boolean f = this.wxUserService.saveOrUpdate(user);
		return BaseResponse.success(f);
	}

	@PostMapping("delete")
	@ApiOperation(value = "删除用户信息")
	public BaseResponse<Boolean> delete(@NotNull @RequestBody Integer id) {
		WxUser user = this.wxUserService.getById(id);
		if (user == null) {
			return BaseResponse.fail(CodeEnum.USER_NOT_EXIST);
		}
		user.setUpdateTime(new Date());
		user.setDeleted(true);
		boolean f = this.wxUserService.updateById(user);
		return BaseResponse.success(f);
	}
}
