package cn.leo.bookkeeping.api.interfaces;

import cn.leo.bookkeeping.api.constant.HttpConstants;
import cn.leo.bookkeeping.api.fallback.UserBasicApiFallbackFactory;
import cn.leo.bookkeeping.api.request.PersonalInfoResponseDTO;
import cn.leo.bookkeeping.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author create by leo.zl on 2020/11/9
 */
@FeignClient(name = HttpConstants.BOOKKEEPING_USER_SERVICE,fallbackFactory = UserBasicApiFallbackFactory.class)
public interface UserBasicApi {

    /**
     * 查询用户信息接口
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("/bookkeeping/user/queryPersonalInfo")
    Result<PersonalInfoResponseDTO> queryPersonalInfo(@RequestParam String userId);
}
