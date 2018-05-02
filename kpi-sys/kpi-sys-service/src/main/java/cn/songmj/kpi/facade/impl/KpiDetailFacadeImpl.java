package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiDetail;
import cn.songmj.kpi.facade.KpiDetailFacade;
import cn.songmj.kpi.mapper.KpiDetailMapper;
import cn.songmj.kpi.param.*;
import com.alibaba.dubbo.config.annotation.Service;
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
public class KpiDetailFacadeImpl extends ServiceImpl<KpiDetailMapper, KpiDetail> implements KpiDetailFacade {

    @Override
    public Integer update(KpiDetailParam kpiDetailParam) {
        KpiDetail kpiDetail = new KpiDetail();
        BeanUtils.copyProperties(kpiDetailParam, kpiDetail);
        return baseMapper.updateById(kpiDetail);
    }

    @Override
    public Integer updateStatusById(KpiDetailParam kpiDetailParam) {
        KpiDetail kd = new KpiDetail();
        BeanUtils.copyProperties(kpiDetailParam, kd);
        return baseMapper.updateStatus(kd);
    }

    @Override
    public Integer insert(KpiDetailParam kpiDetailParam) {
        KpiDetail kpiDetail = new KpiDetail();
        BeanUtils.copyProperties(kpiDetailParam, kpiDetail);
        return baseMapper.insert(kpiDetail);
    }

    @Override
    public Page<KpiDetailParam> pageByUser(KpiDetailParam kpiDetailParam) {
        Page<KpiDetail> kdPage = new Page<>();
        KpiDetail kd = new KpiDetail();
        BeanUtils.copyProperties(kpiDetailParam, kd);
        kdPage.setSize(kpiDetailParam.getPageSize());
        kdPage.setCurrent(kpiDetailParam.getCurrentPage());
        List<KpiDetail> kdList = baseMapper.pageByUser(kdPage, kd, kpiDetailParam.getKpType(), kpiDetailParam.getKpId(), kpiDetailParam.getUserId());
        List<KpiDetailParam> kdParamList = kdList.stream().map(kd1 -> {
            KpiDetailParam kdParam = new KpiDetailParam();
            KpiContentParam kcParam = new KpiContentParam();
            KpiPointParam kpParam = new KpiPointParam();
            BeanUtils.copyProperties(kd1, kdParam);
            BeanUtils.copyProperties(kd1.getKc(), kcParam);
            BeanUtils.copyProperties(kd1.getKc().getKp(), kpParam);
            kcParam.setKp(kpParam);
            kdParam.setKc(kcParam);
            return kdParam;
        }).collect(Collectors.toList());
        Page<KpiDetailParam> kdParamPage = new Page<>();
        BeanUtils.copyProperties(kdPage, kdParamPage);
        kdParamPage.setRecords(kdParamList);
        return kdParamPage;
    }

    @Override
    public StatisticalObj selectDetail(String kuId) {
        List<StatisticalData> dataList = baseMapper.selectDetail(kuId);
        StatisticalObj statisticalObj = new StatisticalObj();
        statisticalObj.setTeachScore(0.0F);
        statisticalObj.setResearchScore(0.0F);
        for (StatisticalData statisticalData : dataList) {
            if (statisticalData.getType() == 2) {
                statisticalObj.setTeachScore(statisticalObj.getTeachScore() + statisticalData.getScore());
            } else {
                statisticalObj.setResearchScore(statisticalObj.getResearchScore() + statisticalData.getScore());
            }
        }
        statisticalObj.setTotalScore(statisticalObj.getTeachScore()+statisticalObj.getResearchScore());
        return statisticalObj;
    }
}
