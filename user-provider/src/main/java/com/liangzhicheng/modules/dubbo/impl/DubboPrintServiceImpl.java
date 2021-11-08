package com.liangzhicheng.modules.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liangzhicheng.modules.dubbo.api.IDubboPrintService;

@Service
public class DubboPrintServiceImpl implements IDubboPrintService {

    @Override
    public String print(String content) {
        return "dubbo服务调用成功，内容为" + content;
    }

}
