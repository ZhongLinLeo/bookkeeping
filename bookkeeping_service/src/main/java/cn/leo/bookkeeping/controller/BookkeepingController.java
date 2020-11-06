package cn.leo.bookkeeping.controller;

import cn.leo.bookkeeping.api.interfaces.BookkeepingApi;
import cn.leo.bookkeeping.api.request.BillRecordRequestDto;
import cn.leo.bookkeeping.bean.entity.BillInfo;
import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 记账控制层
 *
 * @author leo.zl on 2020/4/17
 */
@RestController
@Slf4j
public class BookkeepingController implements BookkeepingApi {

//    @Autowired
//    private BookkeepingService bookkeepingService;

    @Override
    public Result<Boolean> record(BillRecordRequestDto billRecordRequestDto) {

        BillInfo billInfo = new BillInfo();

//        BeanUtils.copyProperties(billRecordRequestDto, billInfo);

//        bookkeepingService.saveBillInfo(billInfo);

        return Result.warpResult(CommonResponseEnum.SUCCESS);
    }
}
