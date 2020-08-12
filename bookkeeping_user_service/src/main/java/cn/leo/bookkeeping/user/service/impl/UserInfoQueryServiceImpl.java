package cn.leo.bookkeeping.user.service.impl;

import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import cn.leo.bookkeeping.user.dao.PersonalInfoDao;
import cn.leo.bookkeeping.user.service.UserInfoQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leo.zl on 2020/6/5
 */
@Service
public class UserInfoQueryServiceImpl implements UserInfoQueryService {

    @Resource
    private PersonalInfoDao personalInfoDao;

    @Override
    public PersonalInfo queryPersonalInfo(String userId) {
        return personalInfoDao.findPersonalInfoByUserId(userId);
    }

}
