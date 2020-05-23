package cn.leo.bookkeeping.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leo.zl on 2020/3/29
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "";
    }

}
