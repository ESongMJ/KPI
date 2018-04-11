package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.UserFacade;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import cn.songmj.kpi.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class UserServiceImpl implements UserService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private UserFacade userFacade;


    @Override
    public String sayHello(String name) {
        return userFacade.sayHello(name);
    }
}
