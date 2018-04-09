package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Nav;
import cn.songmj.kpi.facade.NavFacade;
import cn.songmj.kpi.mapper.NavMapper;
import cn.songmj.kpi.param.NavParam;
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
public class NavFacadeImpl extends ServiceImpl<NavMapper, Nav> implements NavFacade {
    @Override
    public Page<NavParam> page(NavParam navParam) {
        Page<Nav> page = new Page<>();
        EntityWrapper<Nav> ew = new EntityWrapper<>();
        if (navParam.getNavName() != null) {
            ew.or().like("nva_name", navParam.getNavName());
        }
        if (navParam.getNavTips() != null) {
            ew.or().like("nva_tips", navParam.getNavTips());
        }
        page.setSize(navParam.getPageSize());
        page.setCurrent(navParam.getCurrentPage());
        List<Nav> navList = baseMapper.selectPage(page, ew);
        Page<NavParam> paramPage = new Page<>();
        BeanUtils.copyProperties(page, paramPage);
        paramPage.setRecords(navList.stream().map(nav1 -> {
            NavParam param = new NavParam();
            BeanUtils.copyProperties(nav1, param);
            return param;
        }).collect(Collectors.toList()));

        return paramPage;
    }

    @Override
    public List<NavParam> list() {
        List<Nav> navList = baseMapper.selectList(new EntityWrapper<>());
        return navList.stream().map(nav -> {
            NavParam navParam = new NavParam();
            BeanUtils.copyProperties(nav, navParam);
            return navParam;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer insert(NavParam navParam) {
        Nav nav = new Nav();
        BeanUtils.copyProperties(navParam, nav);

        return baseMapper.insert(nav);
    }

    @Override
    public Integer update(NavParam navParam) {
        Nav nav = new Nav();
        BeanUtils.copyProperties(navParam, nav);
        return baseMapper.updateById(nav);
    }

    @Override
    public Integer delete(Long navId) {
        return baseMapper.deleteById(navId);
    }
}
