package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiBasicRequire;
import cn.songmj.kpi.facade.KpiBasicRequireFacade;
import cn.songmj.kpi.mapper.KpiBasicRequireMapper;
import cn.songmj.kpi.param.KpiBasicRequireParam;
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
public class KpiBasicRequireFacadeImpl extends ServiceImpl<KpiBasicRequireMapper, KpiBasicRequire> implements KpiBasicRequireFacade {

    @Override
    public Page<KpiBasicRequireParam> page(KpiBasicRequireParam kbrParam) {
        Page<KpiBasicRequire> kbrPage = new Page<>();
        EntityWrapper<KpiBasicRequire> ew = new EntityWrapper<>();
        if (kbrParam.getKbrType() != null) {
            ew.like("kbr_type", kbrParam.getKbrType());
        }
        kbrPage.setSize(kbrParam.getPageSize());
        kbrPage.setCurrent(kbrParam.getCurrentPage());
        kbrPage.setRecords(baseMapper.selectPage(kbrPage, ew));
        Page<KpiBasicRequireParam> kbrParamPage = new Page<>();
        BeanUtils.copyProperties(kbrPage, kbrParamPage);
        //把list中的实体类对象数据转化为实体参数对象，防止long型精度截断
        kbrParamPage.setRecords(kbrPage.getRecords().stream().map(kbr->{
            KpiBasicRequireParam kbrParam1 = new KpiBasicRequireParam();
            BeanUtils.copyProperties(kbr, kbrParam1);
            return kbrParam1;
        }).collect(Collectors.toList()));
        return kbrParamPage;
    }

    @Override
    public List<KpiBasicRequireParam> list(KpiBasicRequireParam kbrParam) {
        EntityWrapper<KpiBasicRequire> ew = new EntityWrapper<>();
        if (kbrParam.getKbrType() != null) {
            ew.like("kbr_type", kbrParam.getKbrType());
        }
        List<KpiBasicRequire> kbrList = baseMapper.selectList(ew);
        return kbrList.stream().map(kbr -> {
            KpiBasicRequireParam kbrParam1 = new KpiBasicRequireParam();
            BeanUtils.copyProperties(kbr, kbrParam1);
            return kbrParam1;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer delete(Long kbrId) {
        return baseMapper.deleteById(kbrId);
    }

    @Override
    public Integer insert(KpiBasicRequireParam kbrParam) {
        KpiBasicRequire kbr = new KpiBasicRequire();
        BeanUtils.copyProperties(kbrParam, kbr);
        return baseMapper.insert(kbr);
    }

    @Override
    public Integer update(KpiBasicRequireParam kbrParam) {
        KpiBasicRequire kbr = new KpiBasicRequire();
        BeanUtils.copyProperties(kbrParam, kbr);
        return baseMapper.updateById(kbr);
    }
}
