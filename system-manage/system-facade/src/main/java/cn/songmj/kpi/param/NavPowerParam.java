package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class NavPowerParam extends PageParam implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long npId;
    /**
     * 角色
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    /**
     * 版块
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long navId;
}
