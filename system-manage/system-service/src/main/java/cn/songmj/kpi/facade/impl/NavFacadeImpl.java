package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Nav;
import cn.songmj.kpi.facade.NavFacade;
import cn.songmj.kpi.mapper.NavMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

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
public class NavFacadeImpl  extends ServiceImpl<NavMapper, Nav> implements NavFacade {
}
