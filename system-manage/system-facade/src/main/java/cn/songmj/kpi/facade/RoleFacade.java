package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.Role;
import cn.songmj.kpi.param.RoleParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;


/**
 * <p>
 *  角色接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface RoleFacade extends IService<Role> {

    /**
     * 分页获取角色列表
     *
     * @param roleParam
     * @return
     */
    Page<RoleParam> page(RoleParam roleParam);

    /**
     * 增加角色
     *
     * @param roleParam
     * @return
     */
    Integer insert(RoleParam roleParam);

    /**
     * 更新角色信息
     *
     * @param roleParam
     * @return
     */
    Integer update(RoleParam roleParam);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    Integer delete(Long roleId);
}
