package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("year_end_bonus")
public class YearEndBonus extends Model<YearEndBonus> implements Serializable {

    @TableId("yeb_id")
    private Long yebId;
    @TableField("yeb_name")
    private String yebName;
    @TableField("user_id")
    private Long userId;
    /**
     * 申请金额
     */
    @TableField("yeb_money")
    private Float yebMoney;
    /**
     * 教学分数
     */
    @TableField("yeb_teach_score")
    private Float yebTeachScore;
    /**
     * 科研分数
     */
    @TableField("yeb_research_score")
    private Float yebResearchScore;
    /**
     * 基础绩效
     */
    @TableField("yeb_basic_kpi")
    private String yebBasicKpi;
    /**
     * 奖励绩效
     */
    @TableField("yeb_award_kpi")
    private String yebAwardKpi;
    /**
     * 减免工作量
     */
    @TableField("yeb_reduce_workload")
    private String yebReduceWorkload;
    /**
     * 减免理由
     */
    @TableField("yeb_reduce_reaon")
    private String yebReduceReaon;
    /**
     * 审核状态
     */
    @TableField("yeb_status")
    private Integer yebStatus;

    @Override
    protected Serializable pkVal() {
        return this.yebId;
    }
}
