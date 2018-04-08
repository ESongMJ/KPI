package cn.songmj.kpi.service;


import cn.songmj.kpi.dto.RoleDto;
import cn.songmj.kpi.param.RoleParam;

import java.util.List;

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
    List<RoleDto> list(RoleParam roleParam);
}
