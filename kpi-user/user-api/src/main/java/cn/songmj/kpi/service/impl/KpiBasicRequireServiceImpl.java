package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiBasicRequireFacade;
import cn.songmj.kpi.param.KpiBasicRequireParam;
import cn.songmj.kpi.service.KpiBasicRequireService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class KpiBasicRequireServiceImpl implements KpiBasicRequireService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiBasicRequireFacade kpiBasicRequireFacade;

    @Override
    public Page<KpiBasicRequireParam> page(KpiBasicRequireParam kbrParam) {
        if (kbrParam.getPageSize() == null) {
            kbrParam.setPageSize(10);
        }
        if (kbrParam.getCurrentPage() == null) {
            kbrParam.setCurrentPage(1);
        }
        return kpiBasicRequireFacade.page(kbrParam);
    }

    @Override
    public List<KpiBasicRequireParam> list(KpiBasicRequireParam kbrParam) {
        return kpiBasicRequireFacade.list(kbrParam);
    }

    @Override
    public Integer delete(Long kbrId) {
        return kpiBasicRequireFacade.delete(kbrId);
    }

    @Override
    public Integer save(KpiBasicRequireParam kbrParam) {
        if (kbrParam.getKbrId() == null || kbrParam.getKbrId() ==  -1) {
            kbrParam.setKbrId(null);
            return kpiBasicRequireFacade.insert(kbrParam);
        }
        return kpiBasicRequireFacade.update(kbrParam);
    }
}
