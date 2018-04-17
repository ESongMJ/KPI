package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiAudit;
import cn.songmj.kpi.facade.KpiAuditFacade;
import cn.songmj.kpi.mapper.KpiAuditMapper;
import cn.songmj.kpi.param.KpiAuditParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

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
public class KpiAuditFacadeImpl extends ServiceImpl<KpiAuditMapper, KpiAudit> implements KpiAuditFacade {

    @Override
    public Integer insert(KpiAuditParam kpiAuditParam) {
        KpiAudit ka = new KpiAudit();
        BeanUtils.copyProperties(kpiAuditParam, ka);
        return baseMapper.insert(ka);
    }

    @Override
    public Integer update(KpiAuditParam kpiAuditParam) {
        KpiAudit ka = new KpiAudit();
        BeanUtils.copyProperties(kpiAuditParam, ka);
        return baseMapper.updateById(ka);
    }

    @Override
    public KpiAuditParam getOne(Long kdId) {
        KpiAuditParam kpiAuditParam = new KpiAuditParam();
        EntityWrapper<KpiAudit> ew = new EntityWrapper<>();
        ew.eq("kd_id", kdId);
        List<KpiAudit> kaList = baseMapper.selectList(ew);
        if (kaList.size() > 0) {
            BeanUtils.copyProperties(kaList.get(0), kpiAuditParam);
            return kpiAuditParam;
        }
        return null;
    }
}
