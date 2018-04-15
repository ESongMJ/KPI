package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiContentFacade;
import cn.songmj.kpi.param.KpiContentParam;
import cn.songmj.kpi.service.KpiContentService;
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
public class KpiContentServiceImpl implements KpiContentService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiContentFacade kpiContentFacade;

    @Override
    public Page<KpiContentParam> page(KpiContentParam kpiContentParam) {
        kpiContentParam = checkPageParam(kpiContentParam);
        return kpiContentFacade.page(kpiContentParam);
    }

    @Override
    public List<KpiContentParam> list(KpiContentParam kpiContentParam) {
        return kpiContentFacade.list(kpiContentParam);
    }

    @Override
    public Integer save(KpiContentParam kpiContentParam) {
        if (kpiContentParam.getKcId() == null || kpiContentParam.getKcId() == -1) {
            kpiContentParam.setKcId(null);
            return kpiContentFacade.insert(kpiContentParam);
        }
        return kpiContentFacade.update(kpiContentParam);
    }

    @Override
    public Integer delete(Long kcId) {
        return kpiContentFacade.delete(kcId);
    }
    private KpiContentParam checkPageParam(KpiContentParam kpiContentParam) {
        if (kpiContentParam.getPageSize() == null) {
            kpiContentParam.setPageSize(10);
        }
        if (kpiContentParam.getCurrentPage() == null) {
            kpiContentParam.setCurrentPage(1);
        }
        return kpiContentParam;
    }
}
