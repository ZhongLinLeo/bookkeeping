package cn.leo.bookkeeping.api;

import cn.leo.bookkeeping.constant.HttpConstants;
import cn.leo.bookkeeping.dto.request.BillRecordRequestDto;
import cn.leo.bookkeeping.fallback.BookkeepingApiFallbackFactory;
import cn.leo.bookkeeping.user.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * record relevant interface
 *
 * @author create by leo.zl on 2020/8/13
 */
@FeignClient(name = HttpConstants.SERVICE_NAME, fallbackFactory = BookkeepingApiFallbackFactory.class)
public interface BookkeepingApi {

    /**
     * 记账项目中记录接口
     *
     * @param billRecordRequestDto 记录信息
     * @return 返回记录是否成功
     */
    @PostMapping(
            value = "leo/bookkeeping/record",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    Result<Boolean> record(BillRecordRequestDto billRecordRequestDto);

}
