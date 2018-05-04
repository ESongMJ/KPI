package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiContent;
import cn.songmj.kpi.facade.KpiContentFacade;
import cn.songmj.kpi.mapper.KpiContentMapper;
import cn.songmj.kpi.param.KpiContentParam;
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
public class KpiContentFacadeImpl extends ServiceImpl<KpiContentMapper, KpiContent> implements KpiContentFacade {

    @Override
    public Page<KpiContentParam> page(KpiContentParam kpiContentParam, Integer kpType) {
        Page<KpiContent> kcPage = new Page<>();
        KpiContent kc = new KpiContent();
        BeanUtils.copyProperties(kpiContentParam, kc);
        kcPage.setSize(kpiContentParam.getPageSize());
        kcPage.setCurrent(kpiContentParam.getCurrentPage());
        List<KpiContent> kcList = baseMapper.selectJoinPage(kcPage, kc, kpType);
        Page<KpiContentParam> kcParamPage = new Page<>();
        BeanUtils.copyProperties(kcPage, kcParamPage);
        kcParamPage.setRecords(kcList.stream().map(kc1 -> {
            KpiContentParam kcParam = new KpiContentParam();
            KpiPointParam kp = new KpiPointParam();
            BeanUtils.copyProperties(kc1.getKp(), kp);
            BeanUtils.copyProperties(kc1, kcParam);
            kcParam.setKp(kp);
            return kcParam;
        }).collect(Collectors.toList()));
        return kcParamPage;
    }

    @Override
    public List<KpiContentParam> list(KpiContentParam kpiContentParam, String type) {
        EntityWrapper<KpiContent> ew = bindParam(kpiContentParam);
        List<KpiContent> kcList = baseMapper.selectList(ew);
        return kcList.stream().map(kc -> {
            KpiContentParam kcParam = new KpiContentParam();
            BeanUtils.copyProperties(kc, kcParam);
            return kcParam;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(KpiContentParam kpiContentParam) {
        KpiContent kc = new KpiContent();
        BeanUtils.copyProperties(kpiContentParam, kc);
        return baseMapper.insert(kc);
    }

    @Override
    public Integer update(KpiContentParam kpiContentParam) {
        KpiContent kc = new KpiContent();
        BeanUtils.copyProperties(kpiContentParam, kc);
        return baseMapper.updateById(kc);
    }

    @Override
    public Integer delete(Long kcId) {
        return baseMapper.deleteById(kcId);
    }

    /**
     * 绑定查询参数
     * @param kcParam
     * @return
     */
    private EntityWrapper<KpiContent> bindParam(KpiContentParam kcParam) {
        EntityWrapper<KpiContent> ew = new EntityWrapper<>();
        if (kcParam.getKcName() != null) {
            ew.or().like("kc_name", kcParam.getKcName());
        }
        if (kcParam.getKcDescription() != null) {
            ew.or().like("kc_description", kcParam.getKcDescription());
        }
        if (kcParam.getKcStandard() != null) {
            ew.or().like("kc_standard", kcParam.getKcStandard());
        }
        return ew;
    }
}
