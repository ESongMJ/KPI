package cn.songmj.kpi.facade;

import cn.songmj.kpi.dto.RoleDto;

import java.util.List;

/**
 * <p>
 *  角色接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface RoleFacade {

    List<RoleDto> list(RoleDto role);
}
