package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.NavPowerFacade;
import cn.songmj.kpi.param.NavPowerParam;
import cn.songmj.kpi.service.NavPowerService;
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
public class NavPowerServiceImpl implements NavPowerService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private NavPowerFacade navPowerFacade;

    @Override
    public Page<NavPowerParam> page(NavPowerParam navPowerParam) {
        return navPowerFacade.page(navPowerParam);
    }

    @Override
    public boolean checkRepeat(NavPowerParam navPowerParam) {
        List<NavPowerParam> npParamList = navPowerFacade.list(navPowerParam);
        if (npParamList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Integer save(NavPowerParam navPowerParam) {
        if (navPowerParam.getNpId() == null || navPowerParam.getNpId() == -1) {
            navPowerParam.setNpId(null);
            return navPowerFacade.insert(navPowerParam);
        } else {
            return navPowerFacade.update(navPowerParam);
        }
    }


    @Override
    public Integer delete(Long npId) {
        return navPowerFacade.delete(npId);
    }
}
