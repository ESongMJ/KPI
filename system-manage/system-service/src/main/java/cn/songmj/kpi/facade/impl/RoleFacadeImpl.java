package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.data.RoleData;
import cn.songmj.kpi.dto.RoleDto;
import cn.songmj.kpi.entity.Role;
import cn.songmj.kpi.facade.RoleFacade;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/9
 **/
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class RoleFacadeImpl implements RoleFacade {
    @Resource
    private RoleData roleData;
    @Override
    public List<RoleDto> list(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        List list = roleData.list(role);
        return null;
    }
}
