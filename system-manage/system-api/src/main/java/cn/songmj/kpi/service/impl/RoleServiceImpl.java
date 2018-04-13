package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.RoleFacade;
import cn.songmj.kpi.param.RoleParam;
import cn.songmj.kpi.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private RoleFacade roleFacade;

    @Override
    public Page<RoleParam> page(RoleParam roleParam) {
        return roleFacade.page(roleParam);
    }

    @Override
    public List<RoleParam> list(RoleParam roleParam) {
        return roleFacade.list(roleParam);
    }

    @Override
    public Integer insert(RoleParam roleParam) {
        return roleFacade.insert(roleParam);
    }

    @Override
    public Integer update(RoleParam roleParam) {
        return roleFacade.update(roleParam);
    }

    @Override
    public Integer delete(Long roleId) {
        return roleFacade.delete(roleId);
    }

    @Override
    public RoleParam selectById(Long roleId) {
        return roleFacade.selectById(roleId);
    }
}
