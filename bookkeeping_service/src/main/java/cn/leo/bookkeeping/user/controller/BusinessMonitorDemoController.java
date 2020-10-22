package cn.leo.bookkeeping.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author create by leo.zl on 2020/9/26
 */
@RestController
public class BusinessMonitorDemoController {

    @GetMapping("test")
    public String  test(){
        return "jfdalk";
    }

}
