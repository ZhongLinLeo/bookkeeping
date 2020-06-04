package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.user.bean.dto.RegisterUserInfoDTO;
import cn.leo.bookkeeping.user.common.response.Result;
import cn.leo.bookkeeping.user.constant.UserMappingConstants;
import cn.leo.bookkeeping.user.service.UserRegisterService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.leo.bookkeeping.user.common.enums.CallSystemResponseEnum.USER_EXIST;

/**
 * 用户注册控制层
 *
 * @author leo.zl on 2020/6/1
 */
@RestController
@RequestMapping(value = UserMappingConstants.USER_SERVICE_MAPPING_PREFIX,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRegisterController {

    @Resource
    private UserRegisterService userRegisterService;

    @PostMapping("/register")
    public Result<Boolean> userRegister(@RequestBody @Validated RegisterUserInfoDTO registerUserInfo) {

        Boolean flag = userRegisterService.isUserRegister(registerUserInfo.getPhoneNumber());
        USER_EXIST.assertIsFalse(flag);






        return null;
    }

}
