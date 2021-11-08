package com.liangzhicheng.modules.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzhicheng.modules.dubbo.api.ITUserServiceP;
import com.liangzhicheng.modules.entity.TUser;
import com.liangzhicheng.modules.mapper.TUserMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TUserServicePImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserServiceP {

    @Override
    public void save(String name) {
        log.warn("[user server dubbo invoke] save ... xid:{}", RootContext.getXID());
        baseMapper.insert(new TUser().setName(name));
    }

}
