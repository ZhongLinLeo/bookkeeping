package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.api.interfaces.UserBasicApi;
import cn.leo.bookkeeping.api.request.PersonalInfoResponseDTO;
import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.response.Result;
import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import cn.leo.bookkeeping.user.service.UserInfoQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户服务基础操作
 *
 * @author leo.zl on 2020/6/5
 */
@RestController
@Slf4j
public class UserBasicController implements UserBasicApi {

    @Resource
    private UserInfoQueryService userInfoQueryService;

    @Override
    public Result<PersonalInfoResponseDTO> queryPersonalInfo(@RequestParam String userId) {
        final PersonalInfo personalInfo = userInfoQueryService.queryPersonalInfo(userId);

        log.info("用户信息:{}", personalInfo);

        PersonalInfoResponseDTO personalInfoResponse = null;
        if (personalInfo != null) {
            personalInfoResponse = new PersonalInfoResponseDTO();
            BeanUtils.copyProperties(personalInfo, personalInfoResponse);
        }

        return Result.warpResult(CommonResponseEnum.SUCCESS, personalInfoResponse);
    }

}