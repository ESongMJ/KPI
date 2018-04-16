package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiFormFacade;
import cn.songmj.kpi.param.KpiFormParam;
import cn.songmj.kpi.service.KpiFormService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class KpiFormServiceImpl implements KpiFormService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiFormFacade kpiFormFacade;

    @Override
    public Page<KpiFormParam> page(KpiFormParam kpiFormParam) {
        checkPageParam(kpiFormParam);
        return kpiFormFacade.page(kpiFormParam);
    }

    @Override
    public List<KpiFormParam> list(KpiFormParam kpiFormParam) {
        return kpiFormFacade.list(kpiFormParam);
    }

    @Override
    public Integer save(KpiFormParam kpiFormParam) {
        if (kpiFormParam.getKfId() == null || kpiFormParam.getKfId() == -1) {
            kpiFormParam.setKfId(null);
            kpiFormFacade.insert(kpiFormParam);
        }
        return kpiFormFacade.update(kpiFormParam);
    }

    @Override
    public Integer delete(Long kfId) {
        return kpiFormFacade.delete(kfId);
    }

    private void checkPageParam(KpiFormParam kpiFormParam) {
        if (kpiFormParam.getPageSize() == null) {
            kpiFormParam.setPageSize(10);
        }
        if (kpiFormParam.getCurrentPage() == null) {
            kpiFormParam.setCurrentPage(1);
        }
    }
}
