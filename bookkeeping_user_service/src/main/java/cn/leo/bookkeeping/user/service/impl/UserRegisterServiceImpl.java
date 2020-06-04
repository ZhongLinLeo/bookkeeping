package cn.leo.bookkeeping.user.service.impl;

import cn.leo.bookkeeping.user.bean.dto.RegisterUserInfoDTO;
import cn.leo.bookkeeping.user.common.uid.UidGenerator;
import cn.leo.bookkeeping.user.dao.PersonalInfoDao;
import cn.leo.bookkeeping.user.service.UserRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leo.zl on 2020/6/2
 */
@Service
@Slf4j
public class UserRegisterServiceImpl implements UserRegisterService {

    @Resource
    private PersonalInfoDao personalInfoDao;

    @Resource(name = "defaultUidGenerator")
    private UidGenerator uidGenerator;

    @Override
    public Boolean isUserRegister(String phoneNum) {
        log.info("校验该手机号是否注册");
        return personalInfoDao.countUserByPhoneNumber(phoneNum);
    }

    @Override
    public Boolean registerUser(RegisterUserInfoDTO registerUserInfo) {





        return null;
    }
}
