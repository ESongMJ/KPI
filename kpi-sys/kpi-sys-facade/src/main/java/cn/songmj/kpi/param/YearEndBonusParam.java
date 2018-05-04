package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 年终奖预报
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class YearEndBonusParam extends PageParam implements Serializable{

    @JsonSerialize(using = ToStringSerializer.class)
    private Long yebId;
    private String yebName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String userName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kuId;
    /**
     * 申请金额
     */
    private Float yebMoney;
    /**
     * 教学分数
     */
    private Float yebTeachScore;
    /**
     * 科研分数
     */
    private Float yebResearchScore;
    /**
     * 基础绩效
     */
    private String yebBasicKpi;
    /**
     * 奖励绩效
     */
    private String yebAwardKpi;
    /**
     * 减免工作量
     */
    private String yebReduceWorkload;
    /**
     * 减免理由
     */
    private String yebReduceReason;
    /**
     * 审核状态
     */
    private Integer yebStatus;
}
