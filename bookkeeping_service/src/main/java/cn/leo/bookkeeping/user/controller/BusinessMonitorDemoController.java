package cn.leo.bookkeeping.user.controller;

import cn.leo.bookkeeping.api.BookkeepingApi;
import cn.leo.bookkeeping.dto.request.BillRecordRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author create by leo.zl on 2020/9/26
 */
@RestController
public class BusinessMonitorDemoController {

    @Resource
    private BookkeepingApi bookkeepingApi;

    @GetMapping("test")
    public String  test(){

        final BillRecordRequestDto billRecordRequestDto = new BillRecordRequestDto();

        bookkeepingApi.record(billRecordRequestDto);

        return "jfdalk";
    }

}
