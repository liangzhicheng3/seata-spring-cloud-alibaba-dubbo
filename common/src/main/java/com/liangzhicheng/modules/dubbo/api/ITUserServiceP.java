package com.liangzhicheng.modules.dubbo.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzhicheng.modules.entity.TUser;

public interface ITUserServiceP extends IService<TUser> {

    void save(String name);

}
