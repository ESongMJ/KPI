package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.dto.RoleDto;
import cn.songmj.kpi.facade.RoleFacade;
import cn.songmj.kpi.param.RoleParam;
import cn.songmj.kpi.service.RoleService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
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
    public List<RoleDto> list(RoleParam roleParam) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleParam, roleDto);

        return roleFacade.list(roleDto);
    }
}
