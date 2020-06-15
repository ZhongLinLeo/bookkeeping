package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import cn.leo.bookkeeping.user.dao.PersonalInfoDao;
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
    private PersonalInfoDao personalInfoDao;

    public PersonalInfo queryPersonalInfo(String userId) {
        return personalInfoDao.findPersonalInfoByUserId(userId);
    }



}
