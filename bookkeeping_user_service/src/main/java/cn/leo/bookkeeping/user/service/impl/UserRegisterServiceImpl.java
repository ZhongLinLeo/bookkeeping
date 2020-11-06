package cn.leo.bookkeeping.user.service.impl;

import cn.leo.bookkeeping.uid.UidGenerator;
import cn.leo.bookkeeping.user.bean.dto.RegisterUserInfoDTO;
import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import cn.leo.bookkeeping.user.dao.PersonalInfoDao;
import cn.leo.bookkeeping.user.service.UserRegisterService;
import cn.leo.bookkeeping.util.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static cn.leo.bookkeeping.enums.CallSystemResponseEnum.PASSWORD_PARSE_ERROR;

/**
 * @author leo.zl on 2020/6/2
 */
@Service
@Slf4j
public class UserRegisterServiceImpl implements UserRegisterService {

    @Resource
    private PersonalInfoDao personalInfoDao;

    @Resource
    private EncryptUtils encryptUtils;

    @Resource(name = "defaultUidGenerator")
    private UidGenerator uidGenerator;

    @Override
    public Boolean isUserRegister(String phoneNum) {
        log.info("校验该手机号是否注册");
        return personalInfoDao.countUserByPhoneNumber(phoneNum);
    }

    @Override
    public Boolean registerUser(RegisterUserInfoDTO registerUserInfo) {
        String passWord = encryptUtils.AESDecode(registerUserInfo.getEncryptionInfo(), registerUserInfo.getToken());
        log.info("校验用户密码是否可以解析");
        PASSWORD_PARSE_ERROR.assertIsNull(passWord);

        PersonalInfo personalInfo = new PersonalInfo();
        BeanUtils.copyProperties(registerUserInfo, personalInfo);
        personalInfo.setId(uidGenerator.getUID());
        personalInfo.setUserId(uidGenerator.getUID());
        log.info("存储用户信息:{}", personalInfo);

        return personalInfoDao.saveNewUser(personalInfo);
    }
}
