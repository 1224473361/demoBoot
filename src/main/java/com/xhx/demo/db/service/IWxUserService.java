package com.xhx.demo.db.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhx.demo.db.entity.WxUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xhx
 * @since 2020-03-18
 */
public interface IWxUserService extends IService<WxUser> {

	IPage<WxUser> getAllUsers(int pageNum, int pageSize);

	List<WxUser> getAllUsers();

}
