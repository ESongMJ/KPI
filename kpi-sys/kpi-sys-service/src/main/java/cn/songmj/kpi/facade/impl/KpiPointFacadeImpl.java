package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiPoint;
import cn.songmj.kpi.facade.KpiPointFacade;
import cn.songmj.kpi.mapper.KpiPointMapper;
import cn.songmj.kpi.param.KpiPointParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
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
public class KpiPointFacadeImpl extends ServiceImpl<KpiPointMapper, KpiPoint> implements KpiPointFacade {

    @Override
    public Page<KpiPointParam> page(KpiPointParam kpiPointParam) {
        Page<KpiPoint> kpPage = new Page<>();
        EntityWrapper<KpiPoint> ew = bindParam(kpiPointParam);
        kpPage.setSize(kpiPointParam.getPageSize());
        kpPage.setCurrent(kpiPointParam.getCurrentPage());
        List<KpiPoint> kpList = baseMapper.selectPage(kpPage, ew);
        List<KpiPointParam> kpParamList = kpList.stream().map(kp -> {
            KpiPointParam kpParam = new KpiPointParam();
            BeanUtils.copyProperties(kp, kpParam);
            return kpParam;
        }).collect(Collectors.toList());
        Page<KpiPointParam> kpParamPage = new Page<>();
        BeanUtils.copyProperties(kpPage, kpParamPage);
        kpParamPage.setRecords(kpParamList);
        return kpParamPage;
    }

    @Override
    public List<KpiPointParam> list(KpiPointParam kpiPointParam) {
        EntityWrapper<KpiPoint> ew = bindParam(kpiPointParam);
        List<KpiPoint> kpList = baseMapper.selectList(ew);
        return kpList.stream().map(kp -> {
            KpiPointParam kpParam = new KpiPointParam();
            BeanUtils.copyProperties(kp, kpParam);
            return kpParam;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(KpiPointParam kpiPointParam) {
        KpiPoint kp = new KpiPoint();
        BeanUtils.copyProperties(kpiPointParam, kp);
        return baseMapper.insert(kp);
    }

    @Override
    public Integer update(KpiPointParam kpiPointParam) {
        KpiPoint kp = new KpiPoint();
        BeanUtils.copyProperties(kpiPointParam, kp);
        return baseMapper.updateById(kp);
    }

    @Override
    public Integer delete(Long kpId) {
        return baseMapper.deleteById(kpId);
    }

    /**
     * 绑定查询参数
     * @param kpiPointParam
     * @return
     */
    private EntityWrapper<KpiPoint> bindParam(KpiPointParam kpiPointParam) {
        EntityWrapper<KpiPoint> ew = new EntityWrapper<>();
        if (kpiPointParam.getKpName() != null) {
            ew.like("kp_name", kpiPointParam.getKpName()).or();
        }
        if (kpiPointParam.getKpDescription() != null) {
            ew.like("kp_description", kpiPointParam.getKpDescription()).or();
        }
        if (kpiPointParam.getKpType() != null) {
            ew.eq("kp_type", kpiPointParam.getKpType());
        }
        return ew;
    }
}
