package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiBasicRequire;
import cn.songmj.kpi.facade.KpiBasicRequireFacade;
import cn.songmj.kpi.mapper.KpiBasicRequireMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class KpiBasicRequireFacadeImpl extends ServiceImpl<KpiBasicRequireMapper, KpiBasicRequire> implements KpiBasicRequireFacade {

}
