package com.liangzhicheng.modules.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liangzhicheng.modules.dubbo.api.ITUserServiceP;
import com.liangzhicheng.modules.entity.TUser;
import com.liangzhicheng.modules.service.ITUserServiceC;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/user/consumer")
public class UserController {

    @Resource
    private ITUserServiceC userServiceC;
    @Reference
    private ITUserServiceP userServiceP;

    /**
     * 全局事务提交
     * @param name
     */
    @GetMapping(value = "/save/commit/{name}")
    @GlobalTransactional(rollbackFor = Exception.class)
    public void saveCommit(@PathVariable("name") String name){
        log.warn("[user server] save ... xid:{}", RootContext.getXID());
        //本地保存
        userServiceC.save(new TUser().setName(name));
        //dubbo远程调用保存
        userServiceP.save(name);
    }

    /**
     * 全局事务回滚
     * @param name
     */
    @GetMapping(value = "/save/rollback/{name}")
    @GlobalTransactional(rollbackFor = Exception.class)
    public void saveRollback(@PathVariable("name") String name){
        log.warn("[user server] save ... xid:{}", RootContext.getXID());
        //本地保存
        userServiceC.save(new TUser().setName(name));
        //dubbo远程调用保存
        userServiceP.save(name);
        //模拟异常
        throw new RuntimeException();
    }

}
