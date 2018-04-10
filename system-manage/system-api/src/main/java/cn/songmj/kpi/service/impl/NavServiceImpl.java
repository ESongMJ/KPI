package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.NavFacade;
import cn.songmj.kpi.param.NavParam;
import cn.songmj.kpi.service.NavService;
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
public class NavServiceImpl implements NavService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private NavFacade navFacade;

    @Override
    public Page<NavParam> page(NavParam navParam) {
        return navFacade.page(navParam);
    }

    @Override
    public List<NavParam> list(NavParam navParam) {
        return navFacade.list(navParam);
    }

    @Override
    public Integer save(NavParam navParam) {
        if (navParam.getNavId() == null || navParam.getNavId() == -1) {
            // 重置为null是为了让mybatis-plus生成uuid
            navParam.setNavId(null);
            return navFacade.insert(navParam);
        } else {
            return navFacade.update(navParam);
        }
    }


    @Override
    public Integer delete(Long navId) {
        return navFacade.delete(navId);
    }
}
