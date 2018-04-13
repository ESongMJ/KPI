package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiOfUser;
import cn.songmj.kpi.facade.KpiOfUserFacade;
import cn.songmj.kpi.mapper.KpiOfUserMapper;
import cn.songmj.kpi.param.KpiOfUserParam;
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
public class KpiOfUserFacadeImpl extends ServiceImpl<KpiOfUserMapper, KpiOfUser> implements KpiOfUserFacade {

    @Override
    public Page<KpiOfUserParam> page(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public List<KpiOfUserParam> list(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer insert(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer update(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer delete(Long kuId) {
        return null;
    }
}