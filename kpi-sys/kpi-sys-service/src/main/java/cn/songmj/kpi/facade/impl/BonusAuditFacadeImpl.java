package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.BonusAudit;
import cn.songmj.kpi.facade.BonusAuditFacade;
import cn.songmj.kpi.mapper.BonusAuditMapper;
import cn.songmj.kpi.param.BonusAuditParam;
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
public class BonusAuditFacadeImpl extends ServiceImpl<BonusAuditMapper, BonusAudit> implements BonusAuditFacade {

    @Override
    public Integer insert(BonusAuditParam bonusAuditParam) {
        BonusAudit bonusAudit = getEntityByParam(bonusAuditParam);
        return baseMapper.insert(bonusAudit);
    }

    @Override
    public Integer updateById(BonusAuditParam bonusAuditParam) {
        BonusAudit bonusAudit = getEntityByParam(bonusAuditParam);
        return baseMapper.updateById(bonusAudit);
    }

    @Override
    public BonusAuditParam selectOne(Long yebId) {
        EntityWrapper<BonusAudit> ew = new EntityWrapper<>();
        ew.eq("yeb_id", yebId);
        List<BonusAudit> bonusAudit = baseMapper.selectList(ew);
        // 没有数据
        if (bonusAudit.size() <= 0) {
            return null;
        }
        return getParamByEntity(bonusAudit.get(0));
    }

    private BonusAudit getEntityByParam(BonusAuditParam bonusAuditParam) {
        BonusAudit bonusAudit = new BonusAudit();
        BeanUtils.copyProperties(bonusAuditParam, bonusAudit);
        return bonusAudit;
    }

    private BonusAuditParam getParamByEntity(BonusAudit bonusAudit) {
        BonusAuditParam bonusAuditParam = new BonusAuditParam();
        BeanUtils.copyProperties(bonusAudit, bonusAuditParam);
        return bonusAuditParam;
    }
}
