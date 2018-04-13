package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiPointFacade;
import cn.songmj.kpi.param.KpiPointParam;
import cn.songmj.kpi.service.KpiPointService;
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
public class KpiPointServiceImpl implements KpiPointService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiPointFacade kpiPointFacade;

    @Override
    public Page<KpiPointParam> page(KpiPointParam kpiPointParam) {
        kpiPointParam = checkPageParam(kpiPointParam);
        return kpiPointFacade.page(kpiPointParam);
    }

    @Override
    public List<KpiPointParam> list(KpiPointParam kpiPointParam) {
        return kpiPointFacade.list(kpiPointParam);
    }

    @Override
    public Integer save(KpiPointParam kpiPointParam) {
        if (kpiPointParam.getKpId() == null || kpiPointParam.getKpId() == -1) {
            kpiPointParam.setKpId(null);
            return kpiPointFacade.insert(kpiPointParam);
        }
        return kpiPointFacade.update(kpiPointParam);
    }

    @Override
    public Integer delete(Long kpId) {
        return kpiPointFacade.delete(kpId);
    }
    private KpiPointParam checkPageParam(KpiPointParam kpiPointParam) {
        if (kpiPointParam.getPageSize() == null) {
            kpiPointParam.setPageSize(10);
        }
        if (kpiPointParam.getCurrentPage() == null) {
            kpiPointParam.setCurrentPage(1);
        }
        return kpiPointParam;
    }
}
