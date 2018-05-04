package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 年终奖预报审核
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class BonusAuditParam extends PageParam implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long baId;
    /**
     * 年终预报
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long yebId;
    /**
     * 审核结果
     */
    private Integer baResult;
    /**
     * 审核信息
     */
    private String baReason;
}
