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
 * 年终奖预报审核
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("bonus_audit")
public class BonusAudit extends Model<BonusAudit> implements Serializable {
    @TableId("ba_id")
    private Integer baId;
    /**
     * 年终预报
     */
    @TableField("yeb_id")
    private Integer yebId;
    /**
     * 审核结果
     */
    @TableField("ba_result")
    private String baResult;
    /**
     * 审核信息
     */
    @TableField("ba_reason")
    private String baReason;

    @Override
    protected Serializable pkVal() {
        return this.baId;
    }
}
