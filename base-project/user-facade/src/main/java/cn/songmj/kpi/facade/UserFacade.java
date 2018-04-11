package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  用户接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface UserFacade extends IService<User> {
    String sayHello(String name);
}
