package com.liangzhicheng.modules.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-provider")
public interface IFeignPrintService {

    @GetMapping(value = "/user/provider/feign/print")
    String print(@RequestParam("content") String content);

}
