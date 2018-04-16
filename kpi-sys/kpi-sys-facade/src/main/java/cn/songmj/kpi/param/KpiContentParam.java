package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效内容
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiContentParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long kcId;
    private String kcName;
    private String kcDescription;
    /**
     * 绩效标准
     */
    private String kcStandard;
    /**
     * 绩效观测点
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kpId;
    private String kpName;
    private Integer kpType;
    private Long userId;
}
