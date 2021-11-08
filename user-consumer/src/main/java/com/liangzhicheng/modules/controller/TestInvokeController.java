package com.liangzhicheng.modules.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liangzhicheng.modules.dubbo.api.IDubboPrintService;
import com.liangzhicheng.modules.feign.IFeignPrintService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test/invoke")
public class TestInvokeController {

    @Reference
    private IDubboPrintService dubboPrintService;
    @Resource
    private IFeignPrintService feignPrintService;

    @GetMapping(value = "/dubbo/print/{content}")
    public String dubboPrint(@PathVariable("content") String content){
        return dubboPrintService.print(content);
    }

    /**
     * Caused by: java.lang.NoClassDefFoundError: feign/slf4j/Slf4jLogger
     * 注释IFeignPrintService、FeignClient注解
     * @param content
     * @return
     */
    @GetMapping(value = "/feign/print/{content}")
    public String feignPrint(@PathVariable("content") String content){
        return feignPrintService.print(content);
    }

}
