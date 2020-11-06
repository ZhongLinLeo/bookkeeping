package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.response.Result;
import cn.leo.bookkeeping.user.bean.dto.RegisterUserInfoDTO;
import cn.leo.bookkeeping.user.constant.UserMappingConstants;
import cn.leo.bookkeeping.user.service.UserRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.leo.bookkeeping.enums.CallSystemResponseEnum.USER_EXIST;
import static cn.leo.bookkeeping.enums.CurrentSystemResponseEnum.REGISTER_FAILED;

/**
 * 用户注册控制层
 *
 * @author leo.zl on 2020/6/1
 */
@RestController
@RequestMapping(value = UserMappingConstants.USER_SERVICE_MAPPING_PREFIX,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class UserRegisterController {

    @Resource
    private UserRegisterService userRegisterService;

    @PostMapping("/register")
    public Result<Boolean> userRegister(@RequestBody @Validated RegisterUserInfoDTO registerUserInfo) {
        log.info("开始注册用户:{}", registerUserInfo);

        Boolean flag = userRegisterService.isUserRegister(registerUserInfo.getPhoneNumber());
        USER_EXIST.assertIsFalse(flag);

        Boolean registerFlag = userRegisterService.registerUser(registerUserInfo);
        REGISTER_FAILED.assertIsFalse(registerFlag);

        return Result.warpResult(CommonResponseEnum.SUCCESS, true);
    }

}
