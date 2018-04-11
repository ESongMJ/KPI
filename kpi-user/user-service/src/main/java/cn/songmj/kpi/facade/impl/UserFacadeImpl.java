package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.User;
import cn.songmj.kpi.facade.UserFacade;
import cn.songmj.kpi.mapper.UserMapper;
import cn.songmj.kpi.param.UserParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class UserFacadeImpl extends ServiceImpl<UserMapper, User> implements UserFacade {

    @Override
    public Page<UserParam> page(UserParam userParam) {
        Page<User> userPage = new Page<>();
        userPage.setSize(userParam.getPageSize());
        userPage.setCurrent(userParam.getCurrentPage());
        EntityWrapper<User> ew = new EntityWrapper<>();
        if (userParam.getUserName() != null) {
            ew.like("user_name", userParam.getUserName());
        }
        if (userParam.getUserIntroduce() != null) {
            ew.like("user_introduce", userParam.getUserIntroduce());
        }
        // 根据职业方向查找
        if (userParam.getUserRO() != null) {
            ew.like("user_r_o", userParam.getUserRO());
        }
        userPage.setRecords(baseMapper.selectPage(userPage, ew));
        Page<UserParam> userParamPage = new Page<>();
        BeanUtils.copyProperties(userPage, userParamPage);
        userParamPage.setRecords(userPage.getRecords().stream().map(user -> {
            UserParam up = new UserParam();
            BeanUtils.copyProperties(user, up);
            return up;
        }).collect(Collectors.toList()));

        return userParamPage;
    }

    @Override
    public List<UserParam> list(UserParam userParam) {
        EntityWrapper<User> ew = new EntityWrapper<>();
        if (userParam.getUserNumber() != null) {
            ew.like("user_number", userParam.getUserNumber());
        }
        if (userParam.getUserName() != null) {
            ew.like("user_name", userParam.getUserName());
        }
        if (userParam.getUserIntroduce() != null) {
            ew.like("user_introduce", userParam.getUserIntroduce());
        }
        // 根据职业方向查找
        if (userParam.getUserRO() != null) {
            ew.like("user_r_o", userParam.getUserRO());
        }
        List<User> userList = baseMapper.selectList(ew);
        return userList.stream().map(user -> {
            UserParam up = new UserParam();
            BeanUtils.copyProperties(user, up);
            return up;
        }).collect(Collectors.toList());
    }

    @Override
    public Boolean checkRepeat(UserParam userParam) {
        EntityWrapper<User> ew = new EntityWrapper<>();
        if (userParam.getUserNumber() != null) {
            ew.like("user_number", userParam.getUserNumber());
        }
        List<User> userList = baseMapper.selectList(ew);
        return userList.size() > 0;
    }

    @Override
    public Integer delete(Long userId) {
        return baseMapper.deleteById(userId);
    }

    @Override
    public Integer insert(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        return baseMapper.insert(user);
    }

    @Override
    public Integer update(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        return baseMapper.updateById(user);
    }
}
