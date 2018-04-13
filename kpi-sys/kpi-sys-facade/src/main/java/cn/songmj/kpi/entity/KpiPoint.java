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
 * 绩效观测点
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kpi_point")
public class KpiPoint extends Model<KpiPoint> implements Serializable {
    @TableId("kp_id")
    private Long kpId;
    @TableField("kp_name")
    private String kpName;
    @TableField("kp_description")
    private String kpDescription;
    /**
     * 观测点类型
     */
    @TableField("kp_type")
    private Integer kpType;

    @Override
    protected Serializable pkVal() {
        return this.kpId;
    }
}
