package cn.leo.bookkeeping.fallback;

import cn.leo.bookkeeping.api.BookkeepingApi;
import cn.leo.bookkeeping.dto.request.BillRecordRequestDto;
import cn.leo.bookkeeping.user.common.enums.CommonResponseEnum;
import cn.leo.bookkeeping.user.common.response.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * interface default fallback
 *
 * @author create by leo.zl on 2020/8/13
 */
@Component
public class BookkeepingApiFallbackFactory implements FallbackFactory<BookkeepingApi> {

    @Override
    public BookkeepingApi create(Throwable throwable) {

        Result result = Result.warpResult(CommonResponseEnum.TIME_OUT);
        return new BookkeepingApi() {
            @Override
            public Result record(BillRecordRequestDto billRecordRequestDto) {
                return result;
            }
        };
    }
}
