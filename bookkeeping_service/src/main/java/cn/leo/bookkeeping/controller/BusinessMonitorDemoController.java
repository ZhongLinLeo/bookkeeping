package cn.leo.bookkeeping.controller;

import cn.leo.bookkeeping.api.interfaces.BookkeepingApi;
import cn.leo.bookkeeping.api.request.BillRecordRequestDto;
import cn.leo.bookkeeping.response.Result;
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

        final Result<Boolean> record = bookkeepingApi.record(billRecordRequestDto);

        System.out.println(record);

        return "jfdalk";
    }

}
