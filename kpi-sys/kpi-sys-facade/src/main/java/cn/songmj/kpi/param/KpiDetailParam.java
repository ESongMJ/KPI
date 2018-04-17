package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效申请详情
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiDetailParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long kdId;
    /**
     * 绩效表单 ==>> 对应用户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kuId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String userName;
    /**
     * 绩效内容
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kcId;
    private KpiContentParam kc;
    /**
     * 申请分数
     */
    private Float kdScore;
    /**
     * 申请理由
     */
    private String kdReason;
    /**
     * 受益类型 1.个人 2.团体
     */
    private Integer kdBenefitType;
    /**
     * 审核状态
     */
    private Integer kdStatus;
    /**
     * 绩效类型
     * 非数据库字段
     */
    private Integer kpType;
    private Long kpId;
}
