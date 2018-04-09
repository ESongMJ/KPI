package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.NavPower;
import cn.songmj.kpi.facade.NavPowerFacade;
import cn.songmj.kpi.mapper.NavPowerMapper;
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
public class NavPowerFacadeImpl  extends ServiceImpl<NavPowerMapper, NavPower> implements NavPowerFacade {
}
