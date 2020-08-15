package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.api.BookkeepingApi;
import cn.leo.bookkeeping.dto.request.BillRecordRequestDto;
import cn.leo.bookkeeping.user.bean.entity.BillInfo;
import cn.leo.bookkeeping.user.common.enums.CommonResponseEnum;
import cn.leo.bookkeeping.user.common.response.Result;
import cn.leo.bookkeeping.user.service.BookkeepingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 记账控制层
 *
 * @author leo.zl on 2020/4/17
 */
@RestController
@Slf4j
public class BookkeepingController implements BookkeepingApi {

    @Resource
    private BookkeepingService bookkeepingService;

    @Override
    public Result<Boolean> record(BillRecordRequestDto billRecordRequestDto) {

        BillInfo billInfo = new BillInfo();

        BeanUtils.copyProperties(billRecordRequestDto, billInfo);

        bookkeepingService.saveBillInfo(billInfo);

        return Result.warpResult(CommonResponseEnum.SUCCESS);
    }
}
