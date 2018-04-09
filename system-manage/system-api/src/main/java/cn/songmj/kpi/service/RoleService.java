package cn.songmj.kpi.service;


import cn.songmj.kpi.param.RoleParam;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface RoleService {
    /**
     * 查询角色列表
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
