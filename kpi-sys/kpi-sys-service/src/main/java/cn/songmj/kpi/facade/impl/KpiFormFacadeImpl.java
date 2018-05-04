package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.facade.KpiFormFacade;
import cn.songmj.kpi.mapper.KpiFormMapper;
import cn.songmj.kpi.param.KpiFormParam;
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
public class KpiFormFacadeImpl extends ServiceImpl<KpiFormMapper, KpiForm> implements KpiFormFacade {

    @Override
    public Page<KpiFormParam> page(KpiFormParam kpiFormParam) {
        Page<KpiForm> kfPage = new Page<>();
        kfPage.setSize(kpiFormParam.getPageSize());
        kfPage.setCurrent(kpiFormParam.getCurrentPage());
        EntityWrapper<KpiForm> ew = bindParams(kpiFormParam);
        List<KpiForm> kfList = baseMapper.selectPage(kfPage, ew);
        Page<KpiFormParam> kfParamPage = new Page<>();
        BeanUtils.copyProperties(kfPage, kfParamPage);
        // 数据类型转换
        kfParamPage.setRecords(kfList.stream().map(kf -> {
            KpiFormParam kfParam = new KpiFormParam();
            BeanUtils.copyProperties(kf, kfParam);
            return kfParam;
        }).collect(Collectors.toList()));
        return kfParamPage;
    }

    @Override
    public List<KpiFormParam> list(KpiFormParam kpiFormParam) {
        EntityWrapper<KpiForm> ew = bindParams(kpiFormParam);
        List<KpiForm> kfList = baseMapper.selectList(ew);
        return kfList.stream().map(kf -> {
            KpiFormParam kfParam = new KpiFormParam();
            BeanUtils.copyProperties(kf, kfParam);
            return kfParam;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(KpiFormParam kpiFormParam) {
        KpiForm kf = new KpiForm();
        BeanUtils.copyProperties(kpiFormParam, kf);
        return baseMapper.insert(kf);
    }

    @Override
    public Integer update(KpiFormParam kpiFormParam) {
        KpiForm kf = new KpiForm();
        BeanUtils.copyProperties(kpiFormParam, kf);
        return baseMapper.updateById(kf);
    }

    @Override
    public Integer delete(Long kfId) {
        return baseMapper.deleteById(kfId);
    }

    private EntityWrapper<KpiForm> bindParams(KpiFormParam kpiFormParam) {
        EntityWrapper<KpiForm> ew = new EntityWrapper<>();
        if (kpiFormParam.getKfName() != null) {
            ew.like("kf_name", kpiFormParam.getKfName());
        }
        return ew;
    }
}
