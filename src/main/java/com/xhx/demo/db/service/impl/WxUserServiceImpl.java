package com.xhx.demo.db.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhx.demo.db.entity.WxUser;
import com.xhx.demo.db.mapper.WxUserMapper;
import com.xhx.demo.db.service.IWxUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xhx
 * @since 2020-03-18
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser> implements IWxUserService {

	@Override
	public List<WxUser> getAllUsers() {
		LambdaQueryWrapper<WxUser> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(WxUser::getDeleted, false);
		return this.list(queryWrapper);
	}

	@Override
	public IPage<WxUser> getAllUsers(int pageNum, int pageSize) {
		LambdaQueryWrapper<WxUser> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(WxUser::getDeleted, false);
		return this.page(new Page<>(pageNum, pageSize), queryWrapper);
	}

}
