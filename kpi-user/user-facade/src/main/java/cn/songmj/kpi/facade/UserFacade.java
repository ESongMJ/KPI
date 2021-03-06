package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.User;
import cn.songmj.kpi.param.UserParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  用户接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface UserFacade extends IService<User> {
    /**
     * 分页查询数据
     * @param userParam
     * @return
     */
    Page<UserParam> page(UserParam userParam);

    /**
     * 列表查询数据
     * @param userParam
     * @return
     */
    List<UserParam> list(UserParam userParam);

    /**
     * 检查用户是否重复
     * 适用情况：在更新或者插入数据时，在注册用户时
     * @param userParam
     * @return
     */
    Boolean checkRepeat(UserParam userParam);
    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer delete(Long userId);

    /**
     * 插入用户
     * @param userParam
     * @return
     */
    Integer insert(UserParam userParam);

    /**
     * 更新用户
     * @param userParam
     * @return
     */
    Integer update(UserParam userParam);
}
