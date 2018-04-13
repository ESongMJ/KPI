package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiAuditFacade;
import cn.songmj.kpi.service.KpiAuditService;
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
public class KpiAuditServiceImpl implements KpiAuditService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiAuditFacade kpiAuditFacade;

}
