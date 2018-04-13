package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author meijie.song
 * @date 2018/3/23
 * @time 下午 10:23
 **/
@Data
public class RoleParam extends PageParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    private String roleName;
    private String roleDescription;
}
