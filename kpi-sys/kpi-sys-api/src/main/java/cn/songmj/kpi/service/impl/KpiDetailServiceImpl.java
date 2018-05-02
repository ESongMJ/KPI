package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiDetailFacade;
import cn.songmj.kpi.param.KpiDetailParam;
import cn.songmj.kpi.param.StatisticalObj;
import cn.songmj.kpi.service.KpiDetailService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
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
public class KpiDetailServiceImpl implements KpiDetailService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiDetailFacade kpiDetailFacade;

    @Override
    public Integer save(KpiDetailParam kpiDetailParam) {
        if (kpiDetailParam.getKdId() == null || kpiDetailParam.getKdId() == -1){
            kpiDetailParam.setKdId(null);
            // 设置默认状态，即审核中
            kpiDetailParam.setKdStatus(1);
            return kpiDetailFacade.insert(kpiDetailParam);
        }
        return kpiDetailFacade.update(kpiDetailParam);
    }

    @Override
    public Page<KpiDetailParam> pageByUser(KpiDetailParam kpiDetailParam) {
        checkPageParam(kpiDetailParam);
        return kpiDetailFacade.pageByUser(kpiDetailParam);
    }

    @Override
    public Integer updateStatus(KpiDetailParam kpiDetailParam) {
        return kpiDetailFacade.updateStatusById(kpiDetailParam);
    }

    @Override
    public StatisticalObj selectDetail(String kuId) {
        return kpiDetailFacade.selectDetail(kuId);
    }

    private void checkPageParam(KpiDetailParam kpiDetailParam) {
        if (kpiDetailParam.getPageSize() == null) {
            kpiDetailParam.setPageSize(10);
        }
        if (kpiDetailParam.getCurrentPage() == null) {
            kpiDetailParam.setCurrentPage(1);
        }
    }
}
