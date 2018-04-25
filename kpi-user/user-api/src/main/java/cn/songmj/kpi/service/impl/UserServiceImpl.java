package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.UserFacade;
import cn.songmj.kpi.param.UserParam;
import cn.songmj.kpi.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class UserServiceImpl implements UserService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private UserFacade userFacade;

    @Override
    public Page<UserParam> page(UserParam userParam) {
        if (userParam.getPageSize() == null) {
            userParam.setPageSize(10);
        }
        if (userParam.getCurrentPage() == null) {
            userParam.setCurrentPage(1);
        }
        return userFacade.page(userParam);
    }

    @Override
    public List<UserParam> list(UserParam userParam) {
        return userFacade.list(userParam);
    }

    @Override
    public List<String> listUserIds(UserParam userParam) {
        List<UserParam> userParamList = userFacade.list(userParam);
        return userParamList.stream().map(user -> String.valueOf(user.getUserId())).collect(Collectors.toList());
    }

    @Override
    public Boolean checkRepeat(UserParam userParam) {
        return userFacade.checkRepeat(userParam);
    }

    @Override
    public Integer delete(Long userId) {
        return userFacade.delete(userId);
    }

    @Override
    public Integer save(UserParam userParam) {
        if (userParam.getUserId() == null || userParam.getUserId() == -1) {
            userParam.setUserId(null);
            return userFacade.insert(userParam);
        }
        return userFacade.update(userParam);
    }
    @Override
    public UserParam getUserById(Long userId) {
        UserParam userParam = new UserParam();
        BeanUtils.copyProperties(userFacade.selectById(userId), userParam);
        return userParam;
    }
}
