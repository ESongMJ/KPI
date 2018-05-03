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
 * 收益分配表
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("benefit_alloca")
public class BenefitAlloca extends Model<BenefitAlloca> implements Serializable {
    @TableId("ba_id")
    private Integer baId;
    /**
     * 绩效表单详情
     */
    @TableField("kd_id")
    private Integer kdId;
    @TableField("user_id")
    private Integer userId;
    /**
     * 受益分配分数
     */
    @TableField("ba_score")
    private String baScore;
    /**
     * 受益分配理由
     */
    @TableField("ba_reason")
    private String baReason;

    @Override
    protected Serializable pkVal() {
        return this.baId;
    }
}
