package cn.songmj.kpi.data;

import cn.songmj.kpi.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  角色接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface RoleData extends IService<Role> {

    List<Role> list(Role role);
}
