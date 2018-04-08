package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.facade.NavFacade;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/9
 **/
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class NavFacadeImpl implements NavFacade {
}
