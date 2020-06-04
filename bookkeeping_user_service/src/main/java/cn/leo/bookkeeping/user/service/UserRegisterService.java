package cn.leo.bookkeeping.user.service;

import cn.leo.bookkeeping.user.bean.dto.RegisterUserInfoDTO;

/**
 * 用户注册相关service
 *
 * @author leo.zl on 2020/6/2
 */
public interface UserRegisterService {

    /**
     * 判断该手机号码是否已经注册
     *
     * @param phoneNum 手机号码
     * @return 该手机号码是否已经注册
     */
    Boolean isUserRegister(String phoneNum);

    /**
     * 注册新用户
     *
     * @param registerUserInfo 用户相关信息
     * @return 返回是否注册成功
     */
    Boolean registerUser(RegisterUserInfoDTO registerUserInfo);

}
