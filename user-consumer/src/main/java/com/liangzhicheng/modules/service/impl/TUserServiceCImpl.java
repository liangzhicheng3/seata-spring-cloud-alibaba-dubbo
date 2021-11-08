package com.liangzhicheng.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzhicheng.modules.entity.TUser;
import com.liangzhicheng.modules.mapper.TUserMapper;
import com.liangzhicheng.modules.service.ITUserServiceC;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TUserServiceCImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserServiceC {

}
