package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiContent;
import cn.songmj.kpi.facade.KpiContentFacade;
import cn.songmj.kpi.mapper.KpiContentMapper;
import cn.songmj.kpi.param.KpiContentParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

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
public class KpiContentFacadeImpl extends ServiceImpl<KpiContentMapper, KpiContent> implements KpiContentFacade {

    @Override
    public Page<KpiContentParam> page(KpiContentParam kpiContentParam) {
        return null;
    }

    @Override
    public List<KpiContentParam> list(KpiContentParam kpiContentParam) {
        return null;
    }

    @Override
    public Integer insert(KpiContentParam kpiContentParam) {
        return null;
    }

    @Override
    public Integer update(KpiContentParam kpiContentParam) {
        return null;
    }

    @Override
    public Integer delete(Long kcId) {
        return null;
    }
}
