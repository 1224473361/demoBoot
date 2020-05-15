package com.xhx.demo.db.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhx.demo.db.entity.WxUser;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xhx
 * @since 2020-03-18
 */
@Mapper
public interface WxUserMapper extends BaseMapper<WxUser> {

}
