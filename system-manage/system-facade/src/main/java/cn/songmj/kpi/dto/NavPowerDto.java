package cn.songmj.kpi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 版块权限
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class NavPowerDto implements Serializable {

    private Integer npId;
    /**
     * 角色
     */
    private Integer roleId;
    /**
     * 版块
     */
    private Integer navId;
}
