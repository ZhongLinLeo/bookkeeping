package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import cn.leo.bookkeeping.user.service.UserInfoQueryService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息查询
 *
 * @author leo.zl on 2020/6/5
 */
@RestController
public class UserBasicController {

    @Resource
    private UserInfoQueryService userInfoQueryService;

    public PersonalInfo queryPersonalInfo(String userId) {
        return userInfoQueryService.queryPersonalInfo(userId);
    }





}
