package com.liangzhicheng.modules.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/provider")
public class ProviderController {

    @GetMapping(value = "/feign/print")
    public String feignPrint(String content){
        return "feign服务调用成功，内容为" + content;
    }

}
