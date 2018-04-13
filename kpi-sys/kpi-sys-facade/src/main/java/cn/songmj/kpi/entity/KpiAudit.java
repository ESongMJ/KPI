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
 * 绩效审核
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kpi_audit")
public class KpiAudit extends Model<KpiAudit> implements Serializable {
    @TableId("ka_id")
    private Long kaId;
    /**
     * 绩效申请详情
     */
    @TableField("kd_id")
    private Long kdId;
    /**
     * 审批结果
     */
    @TableField("ka_result")
    private String kaResult;
    /**
     * 审批信息
     */
    @TableField("ka_msg")
    private String kaMsg;

    @Override
    protected Serializable pkVal() {
        return this.kaId;
    }
}
