package cn.leo.bookkeeping.api.fallback;

import cn.leo.bookkeeping.api.interfaces.UserBasicApi;
import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.response.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 为 UserBasicApi 提供的默认 fallback
 *
 * @author create by leo.zl on 2020/11/9
 */
@Component
public class UserBasicApiFallbackFactory implements FallbackFactory<UserBasicApi> {
    @Override
    public UserBasicApi create(Throwable cause) {
        return new UserBasicApi() {

            final Result<Object> result = Result.warpResult(CommonResponseEnum.TIME_OUT);

            @Override
            public Result queryPersonalInfo(String userId) {
                return result;
            }
        };
    }
}
