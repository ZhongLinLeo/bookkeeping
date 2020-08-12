package cn.leo.bookkeeping.user.service;

import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;

/**
 * 查询用户信息service
 *
 * @author leo.zl on 2020/6/5
 */
public interface UserInfoQueryService {
    PersonalInfo queryPersonalInfo(String userId);
}
