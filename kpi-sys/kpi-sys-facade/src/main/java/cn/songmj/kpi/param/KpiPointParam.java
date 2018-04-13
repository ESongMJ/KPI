package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效观测点
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiPointParam extends PageParam implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kpId;
    private String kpName;
    private String kpDescription;
    /**
     * 观测点类型
     */
    private Integer kpType;
}
