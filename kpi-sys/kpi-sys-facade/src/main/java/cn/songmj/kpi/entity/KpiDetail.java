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
 * 绩效申请详情
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kpi_detail")
public class KpiDetail extends Model<KpiDetail> implements Serializable {

    @TableId("kd_id")
    private Long kdId;
    /**
     * 绩效表单 ==>> 对应用户
     */
    @TableField("ku_id")
    private Long kuId;
    @TableField(exist = false)
    private Long userId;
    @TableField(exist = false)
    private String userName;
    /**
     * 绩效内容
     */
    @TableField("kc_id")
    private Long kcId;
    @TableField(exist = false)
    private KpiContent kc;
    /**
     * 申请分数
     */
    @TableField("kd_score")
    private Float kdScore;
    /**
     * 申请理由
     */
    @TableField("kd_reason")
    private String kdReason;
    /**
     * 受益类型 1.个人 2.团体
     */
    @TableField("kd_benefit_type")
    private Integer kdBenefitType;
    /**
     * 审核状态
     */
    @TableField("kd_status")
    private Integer kdStatus;
    /**
     * 绩效类型
     * 非数据库字段
     */
    @TableField(exist = false)
    private Integer kpType;
    @TableField(exist = false)
    private Long kpId;


    @Override
    protected Serializable pkVal() {
        return this.kdId;
    }
}
