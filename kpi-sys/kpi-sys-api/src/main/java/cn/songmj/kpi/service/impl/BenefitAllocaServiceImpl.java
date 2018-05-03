package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.BenefitAllocaFacade;
import cn.songmj.kpi.service.BenefitAllocaService;
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
public class BenefitAllocaServiceImpl implements BenefitAllocaService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private BenefitAllocaFacade benefitAllocaFacade;

}
