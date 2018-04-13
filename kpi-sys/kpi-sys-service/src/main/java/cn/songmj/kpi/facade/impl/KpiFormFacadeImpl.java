package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.facade.KpiFormFacade;
import cn.songmj.kpi.mapper.KpiFormMapper;
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
public class KpiFormFacadeImpl extends ServiceImpl<KpiFormMapper, KpiForm> implements KpiFormFacade {

}
