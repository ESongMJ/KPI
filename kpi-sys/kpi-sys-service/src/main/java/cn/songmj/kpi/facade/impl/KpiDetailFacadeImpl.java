package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiDetail;
import cn.songmj.kpi.facade.KpiDetailFacade;
import cn.songmj.kpi.mapper.KpiDetailMapper;
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
public class KpiDetailFacadeImpl extends ServiceImpl<KpiDetailMapper, KpiDetail> implements KpiDetailFacade {

}
