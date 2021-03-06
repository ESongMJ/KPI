package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Nav;
import cn.songmj.kpi.entity.NavPower;
import cn.songmj.kpi.facade.NavPowerFacade;
import cn.songmj.kpi.mapper.NavPowerMapper;
import cn.songmj.kpi.param.NavParam;
import cn.songmj.kpi.param.NavPowerParam;
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
public class NavPowerFacadeImpl extends ServiceImpl<NavPowerMapper, NavPower> implements NavPowerFacade {
    @Override
    public Page<NavPowerParam> page(NavPowerParam navPowerParam) {
        NavPower np1 = new NavPower();
        BeanUtils.copyProperties(navPowerParam, np1);
        Page<NavPower> npPage = new Page<>();
        npPage.setSize(navPowerParam.getPageSize());
        npPage.setCurrent(navPowerParam.getCurrentPage());
        npPage.setRecords(baseMapper.selectJoinPage(npPage, np1));
        List<NavPower> npList = npPage.getRecords();
        // 转化数据格式
        List<NavPowerParam> npParamList = npList.stream().map(np2 -> {
            NavPowerParam npParam = new NavPowerParam();
            BeanUtils.copyProperties(np2, npParam);
            return npParam;
        }).collect(Collectors.toList());
        Page<NavPowerParam> npParamPage = new Page<>();
        BeanUtils.copyProperties(npPage, npParamPage);
        npParamPage.setRecords(npParamList);
        return npParamPage;
    }

    @Override
    public List<NavPowerParam> list(NavPowerParam navPowerParam) {
        // 绑定查询参数
        EntityWrapper<NavPower> ew = new EntityWrapper<>();
        if (navPowerParam.getRoleId() != null) {
            ew.eq("role_id", navPowerParam.getRoleId());
        }
        if (navPowerParam.getNavId() != null) {
            ew.eq("nav_id", navPowerParam.getNavId());
        }
        List<NavPower> npList = baseMapper.selectList(ew);
        // 转化数据格式
        return npList.stream().map(np -> {
            NavPowerParam npParam = new NavPowerParam();
            BeanUtils.copyProperties(np, npParam);
            return npParam;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(NavPowerParam navPowerParam) {
        NavPower np = new NavPower();
        BeanUtils.copyProperties(navPowerParam, np);
        return baseMapper.insert(np);
    }

    @Override
    public Integer update(NavPowerParam navPowerParam) {
        NavPower np = new NavPower();
        BeanUtils.copyProperties(navPowerParam, np);
        return baseMapper.updateById(np);
    }

    @Override
    public Integer delete(Long npId) {
        return baseMapper.deleteById(npId);
    }

    @Override
    public List<NavParam> listNav(Long roleId) {
        List<Nav> navList = baseMapper.selectPower(roleId);
        // 转化数据格式
        return navList.stream().map(nav -> {
            NavParam navParam = new NavParam();
            BeanUtils.copyProperties(nav, navParam);
            return navParam;
        }).collect(Collectors.toList());
    }
}
