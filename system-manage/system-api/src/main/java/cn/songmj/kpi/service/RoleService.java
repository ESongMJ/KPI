package cn.songmj.kpi.service;


import cn.songmj.kpi.param.RoleParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface RoleService {
    /**
     * 查询角色列表
     *
     * @param roleParam
     * @return
     */
    Page<RoleParam> page(RoleParam roleParam);

    /**
     * 列表查询
     *
     * @param roleParam
     * @return
     */
    List<RoleParam> list(RoleParam roleParam);

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

    /**
     * 根据id查找角色
     * @param roleId
     * @return
     */
    RoleParam selectById(Long roleId);
}
