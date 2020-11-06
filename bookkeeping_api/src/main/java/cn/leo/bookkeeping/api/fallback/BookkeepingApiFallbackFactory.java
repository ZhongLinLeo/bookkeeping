package cn.leo.bookkeeping.api.fallback;

import cn.leo.bookkeeping.api.interfaces.BookkeepingApi;
import cn.leo.bookkeeping.api.request.BillRecordRequestDto;
import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.response.Result;
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
