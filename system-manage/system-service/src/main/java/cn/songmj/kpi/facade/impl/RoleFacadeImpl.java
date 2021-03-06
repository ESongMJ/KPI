package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Role;
import cn.songmj.kpi.facade.RoleFacade;
import cn.songmj.kpi.mapper.RoleMapper;
import cn.songmj.kpi.param.RoleParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

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
public class RoleFacadeImpl extends ServiceImpl<RoleMapper, Role> implements RoleFacade {
    @Override
    public Page<RoleParam> page(RoleParam roleParam) {
        Page<Role> page = new Page<>();
        // 绑定查询参数
        EntityWrapper<Role> ew = new EntityWrapper<>();
        if (roleParam.getRoleName() != null) {
            ew.or();
            ew.like("role_name", roleParam.getRoleName());
        }
        if (roleParam.getRoleDescription() != null) {
            ew.or();
            ew.like("role_description", roleParam.getRoleDescription());
        }
        page.setSize(roleParam.getPageSize());
        page.setCurrent(roleParam.getCurrentPage());
        List<Role> roleList = baseMapper.selectPage(page, ew);
        Page<RoleParam> paramPage = new Page<>();
        BeanUtils.copyProperties(page, paramPage);
        // 转化数据格式
        paramPage.setRecords(roleList.stream().map(role -> {
            RoleParam param = new RoleParam();
            BeanUtils.copyProperties(role, param);
            return param;
        }).collect(Collectors.toList()));

        return paramPage;
    }

    @Override
    public List<RoleParam> list(RoleParam roleParam) {
        // 绑定查询参数
        EntityWrapper<Role> ew = new EntityWrapper<>();
        if (roleParam.getRoleName() != null) {
            ew.or();
            ew.like("role_name", roleParam.getRoleName());
        }
        if (roleParam.getRoleDescription() != null) {
            ew.or();
            ew.like("role_description", roleParam.getRoleDescription());
        }
        List<Role> roleList = baseMapper.selectList(ew);
        return roleList.stream().map(role -> {
            RoleParam rp = new RoleParam();
            BeanUtils.copyProperties(role, rp);
            return rp;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(RoleParam roleParam) {
        Role role = new Role();
        BeanUtils.copyProperties(roleParam, role);

        return baseMapper.insert(role);
    }

    @Override
    public Integer update(RoleParam roleParam) {
        Role role = new Role();
        BeanUtils.copyProperties(roleParam, role);

        return baseMapper.updateById(role);
    }

    @Override
    public Integer delete(Long roleId) {
        return baseMapper.deleteById(roleId);
    }

    @Override
    public RoleParam selectById(Long roleId) {
        Role role = baseMapper.selectById(roleId);
        RoleParam roleParam = new RoleParam();
        BeanUtils.copyProperties(role, roleParam);
        return roleParam;
    }
}
