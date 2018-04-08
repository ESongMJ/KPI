package cn.songmj.kpi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class RoleDto implements Serializable {

    private Integer roleId;
    private String roleName;
    private String roleDescription;
}
