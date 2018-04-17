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
 * 绩效内容
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kp")
public class KpiContent extends Model<KpiContent> implements Serializable {

    @TableId("kc_id")
    private Long kcId;
    @TableField("kc_name")
    private String kcName;
    @TableField("kc_description")
    private String kcDescription;
    /**
     * 绩效标准
     */
    @TableField("kc_standard")
    private String kcStandard;
    /**
     * 绩效观测点
     */
    @TableField("kp_id")
    private Long kpId;
    @TableField(exist = false)
    private KpiPoint kp;

    @Override
    protected Serializable pkVal() {
        return this.kcId;
    }
}
