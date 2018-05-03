package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.BonusAuditFacade;
import cn.songmj.kpi.param.BonusAuditParam;
import cn.songmj.kpi.service.BonusAuditService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class BonusAuditServiceImpl implements BonusAuditService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private BonusAuditFacade bonusAuditFacade;

    @Override
    public Integer save(BonusAuditParam bonusAuditParam) {
        if (bonusAuditParam.getBaId() == null || bonusAuditParam.getBaId() == -1) {
            return bonusAuditFacade.insert(bonusAuditParam);
        }
        return bonusAuditFacade.updateById(bonusAuditParam);
    }

    @Override
    public BonusAuditParam selectOne(Long yebId) {
        return bonusAuditFacade.selectOne(yebId);
    }
}
