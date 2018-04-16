package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiDetailFacade;
import cn.songmj.kpi.param.KpiDetailParam;
import cn.songmj.kpi.service.KpiDetailService;
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
            return kpiDetailFacade.insert(kpiDetailParam);
        }
        return kpiDetailFacade.update(kpiDetailParam);
    }
}
