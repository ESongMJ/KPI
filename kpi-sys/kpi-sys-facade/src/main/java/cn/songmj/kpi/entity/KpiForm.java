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
 * 绩效申请表单
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kpi_form")
public class KpiForm extends Model<KpiForm> implements Serializable {

    @TableId("kf_id")
    private Long kfId;
    @TableField("kf_name")
    private String kfName;
    /**
     * 开始时间
     */
    @TableField("kf_begin_date")
    private String kfBeginDate;
    /**
     * 结束时间
     */
    @TableField("kf_end_date")
    private String kfEndDate;

    @Override
    protected Serializable pkVal() {
        return this.kfId;
    }
}
