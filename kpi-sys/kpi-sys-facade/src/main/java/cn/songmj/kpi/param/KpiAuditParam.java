package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效审核
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiAuditParam extends PageParam implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kaId;
    /**
     * 绩效申请详情
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kdId;
    /**
     * 审批结果
     */
    private Integer kaResult;
    /**
     * 审批信息
     */
    private String kaMsg;
}
